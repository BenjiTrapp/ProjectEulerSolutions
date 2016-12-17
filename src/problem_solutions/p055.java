package problem_solutions;
import utils.ProjectEulerLibrary;

import java.math.BigInteger;

public final class p055 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p055().solve());
	}
	
	public String solve()
	{
		int count = 0;

		for (int i = 0; i < 10000; i++)
			if (isLychrel(i))
				count++;
		return Integer.toString(count);
	}
	
	
	private static boolean isLychrel(int n)
	{
		BigInteger temp = BigInteger.valueOf(n);

		for (int i = 0; i < 49; i++)
		{
			temp = temp.add(new BigInteger(ProjectEulerLibrary.reverse(temp.toString())));

			if (ProjectEulerLibrary.isPalindrome(temp.toString()))
				return false;
		}

		return true;
	}
}
