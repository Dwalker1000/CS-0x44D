package PA11.Neighborhood;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 12/3/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Class template description: Represents an office with different attributes
//          and methods to compare objects and display the objects as a string

public class Office extends Building {
    // Variables
    private static int totalOffices = 0;
    private String businessName;
    private int parkingSpaces;

    /**
     * Constructor to create an PA11.Neighborhood.Office object with building dimensions and lot dimensions
     * @param length    Length of the office building
     * @param width     Width of the office building
     * @param lotLength Length of the lot
     * @param lotWidth  Width of the lot
     */
    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.businessName = null;
        this.parkingSpaces = 0;
        totalOffices++;
    }

    /**
     * Constructor to create object with building dimensions, lot dimensions,and business name
     * @param length        Length of the office building
     * @param width         Width of the office building
     * @param lotLength     Length of the lot
     * @param lotWidth      Width of the lot
     * @param businessName  Name of the business
     */
    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this(length, width, lotLength, lotWidth);
        this.businessName = businessName;
    }

    /**
     * Constructor for object with lot/building dimensions, business name, and parking spaces
     * @param length        Length of the office building
     * @param width         Width of the office building
     * @param lotLength     Length of the lot
     * @param lotWidth      Width of the lot
     * @param businessName  Name of the business
     * @param parkingSpaces Number of parking spaces available
     */
    public Office(int length, int width, int lotLength, int lotWidth,
                                String businessName, int parkingSpaces) {
        this(length, width, lotLength, lotWidth, businessName);
        this.parkingSpaces = parkingSpaces;
    }

    /**
     * Sets the number of parking spaces
     * @param parkingSpaces Number of parking spaces
     */
    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    /**
     * Returns the office stats as a string
     * @return  The returned String
     */
    public String toString() {
        String businessInfo;
        if (businessName == null) {
            businessInfo = "Business: unoccupied";
        } else {
            businessInfo = "Business: " + businessName;
        }

        String parkingInfo = "";
        if (parkingSpaces > 0) {
            parkingInfo = "; has " + parkingSpaces + " parking spaces";
        }

        String totalOfficesInfo = " (total offices: " + totalOffices + ")";
        return businessInfo + parkingInfo + totalOfficesInfo + "\n" + super.toString();
    }

    /**
     * Compares two objects to see if the offices are the same
     * @param obj   The object we are going to compare
     * @return      Returns true if the objects are the same, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Office otherOffice = (Office) obj;
        return this.calcBuildingArea() == otherOffice.calcBuildingArea() &&
                this.parkingSpaces == otherOffice.parkingSpaces;
    }
}