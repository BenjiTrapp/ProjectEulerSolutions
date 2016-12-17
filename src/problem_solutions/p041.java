package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p041 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p041().solve());
	}

	public String solve()
	{

		for (int n = 9; n >= 1; n--)
		{
			int[] digits = new int[n];
			int result = -1;

			for (int i = 0; i < digits.length; i++)
				digits[i] = i + 1;

			do
			{
				if (ProjectEulerLibrary.isPrime(toInteger(digits)))
					result = toInteger(digits);

			} while (ProjectEulerLibrary.nextPermutation(digits));

			if (result != -1)
				return Integer.toString(result);
		}
		throw new ArithmeticException("Not found");
	}
	
	private static int toInteger(int[] digits)
	{
		int result = 0;

		for (int x : digits)
			result = result * 10 + x;

		return result;
	}
	
}
