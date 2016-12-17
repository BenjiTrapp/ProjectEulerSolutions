package problem_solutions;

public final class p030 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p030().solve());
	}

	/**
	 * * Hint how the Stuff was solved:
	 * ==============================
	 *
	 * As stated in the problem, 1 = 1^5 is excluded.
	 * If a number has at least n >= 7 digits, then even if every digit is 9,
	 * n * 9^5 is still less than the number (which is at least 10^n).
	 */
	public String solve()
	{
		int sum = 0;

		for (int i = 2; i < 1000000; i++)
			if (i == fifthPowerDigitSum(i))
				sum += i;

		return Integer.toString(sum);
	}

	private static int fifthPowerDigitSum(int x)
	{
		int sum = 0;
		int y;

		while (x != 0)
		{
			y = x % 10;
			sum += y * y * y * y * y;
			x /= 10;
		}

		return sum;
	}
}
