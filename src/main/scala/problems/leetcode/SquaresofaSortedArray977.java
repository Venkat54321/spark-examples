package problems.leetcode;

public class SquaresofaSortedArray977 {
    public static void main(String[] args) {
        int[] array = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(array);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] sortedSquares(int[] array) {
        int[] result = new int[array.length];
        int i = 0;
        int j = array.length - 1;
        int p = array.length - 1;
        while (i <= j) {
            int left = array[i] * array[i];
            int right = array[j] * array[j];
            if (left > right) {
                result[p] = left;
                i++;
            } else {
                result[p] = right;
                j--;

            }
            p--;
        }
        return result;
    }
}
