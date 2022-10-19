package week01.lesson04;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

//todo：快慢指针
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            head = head.next;
            if(fast == head){
                return true;
            }
        }
        return false;
    }
}
