package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p069 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p069().solve());
	}
	
	private static final int LIMIT = ProjectEulerLibrary.pow(10, 6);
	
	public String solve()
    {
        int maxNumer = 0;
        int maxDenom = 1;
        int[] totients = ProjectEulerLibrary.listTotients(LIMIT);

        for (int n = 1; n < totients.length; n++)
        {
            if ((long) n * maxDenom > (long) maxNumer * totients[n])
            {
                maxNumer = n;
                maxDenom = totients[n];
            }
        }

        return Integer.toString(maxNumer);
    }
}
