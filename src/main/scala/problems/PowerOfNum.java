package problems;

public class PowerOfNum {

    public static void main(String[] args) {
        int n = 2;
        int k = 4;
        int result = power(n,k);
        System.out.println(result);

    }

    private static int power(int n, int k) {
        if(k == 0)
            return 1;
        else if(k % 2 == 0){
            return power(n, k/2) * power(n,k/2);
        }else{
            return n * power(n,k/2) * power(n,k/2);
        }
    }
}
