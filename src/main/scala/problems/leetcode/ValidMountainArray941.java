package problems.leetcode;

public class ValidMountainArray941 {

    public static void main(String[] args) {
       // int[] array = {0,2,3,4,5,2,1,0};
       // int[] array = {0,2,3,3,4,5,2,1,0};
        //int[] array = {0,3,2,1};
       // int[] array = {0,1,2,1,2};
        int[] array = {5,4,3,2,1};
        //int[] array  = {1,2,3,4,5,6,7};
        //int[] array = {3,5,5};

        boolean isMountain = isMountainArray(array);
        System.out.println(isMountain);
    }

    private static boolean isMountainArray(int[] array) {
        if(array.length < 2){
            return false;
        }
        int i =0;
        int k;
        while (i < array.length -1){
            if(array[i] == array[i+1]){
               return false;
            }
            if(array[i] > array[i+1]){
                k = i;
                break;
            }
            i++;
        }
        System.out.println(i);
        k = i+1;
        if(i ==0 || k == array.length){
            return false;
        }
        System.out.println(k);
        while (k < array.length - 1){
            if(array[k] == array[k+1]){
                return false;
            }
            if(array[k] < array[k+1]){
             return false;
            }
            k++;
        }
        return true;
    }
}
