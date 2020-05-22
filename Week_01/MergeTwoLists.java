/**
 * Created by xutao on 2020/3/23.
 */
public class MergeTwoLists {

    /**
     * 21. 合并两个有序链表
     将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

     示例：

     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }


    public ListNode mergeTwoListsForLoop(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

}

/**
 Definition for singly-linked list.
 */
 class ListNode {
 int val;
 ListNode next;
 ListNode(int x) { val = x; }
 }
