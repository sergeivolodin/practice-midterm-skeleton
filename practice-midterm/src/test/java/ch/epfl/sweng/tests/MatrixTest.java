package ch.epfl.sweng.tests;

import ch.epfl.sweng.Matrix;
import ch.epfl.sweng.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link Matrix}.
 */
public final class MatrixTest {

    @Test
    public void initializeZerosTest() {
        Matrix m = new Matrix(123, 456);
        assertEquals(123, m.getHeight());
        assertEquals(456, m.getWidth());
        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                assertEquals(0.0, m.getElement(i, j), 0.0);
            }
        }
    }
}
