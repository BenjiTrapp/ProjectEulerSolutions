package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p007 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p007().solve());
	}

	public String solve()
	{
		for (int i = 2, count = 0; ; i++)
		{
			if (ProjectEulerLibrary.isPrime(i))
			{
				count++;
				if (count == 10001)
					return Integer.toString(i);
			}
		}
	}
}