package problems.leetcode;

import org.apache.spark.sql.sources.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumofEvenNumbersAfterQueries985 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};

       // int[] newArray = sumEvenAfterQueries(nums,queries);
        int[] newArray = sumEvenAfterQueries2(nums,queries);
        for(int i:newArray){
            System.out.print(" " + i +" ");
        }

    }

    private static int[] sumEvenAfterQueries2(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int evenSum = 0;

        for(int x: nums) if(x % 2 == 0) evenSum += x;

        for(int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int val = queries[i][0];
            if(nums[index] % 2 == 0)
                 evenSum -= nums[index];
              nums[index] += val;
            if(nums[index] % 2 == 0)
                evenSum += nums[index];
              ans[i] = evenSum;

        }
        return ans;
    }

    private static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int rows = queries.length;
        int[] newArray = new int[rows];
        List<Integer> list = new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        System.out.println(rows);
        int i = 0;
        while (i < rows){
            int value = queries[i][0];
            int index = queries[i][1];

            int arrayValue = list.get(index);
            list.set(index,value + arrayValue);
            int sum = 0;
            for(int j = 0;j<list.size();j++){
                if(list.get(j) % 2 ==0){
                    sum = sum + list.get(j);
                }
            }
            newArray[i] = sum;
            i++;
        }
        return newArray;
    }



}
