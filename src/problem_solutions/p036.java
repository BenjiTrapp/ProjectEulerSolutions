package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p036 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p036().solve());
	}

	public String solve()
	{
		int sum = 0;

		for (int i = 1; i < 1000000; i++)
			if (ProjectEulerLibrary.isPalindrome(Integer.toString(i, 10)) && ProjectEulerLibrary.isPalindrome(Integer.toString(i, 2)))
				sum += i;

		return Integer.toString(sum);
	}
}
