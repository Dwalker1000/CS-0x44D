package PA5;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/1/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Gets a number from the user and determines is the number is a palindrome

import java.util.Scanner;

public class NumericPalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer between 1 and 999 (inclusive): ");
        int num = scan.nextInt();

        //checks is num is between 1 and 999
        if (num < 1 || num > 999){
            System.out.println("Input must be 1-999.");
        }
        else{
            isPalindrome(num);
        }
    }

    /**
     * Prints weather or not a number is a palindrome
     * @param num   the number inputted by the user
     */
    public static void isPalindrome(int num){
        int reversed  = reverse(num);
        //prints weather it is a palindrome or not
        if (reversed == num){
            System.out.println(num + " is a numeric palindrome.");
        }
        else{
            System.out.println(num + " is not a numeric palindrome.");
        }
    }

    /**
     * Flips the number given
     * @param num   the number given by the user
     * @return  the reversed number
     */
    public static int reverse(int num){
        //flips inputted number
        int dig3 = (num / 100);
        int dig2 = (num/10) - dig3 * 10;
        int dig1 = num - (num / 10) * 10;
        int reversed;

        //flips for 1, 2, and 3 digit integers
        if (dig3 != 0){
            reversed = dig1 * 100 + dig2 * 10 + dig3;
        }
        else if (dig2 == 0){
            reversed = dig1;
        }
        else{
            reversed = dig2 + dig1 * 10;
        }

        return reversed;
    }
}