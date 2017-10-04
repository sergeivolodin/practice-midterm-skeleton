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
}
