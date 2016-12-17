package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p040 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p040().solve());
	}

	public String solve()
	{
		StringBuilder sb = new StringBuilder();
		int prod = 1;


		for (int i = 1; i < 1000000; i++)
			sb.append(i);

		for (int i = 0; i <= 6; i++)
			prod *= sb.charAt(ProjectEulerLibrary.pow(10, i) - 1) - '0';

		return Integer.toString(prod);
	}
}
