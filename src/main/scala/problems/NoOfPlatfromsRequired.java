package problems;

public class NoOfPlatfromsRequired {

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int noOfPlatforms = getNumberOfPlatforms(arr,dep,arr.length);
        System.out.println(noOfPlatforms);
    }

    private static int getNumberOfPlatforms(int[] arr, int[] dep, int length) {

        int i = 0;
        int j = 0;
        int result = 0;
        int platforms = 0;
        while (i < length && j < length){
            if(arr[i] <= dep[j]){
                platforms++;
                i++;
            }else if(arr[i] >= dep[j]){
                platforms--;
                j++;
            }
            if(platforms > result){
                result = platforms;
            }
        }
        return result;
    }
}
