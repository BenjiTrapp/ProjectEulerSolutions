package problem_solutions;

public final class p323 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p323().solve());
	}
	
	/**
	 * Suppose that n 32-bit integers have been OR'd together.
	 * For any arbitrary digit:
	 *   The probability that it is 0 is 1/2^n.
	 *   The probability that it is 1 is 1 - 1/2^n.
	 * Thus for the entire number:
	 *   The probability that all digits are 1 is (1 - 1/2^n)^32.
	 *     This is the cumulative distribution function that we want.
	 *   The probability that some digit is 0 is 1 - (1 - 1/2^n)^32.
	 * 
	 * The probability density function is simply pdf(n) = cdf(n) - cdf(n-1).
	 * So the expected value of the index where the number becomes all 1's is
	 * sum(n * pdf(n) for n = 0 to infinity).
	 */
    public String solve()
    {
        /* Computes an approximate answer using floating-point, not guaranteed to be correct.*/
        double sum = 0;
        double p;

        for (int n = 1; ; n++)
        {
            p = cdf(n) - cdf(n - 1);

            /* Tsolvecate the series by ignoring insignificant contributions to the sum */
            if (p < 1e-20)
                break;

            sum += n * p;
        }

        return String.format("%.10f", sum);
    }

    private static double cdf(int n)
    {
        return  (n >= 0)? Math.pow(1 - Math.pow(2, -n), 32):0;
    }
}
