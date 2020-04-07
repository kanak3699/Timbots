/**
 File: SpressoPlant.java
 Author: Kanak Prajapati
 Date: April 06, 2020
 Purpose: CSCI 1110, Assignment 4 Solution

 Description: This class specifies the SpressoPlant class.
 */

/**
 This is the SpressoPlant class for representing SpressoPlant and their
 behaviours on the planet DohNat.
 */

public class SpressoPlant extends Plant {

    /**
     This is the constructor for this class.  This constructor
     initializes the SpressoPlant and sets its name, number of rounds
     for plant to grow and the number of jolts the plant harvest yields

     This constructor has no parameter
     */

    public SpressoPlant(){
        name = "spresso";               // "Spresso" name of the plant.
        plantGrowth = 0;                // Initial number of rounds for plant to grow.
        plantJolts = 0;                 // Initial number of jolts the plant harvest yields.
    }

    /**
     This is the another constructor for this class.  This constructor
     initializes the spresso count, the amount of energy in jolts and,
     the number of rounds needed for plant to grow.

     parameter: s_count : Count of Spresso Plants
                jolts : Initial amount of energy
                growth : the number of rounds needed for plant to grow.
     */

    public SpressoPlant(int  s_count, int jolts, int growth) {
        name = "spresso";
        count=s_count;
        plantGrowth = growth;
        plantJolts = jolts;
    }

    /**
     This method initializes name of the plant. String denoting
     name of plant. E.g., spresso.

     parameters : name : String denoting name of plant.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     This is a getter method for the name of the plant.
     This method is called during the Testing phase.

     returns : name : String denoting name of plant. E.g., spresso
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