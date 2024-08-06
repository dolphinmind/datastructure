package com.github.dolphinmind.hash.utils;

/**
 * @author dolphinmind
 * @ClassName HashMap
 * @description
 * @date 2024/8/5
 */

public class HashMapSelfDefine {

    /**-------------------------------初始化容量---------------------------------------------------*/
    private float threshold;

    public HashMapSelfDefine(int initialCapacity) {
        /**
         * 寻找比初始值大，最小的2进制数值，比如传了17，则目标threshold就为32(与绘制生态散点图图例有异曲同工之妙)
         */
        this.threshold = tableSizeFor(initialCapacity);
    }

    /**
     * 1. 为什么MAXIMUM_CAPACITY = 1 << 30? INT最大的值是2^31 - 1，首位为符号位，如果右移 1 << 31,就会导致首位为1，为负数
     *     2^30 是int类型中最大的2幂次方值，幂次方是指只有首位为1，其余为0
     *
     * 2.  n |= n >>> 1 直到 n |= n >>> 16的作用，且为什么到16就截至？
     *     int最高位是符号位，右移操作，最多只能右移31位，
     *     右移操作的目的就是为了把二进制的各个位置都填上1，最后把结果加1再返回即可
     *
     * 3. << 和 <<<(不存在) ，>>（有符号） 和 >>>（无符号） ？
     * @param cap
     * @return
     */

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**-------------------------------负载因子---------------------------------------------------*/
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**-------------------------------扰动函数--------------------------------------------------*/

    /**
     * 扰动计算函数：增加随机性，让数据元素更加均衡的散列，减少碰撞
     * @param key hash方法是对hashCode方法结果的进行优化，以提高哈希分布的均匀性和减少哈希冲突
     * @return
     */
    static int hash(Object key) {
        int h;

        /**
         * hashCode的取值范围：0 - 2^31 - 1，有将近40亿的长度
         * 默认初始化的Map大小是16个长度：DEFAULT_INITIAL_CAPACITY = 1 << 4
         * 获取的Hash值并不能直接作为下标使用，需要与数组长度进行取模运算得到一个下标值，即散列因子
         * 1. h = key.hashCode() 计算哈希值
         * 2. h >>> 16， 把哈希值右移16位，也就正好为自己长度的一半，int类型
         * 3. 之后与原哈希值做异或运算，混合原哈希值中的高位和低位，增大了随机性
         */
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static int disturbHashIdx(String key, int size) {
        return (size - 1) & (key.hashCode() ^ (key.hashCode() >>> 16));
    }

    public static int hashIdx(String key, int size) {
        return (size - 1) & key.hashCode();

    }

}
