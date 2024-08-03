package com.github.dolphinmind.array;

import com.github.dolphinmind.array.SquaresOfASortedArray;
import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName SquaresOfASortedArray
 * @description
 * @date 2024/7/31
 */

public class SquaresOfASortedArrayTest {

    @Test
    public void test_twoPointersReverse() {
        int[] nums = {-4,-1,0,3,10};
//        int[] nums = {};

        int[] result = new SquaresOfASortedArray().twoPointersReverse(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
