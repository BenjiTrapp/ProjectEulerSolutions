package problem_solutions;

public final class p039 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p039().solve());
	}

	public String solve()
	{
		int maxPerimeter = 0;
		int maxTriangles = 0;
		int triangles;

		for (int p = 1; p <= 1000; p++)
		{
			triangles = countSolutions(p);

			if (triangles > maxTriangles)
			{
				maxTriangles = triangles;
				maxPerimeter = p;
			}
		}

		return Integer.toString(maxPerimeter);
	}
	
	private static int countSolutions(int p)
	{
		int count = 0;
		int c;

		for (int a = 1; a <= p; a++)
			for (int b = a; b <= p; b++)
			{
				c = p - a - b;

				if (b <= c && a * a + b * b == c * c)
					count++;
			}

		return count;
	}
}
