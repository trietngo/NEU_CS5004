/**
 * This interface contains all operations that all types of fractions
 * should support.
 */
public interface Fraction extends Comparable<FractionImpl>{

    /**
     * Returns the scientific value (decimal) of the fraction.
     * @return the decimal value of the fraction.
     */
    double toDouble();

    /**
     * Returns the reciprocal of this fraction
     * @return the reciprocal of this fraction
     */
    String reciprocal();

    /**
     * Computes and returns the sum of this faction and
     * the other one added.
     * @param other the other fraction to be added
     * @return the sum of two fractions
     */
    String add(FractionImpl other);
}

