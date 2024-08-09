package com.github.dolphinmind.hash;

/**
 * @author dolphinmind
 * @ClassName ValidAnagram
 * @description
 * @date 2024/8/6
 */

public class ValidAnagram {

    /**
     * Anagram: a word or phrase that is made by changing the order of the letters in another word or phrase
     * 变位词（组）〔改变某个词或短语的字母顺序后构成的新词或短语
     *
     * 初始判断：
     * 1. 入参判断：是否为空引用，实例化是否为空字符串
     * 2. 输入长度是否相等
     *
     * 思路：
     * 1. 字母字符，26个字母，26个字母的ASCII码范围：[97, 122]，固定
     * 2. 任意字符减去97，得到ASCII码值，可作为数组下标，即索引与字符一一对应，即该方式的hash函数是:字符-'a'得到哈希映射
     * 3. 创建26个元素的数组，用于统计s中每个字符出现的次数，字母多次出现，就相当于出现了哈希碰撞，在这里通过+1来处理哈希碰撞
     * 4. 遍历t,两个字符串为Anagram，那么其每个字符出现的次数是一致的，即两个字符串等价
     *    遍历后放入和取出对哈希表没有影响
     *    若哈希表发生了改变，则返回false，也就表明不是Anagram
     *
     *    这里面其实就是在假设，两个是等价的，一个放入和取出的过程
     *
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return false;
        }

        if (s.length() != t.length()) {
            System.out.println("false");
        }

        int[] sCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            sCount[t.charAt(i) - 'a']--;
        }

        for (int item : sCount) {
            if (item != 0) {
                System.out.println("false");
                return false;
            }
        }

        System.out.println("true");
        return true;
    }
}
