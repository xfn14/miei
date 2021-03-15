package com.andreubita.poo.ficha2;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
    }

    /**
     * Gets a certain element of a matrix
     *
     * @param matrix matrix to get the element from
     * @param line line number in matrix
     * @param col column number in matrix
     * @return element in pos (line,col) in matrix
     */
    public int getElem(int[][] matrix, int line, int col){
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[0].length);
        return newMatrix[line][col];
    }

    /**
     * Sums to matrices together
     * (Matrix must be same size)
     *
     * @param matrix1 the first matrix to sum
     * @param matrix2 the second matrix to sum
     * @param line number of lines
     * @param col number of columns
     * @return a matrix with the same size with the sum
     */
    public int[][] sumMatrix(int[][] matrix1, int[][] matrix2, int line, int col){
        int[][] sumMatrix = new int[line][col];
        for (int i = 0; i < line; i++)
            for (int j = 0; j < col; j++)
                sumMatrix[i][j] = getElem(matrix1, i, j) + getElem(matrix2, i, j);
        return sumMatrix;
    }

    /**
     * Sees if two matrix are equal
     * (Matrix must be same size)
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     * @param line number of lines
     * @param col number of columns
     * @return equality value
     */
    public boolean equalMatrix(int[][] matrix1, int[][] matrix2, int line, int col){
        for (int i = 0; i < line; i++)
            for (int j = 0; j < col; j++)
                if(matrix1[i][j] == matrix2[i][j]) return true;
        return false;
    }

    /**
     * Calculates the opposite matrix
     *
     * @param matrix matrix to get the opposite
     * @param lin number of lines
     * @param col number of columns
     * @return the opposite matrix
     */
    public int[][] oppositeMatrix(int[][] matrix, int lin, int col){
        int[][] newMatrix = new int[lin][col];
        for (int i = 0; i < lin; i++)
            for (int j = 0; j < col; j++)
                newMatrix[i][j] = -matrix[i][j];
        return newMatrix;
    }

    /**
     * Prints a matrix to the terminal
     *
     * @param matrix matrix to print
     * @param lin number of lines
     * @param col number of columns
     */
    public void printMatrix(int[][] matrix, int lin, int col){
        for (int i = 0; i < lin; i++){
            System.out.print("[");
            for (int j = 0; j < col; j++)
                System.out.print(getElem(matrix, i, j) + (j == col-1 ? "" : ", "));
            System.out.print("]\n");
        }
    }

    /**
     * Prints a matrix to the terminal
     * (Alternative)
     *
     * @param matrix matrix to print
     * @param lin number of lines
     */
    public void printMatrix(int[][] matrix, int lin){
        for (int i = 0; i < lin; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
