package com.github.dolphinmind.array;

import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName RangeSumQueryImmutableTest
 * @description
 * @date 2024/8/2
 */

public class RangeSumQueryImmutableTest {

    @Test
    public void test_sunRange() {
//        int[] nums = {-2, 0, 3, -5, 2, -1};
//        int[] nums   =  {   1, 2, 3, 4,  5,  6,  7,  8};
        int[] nums   = {};

        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums);

        rangeSumQueryImmutable.printOriginArray(nums);
        rangeSumQueryImmutable.printPreSum();
        rangeSumQueryImmutable.printRecoverArray();

        System.out.println("\n");
        System.out.println(rangeSumQueryImmutable.sumRange(2, 2));
        System.out.println(rangeSumQueryImmutable.sumRange(0, 1));
        System.out.println(rangeSumQueryImmutable.sumRange(1, 0));
        System.out.println(rangeSumQueryImmutable.sumRange(1, 9));
        System.out.println(rangeSumQueryImmutable.sumRange(0, 7));

    }
}
