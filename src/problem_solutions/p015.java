package problem_solutions;
import utils.ProjectEulerLibrary;

public final class p015 implements EulerSolution
{
	public static void main(String[] args) {
		System.out.println(new p015().solve());
	}

	public String solve() {
		return ProjectEulerLibrary.binomial(40, 20).toString();
	}
}
