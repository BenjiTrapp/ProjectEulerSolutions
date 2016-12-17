package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p010 implements EulerSolution {
	
	public static void main(String[] args) { System.out.println(new p010().solve());}
	
	private static final int LIMIT = 2000000;

	public String solve()
	{
		long sum = 0;

		for (int p : ProjectEulerLibrary.listPrimes(LIMIT - 1))
			sum += p;

		return Long.toString(sum);
	}
}
