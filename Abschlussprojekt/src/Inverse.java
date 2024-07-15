/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */


public class Inverse {

    // Bestimmt die Inverse I einer invertierbaren Matrix A
    // Die Einträge der Inversen I sind aufgerundet auf zwei Nachkommastellen

    public static Matrix GaussJordan(Matrix A) {
        if (!Check.isQuadradic(A)) {
            throw new IllegalArgumentException("Die Matrix muss quadratisch sein.");

        } else if (!Check.isInvertible(A)) {
            throw new IllegalArgumentException("Die Matrix ist nicht invertierbar.");
        }
        else {
            int n = A.getRowNumber();

            // Stelle die erweiterte Koeffizientenmatrix G = [A | I]
            Matrix G = Utils.AugmentedMatrix(A);

            // Anwenden des Gauß-Jordan-Algorithmus
            for (int i = 0; i < n; i++) {
                double[][] array = G.getArray();

                // Suche das maximale Element in der aktuellen Spalte
                int maxRow = Utils.findMaxRow(array, i, n);

                // Tausche die maximale Zeile mit der aktuellen Zeile (Spalte pivotisieren)
                Utils.swapRows(G, i, maxRow);

                // Nullsetzen aller Zeilen unterhalb der aktuellen Zeile
                Utils.eliminateBelow(G, i);
            }

            // Nullsetzen aller Zeilen oberhalb der aktuellen Zeile
            for (int i = n - 1; i >= 0; i--) {
                Utils.eliminateAbove(G, i);
            }

            // Mache die Hauptdiagonale zu 1
            double[][] array = G.getArray();
            for (int i = 0; i < n; i++) {
                double c = array[i][i];
                Utils.multiplyRow(G, i, 1.0 / c);
            }

            // Gebe die inverse Matrix aus der erweiterten Matrix zurück
            double[][] inverseArray = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    inverseArray[i][j] = array[i][j + n];
                }
            }

            return new Matrix(inverseArray);
        }
    }
}
