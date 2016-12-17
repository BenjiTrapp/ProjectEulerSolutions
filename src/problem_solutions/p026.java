package problem_solutions;
import java.util.HashMap;
import java.util.Map;

public final class p026 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p026().solve());
	}

	public String solve()
	{
		int bestNumber = 0;
		int bestLength = 0;
		int len;

		for (int i = 1; i <= 1000; i++)
		{
			len = getCycleLength(i);

			if (len > bestLength)
			{
				bestNumber = i;
				bestLength = len;
			}
		}
		return Integer.toString(bestNumber);
	}

	private static int getCycleLength(int n)
	{
		Map<Integer, Integer> stateToIterate = new HashMap<Integer, Integer>();
		int state = 1;
		int iterate = 0;

		while (!stateToIterate.containsKey(state))
		{
			stateToIterate.put(state, iterate);
			state = state * 10 % n;
			iterate++;
		}

		return iterate - stateToIterate.get(state);
	}
}
