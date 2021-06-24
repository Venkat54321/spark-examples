package problems.leetcode;

public class SingleNumber136 {

    public static void main(String[] args) {
        int[] array = {2,2,1};
        int result = 0;
        for(int i:array){
            result = result^i;
        }
        System.out.println(result);
    }
}
