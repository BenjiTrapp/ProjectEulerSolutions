package problem_solutions;

public final class p071 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p071().solve());
	}
	
	
	public String solve()
	{
		int maxN = 0;
		int maxD = 1;

		for (int d = 2; d <= 1000000; d++)
		{
			int n = d * 3 / 7;

			if (d % 7 == 0)
				n--;

			if ((long)n * maxD > (long)maxN * d)
			{
				maxN = n;
				maxD = d;
			}
		}
		return Integer.toString(maxN);
	}
}
