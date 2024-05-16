package problem01;

public class MultiplesOf3Or5 {

    public static void main(String[] args) {
        int result = 0;
        int num = 1;
        while (num * 3 < 1000) {
            result += 3 * num++;
        }
        num = 0;
        while (++num * 5 < 1000) {
            if (num % 3 == 0) {
                continue;
            }
            result += 5 * num;
        }
        System.out.println(result);
    }

}
