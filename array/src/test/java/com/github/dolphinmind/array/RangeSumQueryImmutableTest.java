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
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums);
        System.out.println(rangeSumQueryImmutable.sunRange(0, 2));
        System.out.println(rangeSumQueryImmutable.sunRange(2, 5));
        System.out.println(rangeSumQueryImmutable.sunRange(0, 5));
    }
}
