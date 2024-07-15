/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */


import java.text.DecimalFormat;


public class Matrix {
    private double[][] array;
    private int rowNumber;
    private int colNumber;


    // --------------------------
    //   Konstruktoren
    // --------------------------


    // Erstellt eine m x n -  Nullmatrix
    public Matrix(int m, int n) {
        this.array = new double[m][n];
        this.rowNumber = m;
        this.colNumber = n;
    }

    // Erstellt eine m x n - Matrix
    // Überführt ein gegebenes 2D-Array in ein Objekt vom Typ Matrix
    public Matrix(double[][] array) {
        this.array = array;
        this.rowNumber = array.length;
        this.colNumber = array[0].length;
    }


    // --------------------------
    //     Getter - Methoden
    // --------------------------

    public int getRowNumber() {
        return this.rowNumber;
    }

    public int getColNumber() {

        return this.colNumber;
    }

    public double[][] getArray() {

        return this.array;
    }


    // --------------------------
    //     Setter - Methoden
    // --------------------------



    // --------------------------
    //      Print - Methoden
    // --------------------------

    public void print() {


        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.printf("%8.2f", array[i][j]);
            }
            System.out.println();
        }
    }

    public static void print(Matrix A, double[] b, double[] x) {
        System.out.println("Deine Koeffizientenmatrix ist:");
        for (int i = 0; i < A.getRowNumber(); i++) {
            for (int j = 0; j < A.getColNumber(); j++) {
                System.out.printf("%8.2f", A.getArray()[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nDein Vektor b ist:");
        for (double value : b) {
            System.out.printf("%8.2f", value);
        }
        System.out.println();

        System.out.println("\nDie Lösung x lautet:");
        for (double value : x) {
            System.out.printf("%8.2f", value);
        }
        System.out.println();
    }






    public static void print(Matrix A, Matrix B, Matrix result) {
        System.out.println("Die Matrix A ist:");
        for (int i = 0; i < A.getRowNumber(); i++) {
            for (int j = 0; j < A.getColNumber(); j++) {
                System.out.printf("%8.2f", A.getArray()[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nDie Matrix B ist:");
        for (int i = 0; i < B.getRowNumber(); i++) {
            for (int j = 0; j < B.getColNumber(); j++) {
                System.out.printf("%8.2f", B.getArray()[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nDas Ergebnis ist:");
        for (int i = 0; i < result.getRowNumber(); i++) {
            for (int j = 0; j < result.getColNumber(); j++) {
                System.out.printf("%8.2f", result.getArray()[i][j]);
            }
            System.out.println();
        }
    }




    public static void print(Matrix A, double scalar, Matrix result) {
        System.out.println("Die Matrix A ist:");
        for (int i = 0; i < A.getRowNumber(); i++) {
            for (int j = 0; j < A.getColNumber(); j++) {
                System.out.printf("%8.2f", A.getArray()[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nDer Skalar ist:");
        System.out.printf("%8.2f", scalar);
        System.out.println();

        System.out.println("\nDas Ergebnis ist:");
        for (int i = 0; i < result.getRowNumber(); i++) {
            for (int j = 0; j < result.getColNumber(); j++) {
                System.out.printf("%8.2f", result.getArray()[i][j]);
            }
            System.out.println();
        }
    }



    public static void print(Matrix A, Matrix B) {
        System.out.println("Deine Matrix ist:");
        for (int i = 0; i < A.getRowNumber(); i++) {
            for (int j = 0; j < A.getColNumber(); j++) {
                System.out.printf("%8.2f", A.getArray()[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nDas Ergebnis ist:");
        for (int i = 0; i < B.getRowNumber(); i++) {
            for (int j = 0; j < B.getColNumber(); j++) {
                System.out.printf("%8.2f", B.getArray()[i][j]);
            }
            System.out.println();
        }
    }



    public static void print(Matrix A, double k) {
        System.out.println("Deine Matrix ist:");
        for (int i = 0; i < A.getRowNumber(); i++) {
            for (int j = 0; j < A.getColNumber(); j++) {
                System.out.printf("%8.2f", A.getArray()[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n Das Ergebnis ist: " + k);
        }










}