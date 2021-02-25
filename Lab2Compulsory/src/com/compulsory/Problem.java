package com.compulsory;

public class Problem {
    static int[][] matrix;

    public Problem(int n) {
        matrix = new int[n][n];
    }

    public Problem(int i, int j, int cost) {
        matrix[i][j] = cost;
    }

    public void displayMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
