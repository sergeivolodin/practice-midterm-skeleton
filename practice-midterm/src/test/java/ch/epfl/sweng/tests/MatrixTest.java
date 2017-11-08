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
    public void initializeWithZerosTest() {
        Matrix m = new Matrix(123, 456);
        assertEquals(123, m.getHeight());
        assertEquals(456, m.getWidth());
        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                assertEquals(0.0, m.getElement(i, j), 0.0);
            }
        }
    }

    @Test
    public void initializeWithElements() {
        double[][] val = new double[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };

        Matrix m = new Matrix(val);

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                assertEquals(i + " " + j, val[i][j], m.getElement(i, j), 0.0);
            }
        }
    }

    @Test
    public void size10X2() {
        Matrix m = new Matrix(10, 2);

        assertEquals(10, m.getHeight());
        assertEquals(2, m.getWidth());
    }

    @Test
    public void setUpdate() {
        Matrix m = new Matrix(10, 2);

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                assertEquals(0.0, m.getElement(i, j), 0.0);
            }
        }

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                m.setElement(i, j, (i + 1) * (j + 100));
            }
        }

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                assertEquals((double) ((i + 1) * (j + 100)), m.getElement(i, j), 0.0);
            }
        }

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                m.setElement(i, j, (i + 1) + (j % 2));
            }
        }

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                assertEquals((double) ((i + 1) + (j % 2)), m.getElement(i, j), 0.0);
            }
        }

    }

    @Test
    public void normalizeTest() {
        Matrix m = new Matrix(10, 1);

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                m.setElement(i, j, i + j * 100.);
            }
        }

        m.normalizeColumns();

        for(int j = 0; j < m.getWidth(); j++) {
            Vector column = new Vector(m.getHeight());
            for(int i = 0; i < m.getHeight(); i++) {
                column.setElement(i, m.getElement(i, j));
            }
            assertEquals(1.0, column.norm(), 0.0);
        }

        m = new Matrix(10, 20);

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                m.setElement(i, j, i + j * 100.);
            }
        }

        m.normalizeColumns();

        for(int j = 0; j < m.getWidth(); j++) {
            Vector column = new Vector(m.getHeight());
            for(int i = 0; i < m.getHeight(); i++) {
                column.setElement(i, m.getElement(i, j));
            }
            assertEquals(1.0, column.norm(), 1e-5);
        }

        m = new Matrix(5000, 1000);

        for(int i = 0; i < m.getHeight(); i++) {
            for(int j = 0; j < m.getWidth(); j++) {
                m.setElement(i, j, i + j * 100.);
            }
        }

        m.normalizeColumns();

        for(int j = 0; j < m.getWidth(); j++) {
            Vector column = new Vector(m.getHeight());
            for(int i = 0; i < m.getHeight(); i++) {
                column.setElement(i, m.getElement(i, j));
            }
            assertEquals(1.0, column.norm(), 1e-5);
        }

        m = new Matrix(10, 20);
        m.normalizeColumns();

        for(int j = 0; j < m.getWidth(); j++) {
            for(int i = 0; i < m.getHeight(); i++) {
                assertEquals(0.0, m.getElement(i, j), 0.0);
            }
        }

        m = new Matrix(1, 2);
        m.setElement(0, 0, 1);
        m.normalizeColumns();

        assertEquals(1.0, m.getElement(0, 0), 0);
        assertEquals(0.0, m.getElement(0, 1), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException() {
        Matrix A = new Matrix(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException1() {
        Matrix A = new Matrix(10, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException2() {
        Matrix A = new Matrix(0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException3() {
        Matrix A = new Matrix(10, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException4() {
        Matrix A = new Matrix(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException5() {
        Matrix A = new Matrix(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException6() {
        Matrix A = new Matrix(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMatrixException7() {
        Matrix A = new Matrix(new double[][] {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonRectangular() {
        Matrix A = new Matrix(new double[][] {{1,2,3},{4,5}, {}});
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonRectangular1() {
        Matrix A = new Matrix(new double[][] {{1,2,3},null, {4,5}, {}});
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonRectangular2() {
        Matrix A = new Matrix(new double[][] {null, {1,2,3}, null, {4,5}, {}});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsGet1() {
        Matrix A = new Matrix(2, 10);
        A.getElement(0, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsGet2() {
        Matrix A = new Matrix(2, 10);
        A.getElement(2, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsGet3() {
        Matrix A = new Matrix(2, 10);
        A.getElement(-1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsGet4() {
        Matrix A = new Matrix(2, 10);
        A.getElement(0, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsGet5() {
        Matrix A = new Matrix(2, 10);
        A.getElement(-1, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsSet1() {
        Matrix A = new Matrix(2, 10);
        A.setElement(0, 10, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsSet2() {
        Matrix A = new Matrix(2, 10);
        A.setElement(2, 0, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsSet3() {
        Matrix A = new Matrix(2, 10);
        A.setElement(-1, 0, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsSet4() {
        Matrix A = new Matrix(2, 10);
        A.setElement(0, -1, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBoundsSet5() {
        Matrix A = new Matrix(2, 10);
        A.setElement(-1, -1, 10);
    }

    @Test
    public void multiplyTest() {
        Matrix A = new Matrix(new double[][] {{1,2,3}, {4,5,6},{7,8,9}});
        Vector v = new Vector(3);
        v.setElement(0, 10);
        v.setElement(1, -55);
        v.setElement(2, 21);
        Vector v1 = A.multiply(v);
        assertEquals((double) (10 * 1 - 55 * 2 + 21 * 3), v1.getElement(0), 0.0);
        assertEquals((double) (10 * 4 - 55 * 5 + 21 * 6), v1.getElement(1), 0.0);
        assertEquals((double) (10 * 7 - 55 * 8 + 21 * 9), v1.getElement(2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyTest1() {
        Matrix A = new Matrix(new double[][] {{1,2,3}, {4,5,6},{7,8,9}});
        A.multiply(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyTest2() {
        Matrix A = new Matrix(new double[][] {{1,2,3}, {4,5,6},{7,8,9}});
        A.multiply(new Vector(100));
    }
}
