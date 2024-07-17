import java.io.*;
import java.net.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class DigitalSignatureExample {
    private static final String ALGORITHM = "RSA";

    public static void main(String[] args) {
        new Thread(() -> startServer()).start();
        new Thread(() -> startClient()).start();
    }

    private static void startServer() {
        try {
            // Server generates key pair
            KeyPair keyPair = generateKeyPair();

            // Server creates a signature object
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(keyPair.getPrivate());

            // Server listens for incoming connections
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server listening on port 8080...");

            // Accepts client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Server sends its public key to the client
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(keyPair.getPublic());

            // Server sends a message to the client
            String message = "This is a basic chat client-server using digital signature!";
            out.writeObject(message);

            // Server signs the message
            signature.update(message.getBytes());
            byte[] digitalSignature = signature.sign();

            // Server sends the digital signature to the client
            out.writeObject(digitalSignature);

            // Close resources
            out.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startClient() {
        try {
            // Client generates key pair
            KeyPair keyPair = generateKeyPair();

            // Client creates a signature object
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(keyPair.getPrivate());

            // Client connects to the server
            Socket socket = new Socket("localhost", 8080);

            // Client receives the server's public key
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            PublicKey serverPublicKey = (PublicKey) in.readObject();

            // Client receives the message from the server
            String receivedMessage = (String) in.readObject();
            System.out.println("Received message from server: " + receivedMessage);

            // Client receives the digital signature from the server
            byte[] receivedSignature = (byte[]) in.readObject();

            // Client verifies the digital signature using the server's public key
            signature.initVerify(serverPublicKey);
            signature.update(receivedMessage.getBytes());
            boolean isSignatureValid = signature.verify(receivedSignature);

            if (isSignatureValid) {
                System.out.println("Digital Signature is valid.");
            } else {
                System.out.println("Digital Signature is not valid.");
            }

            // Close resources
            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }
}
