package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p046 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p046().solve());
	}
	private boolean[] isPrime = {};

	public String solve()
	{
		for (int i = 2; ; i++)
			if (!satisfiesConjecture(i))
				return Integer.toString(i);
	}

	private boolean satisfiesConjecture(int n)
	{
		if (n % 2 == 0 || isPrime(n))
			return true;

		// Now n is an odd composite number
		for (int i = 1; i * i * 2 <= n; i++)
			if (isPrime(n - i * i * 2))
				return true;

		return false;
	}

	private boolean isPrime(int n)
	{
		if (n >= isPrime.length)
			isPrime = ProjectEulerLibrary.listPrimality(n * 2);

		return isPrime[n];
	}
}
