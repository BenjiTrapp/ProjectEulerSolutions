package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p249 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p249().solve());
	}

	private static final int LIMIT = 5000;
	private static final long MODULUS = 10000000000000000L;

    public String solve()
    {
        boolean[] isPrime = ProjectEulerLibrary.listPrimality(LIMIT * LIMIT / 2);
        long[] numSubsets = new long[LIMIT * LIMIT / 2];  // numSubsets[i] is the number of subsets with sum i, mod 10^16
        numSubsets[0] = 1;
        int maxSum = 0;  // Sum of all primes seen so far
        long sum = 0;

        for (int i = 0; i < LIMIT; i++)
        {
            if (!isPrime[i])
                continue;

            maxSum += i;

            for (int j = maxSum; j >= i; j--)
            {
                // Optimization of modulo because we know 0 <= numSubsets[j] + numSubsets[j - i] < 2 * MODULUS
                long temp = numSubsets[j] + numSubsets[j - i];

                if (temp < MODULUS)
                    numSubsets[j] = temp;
                else
                    numSubsets[j] = temp - MODULUS;
            }
        }

        for (int i = 0; i < numSubsets.length; i++)
            if (isPrime[i])
                sum = (sum + numSubsets[i]) % MODULUS;

        return Long.toString(sum);
    }
}
