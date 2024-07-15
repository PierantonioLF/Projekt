import java.util.Arrays;

/**
 Christian Leroy, 6504373
 Pierantonio La Ferrera, 4162672
 */

public class Demo {
    public static void main(String[] args) {


        //
        // --- Demo-Werte ---
        //
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};
        double[][] c = {{42, 42, 42}, {43, 43, 43}, {44, 44, 44}, {45, 45, 45}};
        double[][] d = {{1, 2, 3}, {1, 5, 6}, {7, 10, 9}};

        // 3x3 Beispielmatrix
        System.out.println("Nicht invertierbare 3x3 Beispielmatrix A");
        Matrix A = new Matrix(a);
        A.print();
        System.out.println();

        // 3x4 Beispielmatrix
        Matrix B = new Matrix(b);
        System.out.println("3x4 Beispielmatrix B");
        B.print();
        System.out.println();

        // 4x3 Beispielmatrix
        Matrix C = new Matrix(c);
        System.out.println("4x3 Beispielmatrix C");
        C.print();
        System.out.println();

        System.out.println("Invertierbare 3x3 Beispielmatrix D");
        Matrix D = new Matrix(d);
        A.print();
        System.out.println();

        //
        // MUST-SUPPORT FUNKTIONEN
        //

        // a) Matrixaddition

        System.out.println("Addiert A+A");
        Operation.add(A,A).print();
        System.out.println();

        // b) Matrixmultiplikation

        System.out.println("Multipliziert B * C");
        Operation.mult(B, C).print();
        System.out.println();

        // c) Skalarmultiplikation

        System.out.println("Multipliziert 42*B");
        Operation.scalarmult(42, B).print();
        System.out.println();

        // d) Transposition

        System.out.println("Transponiert die Matrix C");
        Operation.transpose(C).print();
        System.out.println();

        // e) Umkehrbarkeit prüfen

        System.out.println("Prüft, ob Matrix A invertierbar ist");
        System.out.println("A invertierbar? " + Check.isInvertible(A));
        System.out.println();
        System.out.println("Prüft, ob Matrix D invertierbar ist");
        System.out.println("D invertierbar? " + Check.isInvertible(D));
        System.out.println();

        // f) Umkehrmatrix bestimmen

        System.out.println("Umkehrmatrix von D");
        Operation.inverse(D).print();
        System.out.println();

        // g) Derterminante einer Matrix bestimmen

        System.out.println("Determinanten der Matrizen A, D");
        System.out.println("det(A) = " + Operation.det(A) + " und det(D) = " + Operation.det(D));
        System.out.println();


        /*
        Zusatzfeature: Lösung eines quadratischen LGS bestimmen

        Gegeben folgendes Beispiel-LGS:

        x + y + z = 4
        3x - y = 1
        y - 2z = 0
        */

        double[][] Koeffizienten = {{1,1,1}, {3,-1,0},{0,1,-2}};
        double[] x = {4, 1, 0};
        Matrix KoeffizientenMatrix = new Matrix(Koeffizienten);
        double[] Lösung = Operation.solve(KoeffizientenMatrix, x);

        System.out.println("Lösung des LGS: " + Arrays.toString(Lösung));
        System.out.println();
     }
    }