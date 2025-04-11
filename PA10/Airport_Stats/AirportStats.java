package PA10.Airport_Stats;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 11/16/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Obtains stats from a cvs file on the flights for a specific airport

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class AirportStats {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String[] code = obtainCode(scan);

        //makes sure both the airport code and name exists
        if(code[0] != null || code[1] != null){
            //gets file from user
            File file = obtainFile(scan);

            //reads information from file
            String[][] fileInfo = readData(file, code[0]);

            //combines stats from file
            int[][] stats = combineStats(fileInfo);

            //prints information
            printStats(code, stats);
        }
        else {
            System.out.println("Airport not found.");
        }
    }

    /**
     * obtains airport code from user
     * @param scan      Scanner object to obtain value from user
     * @return          returns airport code/ name
     * @throws FileNotFoundException    makes sure th file of the codes exists
     */
    public static String[] obtainCode(Scanner scan) throws FileNotFoundException {
        String[] airport = new String[2], airportList = new String[100];

        //gets airport code or name from user
        System.out.print("Enter airport name or code: ");
        String input = scan.next();

        //reads from the list of airport codes
        Scanner Sc = new Scanner(new File("PA10/Airport_Stats/airports-code.csv"));
        int i = 0;

        //splits the code and airport names
        while (Sc.hasNextLine()){
            String[] entry = Sc.nextLine().split(",", -1);
            if (entry.length >= 1) airportList[i] = entry[0].trim();
            if (entry.length >= 2) airportList[i + 1] = entry[1].trim();
            i += 2;
        }

        //looks for matching code and name
        for (i = 0; i < airportList.length; i+=2){
            String code = airportList[i];
            String name = airportList[i + 1];
            if (code == null || name == null){}
            else if (input.equalsIgnoreCase(code) ||
                    name.toLowerCase().contains(input.toLowerCase())) {
                airport[0] = code;
                airport[1] = name;
            }
        }
        Sc.close();
        return airport;
    }

    /**
     * obtains the files from the user and validates that it exists
     * @param scan  scanner object used to obtain the file
     * @return      Returns an array with the 4 files used for the word inserts
     */
    public static File obtainFile(Scanner scan){
        File file = null;
        boolean loop = true, first = true;

        System.out.print("Enter data file name: ");

        //loops until a valid file is inputted
        while(loop) {
            //makes sure the file inputted is a file and that it exists
            try{
                file = new File(scan.next().trim());

                if (file.exists() && file.isFile()) {
                    System.out.println(file + " successfully found.");
                    loop = false;
                }
                else {
                    if(!first) {
                        System.out.print("File does not exist, try again: ");
                    }
                }
                first = false;
            }
            catch(Exception e){
                System.out.print("File does not exist, try again: ");
            }
        }
        return file;
    }

    /**
     * Reads the information found in the file of all Airports data
     * @param file          The file with all the airport information
     * @param airportCode   The desired airports code
     * @return              the array with all the information from the desired airport
     * @throws FileNotFoundException    makes sure the file still exists
     */
    public static String[][] readData(File file, String airportCode) throws FileNotFoundException {
        Scanner Sc = new Scanner(file);
        String[][] airportData = new String[10000][10000];
        int count = 0;

        //loops through the inputted file
        while (Sc.hasNextLine()){
            String line = Sc.nextLine();
            String[] contents = line.split(",", -1);

            boolean hasBlankField = false;
            for (String content : contents) {
                if (content.trim().isEmpty()) {
                    hasBlankField = true;
                }
            }

            // checks if the airport code matches and there are no blank fields
            if (contents[0].trim().equalsIgnoreCase(airportCode) && !hasBlankField){
                airportData[count] = contents;
                count++;
            }
        }

        Sc.close();

        //copies and returns the array
        String[][] result = new String[count][6];
        System.arraycopy(airportData, 0, result, 0, count);
        return result;
    }

    /**
     * combines all stats and sorts them by year getting the total for each year
     * @param fileInfo  Array with all the desired airport statistics
     * @return          an array with the combined stats for each year
     */
    public static int[][] combineStats(String[][] fileInfo){
        int[][] stats = new int[LocalDate.now().getYear() - 2003 + 1][5];

        //iterates through fileInfo
        for (String[] entry : fileInfo) {
            if (entry != null && entry.length >= 6) {
                //gets year from date column
                int year = Integer.parseInt(entry[1].split("/")[0]);
                int yearPos = year - 2003;
                stats[yearPos][0] = year;

                //gets integers from the other stats
                for (int j = 2; j < entry.length; j++) {
                    stats[yearPos][j - 1] += Integer.parseInt(entry[j].trim());
                }
            }
        }

        return stats;
    }

    /**
     * displays stats for desired airport
     * @param location  an array containing the abbreviation and the name of the airport
     * @param stats     the combined stats from the desired file
     */
    public static void printStats(String[] location, int[][] stats){
        int cancelledTotal = 0, delayedTotal = 0, divertedTotal = 0, onTimeTotal = 0;

        System.out.println("\n" + location[0] + " | " + location[1]);
        System.out.println("Flight Statistics\n");
        System.out.println("============================================================");
        System.out.println("Year     Cancelled       Delayed      Diverted       On Time");
        System.out.println("============================================================");

        //adds the total array information and prints each years stats
        for (int[] yearStats : stats) {
            if(yearStats[0] != 0) {
                System.out.printf("%4d %,13d %,13d %,13d %,13d\n",
                        yearStats[0], yearStats[1], yearStats[2], yearStats[3], yearStats[4]);
                cancelledTotal += yearStats[1];
                delayedTotal += yearStats[2];
                divertedTotal += yearStats[3];
                onTimeTotal += yearStats[4];
            }
        }
        double total = (cancelledTotal + delayedTotal + divertedTotal + onTimeTotal) / 100.0;

        //prints the total values
        System.out.println("============================================================");
        System.out.printf("     %,13d %,13d %,13d %,13d\n",
                cancelledTotal, delayedTotal, divertedTotal, onTimeTotal);
        System.out.printf("     %,12.1f%% %,12.1f%% %,12.1f%% %,12.1f%%\n", cancelledTotal / total
                , delayedTotal / total, divertedTotal / total, onTimeTotal / total);
    }
}