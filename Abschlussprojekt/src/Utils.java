/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */


public class Utils {


    // --------------------------
    //     Zeilenoperationen
    // --------------------------


    // Vertauscht zwei Zeilen in einer Matrix
    public static void swapRows(Matrix matrix, int row1, int row2) {
        double[][] array = matrix.getArray();
        double[] temp = array[row1];
        array[row1] = array[row2];
        array[row2] = temp;
    }

    //  Addiert ein Vielfaches einer Zeile zu einer anderen Zeile in einer Matrix
    public static void addMultipleOfRow(Matrix matrix, int sourceRow, int targetRow, double multiple) {
        double[][] array = matrix.getArray();
        int numCols = matrix.getColNumber();
        for (int i = 0; i < numCols; i++) {
            array[targetRow][i] += multiple * array[sourceRow][i];
        }
    }

    // Multipliziert eine Zeile mit einem Skalar in einer Matrix
    public static void multiplyRow(Matrix matrix, int row, double scalar) {
        double[][] array = matrix.getArray();
        int numCols = matrix.getColNumber();
        for (int i = 0; i < numCols; i++) {
            array[row][i] *= scalar;
        }
    }


    // -----------------------------------
    //     Mehrfache Zeilenoperationen
    // -----------------------------------


    // Setzt alle Zeilen unterhalb der aktuellen Zeile in einer Matrix gleich Null
    public static void eliminateBelow(Matrix matrix, int pivotRow) {
        double[][] array = matrix.getArray();
        int n = matrix.getRowNumber();
        for (int k = pivotRow + 1; k < n; k++) {
            double c = -array[k][pivotRow] / array[pivotRow][pivotRow];
            Utils.addMultipleOfRow(matrix, pivotRow, k, c);
            array[k][pivotRow] = 0; // Explizit setzen, um numerische Ungenauigkeiten zu vermeiden
        }
    }

    // Setzt alle Zeilen oberhalb der aktuellen Zeile in einer Matrix gleich Null
    public static void eliminateAbove(Matrix matrix, int pivotRow) {
        double[][] array = matrix.getArray();
        for (int k = pivotRow - 1; k >= 0; k--) {
            double c = -array[k][pivotRow] / array[pivotRow][pivotRow];
            Utils.addMultipleOfRow(matrix, pivotRow, k, c);
            array[k][pivotRow] = 0; // Explizit setzen, um numerische Ungenauigkeiten zu vermeiden
        }
    }

    // -----------------------------------
    //     Erweiterte Matrien
    // -----------------------------------


    // Erstellt eine erweiterte Matrix für das Lösen eines LGS
    public static Matrix AugmentedMatrix(Matrix coefficients, double[] constants) {
        int numRows = coefficients.getRowNumber();
        int numCols = coefficients.getColNumber();
        double[][] augmentedArray = new double[numRows][numCols + 1];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                augmentedArray[i][j] = coefficients.getArray()[i][j];
            }
            augmentedArray[i][numCols] = constants[i];
        }

        return new Matrix(augmentedArray);
    }

    // Erstellt eine erweiterte Matrix für die Berechnung der Inversen
    public static Matrix AugmentedMatrix(Matrix matrix) {
        int n = matrix.getRowNumber();
        double[][] augmentedArray = new double[n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedArray[i][j] = matrix.getArray()[i][j];
            }
            augmentedArray[i][i + n] = 1.0;
        }

        return new Matrix(augmentedArray);
    }

    // -----------------------------------
    //     Sonstige Matrizen
    // -----------------------------------

    public static Matrix Identity(int n) {
        Matrix identityMatrix = new Matrix(n, n);
        double[][] array = identityMatrix.getArray();
        for (int i = 0; i < n; i++) {
            array[i][i] = 1.0;
        }
        return identityMatrix;
    }

// Erstellt eine leere Matrix mit der selben Dimension von A

    public static Matrix createEqualSize(Matrix A) {
        Matrix matrix = new Matrix(A.getRowNumber(), A.getColNumber());
        return matrix;
    }


    // Bestimmt die Untermatrix eine Matrix bzgl. einer bestimmten Zeile und Spalte
    public static double[][] getSubMatrix(Matrix matrix, int excludeRow, int excludeCol) {
        int n = matrix.getRowNumber();
        double[][] subMatrix = new double[n - 1][n - 1];
        int rowIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i == excludeRow) {
                continue;
            }
            int colIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludeCol) {
                    continue;
                }
                subMatrix[rowIndex][colIndex] = matrix.getArray()[i][j];
                colIndex++;
            }
            rowIndex++;
        }
        return subMatrix;
    }

    // Sucht nach dem maximalen Element in der aktuellen Spalte
    public static int findMaxRow(double[][] array, int col, int n) {
        int maxRow = col;
        double maxEl = Math.abs(array[col][col]);
        for (int k = col + 1; k < n; k++) {
            if (Math.abs(array[k][col]) > maxEl) {
                maxEl = Math.abs(array[k][col]);
                maxRow = k;
            }
        }
        return maxRow;
    }


}



