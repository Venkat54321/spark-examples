package problems;

public class SquareRoot {

    public static void main(String[] args) {

        int value = 15;
        System.out.println(findSquareRoot(value));

    }

    private static double findSquareRoot(int number) {

        double start = 0;
        double end = number;
        double mid = (start+end)/2;
        double prevMid = 0;
        double diff = Math.abs(mid - prevMid);
        double precision = 0.0005;

        while((mid*mid != number) && (diff > precision)) {
            if(mid*mid > number) {
                end = mid;
            } else {
                start = mid;
            }
            prevMid = mid;
            mid = (start+end)/2;
            diff = Math.abs(mid - prevMid);
        }

        return mid;
    }
}
