package problem_solutions;
import java.math.BigInteger;

public final class p025 implements EulerSolution
{
	
	public static void main(String[] args) {
		System.out.println(new p025().solve());
	}
	
	
	private static final int DIGITS = 1000;
	
	public String solve()
	{
		BigInteger lowerthres = BigInteger.TEN.pow(DIGITS - 1);
		BigInteger upperthres = BigInteger.TEN.pow(DIGITS);
		BigInteger prev = BigInteger.ONE;
		BigInteger cur = BigInteger.ZERO;
		int i = 0;

		while (true)
		{
			/* At this point, prev = fibonacci(i - 1) and cur = fibonacci(i) */
			if (cur.compareTo(lowerthres) >= 0)
				return Integer.toString(i); //Yay, finish :D
			else if (cur.compareTo(upperthres) >= 0)
				throw new ArithmeticException("Not found"); //D'Oh ... Nuts
			
			BigInteger temp = cur.add(prev);
			prev = cur;
			cur = temp;
			i++;
		}
	}
}
