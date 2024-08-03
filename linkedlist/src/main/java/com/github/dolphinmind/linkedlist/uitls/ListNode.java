package com.github.dolphinmind.linkedlist.uitls;

/**
 * @author dolphinmind
 * @ClassName ListNode
 * @description
 * @date 2024/8/3
 */

// 链表组成元素：节点
public  class ListNode<E> {
    public E val;
    public ListNode<E> next;

    public ListNode()
    {
        this.val = null;
        this.next = null;
    }

    public ListNode(E val, ListNode<E> next)
    {
        this.val = val;
        this.next = next;
    }

}
