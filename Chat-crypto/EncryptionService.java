import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Arrays;


public class EncryptionService {

    private SecretKey secretKey;
    private Cipher cipher;

    public EncryptionService(String key, String algorithm, String mode) throws GeneralSecurityException {
        int keyLength = 16; // For AES-128
        byte[] keyBytes = Arrays.copyOf(key.getBytes(StandardCharsets.UTF_8), keyLength);

        if ("DES".equals(algorithm)) {
            DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            secretKey = keyFactory.generateSecret(desKeySpec);
        } else if ("AES".equals(algorithm)) {
            secretKey = new SecretKeySpec(keyBytes, "AES");
        }

        if (mode.equals("GCM")) {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
        } else if (mode.equals("CBC")) {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } else {
            throw new IllegalArgumentException("Unsupported mode: " + mode);
        }
    }

    public String encrypt(String original) throws GeneralSecurityException {
        if ("GCM".equals(cipher.getAlgorithm().split("/")[1])) {
            byte[] iv = new byte[16]; // Initialization Vector
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv); // Generate a random IV
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(128, iv));
            byte[] encryptedData = cipher.doFinal(original.getBytes(StandardCharsets.UTF_8));
            var encoder = Base64.getEncoder();
            var encrypt64 = encoder.encodeToString(encryptedData);
            var iv64 = encoder.encodeToString(iv);
            return encrypt64 + "#" + iv64;
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(original.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedData);
        }
    }

    public String decrypt(String cypher) throws GeneralSecurityException {
        if ("GCM".equals(cipher.getAlgorithm().split("/")[1])) {
            var split = cypher.split("#");
            var decoder = Base64.getDecoder();
            var cypherText = decoder.decode(split[0]);
            var iv = decoder.decode(split[1]);
            var paraSpec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paraSpec);
            byte[] decryptedData = cipher.doFinal(cypherText);
            return new String(decryptedData, StandardCharsets.UTF_8);
        } else {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] encryptedData = Base64.getDecoder().decode(cypher);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            return new String(decryptedData, StandardCharsets.UTF_8);
        }
    }

    public static void main(String[] args) {
        try {
            EncryptionService encryptionService = new EncryptionService("yourKey", "AES", "GCM");
            String encryptedText = encryptionService.encrypt("Hello My name is Nguyen Dang Nha, 21GIT");
            System.out.println("Encrypted Text: " + encryptedText);
            String decryptedText = encryptionService.decrypt(encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
