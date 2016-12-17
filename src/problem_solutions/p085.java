package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p085 implements EulerSolution
{
	
	public static void main(String[] args) {
		System.out.println(new p085().solve());
	}

	private static final int TARGET = 2000000;
	
	public String solve()
	{
		int bestDiff = Integer.MAX_VALUE;
		int bestArea = -1;
		int sqrt = ProjectEulerLibrary.sqrt(TARGET);

		for (int w = 1; w <= sqrt; w++)
		{
			for (int h = 1; h <= sqrt; h++)
			{
				int diff = Math.abs(numberOfRectangles(w, h) - TARGET);
				if (diff < bestDiff) {
					bestDiff = diff;
					bestArea = w * h;
				}
			}
		}
		return Integer.toString(bestArea);
	}
	
	private static int numberOfRectangles(int m, int n)
	{
		return (m + 1) * m * (n + 1) * n / 4;  // A bit more than m^2 n^2 / 4
	}
	
}
