package problem_solutions;

public final class p265 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p265().solve());
	}

	private static final int N = 5;  // Must be in the range [1, 5]
	private static final int TWO_POW_N = 1 << N;
    private static final int MASK = TWO_POW_N - 1;
    private static final int FULL_SET = (int) (1L << TWO_POW_N) - 1;

    public String solve()
    {
        long sum = 0;

        for (int i = 0, end = 1 << (TWO_POW_N - N); i < end; i++)
            if (checkArrangement(i))
                sum += i;

        return Long.toString(sum);
    }

    private static boolean checkArrangement(int digits)
    {
        int seen = 0;

        for (int i = 0; i < TWO_POW_N; i++)
        {
            int rot = (digits << i) | (digits >>> (TWO_POW_N - i));
            seen |= 1 << (rot & MASK);
        }

        return seen == FULL_SET;
    }
}
