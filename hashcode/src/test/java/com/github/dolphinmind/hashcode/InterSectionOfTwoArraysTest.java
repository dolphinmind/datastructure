package com.github.dolphinmind.hashcode;

import com.github.dolphinmind.hash.InterSectionOfTwoArrays;
import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName InterSectionOfTwoArraysTest
 * @description
 * @date 2024/8/9
 */

public class InterSectionOfTwoArraysTest {

    @Test
    public void test_intersection() {
        int[] nums1 = {};
        int[] nums2 = {3,4,5,6,7,8};

        new InterSectionOfTwoArrays().intersectionTwoPointers(nums1, nums2);
    }

    @Test
    public void test_interSectionHashSet() {
        int[] nums1 = {1,2,3,4,5,6,7,8};
        int[] nums2 = {3,4,5,6,7,8};
        new InterSectionOfTwoArrays().interSectionHashSet(nums1, nums2);
    }

}
