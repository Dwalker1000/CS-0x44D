package PA7;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/25/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Obtains value from use and prints list till the first digit of
//                      value is printed as the second value then prints one more time

import java.util.Scanner;

public class SameDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //obtains value from user
        System.out.print("Enter starting number: ");
        int num = scan.nextInt(), originalNum = num;

        //makes it so 10 < num < 100
        if(num < 11 || num > 99){
            System.out.println("Starting number must be between 11-99 (inclusive).");
        }
        else{
            //prints values
            System.out.println("=== Counting down");
            System.out.println(num);
            while (num / 10 != num % 10){
                num--;
                System.out.println(num);
            }
        }
    }
}
