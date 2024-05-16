package extra01;

import java.text.DecimalFormat;

public class Extra01 {

    public static void main(String[] args) {
        new ExtraPrimes();
    }

    private static void writeMessage(long num) {
        StringBuilder sb = new StringBuilder(Long.toString(num));
        sb = sb.reverse();
        for(int i = 3; i < sb.length(); i += 4) {
            sb.insert(i, "_");
        }
        sb = sb.reverse();
        System.out.println(sb);

     }

}
