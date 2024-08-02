package com.github.dolphinmind.array;

import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName RangeAdditionTest
 * @description
 * @date 2024/8/2
 */

public class RangeAdditionTest {

    @Test
    public void test_getModifiedArray() {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};

        int[] result = new RangeAddition().getModifiedArray(length, updates);

        printArray(result);

    }

    /**
     * @description 打印数组
     * @param nums
     */

    public void printArray(int[] nums) {
        System.out.println();

        System.out.print("[");
        for (int item : nums) {
            System.out.print(item + " ");
        }
        System.out.print("]");
    }
}
