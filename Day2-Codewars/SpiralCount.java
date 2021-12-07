package Day3;

import java.math.BigInteger;

class SpiralCount {
    public static BigInteger sum(BigInteger size){
        BigInteger sum = size.multiply(size);

        sum = sum.divide(BigInteger.TWO);
        sum = sum.add (size);

        if (sum.mod (BigInteger.TWO)==BigInteger.ZERO)
            sum = sum.subtract(BigInteger.ONE);

        return sum;
    }
}