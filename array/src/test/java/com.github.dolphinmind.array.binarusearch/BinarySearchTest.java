package com.github.dolphinmind.array.binarusearch;

import com.github.dolphinmind.array.binarysearch.BinarySearch;
import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName ApiTest
 * @description
 * @date 2024/7/31
 */

public class BinarySearchTest {

    /**
     * 找房子编号，不要找房子里面的内容
     */
    @Test
    public void test_binarySearchRightClose() {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearchRightClose(nums, target);
        System.out.println("左闭右闭区间选择：" + result);
    }

    @Test
    public void test_binarySearchRightOpen() {
//        int[] nums = {-1,0,3,5,9,12};
        int[] nums = {};
        int target = 2;

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearchRightOpen(nums, target);
        System.out.println("左闭右开区间选择：" + result);
    }


    @Test
    public void test_leftBound() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.leftBound(nums, target);
        System.out.println("左边界索引：" + result);
    }

    @Test
    public void test_rightBound() {
        int[] nums = {-1,0,3,5,9,12};
//        int[] nums = {};
        int target = 2;

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.rightBound(nums, target);
        System.out.println("右边界索引：" + result);
    }
}
