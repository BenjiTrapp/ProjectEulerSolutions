package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p012 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p012().solve());
	}
	
	public String solve()
	{
		int num = 0;

		for (int i = 1; ; i++)
		{
			num += i;  // num is triangle number i

			if (countDivisors(num) > 500)
				return Integer.toString(num);
		}
	}

	private static int countDivisors(int n)
	{
		int count = 0;
		int end = ProjectEulerLibrary.sqrt(n);

		for (int i = 1; i < end; i++)
			if (n % i == 0)
				count += 2;

		/*Count up if it's a Perfect Square*/
		if (end * end == n)
			count++;

		return count;
	}
}