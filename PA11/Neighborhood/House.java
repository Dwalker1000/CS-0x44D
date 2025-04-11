package PA11.Neighborhood;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 12/3/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Class template description: Represents a house with different attributes
//          and methods to compare objects and display the objects as a string

public class House extends Building{
    //Variables
    private String owner;
    private boolean pool;

    /**
     * Constructor to create PA11.Neighborhood.House object
     * @param length    Length of the house
     * @param width     Width of the house
     * @param lotLength Length of the house parking lot
     * @param lotWidth  Width of the house parking lot
     */
    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.owner = null;
        this.pool = false;
    }

    /**
     * Constructor to create PA11.Neighborhood.House object with owner name
     * @param length    Length of the house
     * @param width     Width of the house
     * @param lotLength Length of the house parking lot
     * @param lotWidth  Width of the house parking lot
     * @param owner     Name of the house owner
     */
    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        this(length, width, lotLength, lotWidth);
        this.owner = owner;
    }

    /**
     * Constructor to create PA11.Neighborhood.House w/ a pool with owner name
     * @param length    Length of the house
     * @param width     Width of the house
     * @param lotLength Length of the house parking lot
     * @param lotWidth  Width of the house parking lot
     * @param owner     Name of the house owner
     * @param pool      Boolean of weather or not the house has a pool
     */
    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        this(length, width, lotLength, lotWidth, owner);
        this.pool = pool;
    }

    /**
     * Sets the owner of the house
     * @param owner The name of teh owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Sets if the house has a pool
     * @param pool If house has a pool
     */
    public void setPool(boolean pool) {
        this.pool = pool;
    }

    /**
     * Returns the house features as a string
     * @return  The returned String
     */
    public String toString() {
        String ownerInfo = "Owner: ";
        if (owner == null) {
            ownerInfo += "n/a";
        } else {
            ownerInfo += owner;
        }

        if (pool) {
            ownerInfo += "; has a pool";
        }

        //if land area is bigger than the building area
        if ((calcLotArea() - calcBuildingArea()) > calcBuildingArea()) {
            ownerInfo += "; has a big open space";
        }

        return ownerInfo + "\n" + super.toString();
    }

    /**
     * Compares two objects to see if the houses are the same
     * @param obj   The object we are going to compare
     * @return      Returns true if the objects are the same, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        House otherHouse = (House) obj;
        return this.calcBuildingArea() == otherHouse.calcBuildingArea()
                                        && this.pool == otherHouse.pool;
    }
}
