package problem_solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class p122 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p122().solve());
	}

	private int[] minChainLength;

	/**
	 * Uses the concepts of addition chains. See: http://en.wikipedia.org/wiki/Addition_chain
 	 */
	public String solve()
	{
		minChainLength = new int[201];
		Arrays.fill(minChainLength, 999999);
		minChainLength[0] = 1;

		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		exploreChains(temp);

		int sum = 0;
		for (int x : minChainLength)
			sum += x - 1;
		return Integer.toString(sum);
	}

	private void exploreChains(List<Integer> chain)
	{
		int largest = chain.get(chain.size() - 1);
		int next;
		if (chain.size() > minChainLength[largest])
			return;
		minChainLength[largest] = chain.size();

		for (int i = chain.size() - 1; i >= 0; i--)
		{
			for (int j = i; j >= 0; j--)
			{
				next = chain.get(i) + chain.get(j);
				if (next > largest && next <= 200)
				{
					chain.add(next);
					exploreChains(chain);
					chain.remove(chain.size() - 1);
				}
			}
		}
	}
}
