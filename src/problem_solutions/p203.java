package problem_solutions;
import utils.ProjectEulerLibrary;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public final class p203 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p203().solve());
	}

    private long[] primesSquared;

    public String solve()
    {
        // Collect unique numbers in Pascal's triangle
        Set<Long> numbers = new HashSet<>();
        int[] primes;
        long sum = 0;
        long max = 0;

        for (int n = 0; n <= 50; n++)
        {
            for (int k = 0; k <= n; k++)
            {
                BigInteger x = ProjectEulerLibrary.binomial(n, k);

                if (x.bitLength() >= 64)
                    throw new AssertionError("Number too large to handle");

                numbers.add(x.longValue());
                max = Math.max(x.longValue(), max);
            }
        }

        // Prepare list of squared primes
        primes = ProjectEulerLibrary.listPrimes((int) ProjectEulerLibrary.sqrt(max));
        primesSquared = new long[primes.length];

        for (int i = 0; i < primes.length; i++)
            primesSquared[i] = (long) primes[i] * primes[i];

        // Sum up the squarefree numbers
        for (long n : numbers)
            if (isSquarefree(n))
                sum += n;

        return Long.toString(sum);
    }

    private boolean isSquarefree(long n)
    {
        for (long p2 : primesSquared)
        {
            if (p2 > n)
                break;
            if (n % p2 == 0)
                return false;
        }

        return true;
    }
}
