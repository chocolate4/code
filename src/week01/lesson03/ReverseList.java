package week01.lesson03;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 *  1 -> 2 -> 3 -> null
 *  一。
 *  2 -> 3 -> null
 *  1 - null
 *  二。
 *  3 -> null
 *  2 -> 1 -> null
 *  三。
 *  3 -> 2 -> 1 -> null
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode listNode1 = new ReverseList().reverseList(listNode);
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = last;
            last = head;
            head = nextNode;
        }
        return last;
    }
}
