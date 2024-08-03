package com.github.dolphinmind.linkedlist.uitls;

/**
 * @author dolphinmind
 * @ClassName SingleLinkedList
 * @description 单链表
 * @date 2024/8/3
 */

public class SingleLinkedList<E> {

    // 单链表头结点
    private ListNode<E> head;

    public SingleLinkedList()
    {
        this.head = null;
    }

    // 1. 将数组元素转化为链表
    public void array2LinkedList(E[] nums)  {

        if (null == nums || nums.length == 0) {
            return ;
        }

        head = new ListNode<>(nums[0], null);
        ListNode<E> cur = head;

        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode<>(nums[i], null);
            cur = cur.next;
        }

    }

    // 2. 头部增加结点
    public void addNodeHead(ListNode<E> node) {

        if (null == node) {
            return;
        }

        System.out.println("头部增加新结点：");

        ListNode<E> dummyHead = new ListNode<>();
        dummyHead.next = node;
        node.next = head;
        head = dummyHead.next;
    }

    // 3. 尾部增加结点
    public void addNodeTail(ListNode<E> node) {

        if (null == node) {
            return;
        }

        System.out.println("尾部增加新结点：");

        ListNode<E> cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = node;
    }

    /** 插入结点：包含原链表本身及其两侧的边界扩展扩展
     * insertNodeBeforeHead 与 insertNodeAfterDummyHead 等价
     * 1. 链表可以看做等价于数组的存在，索引都看做从0开始
     * 2. 两种对于n的看法，逻辑边界处理
     * insertNodeBeforeHead，   n表示以Head为索引0       表示在对应索引之前添加一个结点
     * insertNodeAfterDummyHead n表示以DummyHead为索引0，表示在对应索引之后添加一个结点
     * 3. cur永远在目标索引之前的位置
     * @param node 待插入结点
     * @param n n = [0, length)
     */
    public void insertNodeBeforeHead(ListNode<E> node, int n) {
        // 输入判断
        if (null == node || n < 0 || null == head) {
            return;
        }

        // 头部插入结点
        if (n == 0) {
           node.next = head;
           head = node;

           return;
        }


        ListNode<E> cur = head;

        // 移动游标至目标的前一个位置，移动的最大次数为n-1
        for (int i = 1; i < n; i++) {
            if (null != cur.next) {
                cur = cur.next;
            } else {
                System.out.println( "cur游标指针到了原链表末端,n超出了链表边界，末端直接添加结点");
                break;
            }
        }

        // 即便cur.next = null, 对后续也没有影响，相当于插入到尾部
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 添加入虚拟头节点，使得每个结点的处理条件都一致，与二分法的逻辑区间划分逻辑上是相通的，保证了循环不变量
     * @param node
     * @param n
     */
    public void insertNodeAfterDummyHead(ListNode<E> node, int n) {

        if (null == node || n < 0) {
            return;
        }

        ListNode<E> dummyHead = new ListNode(null, head);
        ListNode<E> cur = dummyHead;

        // 移动游标至目标的前一个位置，移动的最大次数为n
        for (int i = 0; i < n; i++) {
            if (null != cur.next) {
                cur = cur.next;
            } else {
                System.out.println( "cur游标指针到了原链表末端,n超出了链表边界，末端直接添加结点");
                break;
            }
        }

        node.next = cur.next;
        cur.next = node;

        head = dummyHead.next;
    }

    /**
     * 删除结点直包含原有的链表结点本身
     * @param n
     */
    public void deleteNode(int n) {

        if (n < 1 || head == null) {
            return;
        }

        ListNode<E> dummyHead = new ListNode(null, head);
        ListNode<E> cur = dummyHead;

        // 移动游标至目标的前一个位置，移动的最大次数为n
        for (int i = 1; i < n; i++) {
            if (null != cur) {
                cur = cur.next;
            } else {
                System.out.println( "cur游标指针到了原链表末端,n超出了链表边界，删除结点失败！");
                return;
            }
        }

        cur.next = cur.next.next;
        head = dummyHead.next;
    }

    /**
     * 查询/修改一致，只对原有的链表进行操作
     * 加入虚拟结点，只是为了统一处理
     * @param n
     */
    public void searchNode(int n) {

        if (n < 1 || null == head) {
            return;
        }

        ListNode<E> dummyHead = new ListNode(null, head);
        ListNode<E> cur = dummyHead;

        for (int i = 0; i < n; i++) {
            if (null != cur.next) {
                cur = cur.next;
            } else {
                System.out.println( "cur游标指针到了原链表末端,n超出了链表边界，查询结点失败！");
                return;
            }
        }
        System.out.println(cur.val);
    }

    public void reverseSingleLinkedList() {

        // 头节点为空，或者为单个结点直接返回
        if (null == head || head.next == null) {
            return;
        }

        // 左侧链表头部
        ListNode<E> leftHead = null;

        // 拆分链表获取原链表左侧第一个结点
        ListNode<E> rightSlow = head;

        // 拆分链表获取链表右侧
        ListNode<E> rightFast = head.next;

        // 外部循环控制rightSlow边界至链表末尾
        while (null != rightSlow) {

            // 左侧链表
            rightSlow.next = leftHead;
            leftHead = rightSlow;

            // 右侧链表
            rightSlow = rightFast;

            // 内部判断控制rightFast边界null
            if (null != rightFast) {
                rightFast = rightFast.next;
            }

        }

        head = leftHead;

    }

    // 打印链表
    public void printLinkedList() {

        if (null == head) {
            return;
        }

        ListNode<E> cur = head;

        while (null != cur) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

        System.out.println();
    }
}
