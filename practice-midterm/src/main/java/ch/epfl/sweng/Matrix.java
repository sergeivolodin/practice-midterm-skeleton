package ch.epfl.sweng;

import java.util.ArrayList;
import java.util.Collections;

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

	// stored height and width
	private int _height, _width;

	// storing matrix as transpose
	// i.e. matrix is a list of columns, each is a vector
	private ArrayList<Vector> columns;

	// construct empty matrix filled with zeros
	// and allocate space
	public Matrix(int height, int width) {
		init_from_HW(height, width);
	}

	// create zero matrix and allocate space
	private void init_from_HW(int height, int width) {
		if(height <= 0 || width <= 0) {
			throw new IllegalArgumentException("Matrix must be non-empty");
		}
		_height = height;
		_width = width;
		columns = new ArrayList<Vector>(Collections.nCopies(_width, new Vector(_height)));
	}

	// create matrix from an array of elements
	public Matrix(double[][] elements) {
		if(elements == null) {
			throw new IllegalArgumentException("Elements should point to an object");
		}

		if(elements[0] == null) {
			throw new IllegalArgumentException("First row should point to an object");
		}

		init_from_HW(elements.length, elements[0].length);

		for (int i = 0; i < elements.length; i++) {
			if(elements[i] == null) {
				throw new IllegalArgumentException("Row should point to an object");
			}
			if(elements[i].length != elements[0].length) {
				throw new IllegalArgumentException("Number of columns must be the same");
			}

			for(int j = 0; j < elements[i].length; j++) {
				setElement(i, j, elements[i][j]);
			}
		}
	}

	// return height (number of rows)
	public int getHeight() {
		return _height;
	}

	// return width (number of columns)
	public int getWidth() {
		return _width;
	}

	// check if H and W are inside matrix
	private void checkSize(int height, int width) {
		if(height < 0 || height >= _height) {
			throw new IndexOutOfBoundsException("Height must be inside matrix");
		}
		if(width < 0 || width >= _width) {
			throw new IndexOutOfBoundsException("Width must be inside matrix");
		}
	}

	// returns an element at HxW
	public double getElement(int height, int width) {
		checkSize(height, width);

		return columns.get(width).getElement(height);
	}

	// sets element at HxW to the value
	public void setElement(int height, int width, double value) {
		checkSize(height, width);

		columns.get(width).setElement(height, value);
	}

	// set the norm of each column to 1
	// by dividing its elements by the previous value of the norm
	public void normalizeColumns() {
		columns.forEach(Vector::normalize);
	}

	// matrix multiplication
	// (Ax)_i = a_i1 x_1 + ... a_iW * x_w
	public Vector multiply(Vector vector) {
		if(vector == null) {
			throw new IllegalArgumentException("Vector should point to an object");
		}
		if(vector.dimension() != getWidth()) {
			throw new IllegalArgumentException("Vector dimension should equal matrix width");
		}

		// filling the result by the matrix multiplication rule
		Vector result = new Vector(getHeight());
		for(int i = 0; i < getHeight(); i++) {
			Double result_i_th = 0.0;
			for(int j = 0; j < getWidth(); j++) {
				result_i_th += getElement(i, j) * vector.getElement(j);
			}
			result.setElement(i, result_i_th);
		}

		return result;
	}
}
