package problem_solutions;
import utils.ProjectEulerLibrary;


public final class p038 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p038().solve());
	}

	public String solve()
	{
		int max = -1;
		String concat = "";

		for (int n = 2; n <= 9; n++)
		{
			for (int i = 1; i < ProjectEulerLibrary.pow(10, 9 / n); i++)
			{
				concat = "";

				for (int j = 1; j <= n; j++)
					concat += i * j;

				if (ProjectEulerLibrary.isPandigital(concat))
					max = Math.max(Integer.parseInt(concat), max);
			}
		}
		return Integer.toString(max);
	}

	/* Exchanged with ProjectEulerLibrary-Method
	private static boolean isPandigital(String s)
	{
		if (s.length() != 9)
			return false;

		char[] temp = s.toCharArray();
		Arrays.sort(temp);

		return new String(temp).equals("123456789");
	}*/
}
