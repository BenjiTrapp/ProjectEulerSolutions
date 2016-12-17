package problem_solutions;

public final class p009 implements EulerSolution
{
	public static void main(String[] args) {System.out.println(new p009().solve());}

	public String solve() {
		for (int a = 1; a < 1000; a++)
		{
			for (int b = a + 1; b < 1000; b++)
			{
				int c = 1000 - a - b;

				/* This implies b < c */
				if (a * a + b * b == c * c)
					return Integer.toString(a * b * c);
			}
		}
		throw new AssertionError("Not found");
	}
}
