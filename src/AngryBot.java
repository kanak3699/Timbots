/**
   File: AngryBot.java
   Author: Alex Brodsky
   Date: September 21, 2015
   Purpose: CSCI 1110, Assignment 4 Solution

   Description: This class specifies the AngryBot class.
*/


/**
   This is the AngryBot class for representing AngryBots and their 
   behaviours on the planet DohNat.  
*/
public class AngryBot extends SpressoBot {
  /**
     This is the only constructor for this class.  This constructor
     initializes the Tibot and sets its ID and the initial amount of
     energy that it has.

     parameter: id    : ID of the TimBot
                jolts : Initial amount of energy
   */
  public AngryBot( int id, int jolts ) {
    super( id, jolts );
    personality = 'A';
  }


  /** 
     This method is called during the Move phase of each round and
     requires the TimBot to decide whether or not to move to another
     district.  If the TimBot wishes to move, it returns, District.NORTH,
     District.EAST, District.SOUTH, or District.WEST, indicating which 
     direction it wishes to move.  If it does not wish to move, it 
     returns District.CURRENT.

     returns: the one of District.NORTH, District.EAST, District.SOUTH, 
              District.WEST, or District.CURRENT
   */
  public int getNextMove() {
    // Create an array for scoring each of the possible moves
    // And set initial move to CURRENT
    int [] scores = new int[botsSensed.length];
    int move = District.CURRENT;

    // If we have enough energy, consider attacking another district
    if( energyLevel > 2 ) {
      // Compute scores for each of the districts, the lower scores are better
      // score = spressoCount + 2000 * (if district is empty)
      for( int i = 0; i < scores.length; i++ ) {
        scores[i] = spressoSensed[i];
        if( !botsSensed[i] ) {
          scores[i] += 2000;
        }
      }

      // Find the minimum over all scores
      int min = scores[District.CURRENT] + 1;
      for( int i = 0; i < scores.length; i++ ) {
        if( min > scores[i] ) {
          min = scores[i];
          move = i;
        }
      }

      // If move is not to stay here, decrement energy level.
      if( move != District.CURRENT ) {
        energyLevel--;
      }
    } else {
      // Else, if we do not have enough energy to attack, behave like spressobot
      move = super.getNextMove();
    }
    return move;
  }
}
