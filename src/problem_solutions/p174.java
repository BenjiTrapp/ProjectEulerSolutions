package problem_solutions;

public final class p174 implements EulerSolution
{
	public static void main(String[] args){System.out.println(new p174().solve());}

	private static final int SIZE_LIMIT = 1000000;
	private static final int TYPE_LIMIT = 10;

	public String solve()
    {
		// Generate all possible laminae with at most SIZE_LIMIT tiles
		int[] type = new int[SIZE_LIMIT + 1];
        int count = 0;         // Examine the type of each total tiling
        int tiles;

        for (int n = 3; (n - 1) * 4 <= SIZE_LIMIT; n++)
        {
            // Outer square size
            for (int m = n - 2; m >= 1; m -= 2)
            {
                // Inner square hole size
                tiles = n * n - m * m;  // Intermediate computation may overflow, but result is correct

                if (tiles > SIZE_LIMIT)
                    break;

                type[tiles]++;
            }
        }

        for (int t : type)
            if (1 <= t && t <= TYPE_LIMIT)
                count++;

        return Integer.toString(count);
    }
}
