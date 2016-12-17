package problem_solutions;
import utils.ProjectEulerLibrary;
import java.util.HashSet;
import java.util.Set;

public final class p075 implements EulerSolution
{

	public static void main(String[] args) {System.out.println(new p075().solve());}

	private static final int LIMIT = 1500000;

	/*
	 * Pythagorean triples theorem:
     *   Every primitive Pythagorean triple with a odd and b even can be expressed as
     *   a = st, b = (s^2-t^2)/2, c = (s^2+t^2)/2, where s > t > 0 are coprime odd integers.
     */
	public String solve()
	{
		byte[] ways = new byte[LIMIT + 1];
		Set<IntTriple> triples = new HashSet<IntTriple>();
		int count = 0;

		for (int s = 3; s * s <= LIMIT; s += 2)
		{
			for (int t = s - 2; t > 0; t -= 2)
			{
				if (ProjectEulerLibrary.gcd(s, t) == 1)
				{
					int a = s * t;
					int b = (s * s - t * t) / 2;
					int c = (s * s + t * t) / 2;
					int sum = a + b + c;
					if (sum <= LIMIT)
						triples.add(new IntTriple(a, b, c));
				}
			}
		}

		for (IntTriple triple : triples)
		{
			int sum = triple.a + triple.b + triple.c;

			for (int i = 1; i * sum <= LIMIT; i++)
				ways[i * sum] = (byte) Math.min(ways[i * sum] + 1, 2);  // Increment but saturate at 2
		}

		for (int x : ways)
			if (x == 1)
				count++;

		return Integer.toString(count);
	}

	private static final class IntTriple
	{
		public final int a;
		public final int b;
		public final int c;

		public IntTriple(int a, int b, int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public boolean equals(Object obj)
		{
			if (!(obj instanceof IntTriple))
				return false;
			else
			{
				IntTriple other = (IntTriple) obj;
				return a == other.a && b == other.b && c == other.c;
			}
		}

		public int hashCode() {return a + b + c;}
	}
}
