package problem_solutions;
import utils.ProjectEulerLibrary;

import java.math.BigInteger;

public final class p243 implements EulerSolution
{
	
	public static void main(String[] args){System.out.println(new p243().solve());}
	
	private static final BigInteger TARGET_NUMERATOR   = BigInteger.valueOf(15499);
	private static final BigInteger TARGET_DENOMINATOR = BigInteger.valueOf(94744);

    public String solve()
    {
        BigInteger numer = BigInteger.ONE;
        BigInteger denom = BigInteger.ONE;

        /*
           This is related to computing totients.
           To make the totient smaller relative to the number, we must add new prime factors.
         */
        for (int p = 2; ; p = nextPrime(p))
        {
            numer = numer.multiply(BigInteger.valueOf(p - 1));
            denom = denom.multiply(BigInteger.valueOf(p));

            if (numer.multiply(TARGET_DENOMINATOR).compareTo(denom.multiply(TARGET_NUMERATOR)) < 0)
            {
                for (int i = 1; i <= p; i++)
                {
                    BigInteger n = numer.multiply(BigInteger.valueOf(i));
                    BigInteger d = denom.multiply(BigInteger.valueOf(i)).subtract(BigInteger.ONE);

                    if (n.multiply(TARGET_DENOMINATOR).compareTo(d.multiply(TARGET_NUMERATOR)) < 0)
                        return d.add(BigInteger.ONE).toString();
                }
            }
        }
    }

    private static int nextPrime(int n)
    {
        if (n < 0)
            throw new IllegalArgumentException();

        do
        {
            if (n == Integer.MAX_VALUE)
                throw new IllegalArgumentException();

            n++;
        }
        while (!ProjectEulerLibrary.isPrime(n));

        return n;
    }
}
