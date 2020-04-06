/**
 File: District.java
 Author: Alex Brodsky
 Date: September 21, 2015
 Purpose: CSCI 1110, Assignment 4 Solution
 Description: This class specifies the District class.
 */

/**
 This is the District class for representing districts on the planet DohNat
 Each District object is responsible for keeping track of the spresso plants
 in the district, the TimBot (if one is present), and any incoming ion shots
 coming into and out of the district.  It is also responsible for gathering
 sense data from surrounding districts and passing it to the TimBot during the
 Sense phase.
 */
public class District {
  // Thse are the district ID used to index into the spresso and bots
  // arrays passed to the senseDistrict method and also used to specify
  // where the TimBot wishes to fire the ion cannon.
  public static final int CURRENT = 0;
  public static final int NORTH = 1;
  public static final int EAST = 2;
  public static final int SOUTH = 3;
  public static final int WEST = 4;

  private int myX;                               // X position of district
  private int myY;                               // Y position of district
  private TimBot resident;                       // ref to resident timbot
  private TimBot [] invaderBots = new TimBot[5]; // invading TimBots added here
  private int numInvaders = 0;                   // # of invaders at Move phase
  private int incomingFire = 0;                  // # of shots fired at district
  private DohNat myPlanet;                       // ref to district's planet

/*Done
  private int spressoCount = 0;                  // current spresso count
  private int spressoJolts = 0;                  // # of jolts at harvest
  private int spressoGrowth = 0;                 // # of rounds between harvests
*/

  Plant spresso = new SpressoPlant(0, 0, 0);        //count, jolts, growths

  Plant mericano = new MericanoPlant(0, 0, 0);      //count, jolts, growths

  /**
   This constructor initializes the district, its spresso plant counter, and
   saves planet, its coordinates, which it will need to query adjoining
   districts.
   parameters: planet: reference to DohNat so that adjacent districts can be
   accessed.
   x : x coordinate of the district
   y : y coordinate of the district
   jolts : number of jolts that the TimBot gets from a harvest.
   growth : amount of time it takes to grow spresso
   */
  public District( DohNat planet, String type, int x, int y, int jolts, int growth ) {
    myX = x;
    myY = y;
    myPlanet = planet;
    if (type.equals("spresso")){
      spresso.setVal(jolts, growth);
    }
    else if (type.equals("mericano")){
      mericano.setVal(jolts, growth);
    }
  }


  /**
   This method adds a TimBot to the district.  Only one TimBot may occupy
   a district.  It is an error if a TimBot is added to a district that
   has one.

   return: true on success, and false on error
   */
  public boolean setTimBot( TimBot bot ) {
    // If district is empty, set TimBot
    if( resident == null ) {
      resident = bot;
    }

    // return true if District contains the TimBot
    return resident == bot;
  }


  /**
   This method takes a direction and returns the corresponding adjacent
   district.

   parameter: direction (NORTH, EAST, SOUTH, WEST, or CURRENT)
   return: the adjacent district in the specified direction
   */
  private District getAdjoiningDistrict( int direction ) {
    // For each direction, use own coordinates to compute location of
    // adjacent district and get the district from the planet.
    switch( direction ) {
      case CURRENT:
        return myPlanet.getDistrict( myX, myY );
      case NORTH:
        return myPlanet.getDistrict( myX, myY - 1 );
      case EAST:
        return myPlanet.getDistrict( myX + 1, myY );
      case SOUTH:
        return myPlanet.getDistrict( myX, myY + 1 );
      case WEST:
        return myPlanet.getDistrict( myX - 1, myY );
      default:
        return null;
    }
  }


  /**
   This method takes a direction and sensor arrays and performs
   a sensor reading of the adjacent district

   parameter: direction (NORTH, EAST, SOUTH, WEST, or CURRENT
   spresso : array of spresso counts for each adj district
   bots : boolean array indicating bot presence in adj districts
   */
  /*private void senseDistrict( int direction, int [] spresso,
                              boolean [] bots ) {
    // Get adjacent district, and query it for spresso count and timbot presence
    District d = getAdjoiningDistrict( direction );
    spresso[direction] = d.hasSpresso();
    bots[direction] = d.hasTimBot();
  }*/

  private void senseDistrict( int direction, int [] plant, boolean [] bots ) {
    // Get adjacent district, and query it for spresso count and timbot presence
    District d = getAdjoiningDistrict( direction );
    plant[direction] = d.hasplant();
    bots[direction] = d.hasTimBot();
  }

  /**
   This method performs starts the next round for the TimBot in
   the district.  It should call the TimBot's startRound() method.
   This method need not do anything if no functional TimBot is present.
   */
  public void startNewRound() {
    // If district is not empty and timbot is functional, call its startRound()
    // if it is no longer functional, clear the district
    if( ( resident != null ) && resident.isFunctional() ) {
      if( !resident.startRound() ) {
        resident = null;
      }
    }
  }


  /**
   This method performs the Sense phase for the TimBot in the district.
   This method need not do anything if no functional TimBot is present.
   */
/*  public void doSensePhase() {
    // If district is not empty and timbot is functional, sense adj districts
    if( ( resident != null ) && resident.isFunctional() ) {
      // Create sensor arrays
      int [] spresso = new int[5];
      boolean [] bots = new boolean[5];
      // perform sensing for each district
      senseDistrict( CURRENT, spresso, bots );
      senseDistrict( NORTH, spresso, bots );
      senseDistrict( EAST, spresso, bots );
      senseDistrict( SOUTH, spresso, bots );
      senseDistrict( WEST, spresso, bots );
      // inform timbot of sensor readings.
      resident.senseDistricts( spresso, bots );
    }
  }*/


  public void doSensePhase() {
    // If district is not empty and timbot is functional, sense adj districts
    if( ( resident != null ) && resident.isFunctional() ) {
      // Create sensor arrays
      int [] plant = new int[5];
      boolean [] bots = new boolean[5];

      // perform sensing for each district
      senseDistrict( CURRENT, plant, bots );
      senseDistrict( NORTH, plant, bots );
      senseDistrict( EAST, plant, bots );
      senseDistrict( SOUTH, plant, bots );
      senseDistrict( WEST, plant, bots );

      // inform timbot of sensor readings.
      resident.senseDistricts( plant, bots );
    }
  }


  /**
   This method returs true if there is a TimBot in the District and
   false otherwise.

   return: true if TimBot is present
   */
  public boolean hasTimBot() {
    return resident != null;
  }


  /**
   This method returns true if there spresso plants ready for harvest
   and false otherwise.

   return: number of rounds before spresso is ready.
   */
  /*public int hasSpresso() {
    return spresso.count;
  }*/

  public int hasplant(){
    if(mericano.count<spresso.count){
      return mericano.count;
    }
    else{
      return spresso.count;
    }
  }

  /**
   This method performs the Move phase for the TimBot in the district.
   This method need not do anything if no functional TimBot is present.
   */
  public void doMovePhase() {
    // If district is not empty and timbot is functional, query timbot for move
    if( ( resident != null ) && resident.isFunctional() ) {
      int direction = resident.getNextMove();

      // If Timbot chooses to move, move it to the requested district.
      if( direction != CURRENT ) {
        // Get the requested district and move to timbot into it.
        District d = getAdjoiningDistrict( direction );
        d.moveTimBot( resident );

        // mark district as empty
        resident = null;
      }
    }
  }


  /**
   This method moves the TimBot into the District during the Move phase.
   It is ok if there are multiple TimBots in the District, since they will
   be taken care of during the Battle phase.
   Parameter: bot: The TimBot moving into the District.
   */
  public void moveTimBot( TimBot bot ) {
    // Add the timbot to the list of invaders for the Battle Phase
    invaderBots[numInvaders] = bot;
    numInvaders++;
  }


  /**
   This method performs the Battle phase for the TimBot(s) in the district.
   This method need not do anything if less than two TimBots are present.
   */
  public void doBattlePhase() {
    // If there are invaders into the district, perform battle
    if( numInvaders > 0 ) {
      // If district is occupied by functional timbot, add it to the battle list
      if( ( resident != null ) && resident.isFunctional() ) {
        invaderBots[numInvaders] = resident;
        numInvaders++;
      } else if( numInvaders == 1 ) {
        // Else, if the ditrict is empty, and the number of invaders is 1,
        // the invader wins without a fight
        resident = invaderBots[0];
        numInvaders = 0;
        return;
      }

      // Prepare to do battle.  Keep a count of the number of bots involved
      // continue battle as long as there are more than 1 bots.
      int count = numInvaders;
      while( count > 1 ) {
        // reset count and get each participating bot to use its shield
        count = 0;
        for( int i = 0; i < numInvaders; i++ ) {
          // If the bot successfully used its shield, it remains in the battle.
          if( invaderBots[i].useShield() ) {
            // Set resiedent to latest bot and increment count of bots in battle
            resident = invaderBots[i];
            count++;
          }
        }
      }

      // If the bots mutually destroyed each other, the district becomes empty
      // Number of invaders is reset to 0
      if( count == 0 ) {
        resident = null;
      }
      numInvaders = 0;
    }
  }


  /**
   This method performs the Fire phase for the TimBot in the district.
   This method need not do anything if less than two TimBots are present.
   */
  public void doFirePhase() {
    // If district is not empty and timbot is functional, query timbot for shots
    if( ( resident != null ) && resident.isFunctional() ) {
      // Get shots form timbot.  If timbot fires, send shots to districts
      int [] shots = resident.fireCannon();
      if( shots != null ) {
        for( int i = 0; i < shots.length; i++ ) {
          // Get destination district of shot and inform it of the shot.
          District d = getAdjoiningDistrict( shots[i] );
          d.fireAtDistrict();
        }
      }
    }
  }

  /**
   This method is called by adjacent Districts if a TimBot in
   those districts is firing at the TimBot in the present district.
   Every invocation of this method constitutes a single ion shot
   at the TimBot in this district.  This method need not do
   anything if is no TimBot are present.
   */
  public void fireAtDistrict() {
    // If district is not empty and timbot is functional, increment fire counter
    if( ( resident != null ) && resident.isFunctional() ) {
      incomingFire++;
    }
  }


  /**
   This method performs the Defense phase for the TimBot in the district.
   This method need not do anything if is no TimBot are present.
   */
  public void doDefensePhase() {
    // If district is not empty and timbot is functional, use shield on imBot
    // for the number of shots hurled at it.
    if( ( resident != null ) && resident.isFunctional() ) {
      // loop until all shots ar processed or timbot runs out of energy
      for( ; incomingFire > 0; incomingFire-- ) {
        // if timbot runs out of energy, district becomes empty.
        if( !resident.useShield() ) {
          resident = null;
          break;
        }
      }
    }
  }


  /**
   This method performs the Harvest phase for the TimBot in the district.
   This mehtod will always be called at the end of the round.  If the
   spresso is not ready to be harvested, then the method should decrement
   a counter that counts down to when the spresso will be ready for harvest.
   Otherwise, if the spresso is ready for harvest and a TimBot is present,
   the TimBot harvests the spresso and the counter is reset to count down.
   Otherwise, nothing is done.
   */
 /* public void doHarvestPhase() {
    // If spresso is ready to be harvested, check if harvest is to be done
    if( spresso.count == 0 ) {
      // If district is not empty and timbot is functional, perform harvest
      if( ( resident != null ) && resident.isFunctional() ) {
        // give harvest to bot and reset spresso counter
        resident.harvestSpresso( spresso.plantjolts );
        spresso.count = spresso.plantgrowth;
      }
    } else {
      // else decrement the amount of time until harvest time.
      spresso.count--;
    }
  }
*/

  public void doHarvestPhase() {
    // If spresso is ready to be harvested, check if harvest is to be done
    if( spresso.count == 0) {
      // If district is not empty and timbot is functional, perform harvest
      if( ( resident != null ) && resident.isFunctional() ) {
        // give harvest to bot and reset spresso counter
        resident.harvestPlant( spresso.plantJolts);
        spresso.resetCount();
      }
    }
    else {
      // else decrement the amount of time until harvest time.
      spresso.count--;
    }
    if (mericano.count == 0) {
      // If district is not empty and timbot is functional, perform harvest
      if( ( resident != null ) && resident.isFunctional() && mericano.isNotHarvested()) {           //if mericano isn't harvested anytime yet
        // give harvest to bot and reset mericano counter
        resident.harvestPlant( mericano.plantJolts);
        mericano.resetCount();      // khali method call karvani re if there are more plants to be added
        mericano.setHarvested();
      }
    }
    else {
      //else decrement the amount of time until harvest time.
      if(mericano.isNotHarvested())                             // preventing the count to be negative after mericano is harvested once
        mericano.count--;
    }
  }




  /**
   This method returns a String describing state of the District using
   the format:
   |bot counter|
   where bot is either the string representing the TimBot in the District
   or 9 spaces if there is no TimBot; counter is the number of rounds left
   till the spresso is ready for harvest.   The counter should have width 2.
   E.g.,
   |(N 42  7)  3|
   Shows a district with TimBot with personality N, ID 42, energy level 7,
   and there are three rounds left till the spresso is ready for harvest.
   */
/*  public String toString() {
    if( ( resident != null ) && resident.isFunctional() ) {
      return String.format( "|%s %2d|", resident.toString(), spresso.count );
    } else {
      return String.format( "|          %2d|", spresso.count );
    }
  }*/

  public String toString() {
    if( ( resident != null ) && resident.isFunctional() ) {
      return String.format( "|%s %2d|", resident.toString(), spresso.count );
    } else {
      return String.format( "|          %2d|", spresso.count );
    }
  }



}