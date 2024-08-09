package com.github.dolphinmind.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author dolphinmind
 * @ClassName intersectionoftwoarrays
 * @description 349 求两个数组的交集
 * @date 2024/8/9
 */

public class InterSectionOfTwoArrays {

    /**
     * 双指针写法
     * @param nums1
     * @param nums2
     */
    public void intersectionTwoPointers(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            System.out.println("数组为空");
            return;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = Math.min(nums1.length, nums2.length);
        int[] res = new int[len];

        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                /**
                 * 避免重复
                 * 首次添加元素：如果index == 0,说明结果数组还没有任何元素，此时直接将找到的交集元素添加到结果数组中
                 * 避免重复添加：如果index ！= 0, 说明结果数组中已经有至少一个元素。此时需要检查当前要添加的元素是否与结果数组中的最后一个元素相同
                 * 如果相同，则跳过本次循环，继续下一次循环，直到找到不同的元素
                 */
                if (index == 0 || res[index - 1] != nums1[i]) {
                    res[index++] = nums1[i];
                }
                i++;
                j++;
            }
        }

        printArray(removeZeros(res, index));
    }

    /**
     * 去除数组中0
     * @param arr
     * @param index
     * @return
     */
    public int[]  removeZeros(int[] arr, int index) {
        int[] newArr = new int[index];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }
    public void printArray(int[] arr) {
        System.out.print("[");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println("]");
        System.out.println();
    }

    /**
     * HashSet写法
     */

    public void interSectionHashSet(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int item : arr1) {
            set.add(item);
        }

        for (int item : arr2) {
            if (set.contains(item)) {
                res.add(item);
            }
        }

        /**
         * 将List转换为数组.尽管mapToInt并没有改变流中的元素，但是它的作用是将Stream转换为IntStream
         * 以便最后能够直接使用.toArray()方法得到一个int[]类型
         */
        printArray(res.stream().mapToInt(x -> x).toArray());
    }

}
