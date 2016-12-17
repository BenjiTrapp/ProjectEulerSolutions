package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p357 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p357().solve());
	}

	private static final int LIMIT = 100000000;
	
	/* Because the maximum value of (i + n/i) is (n + 1) */
	private boolean[] isPrime = ProjectEulerLibrary.listPrimality(LIMIT + 1);

	public String solve()
    {
		long sum = 0;

		for (int n = 0; n <= LIMIT; n++)
			if (isPrimeGenerating(n))
				sum += n;

		return Long.toString(sum);
	}
	
	private boolean isPrimeGenerating(int n)
    {
		for (int i = 1, end = ProjectEulerLibrary.sqrt(n); i <= end; i++)
			if (n % i == 0)
				if (!isPrime[i + n / i])
					return false;

		return true;
	}
}
