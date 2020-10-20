package com.zuijianren.linkList;

/**
 * 题目：
 *    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *    将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  思路：
 *      可以将问题转化为，将两链表进行合并，一正一反，反序列的节点可以通过栈的结构特性来获取，
 *      然后，修改指针，达到目的，最后，由于中间的节点会变为最后的节点，未避免循环指向，应进行置空，
 *      由于中间节点有两种情况，因此需要分别思考，单双两种情况，是应该将哪个节点的next置空
 *
 *      除此之外，还需考虑，链表长度为 0 和为 1的情况，二者都不用进行处理，
 *      应提出来，避免当成一般情况考虑，最后出现空指针问题
 */


import org.junit.Test;

import java.util.Stack;




/**
 * @author zuijianren
 * @date 2020/10/20 9:40
 */
public class 重排链表 {
    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        ListNode l1 = new ListNode();

        reorderList(l1);
        while (l1!=null){
            System.out.println(l1.val);
            l1 = l1.next;
        }

    }

    /**
     *
     * @param head
     * @return
     */
    static void reorderList(ListNode head){
        // 空链表或者只有一个节点的链表不用处理
        if(head == null || head.next == null){
            return;
        }
        int length = 0;
        // 指针
        ListNode pointer = head;
        // 栈
        Stack<ListNode> stack = new Stack<>();
        // 获取链表长度，并将链表入栈
        while (pointer!=null){
            stack.push(pointer);
            length++;
            pointer=pointer.next;
        }

        // 判断长度是否为双数
        boolean isEvenNumbers = (length%2)==0? true:false;

        // 使指针重新指向链表头部
        pointer = head;
        // 栈中弹出的节点
        ListNode node;
        for (int i = 0; i < length / 2; i++) {
            node = stack.pop();
            node.next = pointer.next;
            pointer.next = node;
            // 最后一次循环
            if(i==length/2 - 1){
                // 双数，右边设置节点的next为空
                if(isEvenNumbers){
                    node.next = null;
                }else {
                    pointer.next.next.next = null;
                    break;
                }
            }
            pointer = pointer.next.next;
        }
    }

}
