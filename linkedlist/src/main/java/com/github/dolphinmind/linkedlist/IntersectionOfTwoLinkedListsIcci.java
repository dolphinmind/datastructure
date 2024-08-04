package com.github.dolphinmind.linkedlist;

import com.github.dolphinmind.linkedlist.uitls.ListNode;

/**
 * @author dolphinmind
 * @ClassName IntersectionOfTwoLinkedListsIcci
 * @description 160. 相交链表
 *              链表相交通过让指针到达链表末尾时跳转到另一个链表的头部，实际上是将两个链表的长度差异进行了补偿
 *              这样做可以确保两个指针在相交点相遇时，它们相对于相交点的距离是相同的
 * @date 2024/8/3
 */

public class IntersectionOfTwoLinkedListsIcci {
    private  ListNode intersectionNode;

    public ListNode<?> getIntersectionNode(ListNode<?> headA, ListNode<?> headB) {

        ListNode<?> courseA = headA;
        ListNode<?> courseB = headB;
        Boolean flag = false;

        if (headA == null || headB == null) {
            System.out.println("headA or headB is null");
            return null;
        }

        while (courseA != courseB) {
            courseA = courseA != null ? courseA.next : headB;
            courseB = courseB != null ? courseB.next : headA;

            /**
             * 解决两个链接不相交而陷入无限循环的情况
             * 初始值：courseA = headA ,courseB = headB
             *
             * 不相交的情况：courseA和courseB会把双方所有结点遍历一遍
             * eg: headA = 1->2->3->4->5
             *     headB = 6->7->8
             *
             *     courseA = 1->2->3->4->5  ->6->7->8  ->6
             *     courseB = 6->7->8  ->1->2->3->4->5  ->1
             *
             * 相交的情况：就是相遇问题
             * eg: headA = 1->2->3->4->5->8->9->10
             *     headB = 6->7->5->8->9->10
             *
             *     在结点相遇
             *     headA = 1->2->3->4->5->8->9->10 ->6->7 ->5 ->8->9->10
             *     headB = 6->7->5->8->9->10 ->1->2->3->4 ->5 ->8->9->10
             *
             */
            // 单个链表遍历结束
            if (!flag && (courseA == headB || courseB == headA)) {
                flag = true;
            }

            // 两个链表都遍历结束,course回到对方的头节点
            if (flag && (courseA == headB && courseB == headA)) {
                System.out.println("No intersection");
                return null;
            }
        }

        return courseA;
    }

    /**
     * 尾对齐法
     * 1. 计算长度：遍历两个链表，分别计算它们的长度
     * 2. 对齐，计算两个链表的长度差:diff = |lenA - lenB|,令两个指针回归头部，然后相同的起点对齐
     * 3. 同步移动
     * 4. 返回结果
     */
    public ListNode<?> getIntersectionNodeTailAlignmentMethod(ListNode<?> headA, ListNode<?> headB) {

        if (headA == null || headB == null) {
            System.out.println("headA or headB is null");
            return null;
        }

        ListNode<?> courseA = headA;
        ListNode<?> courseB = headB;


        int lenA = 0;
        int lenB = 0;

        while (courseA != null) {
            courseA = courseA.next;
            lenA++;
        }

        while (courseB != null) {
            courseB = courseB.next;
            lenB++;
        }

        courseA = headA;
        courseB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                courseA = courseA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                courseB = courseB.next;
            }
        }

        while (courseA != null && courseB != null) {
            if (courseA == courseB) {
                return courseA;
            }
            courseA = courseA.next;
            courseB = courseB.next;

        }

        return null;

    }



}
