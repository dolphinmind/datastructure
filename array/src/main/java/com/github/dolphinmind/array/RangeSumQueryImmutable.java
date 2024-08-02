package com.github.dolphinmind.array;

/**
 * @author dolphinmind
 * @ClassName RangeSumQueryImmutable
 * @description 303. 区域和检索 - 数组不可变
 * @date 2024/8/2
 */

public class RangeSumQueryImmutable {

    // 前缀和数组 缓存概念
    private int[] preSum;

    public RangeSumQueryImmutable(int[] nums) {

        // 初始化前缀和数组 preSum[0]=0
        preSum = new int[nums.length + 1];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }

    }

    public int sunRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}
