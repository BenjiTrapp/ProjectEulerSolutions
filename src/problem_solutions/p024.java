package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p024 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p024().solve());
	}
	
	public String solve()
	{
		/* Initialize the Shit */
		String ans = "";
		int[] array = new int[10];

		for (int i = 0; i < array.length; i++)
			array[i] = i;

		/* Permutete the initialized Shit */
		for (int i = 0; i < 999999; i++)
			if (!ProjectEulerLibrary.nextPermutation(array))
				throw new AssertionError();

		/* Pushover for a pretty output */
		for (int i = 0; i < array.length; i++)
			ans += array[i];

		return ans;
	}
}