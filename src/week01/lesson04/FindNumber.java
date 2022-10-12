package week01.lesson04;

import java.util.HashMap;

class DoubleListNode{
    int index;
    int val;
    DoubleListNode next;
    DoubleListNode pre;
    DoubleListNode() {}
    DoubleListNode(int val, int index) { this.val = val; this.index = index;}
    DoubleListNode(int val, int index, DoubleListNode next, DoubleListNode pre) { this.val = val; this.next = next; this.pre = pre;}
}

public class FindNumber {
    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 4};
        int[] arrayCopy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            arrayCopy[i] = array[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            map.put(array[i],i);
        }
        quickSort(array,0,array.length-1);
        DoubleListNode head = new DoubleListNode(array[0],map.get(array[0]));
        DoubleListNode temp = head;
        for(int i = 1; i < array.length; i++){
            temp.next = new DoubleListNode(array[i],map.get(array[i]));
            temp = temp.next;
        }
        DoubleListNode start = head;
        DoubleListNode pre = head;
        head = head.next;
        head.pre = pre;
        while (true){
            pre = head;
            head = head.next;
            if(head == null) break;
            head.pre = pre;
        }

        HashMap<Integer, Integer> result = new HashMap<>();
        for(int i = arrayCopy.length-1 ; i > 0; i --){
            DoubleListNode doubleListNode = find(start, arrayCopy[i]);
            int left;
            int leftIndex;
            int right;
            int rightIndex;
            if(doubleListNode.pre != null && doubleListNode.next != null){
                left = doubleListNode.pre.val;
                leftIndex = doubleListNode.pre.index;
                right = doubleListNode.next.val;
                rightIndex = doubleListNode.next.index;
                if(Math.abs(arrayCopy[i] - left) > Math.abs(arrayCopy[i] - right)){
                    result.put(arrayCopy[i],Math.abs(arrayCopy[i] - right));
                }else if (Math.abs(arrayCopy[i] - left) < Math.abs(arrayCopy[i] - right)){
                    result.put(arrayCopy[i],Math.abs(arrayCopy[i] - left));
                }else{
                    if(leftIndex < rightIndex){
                        result.put(arrayCopy[i], Math.abs(arrayCopy[i] - right));
                    }else{
                        result.put(arrayCopy[i], Math.abs(arrayCopy[i] - left));
                    }
                }
            }else if(doubleListNode.pre == null && doubleListNode.next != null){
                right = doubleListNode.next.val;
                result.put(arrayCopy[i], Math.abs(arrayCopy[i] - right));
            }else if(doubleListNode.pre != null && doubleListNode.next == null){
                left = doubleListNode.pre.val;
                result.put(arrayCopy[i], Math.abs(arrayCopy[i] - left));
            }else {

            }
            delete(doubleListNode);
        }
    }

    public static DoubleListNode find(DoubleListNode listNode, int value){
        while (listNode != null){
            if(listNode.val == value) break;
            else listNode = listNode.next;
        }
        return listNode;
    }

    public static DoubleListNode delete(DoubleListNode listNode){
        if(listNode.pre == null && listNode.next == null) return null;
        if(listNode.pre == null){
            listNode = listNode.next;
            listNode.pre = null;
            return listNode;
        }
        if(listNode.next == null){
            listNode = listNode.pre;
            listNode.next = null;
            return listNode;
        }
        DoubleListNode lastNode = listNode.pre;
        lastNode.next = listNode.next;
        listNode.next.pre = lastNode;
        while (lastNode.pre == null){
            lastNode = lastNode.pre;
        }
        return lastNode;
    }

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
