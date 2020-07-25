/*
 * 25/07/2020 11:59:28
 * CellParser.java created by Tsvetelin
 */
package com.gvr.cells;


import java.util.Optional;

import com.gvr.cells.Cell.StatusCode;


/**
 * @author Tsvetelin
 *
 */
public interface CellParser
{
    
    /**
     * 
     * @param code
     *            - defined in Cell.StatusCodes
     * @return a red cell if the code is 0 or a green one if the code is 1
     * @throws IllegalArgumentException
     *             - if the code is not 1 or 0
     */
    public static Cell parse ( final char code ) throws IllegalArgumentException
    {
        // I strongly dislike having hardcoded constants
        StatusCode [] codes = StatusCode.values();
        
        for ( int i = 0 ; i < codes.length ; i++ )
        {
            if ( codes[i].code == code )
            {
                return new Cell( codes[i] );
            }
        }
        // if it is not found
        throw new IllegalArgumentException(
            "The code must be defined in StatusCodes"
        ); // I am not fond of throwing exceptions in this instance I
           // would much rather use an Optional
    }
    
    /**
     * 
     * @param code
     *            - defined in Cell.StatusCodes
     * @return an optional of a cell, it is full if the supplied code is
     *         correct, empty one otherwise
     */
    public static Optional< Cell > parseFunctionalStyle ( final char code )
    {
        StatusCode [] codes = StatusCode.values();
        
        for ( int i = 0 ; i < codes.length ; i++ )
        {
            if ( codes[i].code == code )
            {
                return Optional.of( new Cell( codes[i] ) );
            }
        }
        return Optional.empty();
    }
}
