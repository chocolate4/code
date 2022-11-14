package week05.lesson03;

public class RelativeSortArray {

    public static void main(String[] args) {
        int[] ints = new RelativeSortArray().relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6});
        for(int i : ints){
            System.out.println(i);
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] > max){
                max = arr1[i];
            }
        }
        int[] temp = new int[max+1];

        for(int i = 0; i < arr1.length; i++){
            temp[arr1[i]]++;
        }

        int index = 0;
        for(int i = 0; i < arr2.length; i++){
            for(int j = 0; j < temp[arr2[i]]; j++){
                arr1[index] = arr2[i];
                index++;
            }
            temp[arr2[i]] = 0;
        }
        if (index < arr1.length){
            for(int i = 0; i < temp.length; i++){
                if(temp[i] != 0){
                    for(int j = 0; j < temp[i]; j++){
                        arr1[index] = i;
                        index++;
                    }
                }
            }
        }
        return arr1;
    }
}
