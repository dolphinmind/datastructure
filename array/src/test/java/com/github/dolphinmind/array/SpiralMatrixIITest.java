package com.github.dolphinmind.array;

import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName SpiralMatrixIITest
 * @description
 * @date 2024/8/1
 */

public class SpiralMatrixIITest {

    @Test
    public void generateMatrix() {
        int[][] matrix = new SpiralMatrixII().generateMatrix(4);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
