package com.github.dolphinmind.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dolphinmind
 * @ClassName TwoSum
 * @description
 * @date 2024/8/9
 */

public class TwoSum {

    /**
     * 获取单个结果即返回
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumGetOneResult(int[] nums, int target) {
        if (nums == null || nums.length < 2 ) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference),i};
            }

            map.put(nums[i],i);
        }
        return new int[0];
    }

    /**
     * 获取所有结果
     */

    public List<List<Integer>> twoSumGetAllResult(int[] nums, int target) {
        if (nums == null | nums.length < 2) {
            return null;
        }

        //值：索引列表
        Map<Integer, List<Integer>> map = new HashMap();
        // 索引对结果集合
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                for (int index : map.get(complement)) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(index);
                    pair.add(i);
                    res.add(pair);
                }
            }

            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        return res;

    }
}
