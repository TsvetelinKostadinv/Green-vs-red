/*
 * 26/07/2020 16:40:03
 * CellNextGenerationTest.java created by Tsvetelin
 */
package com.gvr.cells;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author Tsvetelin
 *
 */
class CellTest {

	private static final Cell red = Cell.red();
	private static final Cell green = Cell.green();

	/**
	 * Test method for {@link com.gvr.cells.Cell#nextState(com.gvr.cells.Cell[])}.
	 */
	@Test
	void testNextState() {
		for (int i = 0; i < 9; i++) {
			List<Cell> neighbors = new LinkedList<>();
			for (int j = 0; j < i; j++)
				neighbors.add(Cell.green());

			Cell redRes = red.nextState(neighbors.toArray(new Cell[neighbors.size()]));
			Cell greenRes = green.nextState(neighbors.toArray(new Cell[neighbors.size()]));

			switch (i) {
			case 0:
			case 1:
			case 4:
			case 5:
			case 7:
			case 8:
				assertEquals(redRes, red);
				assertEquals(greenRes, red);
				break;
			case 2:
				assertEquals(redRes, red);
				assertEquals(greenRes, green);
				break;
			case 3:
			case 6:
				assertEquals(redRes, green);
				assertEquals(greenRes, green);
				break;
			}

		}
	}

	/**
	 * Test method for {@link com.gvr.cells.Cell#isGreen()}.
	 */
	@Test
	void testIsGreen() {
		assertEquals(red.isGreen(), false);
		assertEquals(green.isGreen(), true);
	}

	/**
	 * Test method for {@link com.gvr.cells.Cell#isRed()}.
	 */
	@Test
	void testIsRed() {
		assertEquals(red.isRed(), true);
		assertEquals(green.isRed(), false);
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		assertEquals(red, Cell.red());
		assertEquals(green, Cell.green());
		assertNotEquals(red, green);
	}

}
