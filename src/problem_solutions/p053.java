package problem_solutions;
import utils.ProjectEulerLibrary;

import java.math.BigInteger;


public final class p053 implements EulerSolution
{

	public static void main(String[] args)
	{
		System.out.println(new p053().solve());
	}

	public String solve()
	{
		BigInteger MILLION = BigInteger.TEN.pow(6);
		int count = 0;

		for (int n = 1; n <= 100; n++)
			for (int r = 0; r <= n; r++)
				if (ProjectEulerLibrary.binomial(n, r).compareTo(MILLION) > 0)
					count++;

		return Integer.toString(count);
	}
}
