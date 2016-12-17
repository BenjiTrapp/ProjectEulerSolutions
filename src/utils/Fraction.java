package utils;

import java.math.BigInteger;

public final class Fraction
{

    public final BigInteger numerator;    // Always coprime with denominator
    public final BigInteger denominator;  // Always positive

    public Fraction(BigInteger numer, BigInteger denom)
    {
        if (denom.signum() == 0)
            throw new ArithmeticException("Division by zero");

        BigInteger gcd = numer.gcd(denom);

        // Reduce to canonical form
        if (denom.signum() == -1)
        {
            numer = numer.negate();
            denom = denom.negate();
        }

        if (!gcd.equals(BigInteger.ONE))
        {
            numer = numer.divide(gcd);
            denom = denom.divide(gcd);
        }

        this.numerator = numer;
        this.denominator = denom;
    }

    public Fraction add(Fraction other)
    {
        return new Fraction(this.numerator.multiply(other.denominator)
                .add(other.numerator.multiply(this.denominator)), this.denominator.multiply(other.denominator));
    }

    public Fraction subtract(Fraction other)
    {
        return new Fraction(this.numerator.multiply(other.denominator)
                .subtract(other.numerator.multiply(this.denominator)), this.denominator.multiply(other.denominator));
    }

    public Fraction multiply(Fraction other)
    {
        return new Fraction(this.numerator.multiply(other.numerator), this.denominator.multiply(other.denominator));
    }

    public Fraction divide(Fraction other)
    {
        return new Fraction(this.numerator.multiply(other.denominator), this.denominator.multiply(other.numerator));
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Fraction)
        {
            Fraction other = (Fraction) obj;
            return this.numerator.equals(other.numerator) && this.denominator.equals(other.denominator);
        }

        return false;
    }

    public int hashCode()
    {
        return numerator.hashCode() + denominator.hashCode();
    }

    public String toString()
    {
        return numerator + "/" + denominator;
    }
}
