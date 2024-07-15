/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */

public class SLE {

    // Bestimmt die Lösung eines quadratischen Gleichungssystems Ax=b
    // Der Lösungsvektor ist aufgerundet auf zwei Nachkommastellen

    public static double[] Gauss(Matrix A, double[] b) {
        // Aus Effizienzgründen speichern wir den Wert der Getter-Aufrufe in Variablen m und n
        // Andernfalls würden die Getter-Methoden in Schleifen unnötig mehrfach aufgerufen

        int n = A.getRowNumber();

        // Ist die Matrix A nicht quadratisch oder b nicht n - dimensional, so gebe eine Exception aus
        if (!Check.isQuadradic(A) || n != b.length) {
            throw new IllegalArgumentException("Das Gleichungssystem muss quadratisch sein!");
        }


        // Stelle die erweiterte Koeffizientenmatrix G = [A | b]
        Matrix G = Utils.AugmentedMatrix(A, b);

        // Führe den Gauß-Algorithmus aus, um die reduzierte Zeilenstufenform zu erhalten
        for (int i = 0; i < n; i++) {
            double[][] array = G.getArray();

            // Suche das maximale Element in der aktuellen Spalte
            int maxRow = Utils.findMaxRow(array, i, n);

            // Tausche die maximale Zeile mit der aktuellen Zeile (Spalte pivotisieren)
            Utils.swapRows(G, i, maxRow);

            // Nullsetzen aller Zeilen unterhalb und oberhalb der aktuellen Zeile
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double c = -array[k][i] / array[i][i];
                    Utils.addMultipleOfRow(G, i, k, c);
                }
            }
        }

        // Berechne den Lösungvektor x aus der RZSF (Reduzierte Zeilen-Stufen-Form)
        double[] x = new double[n];
        double[][] array = G.getArray();
        for (int i = 0; i < n; i++) {
            x[i] = array[i][n] / array[i][i];
        }

        return x;
    }


}
