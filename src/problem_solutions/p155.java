package problem_solutions;
import  utils.Fraction;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


public final class p155 implements EulerSolution
{
	public static void main(String[] args){System.out.println(new p155().solve());}

	/* NOTE: Requires about 5 GB of memory */
	private static final int SIZE = 18;

    public String solve()
    {
        @SuppressWarnings ("unchecked")
        Set<Fraction>[] possible = new Set[SIZE + 1];
        Set<Fraction> all = new HashSet<>();
        possible[0] = new HashSet<>();
        possible[1] = new HashSet<>();
        possible[1].add(new Fraction(BigInteger.valueOf(60), BigInteger.ONE));
        all.addAll(possible[1]);

        for (int i = 2; i <= SIZE; i++)
        {
            Set<Fraction> poss = new HashSet<>();

            for (int j = 1; j <= i - j; j++)
            {
                for (Fraction a : possible[j])
                {
                    for (Fraction b : possible[i - j])
                    {
                        poss.add(a.add(b));
                        poss.add(a.multiply(b).divide(a.add(b)));
                    }
                }
            }

            possible[i] = poss;
            all.addAll(poss);
        }
        return Integer.toString(all.size());
    }
}
