import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions
        System.out.print("Enter rows and columns of Matrix 1: ");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int[][] matrix1 = new int[r1][c1];

        System.out.println("Enter elements of Matrix 1:");
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c1; j++)
                matrix1[i][j] = scanner.nextInt();

        System.out.print("Enter rows and columns of Matrix 2: ");
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int[][] matrix2 = new int[r2][c2];

        System.out.println("Enter elements of Matrix 2:");
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++)
                matrix2[i][j] = scanner.nextInt();

        // Addition and Subtraction
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nAddition:");
            printMatrix(addMatrices(matrix1, matrix2));
            System.out.println("Subtraction:");
            printMatrix(subtractMatrices(matrix1, matrix2));
        } else {
            System.out.println("\nAddition and Subtraction not possible due to dimension mismatch.");
        }

        // Multiplication
        if (c1 == r2) {
            System.out.println("Multiplication:");
            printMatrix(multiplyMatrices(matrix1, matrix2));
        } else {
            System.out.println("Multiplication not possible due to dimension mismatch.");
        }

        scanner.close();
    }

    // Matrix Addition
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    // Matrix Subtraction
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    // Matrix Multiplication
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Utility function to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
