package problem_solutions;
import java.math.BigInteger;


public final class p057 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p057().solve());
	}
	
	
	public String solve()
	{
		BigInteger n = BigInteger.ZERO;
		BigInteger d = BigInteger.ONE;
		int count = 0;

		for (int i = 0; i < 1000; i++)
		{
			BigInteger temp = d.multiply(BigInteger.valueOf(2)).add(n);
			n = d;
			d = temp;

			// Now n/d is the i'th (0-based) continued fraction approximation of sqrt(2) - 1
			if (n.add(d).toString().length() > d.toString().length())
				count++;
		}
		return Integer.toString(count);
	}
	
}
