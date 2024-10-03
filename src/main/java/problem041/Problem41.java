package problem041;

import java.util.List;

public class Problem41 {

    public static void main(String[] args) {
        PandigitalPrimeReload pandigitalPrimeReload = new PandigitalPrimeReload(7_654_321, false);
        System.out.println(pandigitalPrimeReload.getMax());
        List<Integer> primes = pandigitalPrimeReload.getPrimes();
//        System.out.println(primes.size() + " " + primes.getLast());
    }

}
