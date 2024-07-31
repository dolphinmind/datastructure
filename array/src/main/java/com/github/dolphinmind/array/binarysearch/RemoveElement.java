package com.github.dolphinmind.array.binarysearch;

/**
 * @author dolphinmind
 * @ClassName RemoveElement
 * @description 移除元素分析
 *              快慢指针
 *              双向指针
 *              slow和left指针都处于有效数组的末尾，即不包含var的元素的最后一个位置之后，返回的slow和left即有效数组的长度
 * @date 2024/7/31
 */

public class RemoveElement {

    private int left;
    private int right;

    /**
     * 快慢指针同向
     * @param nums
     * @param val
     * @return
     */
    public int removeElementTwoPointersCoextensive(int[] nums, int val) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;
    }

    /**
     * 双指针反向：左指针 右指针 while边界问题也符合开闭原则：左闭右开
     * 疑惑：双指针如果left==right的时候，nums[left] == val,这时返回
     * @param nums
     * @param val
     * @return
     */
    public int removeElementTowPointersReverse1(int[] nums, int val) {
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        if (nums[left] == val) {
            return left - 1;
        }

        return left;
    }

    /**
     * 左闭右闭
     * @param nums
     * @param val
     * @return
     */
    public int removeElementTowPointersReverse2(int[] nums, int val) {
        left = 0;
        right = nums.length;

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}
