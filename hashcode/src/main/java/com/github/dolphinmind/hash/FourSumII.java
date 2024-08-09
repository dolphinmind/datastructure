package com.github.dolphinmind.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dolphinmind
 * @ClassName FourSumII
 * @description 四数相加
 * @date 2024/8/9
 */

public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 统计两个数组中的元素之和，同时统计出现的次数，放入map中
        for (int outer : nums1) {
            for (int inner : nums2) {
                int sum = outer + inner;
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }

        // 统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int outer : nums3) {
            for (int inner : nums4) {
                res += map.getOrDefault(0 - outer - inner, 0);
            }
        }

        return res;
    }
}
