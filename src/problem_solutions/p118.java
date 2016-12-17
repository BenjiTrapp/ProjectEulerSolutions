package problem_solutions;
import utils.ProjectEulerLibrary;

import java.util.Arrays;

public final class p118 implements EulerSolution
{
	
	public static void main(String[] args) { System.out.println(new p118().solve()); }

	private int[] isPrime;
	private int[] countBySize;

	public String solve()
	{
		int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int count = 0;
		countBySize = new int[10];
		listPrimality(ProjectEulerLibrary.pow(10, 9) - 1);

		do
			countPrimeSets(digits, 0, 0);
		while (ProjectEulerLibrary.nextPermutation(digits));

		// Eliminate permutation duplicates
		for (int i = 0; i < countBySize.length; i++)
			count += countBySize[i] / FACTORIAL[i];

		return Integer.toString(count);
	}

	/**
	 * Do prime sieve but store bitwise (instead of the usual Boolean array)
 	 */
	private void listPrimality(int n)
	{
		//Init the array to start with a clean database
		isPrime = new int[n / 32 + 1];
		Arrays.fill(isPrime, ~0);
		isPrime[0] &= ~3;  // 0 and 1 are not prime

		// Sieve of Eratosthenes
		for (int i = 2, end = ProjectEulerLibrary.sqrt(n); i <= end; i++)
		{
			if (isPrime(i))
			{
				for (int j = i * i; j <= n; j += i)
					isPrime[j >>> 5] &= ~(1 << (j & 0x1F));
			}
		}
	}

	private void countPrimeSets(int[] digits, int start, int size)
	{
		if (start == digits.length)
			countBySize[size]++;
		else
		{
			for (int split = start + 1; split <= digits.length; split++)
				if (isPrime(toInteger(digits, start, split)))
					countPrimeSets(digits, split, size + 1);
		}
	}

	private boolean isPrime(int x) { return (isPrime[x >>> 5] >>> (x & 0x1F) & 1) != 0;	}

	private static int toInteger(int[] digits, int start, int end)
	{
		int result = 0;

		for (int i = start; i < end; i++)
			result = result * 10 + digits[i];

		return result;
	}

	/**
	 * Hard-coded values for factorial(0), factorial(1), ..., factorial(9)
 	 */
	private static int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
}
