package PA6;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/15/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Gets robot position based on user instructions.

import java.util.Scanner;

public class RobotSteps {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of robots: ");
        int num = scan.nextInt();

        for (int i = 0; i < num; i++){
            System.out.println();
            System.out.println("=== Robot " + (i+1) + " ===");
            System.out.print("Enter step sequence: ");
            int[] pos = (Movement(scan.next()));
            stats(pos);
        }
    }

    /**
     * converts the movement instructions to numeric positions
     * @param sequence      The user inputted sequence
     * @return              an array with the movement positions
     */
    public static int[] Movement(String sequence){
        char[] seq = sequence.toUpperCase().toCharArray();
        int[] pos = {0,0,0,0};
        for(int i = 0; i < sequence.length(); i++){
            if (seq[i] == 'F'){
                pos[0] += 1;
            }
            else if (seq[i] == 'B'){
                pos[1] += 1;
            }
            else if (seq[i] == 'L'){
                pos[2] += 1;
            }
            else if (seq[i] == 'R'){
                pos[3] += 1;
            }
        }
        return pos;
    }

    /**
     * prints out the stats of the robot
     * @param pos       an array of positions about how the robot moved
     */
    public static void stats(int[] pos){
        System.out.println();
        System.out.println("Forward steps: " + pos[0]);
        System.out.println("Backward steps: " + pos[1]);
        System.out.println("Left steps: " + pos[2]);
        System.out.println("Right steps: " + pos[3]);
        System.out.println();

        int y = (pos[0]-pos[1]);
        int x = (pos[3]-pos[2]);
        double dist = Math.sqrt(x*x + y*y);
        String quad = quadrant(x, y);
        System.out.println("Final coordinate position: (" + x + ", " + y + ")");
        System.out.println("Final quadrant position: " + quad);
        System.out.printf("Distance from origin: %.2f", dist);
        System.out.println();
    }

    /**
     * determines the quadrant the robot is in
     * @param x     the x position of the robot
     * @param y     the y position of the robot
     * @return      returns the quadrant position of the robot
     */
    public static String quadrant(int x, int y){
        if (x > 0 && y > 0) {
            return "Quadrant I";
        } else if (x < 0 && y > 0) {
            return "Quadrant II";
        } else if (x < 0 && y < 0) {
            return "Quadrant III";
        } else if (x > 0 && y < 0) {
            return "Quadrant IV";
        } else if (x == 0 && y != 0) {
            return "On y-axis";
        } else if (y == 0 && x != 0) {
            return "On x-axis";
        } else {
            return "At origin";
        }
    }
}
