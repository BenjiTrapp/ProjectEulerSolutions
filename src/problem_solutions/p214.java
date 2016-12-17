package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p214 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p214().solve());
	}

	private static final int LIMIT = 40000000;

   /**
    * Requires at least 320 MB of memory
    */
	public String solve()
    {
        int[] totient = ProjectEulerLibrary.listTotients(LIMIT);
        int[] totientChainLength = new int[LIMIT + 1];
        totientChainLength[0] = 0;
        long sum = 0;
        int chainlen;

        // Fill table in ascending order because totient chains are strictly decreasing
        for (int i = 1; i < LIMIT; i++)
        {
            chainlen = totientChainLength[totient[i]] + 1;
            totientChainLength[i] = chainlen;

            if (chainlen == 25 && totient[i] == i - 1)  // i is prime iff totient(i) = i-1
                sum += i;
        }
        return Long.toString(sum);
    }
}
