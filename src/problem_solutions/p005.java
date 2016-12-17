package problem_solutions;
import java.math.BigInteger;


public final class p005 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p005().solve());
	}

	public String solve()
	{
		BigInteger allLcm = BigInteger.ONE;

		for (int i = 1; i <= 20; i++)
			allLcm = lcm(BigInteger.valueOf(i), allLcm);

		return allLcm.toString();
	}
	
	private static BigInteger lcm(BigInteger x, BigInteger y)
	{
		return x.divide(x.gcd(y)).multiply(y);
	}
}
