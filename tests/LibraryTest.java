import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.ProjectEulerLibrary.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

public class LibraryTest
{

    @Test
    public void testReverse()
    {
        assertEquals("", reverse(""));
        assertEquals("a", reverse("a"));
        assertEquals("ba", reverse("ab"));
        assertEquals("001", reverse("100"));
        assertEquals("a0a", reverse("a0a"));
        assertEquals("ABBA", reverse("ABBA"));
    }


    @Test
    public void testIsPalindromeString()
    {
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome("aa"));
        assertTrue(isPalindrome("aaa"));
        assertTrue(isPalindrome("aaaa"));
        assertTrue(isPalindrome("aba"));
        assertTrue(isPalindrome("abba"));
        assertTrue(isPalindrome("abbba"));
        assertTrue(isPalindrome("acbca"));
    }

    @Test
    public void testIsNOTPalindromeString()
    {
        assertFalse(isPalindrome("ab"));
        assertFalse(isPalindrome("ba"));
        assertFalse(isPalindrome("aaba"));
        assertFalse(isPalindrome("abcd"));
    }

    @Test
    public void testIsPalindromeInt()
    {
        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(1));
        assertTrue(isPalindrome(5));
        assertTrue(isPalindrome(11));
        assertTrue(isPalindrome(33));
        assertTrue(isPalindrome(101));
        assertTrue(isPalindrome(151));
        assertTrue(isPalindrome(737));
        assertTrue(isPalindrome(2222));
        assertTrue(isPalindrome(5665));
        assertTrue(isPalindrome(2147447412));
    }

    @Test
    public void testIsNOTPalindromeInt()
    {
        assertFalse(isPalindrome(12));
        assertFalse(isPalindrome(43));
        assertFalse(isPalindrome(220));
        assertFalse(isPalindrome(1010));
        assertFalse(isPalindrome(2147483647));
    }

    @Test
    public void testCrossfoot()
    {
        assertEquals(18, getCrossfoot("36036"));
        assertEquals(45, getCrossfoot("1748592603"));
    }

    @Test
    public void testPandigital()
    {
        assertTrue(isPandigital("1748592603"));
        assertTrue(isPandigital("1023456789"));
        assertTrue(isPandigital("1023456978"));
        assertTrue(isPandigital("1023456879"));
    }

    @Test
    public void testSqrtInt()
    {
        assertEquals(0, sqrt(0));
        assertEquals(1, sqrt(1));
        assertEquals(1, sqrt(2));
        assertEquals(1, sqrt(3));
        assertEquals(2, sqrt(4));
        assertEquals(2, sqrt(5));
        assertEquals(2, sqrt(8));
        assertEquals(3, sqrt(9));
        assertEquals(3, sqrt(10));
        assertEquals(18, sqrt(360));
        assertEquals(19, sqrt(361));
        assertEquals(19, sqrt(362));
        assertEquals(256, sqrt(65536));
        assertEquals(32768, sqrt(1073741824));
        assertEquals(46340, sqrt(2147483647));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testSqrtIntInvalid0()
    {
        sqrt(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSqrtIntInvalid1()
    {
        sqrt(-300000);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSqrtIntInvalid2()
    {
        sqrt(Integer.MIN_VALUE);
    }


    @Test
    public void testSqrtLong()
    {
        assertEquals(0L, sqrt(0L));
        assertEquals(1L, sqrt(1L));
        assertEquals(1L, sqrt(2L));
        assertEquals(1L, sqrt(3L));
        assertEquals(2L, sqrt(4L));
        assertEquals(2L, sqrt(5L));
        assertEquals(2L, sqrt(8L));
        assertEquals(3L, sqrt(9L));
        assertEquals(3L, sqrt(10L));
        assertEquals(18L, sqrt(360L));
        assertEquals(19L, sqrt(361L));
        assertEquals(19L, sqrt(362L));
        assertEquals(256L, sqrt(65536L));
        assertEquals(32768L, sqrt(1073741824L));
        assertEquals(46340L, sqrt(2147483648L));
        assertEquals(2645751L, sqrt(7000000000000L));
        assertEquals(3037000499L, sqrt(9223372036854775807L));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testSqrtLongInvalid0()
    {
        sqrt(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSqrtLongInvalid1()
    {
        sqrt(-3000000000L);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSqrtLongInvalid2()
    {
        sqrt(Long.MIN_VALUE);
    }


    @Test
    public void testIsSquare()
    {
        assertTrue(isSquare(0));
        assertTrue(isSquare(1));
        assertTrue(isSquare(4));
        assertTrue(isSquare(9));
        assertTrue(isSquare(16));
        assertTrue(isSquare(25));
        assertTrue(isSquare(36));
        assertTrue(isSquare(100));
        assertTrue(isSquare(65536));
        assertTrue(isSquare(2147302921));
        assertTrue(isSquare(2147395600));
        assertFalse(isSquare(Integer.MIN_VALUE));
        assertFalse(isSquare(Integer.MIN_VALUE + 1));
        assertFalse(isSquare(-8654038));
        assertFalse(isSquare(-300));
        assertFalse(isSquare(-4));
        assertFalse(isSquare(-1));
        assertFalse(isSquare(2));
        assertFalse(isSquare(3));
        assertFalse(isSquare(5));
        assertFalse(isSquare(6));
        assertFalse(isSquare(7));
        assertFalse(isSquare(8));
        assertFalse(isSquare(120));
        assertFalse(isSquare(9999));
        assertFalse(isSquare(Integer.MAX_VALUE - 1));
        assertFalse(isSquare(Integer.MAX_VALUE));
    }


    @Test
    public void testPowMod()
    {
        assertEquals(0, powMod(0, 0, 1));
        assertEquals(0, powMod(1, 0, 1));
        assertEquals(0, powMod(0, 1, 1));
        assertEquals(0, powMod(1, 1, 1));
        assertEquals(0, powMod(2, 3, 1));
        assertEquals(1, powMod(0, 0, 2));
        assertEquals(1, powMod(1, 0, 2));
        assertEquals(1, powMod(2, 0, 2));
        assertEquals(0, powMod(0, 1, 2));
        assertEquals(1, powMod(1, 1, 2));
        assertEquals(0, powMod(2, 1, 2));
        assertEquals(0, powMod(0, 2, 2));
        assertEquals(1, powMod(1, 2, 2));
        assertEquals(0, powMod(2, 2, 2));
        assertEquals(1, powMod(2, 2, 3));
        assertEquals(4, powMod(4, 3, 5));
        assertEquals(3, powMod(7, 7, 10));
        assertEquals(326216098, powMod(78051657, 234602, 456087413));
        assertEquals(1488576545, powMod(2147480000, 2147483645, 2147483647));
    }


    @Test
    public void testFactorial()
    {
        assertEquals(new BigInteger("1"), factorial(0));
        assertEquals(new BigInteger("1"), factorial(1));
        assertEquals(new BigInteger("2"), factorial(2));
        assertEquals(new BigInteger("6"), factorial(3));
        assertEquals(new BigInteger("24"), factorial(4));
        assertEquals(new BigInteger("120"), factorial(5));
        assertEquals(new BigInteger("720"), factorial(6));
        assertEquals(new BigInteger("6227020800"), factorial(13));
        assertEquals(new BigInteger("51090942171709440000"), factorial(21));
        assertEquals(new BigInteger("265252859812191058636308480000000"), factorial(30));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testFactorialInvalid0()
    {
        factorial(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFactorialInvalid1()
    {
        factorial(-563);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFactorialInvalid2()
    {
        factorial(Integer.MIN_VALUE);
    }


    @Test
    public void testBinomial()
    {
        assertEquals(new BigInteger("1"), binomial(0, 0));
        assertEquals(new BigInteger("1"), binomial(1, 0));
        assertEquals(new BigInteger("1"), binomial(1, 1));
        assertEquals(new BigInteger("1"), binomial(2, 0));
        assertEquals(new BigInteger("2"), binomial(2, 1));
        assertEquals(new BigInteger("1"), binomial(2, 2));
        assertEquals(new BigInteger("1"), binomial(3, 0));
        assertEquals(new BigInteger("3"), binomial(3, 1));
        assertEquals(new BigInteger("3"), binomial(3, 2));
        assertEquals(new BigInteger("1"), binomial(3, 3));
        assertEquals(new BigInteger("35"), binomial(7, 4));
        assertEquals(new BigInteger("120"), binomial(10, 7));
        assertEquals(new BigInteger("21"), binomial(21, 20));
        assertEquals(new BigInteger("88749815264600"), binomial(50, 28));
    }


    @Test
    public void testGcd()
    {
        assertEquals(0, gcd(0, 0));
        assertEquals(1, gcd(0, 1));
        assertEquals(1, gcd(1, 0));
        assertEquals(6, gcd(0, 6));
        assertEquals(6, gcd(6, 0));
        assertEquals(1, gcd(1, 1));
        assertEquals(2, gcd(2, 2));
        assertEquals(1, gcd(2, 3));
        assertEquals(1, gcd(10, 3));
        assertEquals(3, gcd(9, 3));
        assertEquals(2, gcd(6, 4));
        assertEquals(2, gcd(18, 14));
        assertEquals(300, gcd(44100, 48000));
        assertEquals(2147483647, gcd(0, 2147483647));
        assertEquals(2147483647, gcd(2147483647, 2147483647));
        assertEquals(1, gcd(2147483646, 2147483647));
    }


    @Test
    public void testIsPrime()
    {
        assertFalse(isPrime(0));
        assertFalse(isPrime(1));
        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertFalse(isPrime(4));
        assertTrue(isPrime(5));
        assertFalse(isPrime(6));
        assertTrue(isPrime(7));
        assertFalse(isPrime(8));
        assertFalse(isPrime(9));
        assertFalse(isPrime(10));
        assertTrue(isPrime(11));
        assertFalse(isPrime(12));
        assertTrue(isPrime(13));
        assertFalse(isPrime(14));
        assertFalse(isPrime(15));
        assertFalse(isPrime(16));
        assertTrue(isPrime(17));
        assertFalse(isPrime(18));
        assertTrue(isPrime(19));
        assertFalse(isPrime(20));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testIsPrimeInvalid0()
    {
        isPrime(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsPrimeInvalid1()
    {
        isPrime(-3000);
    }


    @Test
    public void testListPrimality()
    {
        boolean[] isPrime = listPrimality(1000);
        for (int i = 0; i < isPrime.length; i++)
            assertEquals(isPrime(i), isPrime[i]);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testListPrimalityInvalid0()
    {
        listPrimality(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testListPrimalityInvalid1()
    {
        listPrimality(-3000);
    }


    @Test
    public void testListPrimes()
    {
        int limit = 1000;
        int[] primes = listPrimes(limit);
        for (int i = 0; i < primes.length - 1; i++)
            assertTrue(primes[i] < primes[i + 1]);
        for (int i = 0; i <= limit; i++)
            assertEquals(isPrime(i), Arrays.binarySearch(primes, i) >= 0);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testListPrimesInvalid0()
    {
        listPrimes(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testListPrimesInvalid1()
    {
        listPrimes(-3000);
    }


    @Test
    public void testTotient()
    {
        assertEquals(1, totient(1));
        assertEquals(1, totient(2));
        assertEquals(2, totient(3));
        assertEquals(2, totient(4));
        assertEquals(4, totient(5));
        assertEquals(2, totient(6));
        assertEquals(6, totient(7));
        assertEquals(4, totient(8));
        assertEquals(6, totient(9));
        assertEquals(4, totient(10));
        assertEquals(10, totient(11));
        assertEquals(4, totient(12));
        assertEquals(12, totient(13));
        assertEquals(6, totient(14));
        assertEquals(8, totient(15));
        assertEquals(8, totient(16));
        assertEquals(16, totient(17));
        assertEquals(6, totient(18));
        assertEquals(18, totient(19));
        assertEquals(8, totient(20));
    }


    @Test (expected = IllegalArgumentException.class)
    public void testTotientInvalid0()
    {
        totient(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testTotientInvalid1()
    {
        totient(-3000);
    }


    @Test
    public void testListTotients()
    {
        int[] totients = listTotients(1000);
        for (int i = 1; i < totients.length; i++)
            assertEquals(totient(i), totients[i]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testListTotientsInvalid0()
    {
        listTotients(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testListTotientsInvalid1()
    {
        listTotients(-3000);
    }


    @Test
    public void testNextPermutation()
    {
        int[] arr;

        assertFalse(nextPermutation(new int[0]));

        arr = new int[]{0, 0, 1};
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{0, 1, 0}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 0, 0}, arr);
        assertFalse(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 0, 0}, arr);

        arr = new int[]{1, 2, 3, 5, 9};
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 2, 3, 9, 5}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 2, 5, 3, 9}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 2, 5, 9, 3}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 2, 9, 3, 5}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 2, 9, 5, 3}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 3, 2, 5, 9}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 3, 2, 9, 5}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 3, 5, 2, 9}, arr);
        assertTrue(nextPermutation(arr));
        assertArrayEquals(new int[]{1, 3, 5, 9, 2}, arr);

        for (int i = 0; i < 110; i++)
            assertTrue(nextPermutation(arr));

        assertFalse(nextPermutation(arr));
        assertArrayEquals(new int[]{9, 5, 3, 2, 1}, arr);
    }
}
