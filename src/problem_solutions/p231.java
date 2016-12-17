package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p231 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p231().solve());
	}
	
	private static final int N = 20000000;
	private static final int K = 15000000;

    public String solve()
    {
        int[] smallestPrimeFactor = ProjectEulerLibrary.listSmallestPrimeFactors(N);
        long sum = factorialPrimeFactorSum(N, smallestPrimeFactor);

        sum -= factorialPrimeFactorSum(K, smallestPrimeFactor);
        sum -= factorialPrimeFactorSum(N - K, smallestPrimeFactor);

        return Long.toString(sum);
    }

    private static long factorialPrimeFactorSum(int n, int[] smallestPrimeFactor)
    {
        long sum = 0;
        int j;

        for (int i = 1; i <= n; i++)
        {
            j = i;

            while (j > 1)
            {
                int p = smallestPrimeFactor[j];
                sum += p;
                j /= p;
            }
        }

        return sum;
    }
}
