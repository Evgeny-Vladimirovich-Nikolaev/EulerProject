package main.java.problem033;

public class DigitCancellingFractions {

    public static void main(String[] args) {
      extracted();
    }

    private static void extracted() {
        for(int num = 11; num < 100; num++) {
            if(num % 10 == 0) {
                continue;
            }
            for (int denom = 11; denom < 100; denom++) {
                if(denom % 10 == 0 || num >= denom || (num % 11 == 0 && denom % 11 == 0)) {
                    continue;
                }
                Fraction fraction = new Fraction(num, denom);
                Fraction digCancelFraction = new DigitCancellingFraction(num, denom);
                if(fraction.isReduced() && digCancelFraction.isReduced()) {
                    Fraction fr = new Fraction(digCancelFraction.getNumerator(), digCancelFraction.getDenominator());
                    if (fraction.equals(fr)) {
                        System.out.println(digCancelFraction);
                        System.out.println(num + "/" + denom + " -->" + fraction + " -->" + fr);
                    }
                }
            }
        }
    }
}


