/*
 * 25/07/2020 13:15:51
 * Main.java created by Tsvetelin
 */
package com.gvr;


import java.util.Scanner;

import com.gvr.grid.GridParser;


/**
 * @author Tsvetelin
 *
 */
public class Main
{
    
    public static void main ( String [] args )
    {
        int width , height;
        String [] rawGrid;
        int lookingAtX , lookingAtY;
        int generations;
        
        try ( final Scanner in = new Scanner( System.in ) )
        {
            System.out.println( "Green vs. Red" );
            
            System.out.print( "Input number of rows: " );
            height = in.nextInt();
            
            System.out.print( "Input number of colomns: " );
            width = in.nextInt();
            
            rawGrid = new String[height];
            
            for ( int i = 0 ; i < height ; i++ )
                rawGrid[i] = in.next();
            
            System.out.print( "Input target X: " );
            lookingAtX = in.nextInt();
            
            System.out.print( "Input target Y: " );
            lookingAtY = in.nextInt();
            
            System.out.print( "Input number of generations: " );
            generations = in.nextInt();
            
            /*
             * This was the easy way
             * The other way is if they are on the same row:
             * 
             * String input = in.nextLine();
             * 
             * String [] raw = input.split( ", " );
             * 
             * lookingAtX = Integer.parseInt( raw[0] );
             * lookingAtY = Integer.parseInt( raw[1] );
             * generations = Integer.parseInt( raw[2] );
             */
        }
        
        var gen0 =
            GridParser.parse( width , height , rawGrid );
        
        int counter = 0;
        
        var currGen = gen0;
        
        if ( currGen.at( lookingAtX , lookingAtY ).isGreen() )
            counter++;
        
        for ( int i = 1 ; i <= generations ; i++ )
        {
            
            currGen = currGen.nextGeneration();
            if ( currGen.at( lookingAtX , lookingAtY ).isGreen() )
                counter++;
        }
        
        System.out.println( "It was green: " + counter + " times" );
    }
}
