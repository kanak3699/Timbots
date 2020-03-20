/**
   File: BullyBot.java
   Author: Alex Brodsky
   Date: September 21, 2015
   Purpose: CSCI 1110, Assignment 4 Solution

   Description: This class specifies the BullyBot class.
*/


/**
   This is the BullyBot base class for representing BullyBots and their 
   behaviours on the planet DohNat.  
*/
public class BullyBot extends ChickenBot {
  /**
     This is the only constructor for this class.  This constructor
     initializes the Tibot and sets its ID and the initial amount of
     energy that it has.

     parameter: id    : ID of the TimBot
                jolts : Initial amount of energy
   */
  public BullyBot( int id, int jolts ) {
    super( id, jolts );
    personality = 'B';
  }

  /** 
     This method is called during the Fire Cannon phase.  The TimBot
     creates an array of integers, each representing where it wishes
     to fire the ion cannon, and decreases its energy reserves by
     1 Jolt for each shot.  The integers can be one NORTH, EAST,
     SOUTH, or WEST.  If the TimBot does not wish to fire its cannon,
     it returns null;

     returns: array of integers representing shots from the cannon
   */
  public int [] fireCannon() {
    int count = 0;
    int [] fire = null;

    // Determine number of districts to shoot at
    for( int i = 0; i < botsSensed.length; i++ ) {
      if( ( i != District.CURRENT ) && botsSensed[i] ) {
        count++;
      }
    }

    // Reduce count if we do not have enough energy
    if( count > ( energyLevel - 2 ) ) {
      count = energyLevel - 2;
    }

    // If we are going to shoot, create the array of shots
    if( count > 0 ) {
      // allocate array and set index into it to 0.
      fire = new int[count];  
      int j = 0;

      // loop through all the districts, adding them to array if they
      // contain a timbot
      for( int i = District.NORTH; i < botsSensed.length; i++ ) {
        if( ( i != District.CURRENT ) && botsSensed[i] && ( j < count ) ) {
          fire[j] = i;
          j++;
          energyLevel--;
        }
      }
    }
    return fire;
  }
}
