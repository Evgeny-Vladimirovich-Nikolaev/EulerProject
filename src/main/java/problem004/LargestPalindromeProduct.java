package main.java.problem004;

public class LargestPalindromeProduct {

    private static int maxPalindrome = 0;

    public static void main(String[] args) {
        for(int i = 100; i < 1000; i++) {
            for(int j = 100; j < 1000; j++) {
                int product = i * j;
                if(isPalindrome(product) && product > maxPalindrome) {
                    maxPalindrome = product;
                }
            }
        }
        System.out.println(maxPalindrome);
    }

    private static boolean isPalindrome(int product) {
        String s = Integer.toString(product);
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
