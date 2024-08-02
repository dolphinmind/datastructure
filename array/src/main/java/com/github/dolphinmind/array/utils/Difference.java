package com.github.dolphinmind.array.utils;

/**
 * @author dolphinmind
 * @ClassName Difference
 * @description 差分数组
 *              性质：对于任何常数c，如果将原始数组的所有元素加上c,则差分数组不变
 *              即arr[i] -> arr[i] + c 不改变 diff数组
 * @date 2024/8/2
 */

public class Difference {

    private int[] diff;

    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];

        // 初始值保持不变
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    /**
     * 给闭区间[i,j]增加val(可以是负数)
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        // 边界判断
        if (j + 1 < diff.length) {
            diff[j+1] -= val;
        }
    }

    /**
     * 返回复原数组
     * @return
     */
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];

        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i-1] + diff[i];
        }

        return res;
    }
}
