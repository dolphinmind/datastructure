package com.github.dolphinmind.hashcode;

import com.github.dolphinmind.hash.TwoSum;
import org.junit.Test;

import java.util.List;

/**
 * @author dolphinmind
 * @ClassName TwoSumTest
 * @description
 * @date 2024/8/9
 */

public class TwoSumTest {

    @Test
    public void test_towSumGetOneResult() {
        int[] nums = {1,3,5,7,8,9};
        int target = 10;

        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSumGetOneResult(nums, target);
        System.out.println("获取单个索引对结果："+res[0] + " " + res[1]);

        List<Integer> integers = twoSum.twoSumGetAllResult(nums, target).get(0);
        System.out.println("获取所有索引对结果："+integers.get(0) + " " + integers.get(1));
    }

    @Test
    public void test_towSumGetAllResult() {
        int[] nums = {1,1,1,9,7,9,7,3,5,7,8,9,9,7,8,9};
        int target = 10;

        TwoSum twoSum = new TwoSum();
        List<List<Integer>> lists = twoSum.twoSumGetAllResult(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list.get(0) + " " + list.get(1));
        }

        System.out.println(lists.get(0));
    }
}
