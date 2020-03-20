/**
   File: TimBot.java
   Author: Alex Brodsky
   Date: September 21, 2015
   Purpose: CSCI 1110, Assignment 4 Solution

   Description: This class specifies the solution for the TimBot base class.
*/


/**
   This is the TimBot base class for representing TimBots and their 
   behaviours on the planet DohNat.  
*/
public class TimBot { 
  private int myId;                                  // TimBot's ID
  protected int energyLevel;                         // TimBot's energy level
  protected char personality = 'N';                  // TimBot's personality
  protected int [] spressoSensed = new int[5];       // last spresso sensor read
  protected boolean [] botsSensed = new boolean[5];  // last adj bot sensor read

  /** 
     This is the only constructor for this class.  This constructor 
     initializes the Tibot and sets its ID and the initial amount of
     energy that it has.  The ID is between 0 and 99.

     parameter: id    : ID of the TimBotA
                jolts : Initial amount of energy
   */
  public TimBot( int id, int jolts ) {
    myId = id;
    energyLevel = jolts;
  }


  /** 
     This method returns the ID of this TimBot, which should be 1 or 
     greater.

     returns: id of TimBot
   */
  public int getID() {
    return myId;
  }


  /** 
     This method is called at the start of the round.  The TimBot
     uses up one jolt of energy at the start or each round.  This
     method decrements the energy level and returns true if and 
     only if the TimBot is still functional.

     returns true if energyLevel >= 0
   */
  public boolean startRound() {
    return useJolt();
  }


  /** 
     This method is called during the Sense phase of each round and
     informs the TimBot of the districts around it.  An integer
     array and a boolean array of 5 elements each is passed.  The
     elements represent the state of the District.CURRENT district
     and the districts District.NORTH, District.EAST, District.SOUTH,
     and District.WEST of the current district.  Each element of
     the spresso array stores the number of rounds before the spresso
     plants in the corresponding district will be ready for harvest.
     I.e., a 0 means that the spresso can be harvested this round.
     Each element of the bots array indicates whether a TimBot is
     present in the district.  E.g., if bots[District.SOUTH] is true, 
     then there is a TimBot in the district to the south.

     It is recommended that this method store the information locally,
     in its own boolean variables or arrays to be used in later phases
     of the the round.

     Params: spresso: a 5 element array of integers indicating when
                      the ospresso plants will be ready for harvest in 
                      corresponding districts.
             bots   : a 5 element array of booleans indicating whether
                      TimBots are present in corresponding districts.
   */
  public void senseDistricts( int [] spresso, boolean [] bots ) {
    System.arraycopy( spresso, 0, spressoSensed, 0, spresso.length );
    System.arraycopy( bots, 0, botsSensed, 0, bots.length );
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
    // Never move
    return District.CURRENT;
  }


  /** 
     This method returns true if the TmBot is functional.  I.e., it's
     energy level is not negative.

     returns: energy level >= 0
   */
  public boolean isFunctional() {
    return energyLevel >= 0;
  }


  /** 
     This method is called whenever a TimBot uses a jolt of energy.
     It decrements the energy level and returns true if and only
     if the TimBot is still functional.

     returns true if energyLevel >= 0
   */
  private boolean useJolt() {
    if( energyLevel >= 0 ) {
      energyLevel--;
    }
    return isFunctional();
  }


  /** 
     This method is called when the TimBot has to use its shield.
     This costs the TimBot 1 Jolt of energy.  If the TimBot has
     positive enery, it must use its shield (and use 1 Jolt of
     energy).  Otherwise, its energy level becomes -1 and it 
     becomes nonfunctional.

     returns: true if the shield was raised.
   */
  public boolean useShield() {
    return useJolt();
  }


  /** 
     This method is called during the Harvest phase if there are
     spresso plants to harvest.  This allows the TimBot to increase
     it's energy reserves by jolts Jolts.  The energy level cannot
     exceed 99 Jolts.
   */
  public void harvestSpresso( int jolts ) {
    // add harvest jolts to energy level and ensure it does not exceed 99
    energyLevel += jolts;
    if( energyLevel > 99 ) {
      energyLevel = 99;
    }
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
    // Never shoots
    return null;
  }


  /**
     This method is called at the end of each round to display the state
     of the TimBot.  The format of the String shoud be:
       (P I E)
     where 
       P: is a single Capital letter representing the personality of the TimBot 
         The default personality is N for do Nothing.  
       I: is the ID of the TimBot.
       E: is the TimBot's energy level in Jolts.  
     Both the ID and the Energy should have width 2.  E.g., if the TimBot's 
     Personality is A, its ID is 42, and its energy level is 7, then the 
     string to be returned is:
       (A 42  7)

     returns: a String representing the state of the TimBot
   */
  public String toString() {
    return String.format( "(%c %2d %2d)", personality, myId, energyLevel );
  }
}
