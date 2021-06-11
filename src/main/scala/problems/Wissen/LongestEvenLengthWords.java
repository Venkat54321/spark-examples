package problems.Wissen;

public class LongestEvenLengthWords {

    public static void main(String[] args) {
        String str = "thez";
        int maxLength = 0;
        int index = 0;
        String[] strArray = str.split(" ");
        if(strArray.length > 2) {
            for (int i = 0; i < strArray.length; i++) {
                char[] carList = strArray[i].toCharArray();
                if (carList.length % 2 == 0 && carList.length > maxLength) {
                    maxLength = carList.length;
                    index = i;
                }
            }
        }
        System.out.println(strArray[index]);
    }
}
