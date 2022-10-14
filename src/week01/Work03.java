package week01;


public class Work03 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        myCircularDeque.insertFront(4);
        System.out.println(myCircularDeque.getFront());
    }

}

/**
 * 设计双端队列
 * 使用数组维护
 */
class MyCircularDeque {

    int[] array;
    int index;
    int max;

    public MyCircularDeque(int k) {
        array = new int[k];
        for(int i = 0; i < k; i++){
            array[i] = -1;
        }
        index = 0;
        max = k;
    }

    /**
     * O(n)
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        if(index == max) return false;
        int[] temp = new int[max];
        for(int i = 0; i < index; i++){
            temp[i+1] = array[i];
        }
        array = temp;
        array[0] = value;
        index++;
        return true;
    }

    /**
     * O(1)
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        if(index == max) return false;
        array[index] = value;
        index++;
        return true;
    }

    /**
     * O(n)
     * @return
     */
    public boolean deleteFront() {
        if(index == 0) return false;
        int[] temp = new int[max];
        for(int i = 1; i < index; i++){
            temp[i-1] = array[i];
        }
        array = temp;
        array[index-1] = -1;
        index--;
        return true;
    }

    /**
     * O(1)
     * @return
     */
    public boolean deleteLast() {
        if(index == 0) return false;
        array[index-1] = -1;
        index--;
        return true;

    }

    /**
     * O(1)
     * @return
     */
    public int getFront() {
        return array[0];
    }

    /**
     * O(1)
     * @return
     */
    public int getRear() {
        return index == 0 ? -1 : array[index-1];
    }

    /**
     * O(1)
     * @return
     */
    public boolean isEmpty() {
        return index == 0 ? true : false;
    }

    /**
     * O(1)
     * @return
     */
    public boolean isFull() {
        return index == max ? true :false;
    }
}
