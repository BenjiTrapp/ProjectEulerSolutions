package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p134 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p134().solve());
	}
	
	/**
	 * Let p and q be the two primes. Let k be the smallest power of 10 that exceeds p.
	 * The number that we seek is n = mk + p, where n is divisible by q, and m is minimized.
	 * (For example, p = 19, q = 23, k = 100, m = 12, n = 1219.)
	 * 
	 * Firstly, n = mk + p = 0 mod q. By rearrangement, m = -p k^-1 mod q. (k^-1 exists because q is coprime with 10.)
	 * Then of course the smallest m that satisfies the divisibility condition is the one such that 0 <= m < q.
	 */
    public String solve()
    {
        long sum = 0,m;
        int p,q,k;
        int[] primes = ProjectEulerLibrary.listPrimes(2000000);

        for (int i = 2; primes[i] <= 1000000; i++)
        {
            p = primes[i];
            q = primes[i + 1];
            k = 1;

            while (k < p)
                k *= 10;

            m = (long) (q - p) * ProjectEulerLibrary.reciprocalMod(k % q, q) % q;
            sum += m * k + p;
        }
        return Long.toString(sum);
    }
}
