package problem_solutions;
import java.math.BigInteger;


public final class p080 implements EulerSolution
{
	public static void main(String[] args)
	{
		System.out.println(new p080().solve());
	}

	public String solve()
	{
		int sum = 0;
		BigInteger x,y;
		String s;

		for (int i = 1; i <= 100; i++)
		{
			x = BigInteger.valueOf(i);
			x = x.multiply(BigInteger.TEN.pow(100 * 2));  // Shift left so that we can obtain 100 digits after the decimal point
			y = sqrt(x);

			if (!y.multiply(y).equals(x))
			{
			    /*
			     	Skip perfect squares
				 	Strip rightmost digits so that we have exactly 100 decimal digits (some are before the decimal point)
			      */
				s = y.toString().substring(0, 100);
				for (int j = 0; j < s.length(); j++)
					sum += s.charAt(j) - '0';
			}
		}

		return Integer.toString(sum);
	}


	private static BigInteger sqrt(BigInteger x)
	{
		// Find leftmost position
		int i = 0;
		int j;
		BigInteger y,delta = null;

		while (BigInteger.TEN.pow(i * 2).compareTo(x) <= 0)
			i++;

		// Extract square root from left to right using an algorithm like long division
		y = BigInteger.ZERO;

		for (; i >= 0; i--)
		{
			// Try every value for next digit
			for (j = 9; j >= 0; j--)
			{
				BigInteger temp = BigInteger.valueOf(j).multiply(BigInteger.TEN.pow(i));
				delta = y.shiftLeft(1).add(temp).multiply(temp);

				if (delta.compareTo(x) <= 0)
					break;
			}

			if (j < 0)
				throw new AssertionError();

			x = x.subtract(delta);  // Adjust the remainder
			y = y.add(BigInteger.valueOf(j).multiply(BigInteger.TEN.pow(i)));  // Add the new digit
		}

		return y;
	}
}
