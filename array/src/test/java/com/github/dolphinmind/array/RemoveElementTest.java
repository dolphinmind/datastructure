package com.github.dolphinmind.array;

import com.github.dolphinmind.array.RemoveElement;
import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName RemoveElementTest
 * @description
 * @date 2024/7/31
 */

public class RemoveElementTest {

    /**
     * 测试同向快慢双指针
     */
    @Test
    public void test_removeElementTwoPointersCoextensive() {
        int[] nums = {3,2,2,3};
        int val = 3;

        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElementTwoPointersCoextensive(nums, val);
        System.out.println(result);
        print(nums, result);
    }

    /**
     * 测试反向双指针
     */
    @Test
    public void test_removeElementTowPointersReverse1() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElementTowPointersReverse1(nums, val);
        System.out.println(result);
        print(nums, result);
    }


    /**
     * 测试反向双指针
     */
    @Test
    public void test_removeElementTowPointersReverse2() {
        int[] nums = {};
        int val = 2;

        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElementTowPointersReverse2(nums, val);
        System.out.println(result);
        print(nums, result);
    }

    public void print(int[] nums, int len) {
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }
}
