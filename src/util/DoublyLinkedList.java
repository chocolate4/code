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
        DoublyNode temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
    }

    public void addBeforeNode(int val){
        DoublyNode node = new DoublyNode(val);
        DoublyNode temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
    }

    public void addBehindNode(int val){
        DoublyNode node = new DoublyNode(val);
        DoublyNode temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
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
        while (temp != tail){
            System.out.println(temp.val);
            temp = temp.next;
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
