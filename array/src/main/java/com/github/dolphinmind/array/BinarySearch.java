package com.github.dolphinmind.array;

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

    /**
     * <p>
     *     左右边界索引的二分查找，适用于查找左边界和右边界，但同样适应于数组中只存在一个target的情况
     *     假设target = nums[mid]一开始就成立
     *     尽管在第一次比较时，right或left可能看似"跳过了"目标值，
     *     但由于target唯一性，后续的搜索范围更新操作不会导致left或right错过target
     *     对于的就是左边界索引的left = mid + 1, 有边界索引的 right = mid - 1
     *     left 或 right都会正确地指向target的索引位置，成为有效的左边界或有边界索引
     * </p>
     */

    /**
     * 前置条件：有序数组，元素可允许可重复
     * Left Bound Index ,指的是目标值首次出现的位置，如果数组中有多个相同的元素(即重复值)，左边界索引是目标值在数组中的最早出现位置
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if (target == nums[mid]) {
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]){
                left = mid + 1;
            }
        }

        // 增加边界检查
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    /**
     * 前置条件：有序数组，元素可允许可重复
     * Right Bound Index ,指的是目标值最后出现的位置，如果数组中有多个相同的元素(即重复值)，右边界索引是目标值在数组中的最晚出现位置
     * @param nums
     * @param target
     * @return
     */
    public int rightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);

            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }

}
