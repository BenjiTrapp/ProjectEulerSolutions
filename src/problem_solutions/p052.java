package problem_solutions;
import java.util.Arrays;


public final class p052 implements EulerSolution
{
    public static void main(String[] args)
    {
        System.out.println(new p052().solve());
    }

    public String solve()
    {
        outer: for (int i = 1; ; i++)
        {
            for (int j = 2; j < 6; j++)
                if (!hasSameDigits(i * j, i * (j + 1)))
                    continue outer;

            return Integer.toString(i);
        }
    }

    private static boolean hasSameDigits(int x, int y)
    {
        char[] xdigits = Integer.toString(x).toCharArray();
        char[] ydigits = Integer.toString(y).toCharArray();

        Arrays.sort(xdigits);
        Arrays.sort(ydigits);

        return Arrays.equals(xdigits, ydigits);
    }
}
