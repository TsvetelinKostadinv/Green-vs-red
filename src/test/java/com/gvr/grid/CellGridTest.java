/*
 * 26/07/2020 17:48:12
 * CellGridTest.java created by Tsvetelin
 */
package com.gvr.grid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.gvr.cells.Cell;

import static com.gvr.cells.Cell.*;

/**
 * @author Tsvetelin
 *
 */
class CellGridTest {

	static final CellGrid grid = new CellGrid(new Cell[][] {
		{ red(), red(), red() },
		{ green(), green(), green() },
		{ red(), red(), red() },
	});
	
	/**
	 * Test method for {@link com.gvr.grid.CellGrid#at(int, int)}.
	 */
	@Test
	void testAt() {
		assertThrows(IndexOutOfBoundsException.class, () -> grid.at(-1, 1));
		assertThrows(IndexOutOfBoundsException.class, () -> grid.at(1, -1));
		
		assertThrows(IndexOutOfBoundsException.class, () -> grid.at(3, 1));
		assertThrows(IndexOutOfBoundsException.class, () -> grid.at(1, 3));
	}

	/**
	 * Test method for {@link com.gvr.grid.CellGrid#nextGeneration()}.
	 */
	@Test
	void testNextGeneration() {
		// final CellGrid next = grid.nextGeneration();
		// TODO Think this out
	}

}
