package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p127 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p127().solve());
	}
	
	private static final int LIMIT = 120000;
	
	public String solve()
    {
        int[] smallestPrimeFactor = ProjectEulerLibrary.listSmallestPrimeFactors(LIMIT - 1);
        int[] rads = new int[LIMIT];
        long sum = 0;
        int p;

        for (int i = 1; i < rads.length; i++)
        {
            int n = i;
            int rad = 1;

            while (n > 1)
            {
                p = smallestPrimeFactor[n];

                do
                    n /= p;
                while (n % p == 0);

                rad *= p;
            }

            rads[i] = rad;
        }

		/* 
		 * Notes:
		 * - gcd(a,b) = gcd(a,c) = gcd(b,c), so we only need to compute one of them.
		 * - Since {a, b, c} are mutually coprime, rad(a * b * c) = rad(a) * rad(b) * rad(c).
		 * - rad(a)*rad(b)*rad(c) < c implies rad(a)*rad(b)*rad(c) <= c-1 implies rad(a)*rad(b) <= floor((c-1)/rad(c)).
		 */
        for (int c = 2; c < LIMIT; c++)
        {
            int threes = (c - 1) / rads[c];
            int b;

            for (int a = 1; ; a++)
            {
                b = c - a;

                if (b <= a)
                    break;

                /* The first two conditions are just optional optimizations */
                if (rads[a] <= threes && rads[b] <= threes && (long) rads[a] * rads[b] <= threes && ProjectEulerLibrary.gcd(a, b) == 1)
                    sum += c;
            }
        }

        return Long.toString(sum);
    }
}
