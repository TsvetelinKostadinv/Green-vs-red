/*
 * 26/07/2020 16:18:41
 * CellParserTest.java created by Tsvetelin
 */
package com.gvr.cells;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * @author Tsvetelin
 *
 */
class CellParserTest {

	Map< Character, Optional<Cell> > functionalResults = Map.of(
			'0', Optional.of(Cell.red()),
			'1', Optional.of(Cell.green()), 
			'3', Optional.empty(),
			'a', Optional.empty(),
			' ', Optional.empty());

	/**
	 * Test method for {@link com.gvr.cells.CellParser#parse(char)}.
	 */
	@Test
	void testParse() {
		assertEquals( CellParser.parse('0'), Cell.red() );
		assertEquals( CellParser.parse('1'), Cell.green() );
		
		assertThrows(IllegalArgumentException.class, () -> CellParser.parse('3'));
		assertThrows(IllegalArgumentException.class, () -> CellParser.parse('a'));
		assertThrows(IllegalArgumentException.class, () -> CellParser.parse(' '));
	}

	/**
	 * Test method for {@link com.gvr.cells.CellParser#parseFunctionalStyle(char)}.
	 */
	@Test
	void testParseFunctionalStyle() {
		functionalResults.entrySet().stream()
				.forEach( entry ->
					assertEquals( CellParser.parseFunctionalStyle( entry.getKey() ), entry.getValue())
				 );
	}

}
