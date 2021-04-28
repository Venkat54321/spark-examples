package problems;

import java.util.Scanner;

public class ReverseInteger {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println(reverse(sca.nextInt()));
    }


    public static int reverse(long value){
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        while (value != 0){
            long rem = value % 10;
            long div = value / 10;
            if(value < 0) {
                isNegative = true;
                sb.append(rem * -1);
            }else{
                sb.append(rem);
            }
            value = div;
        }
        if(isNegative){
            long val =  Integer.parseInt("-" + sb);
            return 0;
        }else {
            return Integer.parseInt(sb.toString());
        }
    }
}
