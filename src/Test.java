import com.sun.tools.corba.se.idl.InterfaceGen;
import util.DoublyLinkedList;
import week01.lesson02.ResizableArray;
import week01.lesson05.MinStack;
import week02.lesson04.LRUCache;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
//        lruCache.put(4,4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
    }
}
