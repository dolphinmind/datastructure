package com.github.dolphinmind.linkedlist;

import com.github.dolphinmind.linkedlist.uitls.ListNode;

/**
 * @author dolphinmind
 * @ClassName LinkedListCycle
 * @description 141. 环形链表
 * @date 2024/8/4 slow的速度v = 1
 *                fast的速度v = 2
 *                在没有环的情况下，fast会最先到达末尾，从而返回false
 *                在有环的情况下,  fast在未进入环之前的情况和上述类似，fast进入环之后，fast开始在环内转圈
 *                直到slow也进入圈内，两者的相对速度为v = 1，此时fast指针反追击slow，直到fast追击到slow为止
 *                刚刚在思考的时候，突然想起链表相交的问题：发觉160链表相交问题与当前141环形链表问题有一定的相似性
 *
 *                假设 headA = 1->2->3->4
 *                    headB = 5->6->7->8->9->4
 *
 *                    slow  = 1->2->3->4->5->6->7->8->9->4
 *                    fast  = 5->6->7->8->9->4->1->2->3->4
 *
 *                  head = 1->2->3->4->5->6->7->8->4
 *                  slow = 1->2->3->4->5->6->7->8->4->5->6
 *                  fast = 1->3->5->7->4->6->8->5->7->4->6
 */

public class LinkedListCycle {

    /**
     * 双指针法
     * @param head
     * @return
     */
    public boolean hasCycleTowPointer(ListNode<?> head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode<?> slow = head;
        ListNode<?> fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }



}
