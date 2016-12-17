package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p211 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p211().solve());
	}
	
	private static final int LIMIT = 64000000;
	
	/* Can be any number >= 1, but it's most beneficial to use a product of unique small primes excluding 2 */
	private static final int RESIDUE_TEST = 3 * 5 * 7 * 11 * 13;

   /**
    *  Requires at least 640 MB of memory
    */
	public String solve()
    {
		isResidue = new boolean[RESIDUE_TEST];
        long[] sigma2 = listSigma2(LIMIT - 1);
        long sum = 0;

		for (int i = 0; i < RESIDUE_TEST; i++)
			isResidue[i * i % RESIDUE_TEST] = true;

		for (int i = 1; i < LIMIT; i++)
			if (isPerfectSquare(sigma2[i]))
				sum += i;

		return Long.toString(sum);
	}

    private static long[] listSigma2(int n)
    {
        /*
         If i has a prime factor p <= sqrt, then quasiPrimeFactor[i] = p.
         Otherwise i > sqrt must be prime, and quasiPrimeFactor[i] = 0 because i may overflow an int16.
        */
        int sqrt = ProjectEulerLibrary.sqrt(n);
        short[] quasiPrimeFactor = new short[n + 1];
        long[] sigma2 = new long[n + 1];
        sigma2[1] = 1;

        /* Richer version of the sieve of Eratosthenes */
        for (int i = 2; i <= sqrt; i++)
        {
            if (quasiPrimeFactor[i] == 0)
            {
                quasiPrimeFactor[i] = (short) i;
                if ((long) i * i <= n)
                    for (int j = i * i; j <= n; j += i)
                        if (quasiPrimeFactor[j] == 0)
                            quasiPrimeFactor[j] = (short) i;
            }
        }

        for (int i = 2; i < sigma2.length; i++)
        {
            int p = quasiPrimeFactor[i];
            long sum = 1;
            int j = i;
            long p2 = (long) p * p;

            if (p == 0)
                p = i;

            for (long k = p2; j % p == 0; j /= p, k *= p2)
                sum += k;

            sigma2[i] = sum * sigma2[j];
        }

        return sigma2;
    }

    private boolean[] isResidue;

    private boolean isPerfectSquare(long x)
    {
        /*
		 * Optional optimization: Check if x is a quadratic residue modulo some number.
		 * The modulus was chosen to be a product of k primes; in this case, k = 5.
		 * If x is a square, then it must be a quadratic residue modulo each prime.
		 * For each prime p, there is an approximately half chance that an arbitrary number
		 * is a residue mod p. Thus with 5 primes, only about 1/32 of candidates remain.
		 * Note that the prime 2 tells us nothing about whether x is a square, so we exclude it.
		 */
        if (!isResidue[(int) (x % RESIDUE_TEST)])
            return false;

        long y = 0;

        for (long i = 1L << 31; i != 0; i >>>= 1)
        {
            y |= i;

            if (y > 3037000499L || y * y > x)
                y ^= i;
        }

        return y * y == x;
    }
}
