package problem012;

public class HighlyDivisibleTriangularNumber {

    public static void main(String[] args) {
        int num = 1;
        int increment = 2;
        int commonCount = 0;
        while (true) {
            num += increment;
            int count = countDivisors(num);
            if (count > commonCount) {
                commonCount = count;
                System.out.println(num + " ; " + commonCount);
            }
            if(count > 500) {
                    break;
            }
            increment++;
        }

        System.out.println(num);
    }

    private static int countDivisors(int num) {
        int count = 1;
        for(int div = 2; div <= num; div++) {
            if(num % div == 0) {
                count++;
            }
        }
        return count;
    }

}
