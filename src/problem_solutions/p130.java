package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p130 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p130().solve());
	}

	public String solve()
    {
		int sum = 0;
		int found = 0;

		for (int i = 7; found < 25; i += 2)
        {
			if (i % 5 != 0 && !ProjectEulerLibrary.isPrime(i) && (i - 1) % findLeastDivisibleRepunit(i) == 0)
            {
				sum += i;
				found++;
			}
		}

		return Integer.toString(sum);
	}

   /**
    *  Returns the smallest k such that R(k) is divisible by n.
    */
    private static int findLeastDivisibleRepunit(int n)
    {
        if (n % 2 == 0 || n % 5 == 0)
            return 0;

        if (n > Integer.MAX_VALUE / 10)
            throw new IllegalArgumentException("Arithmetic overflow");

        int sum = 1;  // Equal to R(k) mod n
        int pow = 1;  // Equal to 10^k mod n
        int k = 1;

        while (sum % n != 0)
        {
            k++;
            pow = pow * 10 % n;
            sum = (sum + pow) % n;
        }

        return k;
    }
}
