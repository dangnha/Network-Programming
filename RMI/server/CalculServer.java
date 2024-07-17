import java.rmi.*;
import java.rmi.server.*;
public class CalculServer {
    public static void main(String args[]) {
        try {
// Load the service
            RMICalculimpl CalculService = new RMICalculimpl();
            String registration = "rmi://localhost/RMICalcul";

// Register with service so that clients can find us
            Naming.rebind(registration, CalculService);
        } catch (Exception e) {
            System.err.println("Error - " + e);
        }
    }
}
