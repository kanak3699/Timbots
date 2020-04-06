/**
   File: SpressoBot.java
   Author: Alex Brodsky
   Date: September 21, 2015
   Purpose: CSCI 1110, Assignment 4 Solution

   Description: This class specifies the SpressoBot class.
*/


/**
   This is the SpressoBot class for representing SpressoBots and their 
   behaviours on the planet DohNat.  
*/
public class SpressoBot extends TimBot { 
  /**
     This is the only constructor for this class.  This constructor
     initializes the Tibot and sets its ID and the initial amount of
     energy that it has.

     parameter: id    : ID of the TimBotA
                jolts : Initial amount of energy
   */
  public SpressoBot( int id, int jolts ) {
    super( id, jolts );
    personality = 'S';
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
    // Create a score for each possible move, lower scores are better
    // score = 4 * spressoCount + 2 * (bot in district) + 1 * (adjacent bot)
    // initially no bots are adjacent and the initial choice is not to move
    int [] scores = new int[botsSensed.length];
    int adj = 0;
    int move = District.CURRENT;

    // If we have energy, consider moving
    if( energyLevel > 0 ) {
      // Compute scores for each possible move
      for( int i = 0; i < scores.length; i++ ) {
        scores[i] = plantSensed[i] * 4;
        if( ( i != District.CURRENT ) && botsSensed[i] ) {
          scores[i] += 2;
          adj = 1;
        }
      }
      // Only the current district will have an adjacent score
      scores[District.CURRENT] += adj;

      // Find the move with the lowest score
      int min = scores[District.CURRENT] + 1;
      for( int i = 0; i < scores.length; i++ ) {
        if( min > scores[i] ) {
          min = scores[i];
          move = i;
        }
      }

      // If the move is to anothr district, decrement energy level.
      useMoveEnergy(move);
    }
    return move;
  }
}
