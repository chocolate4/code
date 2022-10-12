package week01.lesson03;

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = new ReverseKGroup().reverseKGroup(listNode,1);
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode project = new ListNode(0);
        project.next = head;
        ListNode temp = project;
        while (head != null) {
            //todo：1.分组
            ListNode end = getEnd(head, k);
            if(end == null) break;
            ListNode nextGroup = end.next;
            //todo：2.反转
            reverseList(head,nextGroup);
            //todo：3.连接首尾
            temp.next = end;
            head.next = nextGroup;
            temp = head;
            head = nextGroup;
        }
        return project.next;
    }
    public ListNode getEnd(ListNode list, int k){
        while (k > 1){
            k--;
            if(list == null) break;
            list = list.next;
        }
        return list;
    }

    public ListNode reverseList(ListNode head, ListNode stop){
        ListNode last = null;
        while (head != stop){
            ListNode cur = head.next;
            head.next = last;
            last = head;
            head = cur;
        }
        return last;
    }

}
