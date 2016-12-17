package problem_solutions;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public final class p029 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p029().solve());
	}

	public String solve()
	{
		Set<BigInteger> generated = new HashSet<>();

		for (int a = 2; a <= 100; a++)
			for (int b = 2; b <= 100; b++)
				generated.add(BigInteger.valueOf(a).pow(b));

		return Integer.toString(generated.size());
	}
}
