package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p035 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p035().solve());
	}

	private static final int LIMIT = ProjectEulerLibrary.pow(10, 6);
	private boolean[] isPrime = ProjectEulerLibrary.listPrimality(LIMIT - 1);

	public String solve()
	{
		int count = 0;

		for (int i = 0; i < isPrime.length; i++)
			if (isCircularPrime(i))
				count++;

		return Integer.toString(count);
	}

	private boolean isCircularPrime(int n)
	{
		String s = Integer.toString(n);

		for (int i = 0; i < s.length(); i++)
			if (!isPrime[Integer.parseInt(s.substring(i) + s.substring(0, i))])
				return false;

		return true;
	}
}
