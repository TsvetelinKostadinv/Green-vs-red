/*
 * 25/07/2020 11:07:00
 * Cell.java created by Tsvetelin
 */
package com.gvr.cells;


import java.io.Serializable;


/**
 * 
 * Represents a single cell in the grid
 * 
 * @author Tsvetelin
 *
 */
public class Cell implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     * Represents the state of each Cell, it is not in it's own file, because it
     * is tied to the internal state of the Cell so it doesn't make sense to be
     * outside of the cell class
     * 
     * @author Tsvetelin
     *
     */
    public static enum StatusCode
    {
        
        RED,
        GREEN,
        ; // trailing comma is considered a good practice, a shame Java does not
          // support it more
    }
    
    /**
     * 
     * The current status of the cell
     * 
     */
    private final StatusCode status;
    
    /**
     * 
     * Constructs a new Cell, it is intentionally private so users need to use
     * the factory methods
     * 
     * @param val
     *            - the value of the cell
     */
    private Cell ( final StatusCode val )
    {
        this.status = val;
    }
    
    /**
     * 
     * @return a red cell
     */
    public static Cell red ()
    {
        return new Cell( StatusCode.RED );
    }
    
    /**
     * 
     * @return a green cell
     */
    public static Cell green ()
    {
        return new Cell( StatusCode.GREEN );
    }
    
    /**
     * A getter if anyone wants the internal state, but it should not be needed
     * because the cell can calculate it's next state given the neighbors
     * 
     * @return
     */
    public StatusCode getStatus ()
    {
        return this.status;
    }
    
    /**
     * 
     * Calculates the next state given the neighbors according to the rules
     * 
     * @param neighbors
     *            - an array of the neighbors
     * @return a green cell or a red cell
     * @throws IllegalStateException
     *             if somehow the status is not red nor green
     */
    public Cell nextState ( final Cell [] neighbors )
        throws IllegalStateException
    {
        int greens = 0;
        
        for ( Cell c : neighbors )
        {
            if ( c.status == StatusCode.GREEN )
            {
                greens++;
            }
        }
        
        switch ( this.status )
        {
            case RED :
                if ( greens == 3 || greens == 6 )
                    return Cell.green();
                else
                    return Cell.red();
            case GREEN :
                if ( greens == 2 || greens == 3 || greens == 6 )
                    return Cell.green();
                else
                    return Cell.red();
            default :
                throw new IllegalStateException(
                    "The status codes are RED and GREEN only this should never be hit"
                );
        }
        
    }
    
    @Override
    public boolean equals ( final Object obj )
    {
        if (
            obj == null
                || ! ( obj instanceof Cell )
        )
            return false;
        
        return this.status == ( (Cell) obj ).status;
    }
    
    @Override
    public String toString ()
    {
        return "" + this.status;
    }
}
