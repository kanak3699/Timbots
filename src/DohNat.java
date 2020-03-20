/**
   File: DohNat.java
   Author: Alex Brodsky
   Date: September 21, 2015
   Purpose: CSCI 1110, Assignment 4 Solution

   Description: This class specifies the DohNat class.
*/

import java.util.*;

/**
   This is the DohNat base class for representing the torroidal planet
   DohNat.  It represents a grid division of the planet where each element
   of the grid is a District and where oposit edges of the grid are
   considered adjacent.  
*/
public class DohNat { 
  private District [][] districts;
  private int height;
  private int width;


  /** This constructor creates a planet divided into a grid of
      rows X columns districts.

      parameters:  rows:    number of rows in the grid
                   columns: number of columns in the grid
                   jolts:   number of jolts that a spresso harvest delivers
                   growth:  number of rounds it taks to grow spresso plants
   */
  public DohNat( int height, int width, int jolts, int growth ) {
    // Set size of grid, allocate 2D array
    this.height = height;
    this.width = width;
    districts = new District[width][height];

    // Instantiate a district for each element in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y] = new District( this, x, y, jolts, growth );
      }
    }
  }


  /** This method adds a TimBot to the District in grid element (x,y).
      where 0 <= x < width and 0 <= y < height.  This method will 
      return false if there is already a TimBot in the District, or
      the coordinates are invalid.

      parameters:  bot: The TimBot object to be added
                   x  : x coordinate of the destination District 
                   y  : y coordinate of the destination District 

      returns: true on success or false otherwise.
   */
  public boolean setTimBot( TimBot bot, int x, int y ) {
    return districts[x][y].setTimBot( bot );
  }


  /** This method starts the next round of the simulation
   */
  public void newRound() {
    // perform a startMewRound() for each district in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y].startNewRound();
      }
    }
  }


  /** This method exectutes the Sense phase of the round.
   */
  public void doSensePhase() {
    // perform a sense phase for each district in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y].doSensePhase();
      }
    }
  }


  /** This method exectutes the Move phase of the round.
   */
  public void doMovePhase() {
    // perform a move phase for each district in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y].doMovePhase();
      }
    }
  }


  /** This method exectutes the Battle phase of the round.
   */
  public void doBattlePhase() {
    // perform a battle phase for each district in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y].doBattlePhase();
      }
    }
  }


  /** This method exectutes the Fire phase of the round.
   */
  public void doFirePhase() {
    // perform a fire phase for each district in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y].doFirePhase();
      }
    }
  }


  /** This method exectutes the Defense phase of the round.
   */
  public void doDefensePhase() {
    // perform a defense phase for each district in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y].doDefensePhase();
      }
    }
  }


  /** This method exectutes the Harvest phase of the round.
   */
  public void doHarvestPhase() {
    // perform a harvest phase for each district in the grid
    for( int x = 0; x < width; x++ ) {
      for( int y = 0; y < height; y++ ) {
        districts[x][y].doHarvestPhase();
      }
    }
  }


  /** This method returns the District object representing district 
      (x,y) on DohNat.  Coordinate may in the range -1 <= x <= width,
      and -1 <= y <= height.  Note since the antipodal edges of the 
      grid are adjacent, 
        if x == -1, then x = width - 1
        if y == -1, then y = height - 1
        if x == width, then x = 0
        if y == height, then y = 0

      parameters: x: x coordinate of the District
                  y: y coordinate of the District

      returns the District object
   */
  public District getDistrict( int x, int y ) {
    // compute wrap-around (if needed) and return the corresponding grid element
     x = ( x + width ) % width;
     y = ( y + height ) % height;
     return districts[x][y];
  }


  /**
    This method returns a String describing state of the DohNat using
    the grid format:
      DDDD..D
      DDDD..D
      ::::  :
      DDDD..D
    where D denotes a string representing the corresponding district in
    the grid.   There should be no spaces spearating the districts, and
    each row of disticts should be terminated by a newline.
  */
  public String toString() {
    // add each district to a string, using its toString method
    String s = "";
    for( int y = 0; y < height; y++ ) {
      for( int x = 0; x < width; x++ ) {
        s += districts[x][y].toString();
      }
      // add a new line after each row
      s += "\n";
    }
    return s;
  }
}
