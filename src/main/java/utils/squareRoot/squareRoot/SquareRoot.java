package utils.squareRoot.squareRoot;

public class SquareRoot {

    public static int findIntegerRoot(Long num) {
        int res = 0;
        int bit =  1 << 30;
        while (bit != 0) {
            if(num >= res + bit) {
                num -= res + bit;
                res = (res >> 1) + bit;
            } else {
                res >>= 1;
            }
            bit >>= 2;
        }
        return res;
        }

    public static int findIntegerRoot(int num) {
        int res = 0;
        int bit =  1 << 30;
        while (bit != 0) {
            if(num >= res + bit) {
                num -= res + bit;
                res = (res >> 1) + bit;
            } else {
                res >>= 1;
            }
            bit >>= 2;
        }
        return res;
    }

    }

