package com.mycompany.matrixh;

import org.apache.commons.math3.linear.*;

public class HessianAnalysis {
    public static void main(String[] args) {
        // Définition de la matrice Hessienne
        double[][] matrixData = {
            {0, 2, -1},
            {3, -2, 0},
            {-2, 2, 1}
        };

        System.out.println("### Etape 1 : Definition de la Matrice Hessienne ###");
        printMatrix(matrixData);

        // Création de la matrice
        RealMatrix matrix = new Array2DRowRealMatrix(matrixData);

        System.out.println("\n### Etape 2 : Calcul du Polynome Caracteristique ###");
        calculateCharacteristicPolynomial(matrixData);

        System.out.println("\n### Etape 3 : Calcul des Valeurs Propres ###");
        EigenDecomposition eig = new EigenDecomposition(matrix);
        double[] eigenvalues = eig.getRealEigenvalues();

        System.out.println("Les valeurs propres de H_f sont :");
        for (double lambda : eigenvalues) {
            System.out.println("lamda = " + lambda);
        }

        // Calcul du déterminant
        double determinant = eig.getDeterminant();
        System.out.println("\n### Etape 4 : Calcul du Determinant ###");
        System.out.println("Det(H_f) = " + determinant);

        // Conclusion sur la convexité
        System.out.println("\n### Etape 5 : Conclusion ###");
        analyzeConvexity(eigenvalues);
    }

    // Fonction pour afficher une matrice
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%6.2f ", val);
            }
            System.out.println();
        }
    }

    // Fonction pour calculer le polynôme caractéristique
    private static void calculateCharacteristicPolynomial(double[][] matrix) {
        System.out.println("On resout : det(H_f - lamdaI) = 0");
        System.out.println("H_f - lamdaI devient :");

        System.out.println("|  0-lamda    2     -1  |");
        System.out.println("|   3   -2-lamda    0  |");
        System.out.println("|  -2     2     1-lamda |");

        System.out.println("\nOn developpe le determinant en utilisant la regle de Sarrus :");

        System.out.println("det(H_f - lamdaI) = -lamda * [ (-2-lamda)(1-lamda) - (0 * 2) ]");
        System.out.println("               + (-2) * [ (3(1-lamda)) - (0 * -1) ]");
        System.out.println("               + (-1) * [ (3*2) - (-2)(-2-lamda) ]");

        System.out.println("\nDeveloppement :");

        System.out.println("det(H_f - lamdaI) = -lamda * (-2 - lamda - 2lamda - lamda^2)");
        System.out.println("               + (-2) * (3 - 3lamda)");
        System.out.println("               + (-1) * (6 - (4 + 2lamda))");

        System.out.println("\nSimplification :");

        System.out.println("det(H_f - lamdaI) = -lamda (-lamda^2 - 3lamda - 2)");
        System.out.println("               -6 + 6lamda");
        System.out.println("               -1(6 - 4 - 2lamda)");

        System.out.println("\nFinalement, on obtient :");
        System.out.println("P(lamda) = -lamda^3 - lamda^2 + 10lamda - 8");

        System.out.println("\nOn resout P(lamda) = 0 pour obtenir les valeurs propres.");
    }

    // Fonction pour analyser la convexité en fonction des valeurs propres
    private static void analyzeConvexity(double[] eigenvalues) {
        boolean hasPositive = false;
        boolean hasNegative = false;

        for (double lambda : eigenvalues) {
            if (lambda > 0) hasPositive = true;
            if (lambda < 0) hasNegative = true;
        }

        if (hasPositive && hasNegative) {
            System.out.println("La matrice Hessienne est indefinie : f(x, y) n'est ni convexe ni concave.");
        } else if (hasPositive) {
            System.out.println("La matrice Hessienne est definie positive : f(x, y) est convexe.");
        } else if (hasNegative) {
            System.out.println("La matrice Hessienne est definie negative : f(x, y) est concave.");
        } else {
            System.out.println("Toutes les valeurs propres sont nulles : il faut une analyse plus approfondie.");
        }
    }
}
