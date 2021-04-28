package problems;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{3,2,1}};
        int max = getMaxCount(array);
        System.out.println(max);

    }

    public static int getMaxCount(int[][] array){
        int rows = array.length;
        int columns = array[0].length;

        int max = 0;
        for(int i =0;i<rows;i++){
            int sum = 0;
            for(int j=0;j<columns;j++){
                sum = sum + array[i][j];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
