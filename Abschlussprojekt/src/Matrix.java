/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */


import java.text.DecimalFormat;


public class Matrix{
    private double[][] array;
    private int rowNumber;
    private int colNumber;


    // --------------------------
    //   Konstruktoren
    // --------------------------


    // Erstellt eine m x n - Nullmatrix
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
}