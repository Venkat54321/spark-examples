package problems.Wissen;

public class StockBuySell {

    public static void main(String[] args) {

        int[] array = {13,14,18,10,12,16,9,10};
        //int profit = getMaximumProfitI(array);
        int profit = getMaximumProfitII(array);
        System.out.println(profit);
    }

    private static int getMaximumProfitII(int[] array) {
        int diff = 0;
        int min = array[0];
        for(int i =1;i< array.length -1;i++){
            if(array[i] - min > diff){
                diff = array[i] - min;
            }
            if(array[i] < min){
                min = array[i];
            }
        }

        return diff;
    }

    private static int getMaximumProfitI(int[] array) {
        Integer max = Integer.MIN_VALUE;

        for(int i =0;i< array.length - 1;i++){
            for(int j =i;j< array.length - 1;j++){
                int diff = array[j] - array[i];
                if(array[j] > array[i] && diff > max){
                    max = diff;
                }
            }

        }
        return max;
    }

}
