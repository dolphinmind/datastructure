package com.github.dolphinmind.linkedlist;

import com.github.dolphinmind.linkedlist.uitls.ListNode;

/**
 * @author dolphinmind
 * @ClassName IntersectionOfTwoLinkedListsIcci
 * @description
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
             * 相交的情况：就是相遇问题
             * 不相交的情况：courseA和courseB会把双方所有结点遍历一遍
             * eg: headA = 1->2->3->4->5
             *     headB = 6->7->8
             *
             *     courseA = 1->2->3->4->5  ->6->7->8  ->6
             *     courseB = 6->7->8  ->1->2->3->4->5  ->1
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
}
