package com.github.dolphinmind.array;

/**
 * @author dolphinmind
 * @ClassName SpiralMatrixII
 * @description 59 . 螺旋矩阵 II
 * @date 2024/8/1
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        if (n == 0) {
            return null;
        }

        int[][] nums = new int[n][n];

        int loop = 1;

        int startX = 0;
        int startY = 0;

        int moveX  = 0;
        int moveY  = 0;

        int offset = 1;
        int count  = 1;

        while (loop <= n/2) {
            System.out.println("上边");
            while (moveY < n - offset) {
                printPoint(moveX, moveY, count);
                nums[moveX][moveY] = count++;
                moveY++;
            }
            System.out.println("右边");
            while (moveX < n - offset) {
                printPoint(moveX, moveY, count);

                nums[moveX][moveY] = count++;
                moveX++;
            }

            System.out.println("下边");
            while (moveY > startY) {
                printPoint(moveX, moveY, count);

                nums[moveX][moveY] = count++;
                moveY--;
            }

            System.out.println("左边");
            while (moveX > startX) {
                printPoint(moveX, moveY, count);

                nums[moveX][moveY] = count++;
                moveX--;
            }

            startX++;
            startY++;
            loop++;
            offset++;

            moveX = startX;
            moveY = startY;
        }

        if ( n % 2 == 1) {
            System.out.println("中心");
            printPoint(startX, startY, count);
            nums[startX][startY] = count;
        }

        return nums;
    }

    public void printPoint(int x, int y, int count) {
        System.out.println("[" + x + "," + y + "] = " + count);
    }
}
