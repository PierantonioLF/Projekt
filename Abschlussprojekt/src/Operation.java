public class Operation {

    /**
     Christian Leroy, 6504373
     Pierantonio La Ferrera, 4162672
     */

    // Multipliziert alle Einträge einer Matrix A mit einem Skalar c
    // A ist m x n - Matrix  => c * A ist m x n - Matrix

    public static Matrix scalarmult(double c, Matrix A) {
        Matrix Result = Utils.createEqualSize(A);
        int m = A.getRowNumber();
        int n = A.getColNumber();
        double[][] A_Array = A.getArray();
        double[][] Result_Array = Result.getArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Result_Array[i][j] = c * A_Array[i][j];
            }
        }
        return Result;
    }


    // Addiert zwei Matrizen A und B, falls sie von identischer Größe sind
    // A ist m x n - Matrix und B ist m x n - Matrix => A + B ist m x n - Matrix

    public static Matrix add(Matrix A, Matrix B) {
        if (Check.DimAdd(A, B)) {
            Matrix Result = Utils.createEqualSize(A);
            int m = A.getRowNumber();
            int n = A.getColNumber();
            double[][] A_Array = A.getArray();
            double[][] B_Array = B.getArray();
            double[][] Result_Array = Result.getArray();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Result_Array[i][j] = A_Array[i][j] + B_Array[i][j];
                }
            }
            return Result;
        } else {
            throw new IllegalArgumentException("Spaltenanzahl und Zeilenanzahl von A und B müssen gleich sein");
        }
    }

    // Multipliziert zwei Matrizen A und B, falls A so viele Spalten wie B Zeilen hat
    // A ist m x n - Matrix und B ist n x p - Matrix => A * B ist m x p - Matrix
    public static Matrix mult(Matrix A, Matrix B) {

        if (Check.DimMul(A, B)) {

            int m = A.getRowNumber();
            int n = A.getColNumber();
            double[][] A_Array = A.getArray();

            int p = B.getColNumber();
            double[][] B_Array = B.getArray();
            Matrix Result = new Matrix(m, p);
            double[][] Result_Array = Result.getArray();


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    for (int k = 0; k < n; k++) {
                        Result_Array[i][j] = Result_Array[i][j] + A_Array[i][k] * B_Array[k][j];
                    }
                }
            }
            return Result;
        } else {
            throw new IllegalArgumentException("Spaltenanzahl von A und Zeilenanzahl von B müssen gleich sein");
        }

    }

    // Bestimmt die Transponierte von A
    // A ist m x n - Matrix => A^T * B ist m x p - Matrix
    public static Matrix transpose(Matrix A) {

        // Speichert die Zeilen- und Spaltenzahl als Variable und erstellt eine m x n Nullmatrix
        int rowA = A.getRowNumber();
        int colA = A.getColNumber();
        double[][] arrayA = A.getArray();
        Matrix result = new Matrix (colA, rowA);
        double[][] resultArray = result.getArray();

        for (int i = 0; i < colA; i++) {
            for (int j = 0; j < rowA; j++) {
                resultArray[i][j] = arrayA[j][i];
            }
        }
        return result;
    }


    // Bestimmt die Lösung eines quadratischen LGS
    // Die Lösungen sind aufgerundet auf zwei Nachkommastellen
    public static double[] solve(Matrix A, double[] v) { return SLE.Gauss(A,v); }

    // Berechnet die Determinante einer n x n - Matrix
    public static double det(Matrix A) { return Determinant.determinant(A); }

    // Bestimmt die Inverse einer invertierbaren Matrix
    // Die Einträge sind aufgerundet auf zwei Nachkommastellen
    public static Matrix inverse(Matrix A) { return Inverse.GaussJordan(A); }
}



