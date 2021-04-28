package problems;

public class RunningSumOfArray {

    public static void main(String[] args) {
        int[] array = {3,1,2,10,1};
        int[] runningSumArray = getRunningOFArray(array);
        for (int a : runningSumArray) {
            System.out.println(a);
        }
    }

    public static int[] getRunningOFArray(int[] a){
        int length = a.length;
        if(length == 1){
            return a;
        }
        for(int i = 1; i < length;i++) {
            a[i] = a[i] + a[i - 1];
        }
        return a;
    }
}
