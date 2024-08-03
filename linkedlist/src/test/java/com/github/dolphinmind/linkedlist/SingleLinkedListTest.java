package com.github.dolphinmind.linkedlist;

import com.github.dolphinmind.linkedlist.uitls.ListNode;
import com.github.dolphinmind.linkedlist.uitls.SingleLinkedList;
import org.junit.Test;

import java.util.Arrays;

public class SingleLinkedListTest {

    /**
     * <p>重点：
     * Java 泛型确实主要设计用于处理引用类型，这意味这泛型通常与包装类一起使用。这是因为Java泛型在编译时需要类型信息来进行
     * 类型检查，而在运行时使用类型擦除，这意味着泛型的实际类型参数会被替换为它们的基类型（对于引用类型来说通常是Object或
     * 特定的接口）。因此，基本类型如int, char, boolean等不能使用直接作为泛型参数使用，因为它们没有对应的运行时类型信息
     *</p>
     *
     * <p>泛型与基本类型
     * 基本类型：如int, double,char等，这些类型在内存中占用固定戴奥的空间，并且存储在栈中
     * 包装类：如Integer,Double， Character等，这些类是基本类型的对应对象形式，它们继承自java.lang.Object类，并且
     * 可以作为泛型参数使用
     * <p/>
     * <p>
     * 泛型与包装类
     * 当使用泛型时，实际上是在告诉编译器："我将使用某种类型的对象，但我不关心它是什么类型。" 这样可以编写可重用代码
     * 由于基本类型不是对象，它们不能直接作为泛型参数使用。但是Java提供了自动装箱和拆箱机制，使得在大多数情况下，我们可以像使用对象意义使用基本类型
     * </p>
     *
     *<p> 自动装箱和拆箱
     *  自动装箱：将基本类型自动转换为相应的包装类对象
     *  自动拆箱：将包装类对象自动转换为基本类型
     *</p>
     *
     * @description 测试数组转换为链表
     */

    public SingleLinkedList<Integer> init() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        if (nums instanceof int[]) {
//            System.out.println("nums is int[]");
        }

//        System.out.println("数组元素中的基本类型判断" + nums.getClass().getComponentType().getName());

        // 1. 创建 SingleLinkedList 对象
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();

        // 2. 使用自动装箱将 int[] 转换为 Integer[]
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // 调用 array2LinkedList 方法
        singleLinkedList.array2LinkedList(boxedNums);
        singleLinkedList.printLinkedList();


        return singleLinkedList;
    }

    @Test
    public void test_array2LinkedList() {
       init().printLinkedList();
    }

    @Test
    public void test_addNodeHead() {
        SingleLinkedList<Integer> singleLinkedList = init();

        singleLinkedList.addNodeHead(new ListNode<>(10, null));
        singleLinkedList.printLinkedList();

        singleLinkedList.addNodeHead(new ListNode<>(11, null));
        singleLinkedList.printLinkedList();


    }

    @Test
    public void test_addNodeTail() {
        SingleLinkedList<Integer> singleLinkedList = init();

        singleLinkedList.addNodeTail(new ListNode<>(10, null));
        singleLinkedList.printLinkedList();

        singleLinkedList.addNodeTail(new ListNode<>(11, null));
        singleLinkedList.printLinkedList();
    }

    @Test
    public void test_insertNodeBeforeHead() {
        SingleLinkedList<Integer> singleLinkedList = init();

        singleLinkedList.insertNodeBeforeHead(new ListNode<>(10, null), 0);
        singleLinkedList.printLinkedList();

        singleLinkedList.insertNodeBeforeHead(new ListNode<>(10, null), 1);
        singleLinkedList.printLinkedList();

        singleLinkedList.insertNodeBeforeHead(new ListNode<>(10, null), 100);
        singleLinkedList.printLinkedList();

    }

    @Test
    public void test_insertNodeAfterDummyHead() {
        SingleLinkedList<Integer> singleLinkedList = init();

        singleLinkedList.insertNodeAfterDummyHead(new ListNode<>(10, null), 0);
        singleLinkedList.printLinkedList();

        singleLinkedList.insertNodeAfterDummyHead(new ListNode<>(10, null), 1);
        singleLinkedList.printLinkedList();

        singleLinkedList.insertNodeAfterDummyHead(new ListNode<>(10, null), 100);
        singleLinkedList.printLinkedList();
    }


    @Test
    public void test_deleteNode() {
        SingleLinkedList<Integer> singleLinkedList = init();
        singleLinkedList.deleteNode(1);
        singleLinkedList.printLinkedList();

        singleLinkedList.deleteNode(100);
        singleLinkedList.printLinkedList();
    }

    @Test
    public void test_searchNode() {
        SingleLinkedList<Integer> singleLinkedList = init();
        singleLinkedList.searchNode(1);
        singleLinkedList.searchNode(100);
    }

    @Test
    public void test_reverseSingleLinkedList() {
        SingleLinkedList<Integer> singleLinkedList = init();

        singleLinkedList.reverseSingleLinkedList();
        singleLinkedList.printLinkedList();
    }

    @Test
    public void test_swapPairs() {
        SingleLinkedList<Integer> singleLinkedList = init();

        singleLinkedList.swapPairs();
        singleLinkedList.printLinkedList();
    }
}
