package com.github.dolphinmind.array;

import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName MinimumSizeSubarraySumTest
 * @description
 * @date 2024/8/1
 */

public class MinimumSizeSubarraySumTest {

    @Test
    public void test_caterpillarMovement() {
        int[] nums = {2,3,1,2,4,3};
//        int[] nums = {};
//        int[] nums = {1};
        int target = 7;

        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int res = minimumSizeSubarraySum.caterpillarMovement(nums, target);
        System.out.println("'毛虫移动/滑动窗口'获取最小和区间长度：" + res);
    }
}
