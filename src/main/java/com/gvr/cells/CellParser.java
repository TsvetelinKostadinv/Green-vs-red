/*
 * 25/07/2020 11:59:28
 * CellParser.java created by Tsvetelin
 */
package com.gvr.cells;


/**
 * @author Tsvetelin
 *
 */
public interface CellParser
{
    /**
     * 
     * @param code
     *            - a 0 or 1
     * @return a red cell if the code is 0 or a green one if the code is 1
     * @throws IllegalArgumentException
     *             - if the code is not 1 or 0
     */
    public static Cell parse ( final char code ) throws IllegalArgumentException
    {
        // a switch expression would be nice here tho
        switch ( code )
        {
            case '0' :
                return Cell.red();
            case '1' :
                return Cell.green();
            default :
                throw new IllegalArgumentException(
                    "The code can only be 0 or 1"
                );
        }
    }
}
