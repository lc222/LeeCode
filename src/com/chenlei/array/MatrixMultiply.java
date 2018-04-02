package com.chenlei.array;

import util.NumberUtils;

/**
 *  2.8 矩阵乘法
 * @author chenlei
 * @since 2016 - 12 - 03 12:51
 */
public class MatrixMultiply {

    private static void matrixMultiply(int[][] matrix1, int[][] matrix2, int [][] matrixMultiply) {
        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix2[0].length; j++) {
                int sum = 0;
                for(int k = 0; k < matrix2.length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                matrixMultiply[i][j] = sum;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[2][3];
        matrix1[0][0] = 0;
        matrix1[0][1] = 1;
        matrix1[0][2] = 2;
        matrix1[1][0] = 3;
        matrix1[1][1] = 4;
        matrix1[1][2] = 5;
        int[][] matrix2 = new int[3][2];
        matrix2[0][0] = 0;
        matrix2[0][1] = 1;
        matrix2[1][0] = 2;
        matrix2[1][1] = 3;
        matrix2[2][0] = 4;
        matrix2[2][1] = 5;
        int [][] multiplyResult = new int [2][2];
        matrixMultiply(matrix1, matrix2, multiplyResult);
        NumberUtils.printInMatrix(multiplyResult);
    }
}
