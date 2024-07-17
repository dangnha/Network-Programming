
import java.rmi.*;
public interface RMICalcul extends Remote
{
public int add (int a, int b) throws RemoteException;
public int sub(int a, int b) throws RemoteException;
public int mul(int a, int b) throws RemoteException;
public float div(int a, int b) throws RemoteException;

public int[][] multiplyMatrix(int[][] matrixA, int[][] matrixB) throws RemoteException;

}