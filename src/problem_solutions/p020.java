package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p020 implements EulerSolution
{
	
	public static void main(String[] args) {
		System.out.println(new p020().solve());
	}

	public String solve()
	{
		String temp = ProjectEulerLibrary.factorial(100).toString();
		int sum = 0;

		for (int i = 0; i < temp.length(); i++)
			sum += temp.charAt(i) - '0';

		return Integer.toString(sum);
	}
}
