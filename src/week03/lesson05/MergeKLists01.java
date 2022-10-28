package week03.lesson05;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个升序链表
 */
public class MergeKLists01 {
    public static void main(String[] args) {
        Node node = new Node(-2);
        node.next = new Node(-3);
        node.next.next = new Node(1);
        node.next.next.next = new Node(2);
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.insert(node);
        binaryHeap.insert(node.next);
        binaryHeap.insert(node.next.next);
        binaryHeap.insert(node.next.next.next);
        for (Node node1 : binaryHeap.queue) {
            System.out.println(node1.key);
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        //todo 使用优先队列，底层是小顶堆 重写比较方法
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val) return -1;
                if(o1.val > o2.val) return 1;
                else return 0;
            }
        });
        //todo 节点加入优先队列
        for(ListNode list : lists){
            if (list == null) continue;
            ListNode temp = list;
            while (temp != null){
                queue.add(temp);
                temp = temp.next;
            }
        }

        //todo 创建新链表
        if(queue.isEmpty()) return null;
        ListNode head = new ListNode(queue.poll().val, null);
        ListNode temp = head;
        while (!queue.isEmpty()){
            temp.next = queue.poll();
            if(queue.isEmpty()){
                temp.next.next = null;
            }else {
                temp = temp.next;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Node{
    int key;
    Node next;
    public Node(int key){this.key = key;}
    public Node(int key, Node node){this.key = key; this.next = node;}
}

/**
 * 二插堆
 */
class BinaryHeap{
    ArrayList<Node> queue;
    public BinaryHeap(){
        queue = new ArrayList<>();
        queue.add(new Node(0));
    }

    /**
     * 插入方法
     * @param node
     */
     public void insert(Node node){
        int val = node.key;
        queue.add(node); //todo 先插入到最尾
        heapIfUp(queue.size()-1); //todo 向上交换
     }

    /**
     * 获取最小值
     * @return
     */
     public Node getMin(){
        return queue.get(1);
     }

    /**
     * 删除堆顶
     */
    public void deleteMin(){
        swap(1,queue.size()-1); //todo 交换
        queue.remove(queue.size()-1); //todo 删除尾
        heapIfDown(1);//todo 向下交换
     }

     private void heapIfUp(int index){
        int fa = index / 2;
        while (index > 1){
            if(queue.get(index).key < queue.get(fa).key) {swap(index,fa); index = fa; fa = index/2;}
            else break;
        }
     }

     private void heapIfDown(int index){
        int child = index * 2;
        while (child < queue.size()){
            int other = child + 1;
            if(other < queue.size() && queue.get(child).key > queue.get(other).key) child = other; //todo 换掉两者中最小的那个
            if(queue.get(child).key < queue.get(index).key) {
                swap(index, child);
                index = child;
                child = index * 2;
            }else{
                break;
            }
        }
     }

     private void swap(int i1,int i2){
        Node temp = queue.get(i1);
        queue.set(i1,queue.get(i2));
        queue.set(i2,temp);
     }

}
