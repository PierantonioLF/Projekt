
/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */

abstract class Check {


    // _____________________________________________________________________________
    //  Hilfsfunktionen, die überprüfen, ob Matrizen die gewünschte Dimension haben
    // _____________________________________________________________________________


    // Überprüft, ob eine Matrix A quadratisch ist
    public static boolean isQuadradic(Matrix A) {
        if (A.getRowNumber() == A.getColNumber()) { return true; }
        else { return false; }
    }

    // Prüft die Dimensionsvoraussetzungen für die Addition zweier Matrizen A und B
    // Prüft also, ob Matrizen A und B selbe Anzahl an Zeilen und Spalten haben

    public static Boolean DimAdd(Matrix A, Matrix B){
        // Wenn Spalten- oder Zeilenanzahl nicht identisch, dann false
        if( (A.getRowNumber() != B.getRowNumber()) || (A.getColNumber() != B.getColNumber()) ) {return false;}
        else { return true; }
    }

    // Prüft die Dimensionsvoraussetzungen für die Multiplikation zweier Matrizen A und B
    // Prüft also, ob Matrizen A so viele Spalten wie B Zeilen hat

    public static Boolean DimMul(Matrix A, Matrix B){
        // Wenn Spalten- oder Zeilenanzahl nicht identisch, dann false
        if(A.getColNumber() == B.getRowNumber()) {return true; }
        else{ return false; }
    }


    // _________________________________________________________________________________
    // Hilfsfunktionen, die überprüfen, ob Matrizen die gewünschte Eigenschaften haben
    // _________________________________________________________________________________

    // Überprüft, ob eine Matrix A invertierbar
    public static boolean isInvertible(Matrix A) {
        if (Check.isQuadradic(A) ) {
            double det = Operation.det(A);
            if (det != 0) { return true; }

            else { return false; }
        }
        else { throw new IllegalArgumentException("Die Matrix muss quadratisch sein."); }

    }




}
