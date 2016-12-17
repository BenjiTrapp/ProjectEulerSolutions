package problem_solutions;
import utils.ProjectEulerLibrary;
import java.util.Arrays;

public final class p049 implements EulerSolution
{
	
	public static void main(String[] args) {
		System.out.println(new p049().solve());
	}
	
	private static final int LIMIT = 10000;
	
	public String solve()
	{
		boolean[] isPrime = ProjectEulerLibrary.listPrimality(LIMIT - 1);
		int a,b;

		for (int base = 1000; base < LIMIT; base++) {
			if (isPrime[base]) {
				for (int step = 1; step < LIMIT; step++)
				{
					a = base + step;
					b = a + step;

					if (       a < LIMIT && isPrime[a] && hasSameDigits(a, base)
					        && b < LIMIT && isPrime[b] && hasSameDigits(b, base)
					        && (base != 1487 || a != 4817))
						return "" + base + a + b;
				}
			}
		}
		throw new ArithmeticException("Not found");
	}
	
	
	private static boolean hasSameDigits(int x, int y) {
		char[] xdigits = Integer.toString(x).toCharArray();
		char[] ydigits = Integer.toString(y).toCharArray();
		Arrays.sort(xdigits);
		Arrays.sort(ydigits);
		return Arrays.equals(xdigits, ydigits);
	}
	
}
