package week01;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class work02 {
    public static void main(String[] args) {
        ListNode listNode01 = new ListNode(2);
//        listNode01.next = new ListNode(2);
//        listNode01.next.next = new ListNode(4);

        ListNode listNode02 = new ListNode(1);
//        listNode02.next = new ListNode(3);
//        listNode02.next.next = new ListNode(4);

        ListNode listNode = new work02().mergeTwoLists(listNode01, listNode02);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode headNode = new ListNode();
        if(list1 == null){
            headNode = list2;
            return headNode;
        }
        if(list2 == null){
            headNode = list1;
            return headNode;
        }
        if(list1 == null && list2 == null){
            return headNode;
        }

        if(list1.val <= list2.val){
            headNode = list1;
            list1 = list1.next;
            if(list1 == null){
                headNode.next = list2;
            }
        }else{
            headNode = list2;
            list2 = list2.next;
            if(list2 == null){
                headNode.next = list1;
            }
        }
        ListNode listNode = new ListNode();
        listNode = headNode;


        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                headNode.next = list1;
                list1 = list1.next;
            }else{
                headNode.next = list2;
                list2 = list2.next;
            }
            headNode = headNode.next;
            if(list1 == null){
                headNode.next = list2;
            }

            if(list2 == null){
                headNode.next = list1;
            }
        }
        return listNode;
    }
}

