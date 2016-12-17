package problem_solutions;

public final class p002 implements EulerSolution
{
    public static void main(String[] args)
    {
        System.out.println(new p002().solve());
    }

    public String solve()
    {
        int sum = -1;
        int fib = -1;
        for (int i = 0; ; i++)
        {
            fib = fibonacci(i);

            if (fib > 4000000)
                break;
            if (fib % 2 == 0)
                sum += fib;
        }
        return Integer.toString(sum);
    }

    private static int fibonacci(int x)
    {
        if (x < 0 || x > 46)
            throw new IllegalArgumentException();

        int a = 0;
        int b = 1;

        for (int i = 0; i < x; i++)
        {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
