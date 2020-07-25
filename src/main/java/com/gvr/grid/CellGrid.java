/*
 * 25/07/2020 11:18:54
 * Grid.java created by Tsvetelin
 */
package com.gvr.grid;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.gvr.cells.Cell;


/**
 * 
 * A container to hold the field of the game
 * 
 * @author Tsvetelin
 *
 */
public class CellGrid implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    public static final int MIN_WIDTH = 0;
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_WIDTH = 1000;
    public static final int MAX_HEIGHT = 1000;
    
    private final int width;
    private final int height;
    
    private final Cell [] [] grid;
    
    public CellGrid ( final Cell [] [] grid )
    {
        this.width = grid[0].length;
        this.height = grid.length;
        this.grid = grid;
    }
    
    public Cell at ( final int x , final int y )
    {
        return this.grid[y][x];
    }
    
    public CellGrid nextGeneration ()
    {
        Cell [] [] res = new Cell[this.height][this.width];
        
        for ( int x = 0 ; x < this.width ; x++ )
        {
            for ( int y = 0 ; y < this.height ; y++ )
            {
                List< Cell > neighbors = new LinkedList< Cell >();
                
                for ( int i = -1 ; i <= 1 ; i++ )
                {
                    for ( int j = -1 ; j <= 1 ; j++ )
                    {
                        if ( i == 0 && j == 0 )
                            continue;
                        try
                        {
                            neighbors.add( this.at( x + i , y + j ) );
                        } catch ( IndexOutOfBoundsException e )
                        {
                            // with this try-catch block I don't have to write
                            // the 8 if
                            // statements that check if it exceeds the array
                            // size
                        }
                    }
                }
                
                res[y][x] =
                    this.at( x , y ).nextState(
                        neighbors.toArray( new Cell[neighbors.size()] )
                    );
            }
        }
        return new CellGrid( res );
    }
    
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        
        for ( int x = 0 ; x < this.width ; x++ )
        {
            for ( int y = 0 ; y < this.height ; y++ )
                sb.append( this.at( x , y ) );
            sb.append( '\n' ); // this is way faster than System.lineSeparator()
        }
        return sb.toString();
        
    }
    
    public static void main ( String [] args )
    {
        String [] testgrid1 = new String[] {
            "000" ,
            "111" ,
            "000"
        };
        
        String [] testgrid2 = new String[] {
            "1001" ,
            "1111" ,
            "0100" ,
            "1010"
        };
        
        String [] grid = testgrid2;
        
        var gen0 = GridParser.parse( grid[0].length() , grid.length , grid );
        
        System.out.println( "Generation 0" );
        System.out.println( gen0 );
        
        final int generations = 15;
        final int lookingAtX = 2 , lookingAtY = 2;
        
        int counter = 0;
        
        var currGen = gen0;
        
        if ( currGen.at( lookingAtX , lookingAtY ).isGreen() )
            counter++;
        
        for ( int i = 1 ; i <= generations ; i++ )
        {
            
            currGen = currGen.nextGeneration();
            System.out.println( "------" );
            System.out.println( "Generation " + i );
            System.out
                .println( currGen );
            
            if ( currGen.at( lookingAtX , lookingAtY ).isGreen() )
                counter++;
        }
        
        System.out.println( "It was green: " + counter );
        
    }
    
}
