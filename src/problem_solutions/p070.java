package problem_solutions;
import utils.ProjectEulerLibrary;

import java.util.Arrays;


public final class p070 implements EulerSolution
{

	public static void main(String[] args)
	{
		System.out.println(new p070().solve());
	}

	private static final int LIMIT = ProjectEulerLibrary.pow(10, 7);

	public String solve()
	{
		int minNumer = 1;  // Initially infinity
		int minDenom = 0;
		int tot;
		int[] totients = ProjectEulerLibrary.listTotients(LIMIT - 1);

		for (int n = 2; n < totients.length; n++)
		{
			tot = totients[n];
			if ((long) n * minDenom < (long) minNumer * tot && hasSameDigits(n, tot))
			{
				minNumer = n;
				minDenom = tot;
			}
		}

		if (minDenom == 0)
			throw new ArithmeticException("Not found");

		return Integer.toString(minNumer);
	}


	private static boolean hasSameDigits(int x, int y)
	{
		char[] xdigits = Integer.toString(x).toCharArray();
		char[] ydigits = Integer.toString(y).toCharArray();

		Arrays.sort(xdigits);
		Arrays.sort(ydigits);

		return Arrays.equals(xdigits, ydigits);
	}
}
