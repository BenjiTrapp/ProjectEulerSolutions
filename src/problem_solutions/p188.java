package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p188 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p188().solve());
	}

	public String solve() {return Integer.toString(tetrationMod(1777, 1855, ProjectEulerLibrary.pow(10, 8)));}

	private static int tetrationMod(int x, int y, int m)
    {
		if (y == 1)
			return x % m;
		else
			// Fact: If x and m are coprime, then x^y mod m = x^(y mod totient(m)) mod m
			return ProjectEulerLibrary.powMod(x, tetrationMod(x, y - 1, ProjectEulerLibrary.totient(m)), m);
	}
}
