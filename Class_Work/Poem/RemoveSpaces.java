package Class_Work.Poem;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class RemoveSpaces {
    // TODO: Add the throws clause to the method header
    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        
        System.out.print("Enter file name: ");
        String fileName = "Class_Work/Poem/" + console.nextLine().trim();

        File inputFile = new File(fileName);
        
        // TODO: Use a while loop to validate the input file name
        while(!inputFile.exists()){
            System.out.print("Input file does not exist, try again: ");
            // TODO: complete the while loop
            fileName = console.nextLine().trim();
            inputFile = new File(fileName);
        }
        
        // TODO: Construct a Scanner to read the input file
        Scanner input = new Scanner(inputFile);

        // TODO: Specify the output file name
        File outputFile = new File("Class_Work/Poem/poemNoSpace.txt");
        
        // TODO: Use an if statement to check whether the output file already exists
        if (outputFile.exists()) {
            System.out.println("poemNoSpace.txt already exists!");
        } else {
            // TODO: Construct a PrintStream to print to the output file
            PrintStream output = new PrintStream(outputFile);

            // TODO: Process the file via line-based processing
            while (input.hasNextLine()){
                String line = input.nextLine();
                Scanner lineScnr = new Scanner(line);

                while (lineScnr.hasNext()){
                    output.print(lineScnr.next());
                }
                output.println();
                lineScnr.close();
            }
            
            
            // TODO: Close the Scanner for the input file
            input.close();
            // TODO: Close the PrintStream for the output file
            output.close();
        }
    }
}
