package main.java.problem002;

public class EvenFibonacciNumbers {

    public static void main(String[] args) {
        int result = 0;
        int prev = 1;
        int current = 2;
        while(current <= 4_000_000) {
            if(current % 2 == 0) {
                result += current;
            }
            int temp = current;
            current += prev;
            prev = temp;
        }
        System.out.println(result);
    }

}
