package problem_solutions;
import java.math.BigInteger;

public final class p065 implements EulerSolution
{
	
	public static void main(String[] args) {
		System.out.println(new p065().solve());
	}

	public String solve()
	{
		BigInteger n = BigInteger.ONE;
		BigInteger d = BigInteger.ZERO;
		int sum = 0;

		for (int i = 99; i >= 0; i--)
		{
			BigInteger temp = BigInteger.valueOf(continuedFractionTerm(i)).multiply(n).add(d);
			d = n;
			n = temp;
		}

		while (!n.equals(BigInteger.ZERO))
		{
			BigInteger[] divrem = n.divideAndRemainder(BigInteger.TEN);
			sum += divrem[1].intValue();
			n = divrem[0];
		}

		return Integer.toString(sum);
	}

	private static int continuedFractionTerm(int i)
	{
		if (i == 0)
			return 2;
		else if (i % 3 == 2)
			return i / 3 * 2 + 2;
		else
			return 1;
	}
}