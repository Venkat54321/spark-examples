package problems;

import java.util.HashSet;
import java.util.Set;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        int count = 0;
        int[] array = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        int sum = 11;
        Set<Integer> set = new HashSet<>();
        for(int i : array){
            set.add(i);
        }
        for(int i:array) {
            int diff = sum - i;
            if(set.contains(diff)){
                System.out.println(diff + " " +i);
                count++;
            }
        }
        System.out.println(count / 2);
    }
}
