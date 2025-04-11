package PA4;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/25/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: This program calculates a shipping cost.

import java.util.Scanner;

public class WeShipIt{
    public static final int OVERNIGHT_CHARGE = 5;
    public static final int TWO_DAY_CHARGE = 2;
    public static final int ECONOMY_CHARGE = 1;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);  // Scanner object to pass around.
        
        // Get item description.
        String itemDescription = getItemDescription(console);
        if (itemDescription.equals("")) {
            System.out.println("Invalid description.");
        }
        else {
            double shipWeight = getShipWeight(console);
            if (shipWeight <= 0.0) {
                System.out.println("Invalid weight.");
            }
            else {

                // Get shipping method and convert to uppercase.
                char shipMethod = getShipMethod(console);
                shipMethod = Character.toUpperCase(shipMethod);
                if (shipMethod == 'O' || shipMethod == 'T' || shipMethod == 'E') {
                    // Calculate shipping cost and display results.
                    double shipCost = calculateShipping(shipMethod, shipWeight);
                    displayResults(itemDescription, shipWeight, shipMethod, shipCost);
                } else {
                    System.out.println("Invalid shipping method.");
                }
            }
        }
    }
    
    // Prompts the user for the item description and returns it.
    public static String getItemDescription(Scanner console) {
        System.out.print("Enter item description: ");
        String description = console.nextLine();
        return description;
    }
    
    // Prompts the user for the item weight and returns it.
    public static double getShipWeight(Scanner console) {
        System.out.print("Enter item weight (in lbs): ");
        double weight = console.nextDouble();
        
        return weight;
    }
    
    // Prompts the user for the shipping method and returns it.
    public static char getShipMethod(Scanner console) {
        char method;
        
        System.out.print("Enter ship method (O)vernight - (T)wo Days - (E)conomy: ");
        method = console.next().charAt(0);  // I've been told to leave this line in here.
        // Will be explained in class.
        return method;
    }
    
    // Calculates and returns the shipping charge.
    public static double calculateShipping(char method, double weight) {
        double shipCharge = 0.0;
        
        if (method == 'O') {
            shipCharge = weight * OVERNIGHT_CHARGE;
        } else if (method == 'T') {
            shipCharge = weight * TWO_DAY_CHARGE;
        } else
            shipCharge = weight * ECONOMY_CHARGE;
        return shipCharge;
    }
    
    // Print shipping charge invoice.
    public static void displayResults(String description, double weight, char method, double cost){
        System.out.println("*** WE SHIP INVOICE ***");
        System.out.println("Item Description: " + description);
        System.out.printf("Item Weight: %.2f\n", weight);
        System.out.println("Ship Method: " + method);
        System.out.printf("Total Cost: $%.2f\n", cost);
    }
}
