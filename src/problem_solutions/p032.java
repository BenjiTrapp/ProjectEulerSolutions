package problem_solutions;
import utils.ProjectEulerLibrary;

//import java.util.Arrays;

public final class p032 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p032().solve());
	}

	/**
	 * A candidate product has at most 4 digits. This is because if it has 5 digits,
	 * then the two multiplicands must have at least 5 digits put together.
	 * */
	public String solve()
	{
		int sum = 0;

		for (int i = 1; i < 10000; i++)
			if (hasPandigitalProduct(i))
				sum += i;

		return Integer.toString(sum);
	}

	private static boolean hasPandigitalProduct(int n)
	{
		// Find and examine all factors of n
		for (int i = 1; i <= n; i++)
			if (n % i == 0 && ProjectEulerLibrary.isPandigital("" + n + i + n/i))
				return true;

		return false;
	}

	/* Exchanged with ProjectEulerLibrary-Method
	private static boolean isPandigital(String s)
	{
		if (s.length() != 9)
			return false;

		char[] temp = s.toCharArray();
		Arrays.sort(temp); //Sort it the lazy way ...

		return new String(temp).equals("123456789");
	}
	*/
}
