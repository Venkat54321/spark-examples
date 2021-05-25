package problems;

public class MonotonicArray {


    /**
     *  T T = T
     *  T F = T
     *  F T = T
     *  F F = F
     * @param args
     */

    public static void main(String[] args) {
        int[] array2 = {4,3,1,1,1,1,1,1};
        boolean checkMonotonicArray = isMonotonic(array2);
        System.out.println(checkMonotonicArray);
    }

    public static boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}
