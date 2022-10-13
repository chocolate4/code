package util;

public class DoublyLinkedList {

    DoublyNode head;
    DoublyNode tail;

    public DoublyLinkedList(){
        head = new DoublyNode();
        tail = new DoublyNode();
        head.next = tail;
        tail.pre = head;
    }

    public void addBehindHead(int val){
        DoublyNode node = new DoublyNode(val);
        DoublyNode temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
    }

    public void addBeforeTail(int val){
        DoublyNode node = new DoublyNode(val);
        DoublyNode temp = tail.pre;
        temp.next = node;
        node.pre = temp;
        node.next = tail;
        tail.pre = node;
    }

    public void addBeforeNode(int val){
    }

    public void addBehindNode(int val){
    }

    public void deleteNode(int val){
        DoublyNode temp = head.next;
        while (temp != tail){
            if(temp.val == val) break;
            temp = temp.next;
        }
        if(temp != tail) {
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }
    }

    public void printList(){
        DoublyNode temp = head.next;
        System.out.print("->");
        while (temp != tail){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println();
        System.out.print("<-");
        DoublyNode temp1 = head.next;
        while (temp1 != tail){
            System.out.print(temp1.val+"<-");
            temp1 = temp1.next;
        }
    }
}

class DoublyNode{

    int val;

    DoublyNode pre;

    DoublyNode next;

    public DoublyNode(){}

    public DoublyNode(int val){this.val = val;}

    public DoublyNode(int val, DoublyNode pre, DoublyNode next){this.val = val; this.pre = pre; this.next = next;}

}
