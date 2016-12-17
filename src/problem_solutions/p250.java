package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p250 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p250().solve());
	}

	private static final long MODULUS = 10000000000000000L;

    public String solve()
    {
        // numSubsets[i] is {the number of subsets with sum equal to i mod 250} mod 10^16
        long[] numSubsets = new long[250]; numSubsets[0] = 1;

        for (int i = 1; i <= 250250; i++)
        {
            int temp = ProjectEulerLibrary.powMod(i, i, 250);
            long[] newArray = numSubsets.clone();

            for (int j = 0; j < 250; j++)
                newArray[(j + temp) % 250] = (numSubsets[j] + numSubsets[(j + temp) % 250]) % MODULUS;

            numSubsets = newArray;
        }

        return Long.toString((numSubsets[0] - 1 + MODULUS) % MODULUS);
    }
}
