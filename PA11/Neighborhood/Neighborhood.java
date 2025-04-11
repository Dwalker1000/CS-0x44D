package PA11.Neighborhood;
// Name: CS 1101 instructor

// Description: This program simulates a neighborhood containing houses and offices.

public class Neighborhood {
    public static void main(String[] args) {
        House[] house = getHouses();
        Office[] office = getOffices();
        
        print(house, "Houses");
        System.out.println();
        print(office, "Offices");

        System.out.println();
        System.out.println("Total neighborhood area: " + (calcArea(house) + calcArea(office)));
    }

    /**
     * Prints the list of buildings of a specified building type.
     * @param  list   The list of buildings.
     * @param  header The specified type of the buildings.
     */
    public static void print(Building[] list, String header) {
        System.out.println(header);
        System.out.println("----------");
        
        for (Building item : list) {
            System.out.println(item);
            System.out.println();
        }
    }

    /**
     * Calculates the total area of all buildings in a list.
     * @param  list The list of buildings.
     * @return      The total area of the buildings.
     */
    public static int calcArea(Building[] list) {
        int total = 0;
        
        for (Building item : list) {
            total += item.calcLotArea();
        }
        
        return total;
    }

    /**
     * Creates an array of PA11.Neighborhood.House objects.
     * @return An array of PA11.Neighborhood.House objects.
     */
    public static House[] getHouses() {
        House[] house = new House[9];

        house[0] = new House(20, 40, 56, 60);
        house[0].setOwner("George Washington");
        house[0].setPool(true);
        house[1] = new House(90, 190, 100, 200, "John Adams");
        house[2] = new House(20, 40, 60, 56, "Thomas Jefferson", true);
        house[3] = new House(20, 40, 56, 60, "James Madison", true);
        house[4] = new House(120, 100, 130, 110, "James Monroe", false);
        house[5] = new House(100, 100, 110, 110, "John Quincy Adams", true);
        house[6] = new House(10, 10, 100, 100, "Andrew Jackson", true);
        house[7] = new House(10, 10, 12, 12);
        house[8] = new House(10, 10, 12, 12);
        house[8].setPool(true);

        return house;
    }

    /**
     * Creates an array of PA11.Neighborhood.Office objects.
     * @return An array of PA11.Neighborhood.Office objects.
     */
    public static Office[] getOffices() {
        Office[] office = new Office[6];

        office[0] = new Office(20, 40, 56, 60);
        office[1] = new Office(200, 400, 600, 560, "Bridgestone/Firestone", 100);
        office[2] = new Office(200, 400, 560, 600, "Caterpillar");
        office[2].setParkingSpaces(100);
        office[3] = new Office(100, 400, 200, 500, "Cracker Barrel");
        office[4] = new Office(300, 100, 400, 200);
        office[4].setParkingSpaces(50);
        office[5] = new Office(200, 100, 300, 200, "Nissan");

        return office;
    }
}
