package utils;

import utils.Fraction;
import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void testCreationOfFraction() {
        Fraction fraction = new Fraction(new BigInteger("1"), new BigInteger("2"));
        assertNotNull(fraction);
        assertTrue(fraction.toString().contains("/"));
        assertTrue(fraction instanceof Fraction);
    }

    @Test(expected = ArithmeticException.class)
    public void testCreationOfFractionWithDivZeroFailsWithException() {
        //Given
        Fraction divZero;

        // When denominator is Zero => Then an exception should be triggered
        divZero = new Fraction(new BigInteger("42"), ZERO);

        // Otherwise no exception was triggered
        fail("Arithmetic for DivZero Fraction was NOT triggered! Test Failed");
    }

    @Test
    public void testEqualityOfFraction() {
        //Given
        Fraction f1 = new Fraction(ONE, TEN);
        Fraction f2 = new Fraction(ONE, TEN);

        //When
        boolean result = f1.equals(f2);

        //Then
        assertTrue(result);
    }

    @Test
    public void testGCDUsedByCreationOfFraction() {
        //Given
        Fraction f1;

        //When
        f1 = new Fraction(new BigInteger("2"), new BigInteger("8"));

        //Then
        assertEquals("1/4", f1.toString());
    }


    @Test
    public void testInequalityOfFraction() {
        //Given
        Fraction f1 = new Fraction(ONE, TEN);
        Fraction f2 = new Fraction(TEN, ONE);

        //When
        boolean result = f1.equals(f2);

        //Then
        assertFalse(result);
    }

    @Test
    public void testAdditionOfTwoFractions() {
        //Given
        Fraction f1 = new Fraction(new BigInteger("1"), new BigInteger("4"));
        Fraction f2 = new Fraction(new BigInteger("1"), new BigInteger("4"));

        //When
        Fraction result = f1.add(f2);

        //Then
        assertEquals(result.toString(), "1/2");
    }

    @Test
    public void testSubtractionOfTwoFractions() {
        //Given
        Fraction f1 = new Fraction(new BigInteger("1"), new BigInteger("4"));
        Fraction f2 = new Fraction(new BigInteger("1"), new BigInteger("2"));

        //When
        Fraction result = f1.subtract(f2);

        //Then
        assertEquals(result.toString(), "-1/4");
    }

    @Test
    public void testMultiplicationOfTwoFractions() {
        //Given
        Fraction f1 = new Fraction(new BigInteger("1"), new BigInteger("4"));
        Fraction f2 = new Fraction(new BigInteger("1"), new BigInteger("4"));

        //When
        Fraction result = f1.add(f2);

        //Then
        assertEquals(result.toString(), "1/2");
    }

    @Test
    public void testDivisionOfTwoFractions() {
        //Given
        Fraction f1 = new Fraction(new BigInteger("1"), new BigInteger("4"));
        Fraction f2 = new Fraction(new BigInteger("1"), new BigInteger("2"));

        //When
        Fraction result = f1.add(f2);

        //Then
        assertEquals(result.toString(), "3/4");
    }
}
