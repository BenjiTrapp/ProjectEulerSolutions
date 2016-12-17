package problem_solutions;
import utils.ProjectEulerLibrary;

import java.math.BigInteger;


public final class p014 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p014().solve());
	}
	
	private static final int LIMIT = ProjectEulerLibrary.pow(10, 6);
	/**
	 * Any non-negative number => Though there are diminishing returns
	 */
	private static final BigInteger CACHE_SIZE = BigInteger.valueOf(LIMIT);
	/**
	 * Remember me ... collatz ftw :-D
	 */
	private int[] collatzChainLength = new int[CACHE_SIZE.intValue()];


	public String solve()
	{
		int maxArg = -1;
		int maxChain = 0;

		for (int i = 1; i < LIMIT; i++)
		{
			int chainLen = collatzChainLength(BigInteger.valueOf(i));

			if (chainLen > maxChain)
			{
				maxArg = i;
				maxChain = chainLen;
			}
		}
		return Integer.toString(maxArg);
	}

	private int collatzChainLength(BigInteger n)
	{
		if (n.signum() < 0)
			throw new IllegalArgumentException();

		/* No caching available :-/ */
		if (n.compareTo(CACHE_SIZE) >= 0)
			return collatzChainLengthDirect(n);

		/*Cached index*/
		int index = n.intValue();

		if (collatzChainLength[index] == 0)
			collatzChainLength[index] = collatzChainLengthDirect(n);

		return collatzChainLength[index];
	}
	
	
	private int collatzChainLengthDirect(BigInteger n)
	{
		if (n.equals(BigInteger.ONE))  // The base case case
			return 1;
		else if (!n.testBit(0))  // Check highest one-bit => Digit is even
			return collatzChainLength(n.shiftRight(1)) + 1;
		else  // Digit is odd
			return collatzChainLength(n.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE)) + 1;
	}
}
