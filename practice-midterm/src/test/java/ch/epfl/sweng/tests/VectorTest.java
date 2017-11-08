package ch.epfl.sweng.tests;

import ch.epfl.sweng.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link Vector}.
 */
public final class VectorTest {

	@Test
	public void dimensionTest() {
		Vector v = new Vector(10);
		assertEquals(10, v.dimension());
	}

	@Test
	public void zeroInitTest() {
		Vector v = new Vector(10);
		for(int i = 0; i < v.dimension(); i++) {
			assertEquals(0.0, v.getElement(i), 0.0);
		}
	}

	@Test
	public void updateTest() {
		Vector v = new Vector(10);
		for(int i = 0; i < v.dimension(); i++) {
			v.setElement(i, i);
		}
		for(int i = 0; i < v.dimension(); i++) {
			assertEquals(Double.valueOf(i), v.getElement(i), 0.0);
		}
		for(int i = 0; i < v.dimension(); i++) {
			v.setElement(i, i + 100);
		}
		for(int i = 0; i < v.dimension(); i++) {
			assertEquals(Double.valueOf(i + 100), v.getElement(i), 0.0);
		}
	}

	@Test
	public void normTest() {
		// empty vector norm is 0
		Vector v = new Vector(0);
		assertEquals(0.0, v.norm(), 0.0);

		// norm of [1] * 100 is 10
		v = new Vector(100);
		for(int i = 0; i < v.dimension(); i++) {
			v.setElement(i, 1);
		}
		assertEquals(10.0, v.norm(), 0.0);
	}

	@Test
	public void dimensionTestZero() {
		Vector v = new Vector(0);
		assertEquals(0, v.dimension());
	}

	@Test
	public void dimensionTestLessZero() {
		try {
			Vector v = new Vector(-1);
			assertEquals(0, 1);
		}
		catch(IllegalArgumentException e) {
			assertEquals(0, 0);
		}
	}

	@Test
	public void setOutside() {
		try {
			Vector v = new Vector(10);
			v.setElement(10, 0);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}

		try {
			Vector v = new Vector(10);
			v.setElement(-1, 0);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}

		try {
			Vector v = new Vector(10);
			v.setElement(11, 0);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}

		try {
			Vector v = new Vector(0);
			v.setElement(0, 0);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}
	}

	@Test
	public void getOutside() {
		try {
			Vector v = new Vector(10);
			v.getElement(10);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}

		try {
			Vector v = new Vector(10);
			v.getElement(-1);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}

		try {
			Vector v = new Vector(10);
			v.getElement(11);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}

		try {
			Vector v = new Vector(0);
			v.getElement(0);
			assertEquals(0, 1);
		}
		catch(IndexOutOfBoundsException e) {
			assertEquals(0, 0);
		}
	}

	@Test
	public void stressTest() {
		final int N = 100000000;
		Vector v = new Vector(N);
		for(int i = 0; i < v.dimension(); i++) {
			assertEquals(0.0, v.getElement(i), 0.0);
		}
	}
}
