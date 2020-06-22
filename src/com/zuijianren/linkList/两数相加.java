package com.zuijianren.linkList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 上方是默认给的单链表类
 * 很久没有做链表题了，上次做还是大学用c++的时候，看的我一脸懵逼
 * 都忘记了 p = p.next 这种写法了，自己编程的时候全靠创建新变量来存值，真傻
 * 看了官方解答，才做了出来，和抄答案一摸一样的感觉，理解是理解了，但掌握的还是不行
 * 对于各种异常情况的把握不足，例如：1. 两个都是0， 2.两个加一起刚好进位的情况等
 */
public class 两数相加 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = new ListNode(0);
        ListNode r2 = r;
        int s = 0;

        while(p != null || q != null){
            int x = (p!=null) ? p.val: 0;
            int y = (q!=null) ? q.val: 0;
            int sum = x + y + s;
            s = sum/10;
            sum = sum%10;
            r2.next = new ListNode(sum);
            r2 = r2.next;
            p = p!=null? p.next: null;
            q = q!=null? q.next: null;
        }
        if(s>0){
            r2.next = new ListNode(s);
        }
        return r.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
