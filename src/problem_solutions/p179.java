package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p179 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p179().solve());
	}

	private static final int LIMIT = ProjectEulerLibrary.pow(10, 7);

	public String solve()
	{
		int[] smallestPrimeFactor = ProjectEulerLibrary.listSmallestPrimeFactors(LIMIT);
		int[] numDivisors = new int[LIMIT + 1];
		numDivisors[1] = 1;
        int count = 0;

		for (int i = 2; i < numDivisors.length; i++)
		{
			int p = smallestPrimeFactor[i];
			int exp = 0;
			int j = i;

			for (; j % p == 0; j /= p, exp++)
				;
			numDivisors[i] = (exp + 1) * numDivisors[j];
		}

		for (int i = 2; i < LIMIT; i++)
			if (numDivisors[i] == numDivisors[i + 1])
				count++;

		return Integer.toString(count);
	}
}
