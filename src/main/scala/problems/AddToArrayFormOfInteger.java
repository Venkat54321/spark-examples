package problems;

import scala.Char;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddToArrayFormOfInteger {

    public static void main(String[] args) {

        int results = 0;
        int[] num = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,9,6,9};
        int k = 516;
        int carry = 0;
        for(int i = num.length - 1; i >= 0; i--){
            int toAdd = num[i] + carry + (k % 10);
            num[i] = toAdd % 10;
            carry = toAdd / 10;
            k /= 10;
        }
        for(int i : num){
            System.out.print(i + "  ");
        }
    }
}
