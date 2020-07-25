/*
 * 25/07/2020 11:54:16
 * GridParser.java created by Tsvetelin
 */
package com.gvr.grid;


import java.util.Arrays;
import java.util.stream.Collectors;

import com.gvr.cells.Cell;
import com.gvr.cells.CellParser;


/**
 * @author Tsvetelin
 *
 */
public interface GridParser
{
    
    public static CellGrid parse (
        final int expectedWidth ,
        final int expectedHeight ,
        final String [] rows
    )
        throws IllegalArgumentException
    {
        validateInput( expectedWidth , expectedHeight , rows );
        
        Cell [] [] grid = new Cell[expectedWidth][expectedHeight];
        
        for ( int y = 0 ; y < expectedHeight ; y++ )
        {
            final Character [] codes =
                Arrays.stream( rows[y].split( "" ) ).map( str -> str.charAt( 0 ) ).collect( Collectors.toList() ).toArray( new Character[expectedWidth] );
            for ( int x = 0 ; x < expectedWidth ; x++ )
                grid[x][y] = CellParser.parse( codes[x] );
        }
        
        return new CellGrid( grid );
    }
    
    /**
     * @param expectedWidth
     * @param expectedHeight
     * @param rows
     * @throws IllegalArgumentException
     *             - if the array does not conform with the inputed width and
     *             height
     */
    public static void validateInput (
        final int expectedWidth ,
        final int expectedHeight ,
        final String [] rows
    )
        throws IllegalArgumentException
    {
        if ( expectedHeight != rows.length )
            throw new IllegalArgumentException(
                "The row count does not conform to the inputted height"
            );
        for ( int i = 0 ; i < rows.length ; i++ )
            if ( rows[i].length() != expectedWidth )
                throw new IllegalArgumentException(
                    "The lenght of row : " + ( i + 1 )
                        + " does not conform to the inputed width"
                );
    }
}
