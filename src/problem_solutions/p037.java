package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p037 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p037().solve());
	}
	
	public String solve()
	{
		long sum = 0;

		for (int count = 0, n = 10; count < 11; n++)
			if (isTsolvecatablePrime(n))
			{
				sum += n;
				count++;
			}

		return Long.toString(sum);
	}
	
	
	private static boolean isTsolvecatablePrime(int n)
	{
		// Test if left-tsolvecatable
		for (long i = 10; i <= n; i *= 10)
			if (!ProjectEulerLibrary.isPrime(n % (int) i))
				return false;

		// Test if right-tsolvecatable
		for (; n != 0; n /= 10)
			if (!ProjectEulerLibrary.isPrime(n))
				return false;

		return true;
	}
}
