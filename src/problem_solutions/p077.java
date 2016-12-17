package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p077 implements EulerSolution
{

	public static void main(String[] args)
	{
		System.out.println(new p077().solve());
	}


	private static final int TARGET = 5000;

	public String solve()
	{
		for (int limit = 1; ; limit *= 2)
		{
			int result = search(limit);
			if (result != -1)
				return Integer.toString(result);
		}
	}

	private static int search(int limit)
	{
		int[] primes = ProjectEulerLibrary.listPrimes(limit);
		/* partitions[i][j] is the number of ways (with upper saturation at TARGET)
		   that j can be written as an unordered sum with terms drawn from the first i prime numbers
		 */
		int[][] partitions = new int[primes.length + 1][limit + 1];
		partitions[0][0] = 1;
		int p,sum;

		for (int i = 0; i < primes.length; i++)
		{
			p = primes[i];
			for (int j = 0; j <= limit; j++)
			{
				sum = partitions[i][j];

				if (j >= p)
					sum += partitions[i + 1][j - p];

				partitions[i + 1][j] = Math.min(sum, TARGET);  // Saturate to prevent overflow
			}
		}

		for (int i = 0; i <= limit; i++)
			if (partitions[primes.length][i] >= TARGET)
				return i;

		return -1;
	}
}
