package com.github.dolphinmind.array.binarysearch;

/**
 * @author dolphinmind
 * @ClassName BinarySearch
 * @description 704 二分法搜索
 *              前提条件：有序数组，且无重复元素
 *              循环判断：专注索引
 *              逻辑判断：专注值
 *              特殊情况：无结果，返回-1
 *              技巧：mid = left + ((right - left) >> 1)
 * @date 2024/7/31
 */

public class BinarySearch {

    private int left;
    private int right;
    private int mid;

    /**
     * 二分法搜索：左闭右闭区间
     * 分析：循环条件看索引，中间索引采用移位，逻辑判断条件优先选取目标，循环不成立有兜底 -1
     *      left 处于有效数组的末尾，即不包含target的元素的最后一个位置之后，返回的left即有效数组的长度
     * @param nums
     * @param target
     * @return
     */
    public int binarySearchRightClose(int[] nums, int target) {
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }

        return -1;

    }

    /**
     * 二分法搜索：左闭右开区间
     * @param nums
     * @param target
     * @return
     */
    public int binarySearchRightOpen(int[] nums, int target) {
        left = 0;
        right = nums.length;

        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        return -1;

    }



}
