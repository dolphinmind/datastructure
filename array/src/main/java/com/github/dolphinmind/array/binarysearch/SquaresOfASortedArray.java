package com.github.dolphinmind.array.binarysearch;

/**
 * @author dolphinmind
 * @ClassName SquaresOfASortedArray
 * @description 977. 有序数组的平方
 *              分析：有移除元素{@link RemoveElement}中的双向指针的思路，不过当前解法是开辟一个新数组
 * @date 2024/7/31
 */

public class SquaresOfASortedArray {
    public int[] twoPointersReverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = result.length - 1;

        while (left <= right) {
            if (Math.pow(nums[left], 2) > Math.pow(nums[right], 2)) {
                result[index--] = (int) Math.pow(nums[left], 2);
                ++left;
            } else {
                result[index--] = (int) Math.pow(nums[right], 2);
                --right;
            }
        }

        return result;
    }
}
