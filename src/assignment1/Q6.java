package assignment1;


import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    //crating matrix
    private int n;
    private int[][] matrix;
    private int[][] matrix2;

    //initialize matrix with 0
    Matrix(int n) {
        this.n = n;
        matrix = new int[n][n];
        matrix2 = new int[n][n];
    }

    //set matrix data
    public void setMatrix() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter element a[" + i + "][" + j + "]");
                matrix[i][j] = sc.nextInt();
            }
        }
        matrix2= Arrays.copyOf(matrix,n);
    }

    //print matrix
    public void printMatrix(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    // provide multiplication of 2 matrix
    private int[][] multiplication(int[][] from, int[][] to) {
        int[][] newMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    newMat[i][j]+=from[i][k]*to[k][j];
                }
            }
        }
        return newMat;
    }


    // form multiplication provide power of matrix
    public void getPowerWIthMultiplication(int power) {

        for (int p = 0; p < power-1; p++) {
            matrix2 = multiplication(matrix2,matrix);
        }
        printMatrix(matrix2);
    }
}

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix matrix = null;
        int n;
        // loop to continue to check multiple years.
        do {
            System.out.println("[ 1 ] set new Matrix and find power");
            System.out.println("[ 2 ] find power");
            System.out.println("[ 3 ] exit");
            System.out.print("[   ] enter your choice");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.print("Enter size of matrix in nXn :: ");
                    n = sc.nextInt();
                    matrix= new Matrix(n);
                    matrix.setMatrix();
                    System.out.println("Enter the num of power ");
                    n=sc.nextInt();
                    matrix.getPowerWIthMultiplication(n);
                    break;
                case 2:
                    if(matrix!=null) {
                        System.out.println("Enter the num of power ");
                        n = sc.nextInt();
                        matrix.getPowerWIthMultiplication(n);
                    }
                    else{
                        System.out.println("first set matrix");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        } while (true);
    }
}
