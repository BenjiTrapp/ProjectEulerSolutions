package problem_solutions;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public final class p124 implements EulerSolution
{
	public static void main(String[] args) {System.out.println(new p124().solve());}
	
	private static final int LIMIT = 100000;

	public String solve()
	{
		// Modification of the Sieve of Eratosthenes
		int[] rads = new int[LIMIT + 1];
		IntPair[] data = new IntPair[LIMIT];
		Arrays.fill(rads, 1);

		for (int i = 2; i <= LIMIT; i++)
			if (rads[i] == 1)
				for (int j = i; j <= LIMIT; j += i)
					rads[j] *= i;

		for (int i = 0; i < data.length; i++)
			data[i] = new IntPair(rads[i + 1], i + 1);

		Arrays.sort(data);

		return Integer.toString(data[10000 - 1].b);
	}

	private static final class IntPair implements Comparable<IntPair>
	{
		public final int a;
		public final int b;

		public IntPair() {throw new NotImplementedException();}

		public IntPair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}

		public int compareTo(IntPair other)
		{
			if (a < other.a)
				return -1;
			else if (a > other.a)
				return +1;
			else if (b < other.b)
				return -1;
			else if (b > other.b)
				return +1;
			else
				return 0;
		}
	}
}
