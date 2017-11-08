package ch.epfl.sweng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * A vector of scalar values
 */
public final class Vector{

	// number of components
	private int _dimension = 0;

	// stored values as an array
	private ArrayList<Double> _values = null;

	// construct and allocate space for each component
	// default value is 0
	public Vector(int dimension) {
		if(dimension < 0) {
			throw new IllegalArgumentException("Dimension must be greater than zero");
		}

		_dimension = dimension;
		_values = new ArrayList<Double>(Collections.nCopies(_dimension, 0.0));
	}

	// get element at index
	public double getElement(int index) {
		return _values.get(index);
	}

	// set element at index to a value
	public void setElement(int index, double value) {
		_values.set(index, value);
	}

	// return the number of components
	public int dimension() {
		return _dimension;
	}

	// return the L2 norm of the vector
	public double norm() {
		Double sum = 0.0;
		for(Double item: _values) {
			sum += item * item;
		}
		return sqrt(sum);
	}

	// set L2 norm to 1
	public void normalize() {
		Double norm = norm();

		// check if the norm is zero or already 1
		if(norm == 0.0 || norm == 1.0) {
			return;
		}

		for(int i = 0; i < dimension(); i++) {
			setElement(i, getElement(i) / norm);
		}
	}
}
