package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p050 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p050().solve());
	}

	private static final int LIMIT = ProjectEulerLibrary.pow(10, 6);
	
	public String solve()
	{
		boolean[] isPrime = ProjectEulerLibrary.listPrimality(LIMIT);
		int[] primes = ProjectEulerLibrary.listPrimes(LIMIT);
		long maxSum = 0;
		int maxsolve = -1;
		int sum;

		// For each index of a starting prime number
		for (int i = 0; i < primes.length; i++)
		{
			sum = 0;

			// For each end index (inclusive)
			for (int j = i; j < primes.length; j++)
			{
				sum += primes[j];

				if (sum > LIMIT)
					break;
				else if (j - i > maxsolve && sum > maxSum && isPrime[sum]) {
					maxSum = sum;
					maxsolve = j - i;
				}
			}
		}
		return Long.toString(maxSum);
	}
}
