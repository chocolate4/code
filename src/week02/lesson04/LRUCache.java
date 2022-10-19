package week02.lesson04;

import java.util.HashMap;
import java.util.LinkedList;

//todo : 头部插入 尾部删除 访问时间排序 list
//todo : 元素访问 map
public class LRUCache {

    DoubleLinkedList doubleLinkedList;
    int size; //记录实时的链表长度

    /**
     * 创建初始链表
     * @param capacity
     */
    public LRUCache(int capacity) {
        doubleLinkedList = new DoubleLinkedList(capacity);
    }

    /**
     * 通过key获取value并将node提到链表头部
     * @param key
     * @return
     */
    public int get(int key) {
        Node result =  doubleLinkedList.get(key);
        if(result.value != -1){
            doubleLinkedList.remove(key,result);
            doubleLinkedList.insert(key,result);
            return result.value;
        }else{
            return result.value;
        }
    }

    /**
     * 插入key value至链表头部，并将容量外的末尾节点删除，注意key相同的场景(先删后加)
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if(doubleLinkedList.map.containsKey(key)){
            Node node = doubleLinkedList.get(key);
            doubleLinkedList.remove(node.key, node);
            doubleLinkedList.insert(key, new Node(key, value));
        }else {
            if (doubleLinkedList.capcity > size) {
                doubleLinkedList.insert(key, new Node(key, value));
                size++;
            } else {
                Node pre = doubleLinkedList.getTail().pre;
                doubleLinkedList.remove(pre.key, pre);
                doubleLinkedList.insert(key, new Node(key, value));
            }
        }
    }
}

//todo :  一个带有head和tail的双向链表结构 其中包含的属性是 capcity和map
//todo : map用来存储key和node，便于快速查找
class DoubleLinkedList{

    Node head;
    Node tail;
    int capcity;
    HashMap<Integer,Node> map;

    public DoubleLinkedList(int capcity){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capcity = capcity;
        map = new HashMap<Integer,Node>();
    }

    public Node getTail(){
        return tail;
    }

    public Node getHead(){
        return head;
    }

    public Node get(int value){
        if(!map.containsKey(value)) return new Node(-1,-1);
        Node node = map.get(value);
        return node;
    }

    public void remove(int value,Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        map.remove(value);
    }
    public void insert(int value,Node node){
        Node temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
        map.put(value,node);
    }
}

//todo : 节点 存储了key value和 pre next 指针
class Node{
    int value = -1;
    int key = -1;
    Node pre;
    Node next;
    public Node(){}
    public Node(int key,int value){this.value = value; this.key = key;}
}
