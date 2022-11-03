package week04;



import java.util.ArrayList;

/**
 * 239.滑动窗口最大值
 */

public class Work02 {
    public static void main(String[] args) {
        int[] ints = new Work02().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for(int num : ints){
            System.out.println(num);
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        BinaryHeap heap;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++){
            heap = new BinaryHeap();
            int start = i;
            int end = (i+k)-1;
            for(int j = start; j <= end; j++){
                heap.insert(nums[j]);
            }
            result[i] = heap.getMax();
        }
        return result;
    }
}
class BinaryHeap{
    ArrayList<Integer> queue;
    public BinaryHeap(){
        queue = new ArrayList<>();
        queue.add(Integer.MIN_VALUE);
    }

    /**
     * 插入方法
     * @param num
     */
    public void insert(Integer num){
        int val = num;
        queue.add(num); //todo 先插入到最尾
        heapIfUp(queue.size()-1); //todo 向上交换
    }

    /**
     * 获取最大值
     * @return
     */
    public Integer getMax(){
        return queue.get(1);
    }

    /**
     * 删除堆顶
     */
    public void deleteMax(){
        swap(1,queue.size()-1); //todo 交换
        queue.remove(queue.size()-1); //todo 删除尾
        heapIfDown(1);//todo 向下交换
    }

    private void heapIfUp(int index){
        int fa = index / 2;
        while (index > 1){
            if(queue.get(index) > queue.get(fa)) {swap(index,fa); index = fa; fa = index/2;}
            else break;
        }
    }

    private void heapIfDown(int index){
        int child = index * 2;
        while (child < queue.size()){
            int other = child + 1;
            if(other < queue.size() && queue.get(child) < queue.get(other)) child = other; //todo 换掉两者中最小的那个
            if(queue.get(child) > queue.get(index)) {
                swap(index, child);
                index = child;
                child = index * 2;
            }else{
                break;
            }
        }
    }

    private void swap(int i1,int i2){
        Integer temp = queue.get(i1);
        queue.set(i1,queue.get(i2));
        queue.set(i2,temp);
    }

}
