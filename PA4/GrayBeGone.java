package PA4;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/25/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Takes in an RGB value and removes the grey from it.

import java.util.*;

public class GrayBeGone {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rgb = {0, 0, 0};
        int[] noGreyRGB = {0,0,0};

        System.out.print("Enter the RGB value for red: ");
        rgb[0] = scan.nextInt();

        System.out.print("Enter the RGB value for green: ");
        rgb[1] = scan.nextInt();

        System.out.print("Enter the RGB value for blue: ");
        rgb[2] = scan.nextInt();

        //finds the smallest value
        int smallest = 300;
        for (int i = 0; i < rgb.length; i++){
            if (rgb[i] < smallest){
                smallest = rgb[i];
            }
        }

        //removes the smallest value from the rgb colors
        for (int i = 0; i < rgb.length; i++) {
            noGreyRGB[i] = rgb[i] - smallest;
        }

        //prints new rgb values
        System.out.println("The RGB values with the gray gone are " +
                noGreyRGB[0] + " " + noGreyRGB[1] + " " + noGreyRGB[2]);
    }
}
