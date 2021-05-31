package problems;

public class TransposeMatrix {

    public static void main(String[] args) {
        // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if (rowLength == colLength) {
            squareMtrix(matrix, rowLength, colLength);
        }
    }

    private static void squareMtrix(int[][] matrix,int rowLength,int colLength){
        int r = 0;
        int c = 0;
        int k = 0;
        for (int i = 0; i < rowLength; i++) {
            while (c < colLength) {
                int tmp = matrix[k][c];
                matrix[k][c] = matrix[r][k];
                matrix[r][k] = tmp;
                r++;
                c++;
            }
            k++;
            r = k;
            c = k;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }
}
