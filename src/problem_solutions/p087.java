package problem_solutions;
import utils.ProjectEulerLibrary;
import java.util.HashSet;
import java.util.Set;


public final class p087 implements EulerSolution
{

	public static void main(String[] args)
	{
		System.out.println(new p087().solve());
	}

	private static final int LIMIT = 50000000;

	public String solve()
	{
		int[] primes = ProjectEulerLibrary.listPrimes(ProjectEulerLibrary.sqrt(LIMIT));

		Set<Integer> sums = new HashSet<>();
		sums.add(0);

		for (int i = 2; i <= 4; i++)
		{
			Set<Integer> newsums = new HashSet<>();
			for (int p : primes)
			{
				long q = 1;

				for (int j = 0; j < i; j++)
					q *= p;

				// q = p^i
				if (q > LIMIT)
					break;

				int r = (int) q;

				for (int x : sums)
					if (x + r <= LIMIT)
						newsums.add(x + r);
			}

			sums = newsums;
		}

		return Integer.toString(sums.size());
	}
}
