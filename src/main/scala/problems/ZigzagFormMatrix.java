package problems;

public class ZigzagFormMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,4},
                          {5, 6, 7,8},
                          {9,10,11,12}};

        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int i =0 ;
        int oddRows = 1;
        while (i < rLen) {
            int j = 0;
            for (; j < cLen; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            j--;
            i++;
            if (oddRows < rLen) {
                for (; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
                i++;
            }
            oddRows = oddRows + 2;
        }
    }
}
