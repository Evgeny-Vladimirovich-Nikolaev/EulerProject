package problem33;

public class DigitCancellingFraction extends Fraction {

    public DigitCancellingFraction(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    void reduce() {
        StringBuilder num = new StringBuilder(Integer.toString(numerator));
        StringBuilder denom = new StringBuilder(Integer.toString(denominator));
        int checkLength = num.length();
        boolean deleted = false;
        do {
            for (int i = 0; i < num.length(); i++) {
                deleted = false;
                for (int j = 0; j < denom.length(); j++) {
                    if (num.charAt(i) == denom.charAt(j)) {
                        num.deleteCharAt(i);
                        denom.deleteCharAt(j);
                        if(num.length() == 0 && denom.length() == 0) {
                            num = new StringBuilder("1");
                            denom = new StringBuilder("1");
                            return;
                        }
                        if(num.length() == 0) {
                            num = new StringBuilder("1");
                            return;
                        }
                        if(denom.length() == 0) {
                            denom = new StringBuilder("1");
                            return;
                        }
                        i = -1;
                        deleted = true;
                        break;
                    }
                    if(deleted) {
                        i = 0;
                    }
                }
            }
        } while (deleted);

        numerator = Integer.valueOf(num.toString());
        denominator = Integer.valueOf(denom.toString());
        reduced = checkLength == num.length();
    }
}




