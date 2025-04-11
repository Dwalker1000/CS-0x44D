package PA9.MadLibs;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 11/6/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: obtains files from the user and generates sentences based on the files

import java.io.*;
import java.util.*;

public class MadLibs {
    public static final int SIZE = 4;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        //list of files
        File[] files = obtainFile(scan);

        //obtains seed from user
        int seed = getSeed(scan);

        //how many sentences
        int sentences = getSentences(scan);

        //generates the sentences based on the input
        generateSentence(sentences, seed, files);
    }

    /**
     * obtains the files from the user and validates that it exists
     * @param scan  scanner object used to obtain the file
     * @return      Returns an array with the 4 files used for the word inserts
     */
    public static File[] obtainFile(Scanner scan){
        File[] file = new File[SIZE];

        //4 files needed
        for (int i = 0; i < 4; i++){
            //first print statement for type of info wanted
            fileNameType(i);
            boolean loop = true;
            while(loop) {
                //makes sure the file inputted is a file and that it exists
                try{
                    file[i] = new File(scan.next().trim());

                    if (file[i].exists() && file[i].isFile()) {
                        System.out.println(file[i] + " successfully found.\n");
                        loop = false;
                    }
                    else {
                        System.out.print("File does not exist, try again: ");
                    }
                }
                catch(Exception e){
                    System.out.print("File does not exist, try again: ");
                }
            }
        }
        return file;
    }

    /**
     * prints the type of file that we want from the user
     * @param i     loop value to indicate type of file needed
     */
    public static void fileNameType(int i){
        if (i == 0) {
            System.out.print("Enter file name for adjectives: ");
        }
        else if (i == 1){
            System.out.print("Enter file name for animals: ");
        }
        else if (i == 2){
            System.out.print("Enter file name for objects: ");
        }
        else{
            System.out.print("Enter file name for answers: ");
        }
    }

    /**
     * gets seed for the random number from the user and makes sure it is a positive value
     * @param Scan  scanner to obtain the users seed
     * @return      a positive seed from the user
     */
    public static int getSeed(Scanner Scan) {
        System.out.print("Enter a seed: ");
        int seed = Scan.nextInt();

        //makes sure seed in positive
        while (seed < 1){
            System.out.print("Not a positive number, try again: ");
            seed = Scan.nextInt();
        }
        return seed;
    }

    /**
     * Obtains how many sentences the user wants to print
     * @param Scan  Scanner object used to get the input (1-50)
     * @return      returns the amount of sentences we want to generate (1-50)
     */
    public static int getSentences(Scanner Scan) {
        System.out.print("Enter number of sentences to produce: ");
        int num = Scan.nextInt();

        //makes sure the number enter is between 1 and 50
        while (num < 1 || num > 50){
            System.out.print("Not between 1 and 50, try again: ");
            num = Scan.nextInt();
        }
        return num;
    }

    /**
     * Generates a sentence based on the information in the files
     * @param sentences                 how many sentences the user wants printed
     * @param seed                      users seed for the random generator
     * @param file                      Array of files read from for the generation
     * @throws FileNotFoundException    needed for the file reading
     */
    public static void generateSentence(int sentences, int seed, File[] file)
            throws FileNotFoundException {
        Random rand = new Random(seed);

        if (sentences == 1){
            System.out.println("\nHere is the sentence:\n");
        }
        else {
            System.out.println("\nHere are the sentences:\n");
        }
        //loops for amount of sentences wanted
        for (int i = 0; i < sentences; i++) {
            String adjective = fileProcess(file[0], rand);
            String animal = fileProcess(file[1], rand);
            String object = fileProcess(file[2], rand);
            String answer = fileProcess(file[3], rand);

            //prints the sentences
            System.out.printf("Sentence %2d: ", i+1);
            System.out.println("Six " + adjective + " " + animal +
                    " sit in the " + object + ". Do they fit? " + answer);
        }
    }

    /**
     * Processes the file and obtains the random word that is contained in the file
     * @param file                      the file from the array that is being read
     * @param rand                      random number object with the obtained seed
     * @return                          returns the word needed for the sentence
     * @throws FileNotFoundException    Needed to read the file
     */
    public static String fileProcess(File file, Random rand) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        //gets the amount of lines needed to read
        int totalLines = scanner.nextInt();
        scanner.nextLine();

        //array for all the lines in the file
        String[] input = new String[totalLines];
        int i = 0;

        //reads each line in the file after the number
        while (scanner.hasNextLine() && i < totalLines) {
            input[i] = scanner.nextLine();
            i++;
        }

        scanner.close();

        //returns the random word
        return input[rand.nextInt(i)];
    }
}
