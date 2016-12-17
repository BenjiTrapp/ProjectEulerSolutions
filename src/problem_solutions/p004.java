package problem_solutions;

import utils.ProjectEulerLibrary;

public final class p004 implements EulerSolution
{

    public static void main(String[] args){System.out.println(new p004().solve());}


    public String solve()
    {
        int maxPalin = -1;
        int prod;

        for (int i = 100; i < 1000; i++)
        {
            for (int j = 100; j < 1000; j++)
            {
                prod = i * j;

                if (ProjectEulerLibrary.isPalindrome(prod) && prod > maxPalin)
                    maxPalin = prod;
            }
        }

        return Integer.toString(maxPalin);
    }
}
