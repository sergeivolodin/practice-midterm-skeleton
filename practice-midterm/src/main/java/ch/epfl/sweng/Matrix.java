package ch.epfl.sweng;

/**
 * Represents a Matrix as a collection of Vector instances.
 * <p>
 * The height is the dimension of the vector space, and the width is the number
 * of vectors in the matrix.
 * 
 * <p>
 * e.g. a Matrix of height 4 and width 3 would look like this (example values):
 * <code>
 * 1   2   3
 * 4   5   6
 * 7   8   9
 * 10  11  12
 * </code>
 * 
 */
public final class Matrix {

	public Matrix(int height, int width) {
		// TODO
	}

	public Matrix(double[][] elements) {
		// TODO
	}

	public int getHeight() {
		// TODO
		return 0;
	}

	public int getWidth() {
		// TODO
		return 0;
	}

	public double getElement(int height, int width) {
		// TODO
		return 0;
	}

	public void setElement(int height, int width, double value) {
		// TODO
	}

	public void normalizeColumns() {
		// TODO
	}

	public Vector multiply(Vector vector) {
		// TODO
		return null;
	}
}
