package main.java.problem033;

public class Fraction implements Comparable {

    protected int numerator;
    protected int denominator;

    protected boolean reduced = false;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public boolean isReduced() {
        return reduced;
    }

    public int calculateGCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }

    void reduce() {
        int gcd = calculateGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        reduced = gcd != 1;
    }

    public Fraction add(Fraction fractionTwo) {
        int numer = (numerator * fractionTwo.getDenominator()) +
                (fractionTwo.getNumerator() * denominator);
        int denr = denominator * fractionTwo.getDenominator();
        return new Fraction(numer, denr);
    }

    public Fraction subtract(Fraction fractionTwo) {
        int newNumerator = (numerator * fractionTwo.denominator) -
                (fractionTwo.numerator * denominator);
        int newDenominator = denominator * fractionTwo.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction multiply(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.numerator;
        int newDenominator = denominator * fractionTwo.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction divide(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.getDenominator();
        int newDenominator = denominator * fractionTwo.numerator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public double calculate() {
        return (double) numerator / denominator;
    }


    @Override
    public int compareTo(Object o) {
        Fraction fraction = (Fraction) o;
        if(calculate() > fraction.calculate()) {
            return 1;
        }
        if(calculate() < fraction.calculate()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return numerator * 31 + denominator *31;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || ! (obj instanceof Fraction)) return false;
        Fraction fraction = (Fraction) obj;
        if(this.numerator == fraction.numerator && this.denominator == fraction.denominator) {
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

}