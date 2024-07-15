/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */

public class Determinant {


    // _____________________________________
    //         Formel von Sarrus
    // _____________________________________


    // Berechnet die Determinante einer 3 x 3 - Matrix mit der Regel von Sarrus
    public static double Sarrus(Matrix A) {

        if (!Check.isQuadradic(A)) {
            throw new IllegalArgumentException("Die Matrix muss quadratisch sein.");
        } else {

            double[][] array = A.getArray();

            double det = array[0][0] * array[1][1] * array[2][2] + array[0][1] * array[1][2] * array[2][0]
                    + array[0][2] * array[1][0] * array[2][1] - array[0][2] * array[1][1] * array[2][0]
                    - array[0][1] * array[1][0] * array[2][2] - array[0][0] * array[1][2] * array[2][1];

            return det;
        }
    }

    // _____________________________________
    //         Formel von Laplace
    // _____________________________________


    // Methode zur Berechnung der Determinante einer Matrix
    public static double Laplace(Matrix A) {
        if (!Check.isQuadradic(A)) {
            throw new IllegalArgumentException("Die Matrix muss quadratisch sein.");
        }
        else {
            int n = A.getRowNumber();
            double det = 0.0;

            // Laplace'sche Entwicklung entlang der ersten Zeile
            for (int j = 0; j < n; j++) {
                double[][] subMatrix = Utils.getSubMatrix(A, 0, j);
                double subDet = Laplace(new Matrix(subMatrix));
                det += A.getArray()[0][j] * Math.pow(-1, j) * subDet;
            }
            // Korrektur für -0.0 zu 0.0
            if (det == -0.0) {
                det = 0.0;
            }
            return det;
        }
    }



    // Bestimmt die Determinante einer n x n - Matrix
    public static double determinant(Matrix A) {
        int n = A.getRowNumber();
        double[][] array = A.getArray();

        if (!Check.isQuadradic(A)) {
            throw new IllegalArgumentException("Die Matrix muss quadratisch sein.");
        }
        else {
            if (n == 1) {
                return array[0][0];
            } else if (n == 2) {
                return array[0][0] * array[1][1] - array[0][1] * array[1][0];
            } else if (n == 3) {
                return Sarrus(A);
            } else {
                return Laplace(A);
            }
        }
    }















}



