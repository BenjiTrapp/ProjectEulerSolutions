package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p072 implements EulerSolution
{

	public static void main(String[] args)
	{
		System.out.println(new p072().solve());
	}

	private static final int LIMIT = ProjectEulerLibrary.pow(10, 6);

	public String solve()
	{
		long sum = 0;
		int[] totients = ProjectEulerLibrary.listTotients(LIMIT);

		for (int i = 2; i < totients.length; i++)
			sum += totients[i];

		return Long.toString(sum);
	}
}
