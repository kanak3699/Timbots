/**
 File: Plant.java
 Author: Kanak Prajapati
 Date: April 06, 2020
 Purpose: CSCI 1110, Assignment 4 Solution

 Description: This class specifies the solution for the Plant base class.
 */

/**
 This is the Plant base class for representing plants and their
 behaviours on the planet DohNat.
 */

public class Plant {

    protected String name;                  // String denoting name of the plant.
    protected int count = 0;                // Plant's Count.
    protected int X_coord = 0;              // The x - Coordinates of the district containing the plant.
    protected int Y_coord = 0;              // The y - Coordinates of the district containing the plant.
    protected int plantJolts = 0;           // Number of jolts the plant harvest yields.
    protected int plantGrowth = 0;          // Number of rounds needed for plant to grow.
    protected int harvest;                  // If harvest is 0 then it has not-harvested and
                                            // If harvest is 1 then it has harvested and will not harvest again.

    /**
     This method initializes the number of jolts
     the plant harvest yields (plantJolts) and,
     the number of rounds needed for plant to grow (plantGrowth).

     parameter: jolts : Initial amount of energy
                growth : Initial growth
     */
    protected void setVal(int jolts, int growth){
        this.plantJolts = jolts;
        this.plantGrowth = growth;
    }

    /**
     This method checks if the plant has harvested or not. It will
     return true if harvest is 0 else, It will return false.

     returns :  true if harvest is equal to 0
                false if harvest is not equal to 0
     */
    public boolean isNotHarvested(){
        if(this.harvest == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     This method checks if once the plant has harvested and if it
     has then it will not harvest again and will never grow back.
     It will change harvest to 1 so it will not harvest again.
     */

    public void setHarvested(){
        this.harvest=1;
    }

    /**
     This method resets the counter for the plant grown.
     So, they are not initially ready for harvest.

     This is initial time remaining till harvest is growth time.
     */

    public void resetCount(){
        this.count=this.plantGrowth;
    }

    /**
     This is a getter method for the counter.
     This method is called during the testing phase.

     returns : count
     */
    public int getCounter() {
        return count;
    }

    /**
     This is a getter method for the number
     of rounds needed for plant to grow.
     This method is called during the testing phase.

     returns : plantGrowth
     */
    public int getGrowth(){
        return plantGrowth;
    }

    /**
     This is a getter method for the number
     of jolts the plant harvest yields.
     This method is called during the testing phase.

     returns : plantJolts
     */
    public int getJolts() {
        return plantJolts;
    }

    /**
     This method initializes the x - Coordinates
     of the district containing the plant.

     parameters : X_coord : The x - Coordinates
     of the district containing the plant.
     */
    public void setX_coord(int X_coord){
        this.X_coord = X_coord;
    }

    /**
     This method initializes the y - Coordinates
     of the district containing the plant.

     parameters : Y_coord : The y - Coordinates
     of the district containing the plant.
     */
    public void setY_coord(int Y_coord){
        this.Y_coord = Y_coord;
    }

    /**
     This is a getter method for the x - Coordinates
     of the district containing the plant.
     This method is called during the testing phase.

     returns : X_coord
     */
    public int getX_coord(){
        return X_coord;
    }

    /**
     This is a getter method for the y - Coordinates
     of the district containing the plant.
     This method is called during the testing phase.

     returns : Y_coord
     */
    public int getY_coord(){
        return Y_coord;
    }

}
