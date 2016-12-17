package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p068 implements EulerSolution
{

	public static void main(String[] args)
	{
	}


	public String solve()
	{
		int[] state = new int[10];
		System.out.println(new p068().solve());
		String s = "";
		String max = null;
		int minOuterIndex, minOuter;

		for (int i = 0; i < state.length; i++)
			state[i] = i + 1;

		do
		{
			int sum = state[0] + state[5] + state[6];
			if (state[1] + state[6] + state[7] != sum
					|| state[2] + state[7] + state[8] != sum
					|| state[3] + state[8] + state[9] != sum
					|| state[4] + state[9] + state[5] != sum)
				continue;

			minOuterIndex = -1;
			minOuter = Integer.MAX_VALUE;

			for (int i = 0; i < 5; i++)
			{
				if (state[i] < minOuter)
				{
					minOuterIndex = i;
					minOuter = state[i];
				}
			}


			for (int i = 0; i < 5; i++)
				s += "" + state[(minOuterIndex + i) % 5] + state[(minOuterIndex + i) % 5 + 5] + state[(minOuterIndex + i + 1) % 5 + 5];

			if (s.length() == 16 && (max == null || s.compareTo(max) > 0))
				max = s;

		} while (ProjectEulerLibrary.nextPermutation(state));

		if (max == null)
			throw new AssertionError();

		return max;
	}
}
