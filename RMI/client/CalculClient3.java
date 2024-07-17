import java.rmi.*;
public class CalculClient3
{
 public static void main(String args[])
 {
  int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
  int[][] matrixB = {{7, 8}, {9, 10}, {11, 12}};

  try
  {
   String registration = "rmi://localhost/RMICalcul1";
// Lookup the service in the registry, and obtain a remote service
   Remote remoteService = Naming.lookup (registration );
// Cast to a RMICalcul interface
   RMICalcul calculService = (RMICalcul) remoteService;
// call remote  method :add (..), sub
   System.out.println ("[[1, 2, 3], [4, 5, 6]] x [[7, 8], [9, 10], [11, 12]] = "+calculService.multiplyMatrix(matrixA, matrixB));

  }
  catch (Exception e)
  {
   System.out.println ("Error - " + e);
  }
 }
}
