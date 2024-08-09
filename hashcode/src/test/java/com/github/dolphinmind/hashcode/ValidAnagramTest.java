package com.github.dolphinmind.hashcode;

import com.github.dolphinmind.hash.ValidAnagram;
import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName ValidAnagram
 * @description
 * @date 2024/8/6
 */

public class ValidAnagramTest {

    @Test
    public void test_isAnagram() {
        String s = "appleaf";
        String t = "ppleasf";

        new ValidAnagram().isAnagram(s, t);


    }
}
