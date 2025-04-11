package PA6;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/14/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: returns the number of vowels and numbers in an input.

import java.util.Scanner;

public class CountItUp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //gets the users string and sends is to teh function CountIt()
        System.out.println("Enter a string: ");
        char[] in = scan.nextLine().toLowerCase().toCharArray();
        int[] Count = CountIt(in);

        System.out.println("Total vowels: " + Count[0]);
        System.out.println("Total numbers: " + Count[1]);
    }

    /**
     * calculates how many the total number of values
     * @param in    is the input in the form of an array of characters
     * @return      returns the amount of vowels and numbers in the input
     */
    public static int[] CountIt(char[] in){
        int[] Count = {0,0};

        for(int i = 0; i < in.length; i++){
            if(in[i] == 'a' || in[i] == 'e' || in[i] == 'i' || in[i] == 'o' || in[i] == 'u'){
                Count[0] += 1;
            }
            else if(Character.isDigit(in[i])){
                Count[1] += 1;
            }
        }
        return Count;
    }
}
