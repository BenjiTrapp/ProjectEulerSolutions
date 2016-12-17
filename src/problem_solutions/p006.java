package problem_solutions;

public final class p006 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p006().solve());
	}

	private static final int N = 100;

	/**
	 * 	 Solution based on the following Algorithm:
	 *
	 *   sum  = N(N + 1) / 2.
	 *   sum2 = N(N + 1)(2N + 1) / 6.
	 *
	 * @return Returns the solution as String
	 */
	public String solve()
	{
		int sum = 0;
		int sum2 = 0;

		for (int i = 1; i <= N; i++)
		{
			sum += i;
			sum2 += i * i;
		}

		return Integer.toString(sum * sum - sum2);
	}
}
