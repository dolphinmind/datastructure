package com.github.dolphinmind.array;

import com.github.dolphinmind.array.utils.Difference;

/**
 * @author dolphinmind
 * @ClassName RangeAddition
 * @description 370 区间加法
 *
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * @date 2024/8/2
 */

public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {

        // nums 初始化为全0
        int[] nums = new int[length];

        Difference difference = new Difference(nums);

        for (int[] update : updates) {
            int left     = update[0];
            int right    = update[1];
            int constant = update[2];
            difference.increment(left, right, constant);
        }

        return difference.result();
    }
}
