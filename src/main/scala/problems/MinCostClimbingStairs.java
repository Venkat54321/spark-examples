package problems;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] array = {1,100,1,1,1,100,1,1,100,1};
        //int[] array = {10,15,20};
        int result = 0;
        for(int i= 0;i< array.length - 1;i++){
            result = result + Math.min(array[i],array[i+1]);
        }
        System.out.println(result);
    }
}
