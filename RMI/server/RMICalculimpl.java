import java.rmi.*;
import java.rmi.server.*;

public class RMICalculimpl extends UnicastRemoteObject implements
RMICalcul
{
    public RMICalculimpl() throws RemoteException
    {
    }
    public int add (int a, int b) throws RemoteException
    {
    return (a+b);
    }
    public int sub(int a, int b) throws RemoteException
    {
    return (a-b);
    }

    public int mul(int a, int b) throws RemoteException
    {
        return (a*b);
    }
    public float div(int a, int b) throws RemoteException
    {
        try {
            float result = a / b;
            return (result);
        }
        catch (Exception e) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
    }

        public int[][] multiplyMatrix(int[][] matrixA, int[][] matrixB) {
            int rowsA = matrixA.length;
            int colsA = matrixA[0].length;
            int rowsB = matrixB.length;
            int colsB = matrixB[0].length;

            // Check if matrices can be multiplied
            if (colsA != rowsB) {
                System.out.println("Matrices cannot be multiplied: " +
                        "Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
                return null;
            }

            int[][] result = new int[rowsA][colsB];

            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }

            return result;
        }
    
}