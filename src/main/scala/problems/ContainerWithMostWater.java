package problems;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = { 1, 5, 4, 3 };
        int maxArea = 0;
        int l = 0;
        int r = array.length -1 ;
        while (l < r){
            maxArea = Math.max(maxArea,Math.min(array[l],array[r]) * (r -l));
            if(array[l] < array[r]){
                l = l +1;
            }else{
                r = r -1;
            }
        }
        System.out.println(maxArea);
    }
}
