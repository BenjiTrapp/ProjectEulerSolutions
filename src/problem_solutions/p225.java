package problem_solutions;

public final class p225 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p225().solve());
	}

	private static final int INDEX = 124;  // 1-based

    public String solve()
    {
        int count = 0;

        for (int i = 1; ; i += 2)
        {
            if (!hasMultiple(i))
            {
                count++;

                if (count == INDEX)
                    return Integer.toString(i);
            }
        }
    }

    private static boolean hasMultiple(int modulus)
    {
        /*
           Floyd's cycle-finding algorithm
           See: http://de.wikipedia.org/wiki/Hase-Igel-Algorithmus
         */
        Tribonacci slow = new Tribonacci(modulus);
        Tribonacci fast = new Tribonacci(modulus);

        while (true)
        {
            if (slow.hasMultiple())
                return true;

            slow.next();
            fast.next();
            fast.next();

            if (slow.equals(fast))
                return false;
        }
    }

    /**
     * See http://mathworld.wolfram.com/TribonacciNumber.html for more details
     */
    private static class Tribonacci
    {
        public final int modulus;
        public int a;
        public int b;
        public int c;

        public Tribonacci(int mod)
        {
            a = 1 % mod;
            b = 1 % mod;
            c = 1 % mod;
            modulus = mod;
        }

        public void next()
        {
            int d = (a + b + c) % modulus;
            a = b;
            b = c;
            c = d;
        }

        public boolean hasMultiple()
        {
            return a == 0 || b == 0 || c == 0;
        }

        public boolean equals(Tribonacci other)
        {
            return   a == other.a
                  && b == other.b
                  && c == other.c
                  && modulus == other.modulus;
        }
    }
}
