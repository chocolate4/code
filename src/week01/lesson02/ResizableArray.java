package week01.lesson02;

/**
 * 变长数组
 * 新建
 * get set  （边界检查）
 * push_back  （在末尾插入）
 * pop_back （删除末尾元素）
 */
public class ResizableArray {

    int size;

    int capcity = 1;

    int[] array;

    public ResizableArray(){
        array = new int[1];
    }

    public ResizableArray(int capcity){
        if(capcity < 1){
            System.out.println("初始数组容量需大于0");
        }else {
            array = new int[capcity];
        }
    }

    public int get(int index){
        try {
            return array[index];
        }catch (IndexOutOfBoundsException e){
            System.out.println("数组越界");
        }
        return -1;
    }

    public void set(int index,int value){
        try {
            array[index] = value;
        } catch (IndexOutOfBoundsException e){
            System.out.println("数组越界");
        }
    }

    public void pushBack(int value){
        if(size == capcity){
            capcity = capcity*2;
            int[] tmp = new int[capcity];
            for(int i = 0; i < size; i++){
                tmp[i] = array[i];
            }
            array = tmp;
            array[size] = value;
            size++;
        }else{
            array[size] = value;
            size++;
        }
    }

    public int popBack(){
        int pop = array[size-1];
        size--;
        //todo：0.25可以避免特殊情况频繁扩缩容
        if(size <= 0.25*capcity){
            capcity = (int) (0.5*capcity);
            int[] tmp = new int[capcity];
            for(int i = 0; i < size; i++){
                tmp[i] = array[i];
            }
            array = tmp;
        }
        return pop;
    }

    public int getSize() {
        return size;
    }

    public int getCapcity(){
        return capcity;
    }
}
