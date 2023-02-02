/**
 * Import JUnit testing suite
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FractionImplTest {

    // Declare Fraction objects

    public FractionImpl f0;
    private FractionImpl f1;
    private FractionImpl f2;
    private FractionImpl f3;
    private FractionImpl f4;
    private FractionImpl f5;


    /** Create new objects for testing
     * @throws Exception where necessary
     */
    @Before
    public void fractionSetUp() throws Exception {
        f1 = new FractionImpl(1,5);
        f2 = new FractionImpl(0,2);
        f3 = new FractionImpl(2,3);
        f4 = new FractionImpl(1,8);
        f5 = new FractionImpl(2,10);
    }

    /**
     * Create an invalid fraction, which will
     * throw an IllegalArgumentException()
     */
    @Ignore ("createFractionTestFail():"
        + " Denominator must be greater than 0")
    @Test
    public void createFractionTestFail() {
        f0 = new FractionImpl(3,0);
    }

    /**
     * Test if getNumerator() works
     * The fraction should return its current numerator
     */
    @Test
    public void getNumeratorTest() {
        assertEquals(1, f1.getNumerator());
    }

    /**
     * Test if getDenominator() works
     * The fraction should return its current denominator
     * @throws Exception
     */
    @Test
    public void getDenominatorTest() throws Exception {
        assertEquals(5, f1.getDenominator());
    }

    /**
     * Test if setNumerator() works
     * The fraction should have a new numerator that matches
     * the setter parameter
     */
    @Test
    public void setNumeratorTest() {
        f1.setNumerator(100);
        assertEquals(100, f1.getNumerator());
    }

    /**
     * Test if setDenominator() works
     * The fraction should have a new denominator that matches
     * the setter parameter.
     */
    @Test
    public void setDenominatorTest() {
        f1.setDenominator(100);
        assertEquals(100, f1.getDenominator());
    }

    /**
     * Test if setDenominator() throws an exception
     * when an invalid denominator is set.
     */
    @Ignore ("setDenominatorTestFail(): "
        + "Denominator must be greater than 0")
    @Test
    public void setDenominatorTestFail() {
        f1.setDenominator(-2);
        assertEquals(-2, f1.getDenominator());
    }

    /**
     * Test if toString() outputs the correct representation
     * of the fraction.
     */
    @Test
    public void toStringTest() {
        assertEquals("1 / 5", f5.toString());
    }

    /**
     * Test if toDouble() outputs the correct float value
     * of the fraction.
     */
    @Test
    public void toDoubleTest() {
        assertEquals(0.2, f1.toDouble(), 0.000001);
    }

    /**
     * Test if reciprocal() outputs the correct reciprocated
     * representation of the original fraction
     * @throws Exception where necessary
     */
    @Test
    public void reciprocalTest() throws Exception {
        assertEquals("5 / 1", f1.reciprocal());
    }

    /**
     * Test if reciprocal() throws an error when
     * the numerator is 0.
     * @throws Exception
     */
    @Ignore ("reciprocalTestFail(): "
        + "Numerator must not be 0")
    @Test
    public void reciprocalTestFail() throws Exception {
        f2.reciprocal();
    }

    /**
     * Test if add() outputs the correct string representation
     * of the sum of two fractions.
     */
    @Test
    public void addTest() {
        assertEquals("13 / 15", f1.add(f3));
    }

    /**
     * Test if compareTo() returns the 'less than' value of the
     * comparison between two fractions
     */
    @Test
    public void compareToTestLessThan() {
        assertEquals(-1, f1.compareTo(f3));
    }

    /**
     * Test if compareTo() returns the 'equal' value of the
     * comparison between two fractions
     */
    @Test
    public void compareToTestEqual() {
        assertEquals(0, f1.compareTo(f5));
    }

    /**
     * Test if compareTo() returns the 'greater than' value of the
     * comparison between two fractions
     */
    @Test
    public void compareToTestGreater() {
        assertEquals(1, f1.compareTo(f4));
    }
}