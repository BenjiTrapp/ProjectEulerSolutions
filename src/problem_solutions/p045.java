package problem_solutions;

public final class p045 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p045().solve());
	}
	
	public String solve()
	{
		int i = 286;
		int j = 166;
		int k = 144;
		long triangle, pentagon, hexagon, min;

		while (true)
		{
			triangle = (long)i * (i + 1) / 2;
			pentagon = (long)j * (j * 3 - 1) / 2;
			hexagon  = (long)k * (k * 2 - 1);
			min = Math.min(Math.min(triangle, pentagon), hexagon);

			if (min == triangle && min == pentagon && min == hexagon)
				return Long.toString(min);

			if (min == triangle) i++;
			if (min == pentagon) j++;
			if (min == hexagon ) k++;
		}
	}
}
