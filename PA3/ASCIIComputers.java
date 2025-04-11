package PA3;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/13/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Prints out ASCII art

public class ASCIIComputers {
    public static void main(String[] args) {
        printHappyGirl();
        printHappyBoy();
        printTiredGirl();
        printTiredBoy();
    }

    /**
     * Prints the tired header.
     */
    public static void printTiredTop(){
        System.out.println("     ---------");
        System.out.println("     | Tired |");
    }

    /**
     * Prints the happy header.
     */
    public static void printHappyTop(){
        System.out.println("     ---------");
        System.out.println("     | Happy |");
    }

    /**
     * Prints the girl header.
     */
    public static void printGirlHeader(){
        System.out.println("     | Girl  |");
        System.out.println("     ---------");
        System.out.println("  _   _");
        System.out.println(" | \\_/ |_________");
        System.out.println(" |_/-\\_|_______  |");
    }

    /**
     * Prints the boy header.
     */
    public static void printBoyHeader(){
        System.out.println("     |  Boy  |");
        System.out.println("     ---------");
        System.out.println("  _______________");
        System.out.println(" |  ___________  |");
    }

    /**
     * Prints the tired screen.
     */
    public static void printTiredScreen(){
        System.out.println(" | |           | |");
        System.out.println(" | |   X   X   | |");
        System.out.println(" | |     -     | |");
        System.out.println(" | |    ___    | |");
    }

    /**
     * Prints the happy screen.
     */
    public static void printHappyScreen(){
        System.out.println(" | |           | |");
        System.out.println(" | |   0   0   | |");
        System.out.println(" | |     -     | |");
        System.out.println(" | |   \\___/   | |");
    }

    /**
     * Prints the boy footer.
     */
    public static void printBoyFooter() {
        System.out.println(" | |___     ___| |");
        System.out.println(" |_____|\\_/|_____|");
        System.out.println("    _|_|/ \\|_|_");

    }

    /**
     * Prints the girl footer.
     */
    public static void printGirlFooter(){
        System.out.println(" | |___________| |");
        System.out.println(" |_______________|");
        System.out.println("    _|_______|_");
    }

    /**
     * Prints the keyboard for both guys and girls.
     */
    public static void printKeyboard(){
        System.out.println("   / ********* \\");
        System.out.println(" /  ***********  \\");
        System.out.println("-------------------\n");
    }

    /**
     * Prints a tired girl.
     */
    public static void printTiredGirl(){
        printTiredTop();
        printGirlHeader();
        printTiredScreen();
        printGirlFooter();
        printKeyboard();
    }

    /**
     * Prints a tired boy.
     */
    public static void printTiredBoy(){
        printTiredTop();
        printBoyHeader();
        printTiredScreen();
        printBoyFooter();
        printKeyboard();
    }

    /**
     * Prints a happy girl.
     */
    public static void printHappyGirl(){
        printHappyTop();
        printGirlHeader();
        printHappyScreen();
        printGirlFooter();
        printKeyboard();
    }

    /**
     * Prints a happy boy.
     */
    public static void printHappyBoy(){
        printHappyTop();
        printBoyHeader();
        printHappyScreen();
        printBoyFooter();
        printKeyboard();
    }
}
