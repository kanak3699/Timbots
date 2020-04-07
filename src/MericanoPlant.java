/**
 File: MericanoPlant.java
 Author: Kanak Prajapati
 Date: April 06, 2020
 Purpose: CSCI 1110, Assignment 4 Solution

 Description: This class specifies the MericanoPlant class.
 */

/**
 This is the MericanoPlant class for representing MericanoPlant and their
 behaviours on the planet DohNat.
 */
public class MericanoPlant extends Plant{

    /**
     This is the constructor for this class.  This constructor
     initializes the MericanoPlant and sets its name, number of rounds
     for plant to grow and the number of jolts the plant harvest yields

     This constructor has no parameter
     */
    public MericanoPlant(){
        name = "mericano";
        plantGrowth = 0;
        plantJolts = 0;
        harvest = 0;
    }

    /**
     This is the another constructor for this class.  This constructor
     initializes the mericano count, the amount of energy in jolts and,
     the number of rounds needed for plant to grow.

     parameter: m_count : Count of Spresso Plants
                jolts : Initial amount of energy
                growth : the number of rounds needed for plant to grow.

     Note:  count = growth because they are not initially ready for harvest
            (initial time remaining till harvest is growth time)
            harvest = 0 because once they are harvested, will never grow back.
            so it keeps track of harvest.
     */
    public MericanoPlant(int m_count, int jolts, int growth) {
        name = "mericano";
        count=growth;
        plantGrowth = growth;
        plantJolts = jolts;
        harvest = 0;
    }

    /**
     This method initializes name of the plant. String denoting
     name of plant. E.g., mericano.

     parameters : name : String denoting name of plant.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     This is a getter method for the name of the plant.
     This method is called during the Testing phase.

     returns : name : String denoting name of plant. E.g., mericano
     */
    public String getName(){
        return name;
    }

    /**
     This method initializes number of rounds needed for
     the plant to grow.

     parameters : growth : Number of rounds for the plant to grow.
     */
    public void setPlantGrowth(int growth) {
        this.plantGrowth = growth;
    }

    /**
     This is a getter method for number of rounds needed for
     the plant to grow. This method is called during the Testing phase.

     returns : plantGrowth : Number of rounds for the plant to grow.
     */
    public int getPlantGrowth(){
        return plantGrowth;
    }

    /**
     This method initializes number of Jolts the plant harvest yields.

     parameters : jolts :   Amount of energy for number of Jolts
                            the plant harvest yields.
     */
    public void setPlantJolts(int jolts) {
        this.plantJolts = jolts;
    }

    /**
     This is a getter method for number of Jolts the plant harvest yields.
     This method is called during the Testing phase.

     returns : plantJolts : Amount of energy for number of Jolts
                            the plant harvest yields.
     */
    public int getPlantJolts(){
        return plantJolts;
    }

}
