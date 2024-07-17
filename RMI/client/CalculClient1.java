import java.rmi.*;
public class CalculClient1
{
 public static void main(String args[])
 {
  try
  {
   String registration = "rmi://localhost/RMICalcul";
// Lookup the service in the registry, and obtain a remote service
   Remote remoteService = Naming.lookup (registration );
// Cast to a RMICalcul interface
   RMICalcul calculService = (RMICalcul) remoteService;
// call remote  method :add (..), sub
   System.out.println ("3 + 5 = "+calculService.add(3,5));
   System.out.println ("6 - 3 = "+calculService.sub(6,3));

  }
  catch (Exception e)
  {
   System.out.println ("Error - " + e);
  }
 }
}
