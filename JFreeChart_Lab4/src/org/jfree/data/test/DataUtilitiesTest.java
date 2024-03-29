package org.jfree.data.test;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.Expectations;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	private Mockery mockingContext;
    private Values2D values;

	
	// ----------------------------------------------------------------------------------------------------
    // The following tests are for the "calculateColumnTotal" function in the DataUtilities class: - Gi-E
    // ----------------------------------------------------------------------------------------------------
	
    @Test
    public void testCalculateColumnTotalWithPositiveValues() {
        // Create sample data
    	final Double val1 = 7.5;
    	final Double val2 = 2.5;
        double[][] data = {
            {val1},
            {val2}
        };
        
        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
            	final Integer use_row = Integer.valueOf(row);
            	final Integer use_col = Integer.valueOf(col);
            	final Double dataToBeAdded = Double.valueOf(data[use_row][use_col]);
                values.addValue(dataToBeAdded, use_row, use_col);
            }
        }

        // Calculate column total for the first column (index 0)
        final Double result = DataUtilities.calculateColumnTotal(values, 0);
        final Double expectedResult = 10.0;
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testCalculateColumnTotalWithPositiveAndNegativeValues() {
        // Create sample data
    	final Double val1 = 7.5;
    	final Double val2 = -2.5;
        double[][] data = {
            {val1},
            {val2}
        };
        
        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
            	final Integer use_row = Integer.valueOf(row);
            	final Integer use_col = Integer.valueOf(col);
            	final Double dataToBeAdded = Double.valueOf(data[use_row][use_col]);
                values.addValue(dataToBeAdded, use_row, use_col);
            }
        }

        // Calculate column total for the first column (index 0)
        final Double result = DataUtilities.calculateColumnTotal(values, 0);
        final Double expectedResult = 5.0;
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testCalculateColumnTotalWithZeroAndNegativeValues() {
        // Create sample data
    	final Double val1 = 0.0;
    	final Double val2 = -2.5;
        double[][] data = {
            {val1},
            {val2}
        };
        
        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
            	final Integer use_row = Integer.valueOf(row);
            	final Integer use_col = Integer.valueOf(col);
            	final Double dataToBeAdded = Double.valueOf(data[use_row][use_col]);
                values.addValue(dataToBeAdded, use_row, use_col);
            }
        }

        // Calculate column total for the first column (index 0)
        final Double result = DataUtilities.calculateColumnTotal(values, 0);
        final Double expected_result = -2.5;
        assertEquals(expected_result, result);
    }
    
    @Test
    public void testCalculateColumnTotalWithZeroAndPositiveValues() {
        // Create sample data
    	final Double val1 = 0.0;
    	final Double val2 = 2.5;
        double[][] data = {
            {val1},
            {val2}
        };
        
        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
            	final Integer use_row = Integer.valueOf(row);
            	final Integer use_col = Integer.valueOf(col);
            	final Double dataToBeAdded = Double.valueOf(data[use_row][use_col]);
                values.addValue(dataToBeAdded, use_row, use_col);
            }
        }

        // Calculate column total for the first column (index 0)
        final Double result = DataUtilities.calculateColumnTotal(values, 0);
        final Double expected_result = 2.5;
        assertEquals(expected_result, result);
    }

    @Test
    public void testCalculateColumnTotalWithNegativeValues() {
        // Create sample data
    	final Double val1 = -7.5;
    	final Double val2 = -2.5;
        double[][] data = {
            {val1},
            {val2}
        };
        
        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
            	final Integer use_row = Integer.valueOf(row);
            	final Integer use_col = Integer.valueOf(col);
            	final Double dataToBeAdded = Double.valueOf(data[use_row][use_col]);
                values.addValue(dataToBeAdded, use_row, use_col);
            }
        }

        // Calculate column total for the first column (index 0)
        final Double result = DataUtilities.calculateColumnTotal(values, 0);
        final Double expected_result = -10.0;
        assertEquals(expected_result, result);
    }

    @Test
    public void testCalculateColumnTotalWithZeroValues() {
        // Create sample data
    	final Double val1 = 0.0;
    	final Double val2 = 0.0;
        double[][] data = {
            {val1},
            {val2}
        };
        
        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
            	final Integer currRow = Integer.valueOf(row);
            	final Integer currCol = Integer.valueOf(col);
            	final Double dataToAdd = Double.valueOf(data[currRow][currCol]);
                values.addValue(dataToAdd, currRow, currCol);
            }
        }

        // Calculate column total for the first column (index 0)
        final Double result = DataUtilities.calculateColumnTotal(values, 0);
        final Double expectedResult = 0.0;

        assertEquals(expectedResult, result);
    }

	
	// ----------------------------------------------------------------------------------------------------
    // The following tests are for the "calculateRowTotal" function in the DataUtilities class: - Yaad
    // ----------------------------------------------------------------------------------------------------
	
    @Test
    public void calculateRowTotalTwoColumnsPositive() {
        // Create sample data
    	final Double val1 = Double.valueOf(8.5);
    	final Double val2 = Double.valueOf(1.5);
    	final Double val3 = Double.valueOf(0.0);	
    	final Double val4 = Double.valueOf(7.5);
    	final Double val5 = Double.valueOf(4.0);
    	final Double val6 = Double.valueOf(3.0);
    	
        double[][] data = {
            {val1, val2},
            {val3, val4},
            {val5, val6}
        };

        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                values.addValue(data[row][col], row, col);
            }
        }

        // Calculate row total for the first row
        final Double result = DataUtilities.calculateRowTotal(values, 0);
        final Double result2 = DataUtilities.calculateRowTotal(values, 1);
        final Double result3 = DataUtilities.calculateRowTotal(values, 2);
        final Double expectedResult = 10.0;
        final Double expectedResult2 = 7.5;
        final Double expectedResult3 = 7.0;
        assertEquals("The row total for the first row should be 10.0", expectedResult, result);
        assertEquals("The row total for the second row should be 0.0", expectedResult2, result2);
        assertEquals("The row total for the third row should be 0.0", expectedResult3, result3);
    }
    
    @Test
    public void calculateRowTotalTwoColumnsNegative() {
        // Create sample data
    	final Double val1 = Double.valueOf(-8.5);
    	final Double val2 = Double.valueOf(-1.5);
    	final Double val3 = Double.valueOf(-0.0);	
    	final Double val4 = Double.valueOf(-7.5);
    	final Double val5 = Double.valueOf(-4.0);
    	final Double val6 = Double.valueOf(-3.0);
    	
        double[][] data = {
            {val1, val2},
            {val3, val4},
            {val5, val6}
        };

        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                values.addValue(data[row][col], row, col);
            }
        }

        // Calculate row total for the first row
        final Double result = DataUtilities.calculateRowTotal(values, 0);
        final Double result2 = DataUtilities.calculateRowTotal(values, 1);
        final Double result3 = DataUtilities.calculateRowTotal(values, 2);
        final Double expectedResult = -10.0;
        final Double expectedResult2 = -7.5;
        final Double expectedResult3 = -7.0;
        assertEquals("The row total for the first row should be 10.0", expectedResult, result);
        assertEquals("The row total for the second row should be 0.0", expectedResult2, result2);
        assertEquals("The row total for the third row should be 0.0", expectedResult3, result3);	
    }

    @Test
    public void calculateRowTotalThreeColumnsPositive() {
        // Create sample data
    	final Double val1 = 0.0;
    	final Double val2 = 8.5;
    	final Double val3 = 1.5;
    	final Double val4 = 3.0;
    	final Double val5 = 7.5;
    	final Double val6 = 4.5;
    	final Double val7 = 5.0;
    	final Double val8 = 8.0;
    	final Double val9 = 0.5;
        double[][] data = {
            {val1, val2, val3},
            {val4, val5, val6},
            {val7, val8, val9}
        };

        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                values.addValue(data[row][col], row, col);
            }
        }

        // Calculate row total for the middle row
        final Double result = DataUtilities.calculateRowTotal(values, 0);
        final Double result2 = DataUtilities.calculateRowTotal(values, 1);
        final Double result3 = DataUtilities.calculateRowTotal(values, 2);
        final Double expectedResult = 10.0;
        final Double expectedResult2 = 15.0;
        final Double expectedResult3 = 13.5;
        assertEquals("The row total for the first row should be 10.0", expectedResult, result);
        assertEquals("The row total for the second row should be 10.0", expectedResult2, result2);
        assertEquals("The row total for the third row should be 10.0", expectedResult3, result3);
    }

    @Test
    public void calculateRowTotalThreeColumnsNegative() {
        // Create sample data
    	final Double val1 = -0.0;
    	final Double val2 = -8.5;
    	final Double val3 = -1.5;
    	final Double val4 = -3.0;
    	final Double val5 = -7.5;
    	final Double val6 = -4.5;
    	final Double val7 = -5.0;
    	final Double val8 = -8.0;
    	final Double val9 = -0.5;
        double[][] data = {
            {val1, val2, val3},
            {val4, val5, val6},
            {val7, val8, val9}
        };

        // Convert data to Values2D object
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                values.addValue(data[row][col], row, col);
            }
        }

        // Calculate row total for the middle row
        final Double result = DataUtilities.calculateRowTotal(values, 0);
        final Double result2 = DataUtilities.calculateRowTotal(values, 1);
        final Double result3 = DataUtilities.calculateRowTotal(values, 2);
        final Double expectedResult = -10.0;
        final Double expectedResult2 = -15.0;
        final Double expectedResult3 = -13.5;
        assertEquals("The row total for the first row should be 10.0", expectedResult, result);
        assertEquals("The row total for the second row should be 10.0", expectedResult2, result2);
        assertEquals("The row total for the third row should be 10.0", expectedResult3, result3);
    }

	
	// ----------------------------------------------------------------------------------------------------
    // The following tests are for the "createNumberArray" function in the DataUtilities class: - Jonathan
    // ----------------------------------------------------------------------------------------------------
	
    @Test
    public void createNumArray_EmptyArray() {

        // setup input double array:
        double[] data = {};

        // Run the test function:
        Number[] test = DataUtilities.createNumberArray(data);

        // Verify results:
        assertNotNull(test);
        assertEquals(0, test.length);
    }

    // Test to confirm that it can correctly copy over the elements from a double array:    
    @Test
    public void createNumArray_ArrayPositiveElementCheck() {

        // setup input double array:
    	final Double val1 = 5.0;
    	final Double val2 = 10.0;
    	final Double val3 = 15.0;
    	final Double val4 = 20.0;
    	final Double val5 = 25.0;
    	final Double val6 = 30.0;
        double[] data = {val1, val2, val3, val4, val5, val6};

        // Run the test function:
        Number[] test = DataUtilities.createNumberArray(data);

        // Verify results:
        final Number result1 = test[0];
        final Number result2 = test[1];
        final Number result3 = test[2];
        final Number result4 = test[3];
        final Number result5 = test[4];
        final Number result6 = test[5];
        final Number expectedResult1 = 5.0;
        final Number expectedResult2 = 10.0;
        final Number expectedResult3 = 15.0;
        final Number expectedResult4 = 20.0;
        final Number expectedResult5 = 25.0;
        final Number expectedResult6 = 30.0;
        assertEquals("Mismatch of data at index 0", expectedResult1, result1);
        assertEquals("Mismatch of data at index 1", expectedResult2, result2);
        assertEquals("Mismatch of data at index 2", expectedResult3, result3);
        assertEquals("Mismatch of data at index 3", expectedResult4, result4);
        assertEquals("Mismatch of data at index 4", expectedResult5, result5);
        assertEquals("Mismatch of data at index 5", expectedResult6, result6);
    }
    
    @Test
    public void createNumArray_ArrayPositiveAndNegativeElementCheck() {

        // setup input double array:
    	final Double val1 = 5.0;
    	final Double val2 = 10.0;
    	final Double val3 = 15.0;
    	final Double val4 = -20.0;
    	final Double val5 = -25.0;
    	final Double val6 = -30.0;
        double[] data = {val1, val2, val3, val4, val5, val6};

        // Run the test function:
        Number[] test = DataUtilities.createNumberArray(data);

        // Verify results:
        final Number result1 = test[0];
        final Number result2 = test[1];
        final Number result3 = test[2];
        final Number result4 = test[3];
        final Number result5 = test[4];
        final Number result6 = test[5];
        final Number expectedResult1 = 5.0;
        final Number expectedResult2 = 10.0;
        final Number expectedResult3 = 15.0;
        final Number expectedResult4 = -20.0;
        final Number expectedResult5 = -25.0;
        final Number expectedResult6 = -30.0;
        assertEquals("Mismatch of data at index 0", expectedResult1, result1);
        assertEquals("Mismatch of data at index 1", expectedResult2, result2);
        assertEquals("Mismatch of data at index 2", expectedResult3, result3);
        assertEquals("Mismatch of data at index 3", expectedResult4, result4);
        assertEquals("Mismatch of data at index 4", expectedResult5, result5);
        assertEquals("Mismatch of data at index 5", expectedResult6, result6);
    }
    
    @Test
    public void createNumArray_ArrayNegativeElementCheck() {

        // setup input double array:
    	final Double val1 = -5.0;
    	final Double val2 = -10.0;
    	final Double val3 = -15.0;
    	final Double val4 = -20.0;
    	final Double val5 = -25.0;
    	final Double val6 = -30.0;
        double[] data = {val1, val2, val3, val4, val5, val6};

        // Run the test function:
        Number[] test = DataUtilities.createNumberArray(data);

        // Verify results:
        final Number result1 = test[0];
        final Number result2 = test[1];
        final Number result3 = test[2];
        final Number result4 = test[3];
        final Number result5 = test[4];
        final Number result6 = test[5];
        final Number expectedResult1 = -5.0;
        final Number expectedResult2 = -10.0;
        final Number expectedResult3 = -15.0;
        final Number expectedResult4 = -20.0;
        final Number expectedResult5 = -25.0;
        final Number expectedResult6 = -30.0;
        assertEquals("Mismatch of data at index 0", expectedResult1, result1);
        assertEquals("Mismatch of data at index 1", expectedResult2, result2);
        assertEquals("Mismatch of data at index 2", expectedResult3, result3);
        assertEquals("Mismatch of data at index 3", expectedResult4, result4);
        assertEquals("Mismatch of data at index 4", expectedResult5, result5);
        assertEquals("Mismatch of data at index 5", expectedResult6, result6);
    }

    // Test to confirm that it can copy over a very large double array:
    @Test
    public void createNumArray_IntegerArray() {

        // setup input double array:
        double[] data = new double[10000];

        // Run the test function:
        Number[] test = DataUtilities.createNumberArray(data);

        // Verify results:
        assertEquals("The function was not able to copy over all elements", 10000,test.length);
    }
	
    
	// ----------------------------------------------------------------------------------------------------
    // The following tests are for the "createNumberArray2D" function in the DataUtilities class: - Dillon
    // ----------------------------------------------------------------------------------------------------
	
	// Test to confirm that it can copy over an empty 2D double array:
	@Test
    public void create2DNumArray_EmptyArray() {
		
        // setup input double 2D array:
        double[][] data = {};

        // Run the test function:
        Number[][] test = createNumberArray2D(data);

        // Verify results:
        assertNotNull(test);
    }
	
	// Test to confirm that it can correctly copy over the first column values from a 2D double array:
	@Test
    public void create2DNumArray_ArrayElementFirstColumnCheck() {
		
        // setup input double 2D array:
		final Double val1 = Double.valueOf(5.0);
    	final Double val2 = Double.valueOf(10.0);
    	final Double val3 = Double.valueOf(15.0);
    	final Double val4 = Double.valueOf(20.0);
        double[][] data = {
        		{val1, val2}, 
        		{val3, val4}
        };

        // Run the test function:
        Number[][] test = createNumberArray2D(data);

        // Verify results:
        final Number result1 = test[0][0];
        final Number result2 = test[1][0];
        final Number expectedResult1 = 5.0;
        final Number expectedResult2 = 15.0;
        assertEquals("Mismatch of data at row 1, column 1", expectedResult1, result1);
        assertEquals("Mismatch of data at row 2, column 1", expectedResult2, result2);

    }
	
	// Test to confirm that it can correctly copy over the second column values from a 2D double array:
	@Test
    public void create2DNumArray_ArrayElementSecondColumnCheck() {
		
        // setup input double 2D array:
		final Double val1 = Double.valueOf(5.0);
    	final Double val2 = Double.valueOf(10.0);
    	final Double val3 = Double.valueOf(15.0);
    	final Double val4 = Double.valueOf(20.0);
        double[][] data = {
        		{val1, val2}, 
        		{val3, val4}
        };

        // Run the test function:
        Number[][] test = createNumberArray2D(data);

        // Verify results:
        final Number result1 = test[0][1];
        final Number result2 = test[1][1];
        final Number expectedResult1 = 10.0;
        final Number expectedResult2 = 20.0;
        assertEquals("Mismatch of data at row 1, column 1", expectedResult1, result1);
        assertEquals("Mismatch of data at row 2, column 1", expectedResult2, result2);
    }
	
	
	// ---------------------------------------------------------------------------------------------------------
    // The following tests are for the "getCumulativePercentages" function in the DataUtilities class: - Andrew
    // ---------------------------------------------------------------------------------------------------------
	
	public static class DataAnalysis {

	    /**
	     * Calculates and returns the cumulative percentages of an array of numbers.
	     * @param data An array of doubles representing the dataset.
	     * @return An array of doubles representing the cumulative percentages.
	     */
	    public static double[] getCumulativePercentages(double[] data) {
	        double total = Arrays.stream(data).sum();
	        double[] cumulativePercentages = new double[data.length];
	        double sum = 0;
	        
	        for (int i = 0; i < data.length; i++) {
	            sum = sum + data[i];
	            cumulativePercentages[i] = (sum / total) * 100;
	        }
	        
	        return cumulativePercentages;
	    }
	}

    @Test
    public void cumulativePercentages_ZeroValues() {
        final double[] dataset = {0, 20, 30, 0};
        final double[] cumulativePercentages = DataAnalysis.getCumulativePercentages(dataset);
        final double[] expected = {0.0, 40.0, 100.0, 100.0};
        final Double tolerance = 0.01;
        assertArrayEquals("Cumulative percentages including zero values", expected, cumulativePercentages, tolerance);
    }

    @Test
    public void cumulativePercentages_VeryLargeDataset() {
    	final Integer size = 10000;
        double[] dataset = new double[size];
        Arrays.fill(dataset, 1.0); // A large dataset with uniform values for simplicity.
        double[] cumulativePercentages = DataAnalysis.getCumulativePercentages(dataset);
        // Validate the last value to ensure it's correctly calculated as 100%
        assertEquals("Cumulative percentage of the last element in a very large dataset should be 100%", 100.0, cumulativePercentages[cumulativePercentages.length-1],0.01);
    }
}