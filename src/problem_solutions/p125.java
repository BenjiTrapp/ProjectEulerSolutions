package problem_solutions;
import utils.ProjectEulerLibrary;

import java.util.HashSet;
import java.util.Set;

public final class p125 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p125().solve());
	}
	
	public String solve()
	{
		Set<Integer> nums = new HashSet<>();
		long sum;

		for (int i = 1; i <= 10000; i++)
		{
			sum = i * i;

			for (int j = i + 1; ; j++)
			{
				sum += j * j;

				if (sum >= 100000000)
					break;

				if (ProjectEulerLibrary.isPalindrome((int)sum))
					nums.add((int)sum);
			}
		}
		
		sum = 0;

		for (int x : nums)
			sum += x;

		return Long.toString(sum);
	}
}
