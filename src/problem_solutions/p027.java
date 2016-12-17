package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p027 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p027().solve());
	}

	public String solve()
	{
		int bestNum = 0;
		int bestA = 0;
		int bestB = 0;

		for (int a = -1000; a <= 1000; a++)
		{
			for (int b = -1000; b <= 1000; b++)
			{
				int num = numberOfConsecutivePrimesGenerated(a, b);
				if (num > bestNum)
				{
					bestNum = num;
					bestA = a;
					bestB = b;
				}
			}
		}
		return Integer.toString(bestA * bestB);
	}
	
	private static int numberOfConsecutivePrimesGenerated(int a, int b)
	{
		int n;

		for (int i = 0; ; i++)
		{
			n = i * i + i * a + b;

			if (n < 0 || !ProjectEulerLibrary.isPrime(n))
				return i;
		}
	}
}
