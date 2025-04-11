package PA8.Harshad;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/30/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Gets file input from user and determines if a num is a Harshad number.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Harshad {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        File file = null;

        System.out.print("Enter file name: ");
        while(loop) {
            file = new File(scan.next().trim());
            if (file.exists()){
                System.out.println(file + " successfully found.\n");
                loop = false;
            }
            else{
                System.out.print("File does not exist, try again: ");
            }
        }

        FileProcess(file);
    }

    /**
     * determines if a value is a harshad number
     * @param num   the number obtained form teh file
     * @return      weather it is a harshad num or not
     */
    public static boolean isHarshad(int num){
        int first = num / 100;
        int third = num % 10;
        int second = (num % 100 - third)/10;

        return num % (first + second + third) == 0;
    }

    /**
     * Process the file inputted
     * @param file  the file the user wants processed
     * @throws FileNotFoundException    if the file doesn't exist
     */
    public static void FileProcess(File file) throws FileNotFoundException {
        int harshadTotal = 0, nonHarshadTotoal = 0, badTokens = 0;

        System.out.println("Scanning " + file + "...");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            //if token is good
            if(scanner.hasNextInt()) {
                int num = scanner.nextInt();

                //adds to harshad num counts
                if (isHarshad(num)) {
                    System.out.println(num + " is a Harshad number.");
                    harshadTotal += 1;
                } else {
                    nonHarshadTotoal += 1;
                }
            }
            else{
                badTokens += 1;
                scanner.next();
            }
        }
        scanner.close();
        Results(harshadTotal, nonHarshadTotoal, badTokens, file);
    }

    /**
     * returns the results of the data in the file
     * @param harshadTotal      how many numbers are harshan numbers
     * @param nonHarshadTotoal  how many are not harshad numbers
     * @param badTokens         how many tokens are 'bad'
     */
    public static void Results(int harshadTotal, int nonHarshadTotoal, int badTokens, File file){
        System.out.println("\nResults for " + file + "...");
        System.out.println("- Total Harshad numbers: " + harshadTotal);
        System.out.println("- Total non-Harshad numbers: " + nonHarshadTotoal);
        System.out.println("- Total bad tokens: " + badTokens);
    }
}
