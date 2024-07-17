import java.rmi.*;
public class CalculClient2
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
   System.out.println ("2 * 6 = "+calculService.mul(2,6));
   System.out.println ("10 / 3 = "+calculService.div(10,3));
   System.out.println ("10 / 0 = "+calculService.div(10,0));

  }
  catch (Exception e)
  {
   System.out.println ("Error - " + e);
  }
 }
}
