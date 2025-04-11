package PA11.Neighborhood;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 12/3/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Class template description: Represents a building with different attributes
//          and methods to compare objects and display the objects as a string

public class Building {
    //Variables
    private int length;
    private int width;
    private int lotLength;
    private int lotWidth;

    /**
     * Constructor to create building object
     * @param length    Length of the building
     * @param width     Width of the building
     * @param lotLength Length of parking lot
     * @param lotWidth  Width of parking lot
     */
    public Building(int length, int width, int lotLength, int lotWidth) {
        this.length = length;
        this.width = width;
        this.lotLength = lotLength;
        this.lotWidth = lotWidth;
    }

    /**
     * Calculates building area
     * @return  Returns the area
     */
    public int calcBuildingArea() {
        return length * width;
    }

    /**
     * Calculates parking lot area
     * @return  Returns the area of the lot
     */
    public int calcLotArea() {
        return lotLength * lotWidth;
    }

    /**
     * Returns the building stats as a string
     * @return  The returned String
     */
    public String toString() {
        return "PA11.Neighborhood.Building area: " + calcBuildingArea() + " / Lot area: " + calcLotArea();
    }

    /**
     * Compares two objects to see if the buildings are the same
     * @param obj   The object we are going to compare
     * @return      Returns true if the objects are the same, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Building otherBuilding = (Building) obj;
        return this.calcBuildingArea() == otherBuilding.calcBuildingArea();
    }
}
