package com.github.dolphinmind.array;

/**
 * @author dolphinmind
 * @ClassName MinimumSizeSubarraySum
 * @description 209 长度最小的子数组
 * @date 2024/8/1
 */

public class MinimumSizeSubarraySum {

    /**
     * 毛毛虫移动的步伐，右指针是头，左指针是尾，循环结束双指针的目的就是遍历，内循环中获取最小子数组和的长度
     * 如何获取这个数组区间呢？
     * 在内循环中，如果sum大于等于target，则说明找到了一个满足题意的区间，此时需要更新result，同时更新区间的左右指针，
     * 通过比较最小子数组的大小，来给minIndex和maxIndex赋值，即确定了最小子区间
     * @param nums
     * @param target
     * @return
     */
    public int caterpillarMovement(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left   = 0;
        int right  = 0;

        int sum    = 0;
        int result = Integer.MAX_VALUE;

        int minIndex = 0;
        int maxIndex = 0;

        /**
         * 外循环控制滑动窗口的右指针
         */
        while (right < nums.length) {
            sum += nums[right];

            /**
             * 内循环控制滑动窗口的左指针，target就像是毛毛虫本身的分量
             */
            while (sum >= target) {
                int len = right - left + 1;

                if (len < result) {
                    result   = len;
                    minIndex = left;
                    maxIndex = right;
                }

                sum -= nums[left++];
            }

            // 先判断当前的区间和是否达到或超过，不满足，则右指针继续向右移动
            right++;
        }

        printMinLenArray(nums, minIndex, maxIndex);

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 打印最短子数组
     * @param nums
     * @param left
     * @param right
     */
    public void printMinLenArray(int[] nums, int left, int right) {
        System.out.print("[");

        while (left <= right) {
            System.out.print(nums[left++] + " ");
        }

        System.out.println("]");
    }
}
