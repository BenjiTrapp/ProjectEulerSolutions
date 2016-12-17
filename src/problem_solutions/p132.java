package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p132 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p132().solve());
	}

    public String solve()
    {
        int sum = 0;
        int count = 0;

        for (int i = 2; count < 40; i++)
        {
            if (ProjectEulerLibrary.isPrime(i) && repunitMod(1000000000, i) == 0)
            {
                sum += i;
                count++;
            }
        }

        return Integer.toString(sum);
    }

    private static int repunitMod(int k, int m)
    {
        return (ProjectEulerLibrary.powMod(10, k, m * 9) - 1) / 9;
    }
}
