/**
 * This class represents a fraction.  It offers all the operations mandated by the
 * Fraction interface.
 */
public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;
    private int gcd;

    /**
     * Construct a fraction object using the given numerator and denominator
     * @param num numerator of this fraction
     * @param denom numerator of this fraction
     */
    public FractionImpl(int num, int denom) {
        // Denominator must not be 0
        if (denom <= 0) {
            throw new IllegalArgumentException();
        }

        this.numerator = num;
        this.denominator = denom;
        this.gcd = gcd(num, denom);
    }

    /**
     * Find the greatest common denominator between 2 integers
     * @param a an integer
     * @param b another integer
     */
    static int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return gcd(b, a % b);
    }

    // Getters

    /**
     * Returns the numerator of the current fraction
     * @return numerator the fraction's numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Returns the denominator of the current fraction
     * @return denominator the fraction's denominator
     */
    public int getDenominator() {
        return denominator;
    }

    // Setters

    /**
     * Set a new numerator for the current fraction
     * @param numerator new numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Set a new denominator for the current fraction
     * If an invalid denominator is passed in, throw
     * IllegalArgumentException();
     * @param denominator
     */
    public void setDenominator(int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.denominator = denominator;
        }
    }

    /**
     * Output the simplified string representation
     * of the fraction.
     * @return the string representing the fraction
     */
    public String toString() {
        return String.format("%d / %d",
            numerator / gcd,
            denominator / gcd);
    }

    /**
     * Calculate the decimal value of the fraction
     * @return the decimal value of the fraction
     */
    @Override
    public double toDouble() {
        return (double)numerator / (double)denominator;
    }

    /**
     * Return the string representation of the reciprocal
     * of the current fraction, whose numerator must not
     * be 0
     * @return the string representation of the reciprocal
     * of the current fraction
     */
    @Override
    public String reciprocal() {
        if (numerator == 0) {
            throw new ArithmeticException();
        }

        return String.format("%d / %d", denominator, numerator);
    }

    /**
     * Calculate the fractional value of the sum of two fractions
     * @param other the other fraction to be added
     * @return the sum of two fractions in fraction form
     */
    @Override
    public String add(FractionImpl other) {
        return String.format("%d / %d",
            this.numerator * other.denominator + this.denominator * other.numerator,
            this.denominator * other.denominator);
    }

    /**
     * Compares this fraction with the other one passed to it.
     * if (this<other) return a negative integer
     * if (this==other) return 0
     * if (this>other) return a positive integer
     * @param other the other fraction to be compared to
     * @return the result of the comparison
     */
    public int compareTo(FractionImpl other) {
        int numThis = this.numerator;
        int denomThis = this.denominator;

        int numOther = other.numerator;
        int denomOther = other.denominator;

        if (numThis * denomOther < numOther * denomThis) {
            return -1;
        } else if (numThis * denomOther > numOther * denomThis) {
            return 1;
        } else {
            return 0;
        }
    }

}
