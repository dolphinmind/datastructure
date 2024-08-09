package com.github.dolphinmind.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dolphinmind
 * @ClassName HappyNumber
 * @description
 * @date 2024/8/9
 */

public class HappyNumber {

    public boolean isHappy(int n ) {

        Set<Integer> seen = new HashSet<>();

        /**
         * n == 1 是快乐数的判断标准
         * seen.contains(n) 是判断是否出现过n，即判断是否进入了循环
         */
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSquareSum(n);
        }

        return n == 1;
    }

    private int getSquareSum(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        System.out.println(sum);
        return sum;
    }
}
