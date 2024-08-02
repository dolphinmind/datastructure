package com.github.dolphinmind.array;

/**
 * @author dolphinmind
 * @ClassName RangeSumQueryImmutable
 * @description 303. 区域和检索 - 数组不可变
 * @date 2024/8/2
 */

public class RangeSumQueryImmutable {

    // 前缀和数组 缓存概念
    private int[] preSum;
    private int[] recoverArray;
    private int length;

    public RangeSumQueryImmutable(int[] nums) {


        length = nums.length;

        // 初始化前缀和数组 preSum[0]=0, 允许空数组的存在
        preSum = new int[length + 1];

        // 初始化恢复数组 recoverArray
        recoverArray = new int[length];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }

    }

    public int sumRange(int left, int right) {

        if (left < 0 || right >= preSum.length - 1) {
            System.out.print("索引超出数组范围: ");
            return -1;
        }

        if (left == right) {
            System.out.print("索引相同: ");
            return 0;
        }

        if (left > right) {
            System.out.print("索引顺序错误: ");
            return preSum[left+1] - preSum[right];
        }

        System.out.print("索引顺序正确: ");
        return preSum[right + 1] - preSum[left];

    }

    public void recoverArray() {
        for (int i = length-1 ; i >= 0; i--) {
            recoverArray[i] = preSum[i+1]-preSum[i];
        }
    }

    public void printArray(int[] nums) {
        System.out.println();

        System.out.print("[");
        for (int item : nums) {
            System.out.print(item + " ");
        }
        System.out.print("]");
    }

    public void printOriginArray(int[] nums) {
        System.out.print("\n原始数组：");
        printArray(nums);
    }
    public void printPreSum() {
        System.out.print("\n前缀和数组：");
        printArray(preSum);
    }

    public void printRecoverArray() {
        this.recoverArray();
        System.out.print("\n复原数组: ");
        printArray(recoverArray);
    }
}
