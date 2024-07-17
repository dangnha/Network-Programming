import java.rmi.*;
import java.rmi.server.*;
public class CalculServer1 {
    public static void main(String args[]) {
        try {
// Load the service
            RMICalculimpl CalculService1 = new RMICalculimpl();
            String registration = "rmi://localhost/RMICalcul1";

// Register with service so that clients can find us
            Naming.rebind(registration, CalculService1);
        } catch (Exception e) {
            System.err.println("Error - " + e);
        }
    }
}
