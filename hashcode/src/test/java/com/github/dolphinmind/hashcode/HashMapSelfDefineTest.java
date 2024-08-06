package com.github.dolphinmind.hashcode;

import com.alibaba.fastjson2.JSON;
import com.github.dolphinmind.hash.utils.FileUtil;
import com.github.dolphinmind.hash.utils.HashMapSelfDefine;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dolphinmind
 * @ClassName HashCodeTest
 * @description
 * @date 2024/8/5
 */

public class HashMapSelfDefineTest {

    /**
     * 创建简单的HashMap
     * 存在的问题：
     *      1. 这里所有的元素存放都需要计算一个索引位置，如果元素的位置不够，散列碰撞严重，
     *         也就失去了散列表存放的意义，没有达到预期的性能
     *      2. 在计算索引ID的公式中，需要数组长度是2的幂次方，那么怎么进行初始化这个数组大小？
     *      3. 数组越小碰撞的概率越大，数组越大碰撞的概率越小，时间和空间如何取舍？
     *      4. 目前存放7个元素，已经有两个位置都存放了2个字符串，那么链表越来越长怎么优化？
     *      5. 随着元素的不断增加，数组长度不足扩容时，怎么把原有的元素，拆分到新的位置上去？
     */
    @Test
    public void test_createHashMap(){
        // 初始化一组字符串
        List<String> list = new ArrayList<>();

        // 添加7个元素
        list.add("jlkk");
        list.add("lopi");
        list.add("小傅哥");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        // 定义要存放的数组
        String[] tab = new String[8];

        // 循环存放
        for (String key : list) {
            // 计算索引位置
            int idx = key.hashCode() & (tab.length - 1);
            System.out.println(String.format("key 值 = %s, Idx = %d", key, idx));

            if (null == tab[idx]) {
                tab[idx] = key;
                continue;
            }

            // 模拟哈希冲突
            tab[idx] = tab[idx] + "->" + key;
        }

        System.out.println("测试结果：" + JSON.toJSONString(tab));
    }

    /**--------------------------------------------------------------------------------------*/
    private Set<String> words;
    private String filepathhead = "D:\\Files\\IDEA-workplace\\datastructure\\hashcode\\src\\main\\resources\\";

    @Before
    public void before() {
        String filepath = filepathhead + "103976个英语单词库.txt";
        words = FileUtil.readWordList(filepath);
    }


    @Test
    public void test_DisturbHashIdx(){
        // HashMap会根据计算索引范围，自动扩容
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : words) {
            // 使用扰动函数
            int idx = HashMapSelfDefine.disturbHashIdx(word, 128);
            if (map.containsKey(idx)) {
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            } else {
                map.put(idx, 1);
            }
        }

        try {
            String valuesStr = map.values().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
            FileUtil.writeWordList2Txt(filepathhead + "output_disturb.txt", valuesStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("测试结果：" + JSON.toJSONString(map.values()));
    }

    @Test
    public void test_HashIdx(){
        // HashMap会根据计算索引范围，自动扩容
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : words) {
            // 使用扰动函数
            int idx = HashMapSelfDefine.hashIdx(word, 128);
            if (map.containsKey(idx)) {
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            } else {
                map.put(idx, 1);
            }
        }

        try {
            String valuesStr = map.values().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
            FileUtil.writeWordList2Txt(filepathhead + "output_no_disturb.txt", valuesStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("测试结果：" + JSON.toJSONString(map.values()));
    }

    @Test
    public void test_HashMap() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");

        /**
         * 随机使用一些字符串计算它们分别在16位长度和32位长度数组下的索引分配情况，观察那些数据被重新路由到新的地址
         * Integer.toBinaryString(hash & 16)；16表示哈希桶的个数，后面的32也是，表示在16/32位长度数组下的索引
         * 原哈希值与扩容新增出来的长度16，进行&运算，如果值为0，则下标位置不变，否则新的位置是在原来位置上加16
         * 这样一来，就不需要再重新计算每一个i而数组元素的哈希值
         */
        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串：" + key +
                    " \tIdx(16)：" + ((16 - 1) & hash) +
                    " \tBit值：" + Integer.toBinaryString(hash) + " - " +
                    Integer.toBinaryString(hash & 16) +
                    " \t\tIdx(32)：" + ((32 - 1) & hash));
            System.out.println(Integer.toBinaryString(key.hashCode()) +" "+
                    Integer.toBinaryString(hash) + " " +
                    Integer.toBinaryString((32 - 1) & hash));
            System.out.println();
        }

    }

}
