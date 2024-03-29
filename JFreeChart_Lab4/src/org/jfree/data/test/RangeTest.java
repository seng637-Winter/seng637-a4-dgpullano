package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class RangeTest {
	
	// Instantiate the ranges that will be used for testing the "contains" function:
	private Range exampleRange;
	private Range negMaxRange;
	private Range zeroRange;
	
    
    // ---------------------------------------------------------------------------------
    // The following tests are for the "contains" function in the range class: - Dillon
    // ---------------------------------------------------------------------------------
    
    // The six following tests use the Range "negMaxRange" [-Double.MAX_VALUE, 100]:
	
    // Checks that a negative value within the range is contained in the range
    @Test
    public void negMaxRange_NegInside_Contains() {
    	negMaxRange = new Range(-Double.MAX_VALUE, 100);
        assertTrue("The negative value within the range should be contained in the range (TRUE)",
        negMaxRange.contains(-10));
    }
    
    // Checks that a 0 value within the range is contained in the range
    @Test
    public void negMaxRange_0Inside_Contains() {
    	negMaxRange = new Range(-Double.MAX_VALUE, 100);
        assertTrue("The 0 value within the range should be contained in the range (TRUE)",
        negMaxRange.contains(0));
    }
    
    // Checks that a positive value within the range is contained in the range
    @Test
    public void negMaxRange_PosInside_Contains() {
    	negMaxRange = new Range(-Double.MAX_VALUE, 100);
        assertTrue("The positive value within the range should be contained in the range (TRUE)",
        negMaxRange.contains(10));
    }
    
    // Checks that a value at the upper regular bound is contained in the range
    @Test
    public void negMaxRange_UpperBound_Contains() {
    	negMaxRange = new Range(-Double.MAX_VALUE, 100);
        assertTrue("The value on the upper bound should be contained in the range (TRUE)",
        negMaxRange.contains(100));
    }
    
    // Checks that a value outside the upper regular bound is NOT contained in the range
    @Test
    public void negMaxRange_UpperOutside_Contains() {
    	negMaxRange = new Range(-Double.MAX_VALUE, 100);
        assertTrue("The value outside of the upper bound should NOT be contained in the range (FALSE)",
        !negMaxRange.contains(110));
    }
    
    // Checks that a MAX value outside the upper bound is NOT contained in the range
    @Test
    public void negMaxRange_UpperMaxOutside_Contains() {
    	negMaxRange = new Range(-Double.MAX_VALUE, 100);
        assertTrue("The MAX value outside of the upper bound should NOT be contained in the range (FALSE)",
        !negMaxRange.contains(Double.MAX_VALUE));
    }
    
    // The following three tests use the Range "zeroRange" [0, 0]:
    
    // Checks that a negative value outside the lower and upper bound is NOT contained in the range
    @Test
    public void zeroRange_NegOutside_Contains() {
    	zeroRange = new Range(0, 0);
        assertTrue("The value outside of the lower bound should NOT be contained in the range (FALSE)",
        !zeroRange.contains(-10));
    }
    
    // Checks that a 0 value on the lower and upper bound is contained in the range
    @Test
    public void zeroRange_0Inside_Contains() {
    	zeroRange = new Range(0, 0);
        assertTrue("The value on the lower and upper bound should be contained in the range (TRUE)",
        zeroRange.contains(0));
    }
    
    // Checks that a positive value outside the lower and upper bound is NOT contained in the range
    @Test
    public void zeroRange_PosOutside_Contains() {
    	zeroRange = new Range(0, 0);
        assertTrue("The value outside of the upper bound should NOT be contained in the range (FALSE)",
        !zeroRange.contains(10));
    }
    
    
    // ---------------------------------------------------------------------------------
    // The following tests are for the "getLength" function in the range class: - Yaad
    // ---------------------------------------------------------------------------------
    
    @Test
    public void getLengthWithBothBoundsPositiveDouble() { // This test checks a range where both boundaries are positive, which is a standard condition for this method
    	// Define the range:
    	final Double min = 5.0;
    	final Double max = 10.0;
    	final Range positiveRange = new Range(min, max);
    	
    	// Calculate result and evaluate the test:
    	final Double result = positiveRange.getLength();
        final Double expectedResult = 5.0;
        assertEquals("Testing the length of a range with both bounds positive (Double)", expectedResult, result);
    }

    @Test
    public void getLengthWithBothBoundsNegativeDouble() { // This test ensures correct handling of ranges with negative boundaries, covering another standard equivalence class.
    	// Define the range:
    	final Double min = -10.0;
    	final Double max = -5.0;
    	final Range negativeRange = new Range(min, max);
    	
    	// Calculate result and evaluate the test:
        final Double result = negativeRange.getLength();
        final Double expectedResult = 5.0;
        assertEquals("Testing the length of a range with both bounds negative (Double)", expectedResult, result);
    }

    @Test
    public void getLengthWithNegativeAndPositiveBoundsDouble() { // Testing boundary transition from negative to positive to ensure the range correctly spans across zero
        // Define the range:
    	final Double min = -5.0;
    	final Double max = 5.0;
    	final Range mixedRange = new Range(min, max);

    	// Calculate result and evaluate the test:
        final Double result = mixedRange.getLength();
        final Double expectedResult = 10.0;
        assertEquals("Testing the length of a range with negative and positive bounds (Double)", expectedResult, result);
    }

    @Test
    public void getLengthWithZeroAndPositiveBoundDouble() { // Testing a range starting at zero to positive, examining the lower boundary condition
    	// Define the range:
    	final Double min = 0.0;
    	final Double max = 10.0;
    	final Range zeroPositiveRange = new Range(min, max);
    	
    	// Calculate result and evaluate the test:
        final Double result = zeroPositiveRange.getLength();
        final Double expectedResult = 10.0;
        assertEquals("Testing the length of a range with 0 and a positive bound (Double)", expectedResult, result);
    }

    @Test
    public void getLengthWithNegativeAndZeroBoundDouble() { // Examining the upper boundary condition with a range that includes zero from a negative start
    	// Define the range:
    	final Double min = -10.0;
    	final Double max = 0.0;
    	final Range negativeZeroRange = new Range(min, max);
    	
    	// Calculate result and evaluate the test:
        final Double result = negativeZeroRange.getLength();
        final Double expectedResult = 10.0;
        assertEquals("Testing the length of a range with a negative and 0 bound (Double)", expectedResult, result);
    }

    @Test
    public void getLengthWithBothBoundsPositiveInt() { // SAME AS PREVIOUSLY TESTED, BUT WITH INT
    	// Define the range:
    	final Integer min = 5;
    	final Integer max = 10;
    	final Range positiveRange = new Range(min, max); 
    	
    	// Calculate result and evaluate the test:
        final Integer result = (int) positiveRange.getLength();
        final Integer expectedResult = 5;
        assertEquals("Testing the length of a range with both bounds positive (Int)", expectedResult, result);
    }

    @Test
    public void getLengthWithBothBoundsNegativeInt() { // SAME AS PREVIOUSLY TESTED, BUT WITH INT
    	// Define the range:
    	final Integer min = -10;
    	final Integer max = -5;
    	final Range negativeRange = new Range(min, max); 
    	
    	// Calculate result and evaluate the test:
        final Integer result = (int) negativeRange.getLength();
        final Integer expectedResult = 5;
        assertEquals("Testing the length of a range with both bounds negative (Int)", expectedResult, result);
    }

    @Test
    public void getLengthWithNegativeAndPositiveBoundsInt() { // SAME AS PREVIOUSLY TESTED, BUT WITH INT
    	// Define the range:
    	final Integer min = -5;
    	final Integer max = 5;
    	final Range mixedRange = new Range(min, max); 
    	
    	// Calculate result and evaluate the test:
        final Integer result = (int) mixedRange.getLength();
        final Integer expectedResult = 10;
        assertEquals("Testing the length of a range with negative and positive bounds (Int)", expectedResult, result);
    }

    @Test
    public void getLengthWithZeroAndPositiveBoundInt() { // SAME AS PREVIOUSLY TESTED, BUT WITH INT
    	// Define the range:
    	final Integer min = 0;
    	final Integer max = 10;
    	final Range zeroPositiveRange = new Range(min, max); 
    	
    	// Calculate result and evaluate the test:
        final Integer result = (int) zeroPositiveRange.getLength();
        final Integer expectedResult = 10;
        assertEquals("Testing the length of a range with 0 and a positive bound (Int)", expectedResult, result);
    }

    @Test
    public void getLengthWithNegativeAndZeroBoundInt() { // SAME AS PREVIOUSLY TESTED, BUT WITH INT
    	// Define the range:
    	final Integer min = -10;
    	final Integer max = 0;
    	final Range negativeZeroRange = new Range(min, max);
    	
    	// Calculate result and evaluate the test:
        final Integer result = (int) negativeZeroRange.getLength();
        final Integer expectedResult = 10;
        assertEquals("Testing the length of a range with a negative and 0 bound (Int)", expectedResult, result);
    }

    
    // ---------------------------------------------------------------------------------
    // The following tests are for the "intersects" function in the range class: - Gi-E
    // ---------------------------------------------------------------------------------
    
    @Test
    public void testIntersects() {
    	exampleRange = new Range(-1, 1);
        double[][] testCases = {
                {-2.0, 1.0, 0.5, -1.0, 0.0, -2.0, 1.0, -1.0, 0.5, -2.0, -1.6},
                {-1.0, 1.1, 0.6, 0.0, 1.0, -3.0, 2.0, -0.5, 1.0, 2.0, -1.0}
        };

        boolean[] expectedResults = {false, false, true, true, true, false, false, true, true, true, false};

        for (int i = 0; i < testCases[0].length; i++) {
            assertEquals(expectedResults[i], exampleRange.intersects(testCases[0][i], testCases[1][i]));
        }
    }
    
    
    // --------------------------------------------------------------------------------------
    // The following tests are for the "getLowerBound" function in the range class: - Andrew
    // --------------------------------------------------------------------------------------
    
	// Assuming this is part of the Range class mentioned in the tests
	@Test
    public void testPositiveLowerBound() {
		// Define the range:
    	final Double min = 5.0;
    	final Double max = 10.0;
        final Range range = new Range(min, max);
        
        // Calculate result and evaluate the test:
        final Double result = range.getLowerBound();
        final Double expectedResult = 5.0;
        assertEquals("The lower bound should be positive", expectedResult, result);
    }

    @Test
    public void testZeroLowerBound() {
    	// Define the range:
    	final Double min = 0.0;
    	final Double max = 10.0;
    	final Range range = new Range(min, max);
    	
    	// Calculate result and evaluate the test:
        final Double result = range.getLowerBound();
        final Double expectedResult = 0.0;
        assertEquals("The lower bound should be zero", expectedResult, result);
    }

    @Test
    public void testNegativeLowerBound() {
    	// Define the range:
    	final Double min = -10.0;
    	final Double max = 5.0;
    	final Range range = new Range(min, max);
    	
    	// Calculate result and evaluate the test:
        final Double result = range.getLowerBound();
        final Double expectedResult = -10.0;
        assertEquals("The lower bound should be negative", expectedResult, result);
    }
}