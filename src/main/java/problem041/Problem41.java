package main.java.problem041;

import java.util.List;

public class Problem41 {

    public static void main(String[] args) {
        PandigitalPrimeReload pandigitalPrimeReload = new PandigitalPrimeReload(987_654_203, true);
        System.out.println(pandigitalPrimeReload.getMax());
        List<Integer> primes = pandigitalPrimeReload.getPrimes();
        System.out.println(primes.size() + " " + primes.getLast());
    }

}
