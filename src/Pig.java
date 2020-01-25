import java.util.Random;
import java.util.Scanner;

/**
 * Pig plays the game Pig as outlined by the rules on Wikipedia:
 * https://en.wikipedia.org/wiki/Pig_(dice_game)
 * 
 * @author CPSC255 class
 * @version 1.0
 */
public class Pig {

    // ------------------------------------------------------
    // @TODO - fix this by defining the required fields here (see API)
    // You MUST use the same names and modifiers

    // -------------------------------
    // Method definitions go below

    /**
     * getRandom returns a random number between start and end (or between end and
     * start if end {@literal <} start) based on the Random object randGen,
     * inclusive of both end points.
     * 
     * @param start
     *                  the lowest possible number
     * @param end
     *                  the highest possible number
     * @return an integer between (and including) start and end
     */
    public static int getRandom(int start, int end) {

        return Integer.MIN_VALUE; // @todo - fix this method

    }

    /**
     * Returns a number between 1 and 6. Calls getRandom
     * 
     * @return a number between 1 and 6
     */
    public static int roll() {

        return Integer.MIN_VALUE; // @todo - fix this method

    }

    /**
     * Returns "Y" or "N" based on what the user enters If the user enters y or Y as
     * the first character, getYNAnswer returns Pig.YES. Otherwise, it returns
     * Pig.NO
     * 
     * @param kbd
     *                   reference of single scanner object created to handle
     *                   keyboard input
     * @param prompt
     *                   user prompt string that should be printed
     * @return Y or N based on user input
     */
    public static String getYNAnswer(Scanner kbd, String prompt) {

        return "FIX THIS METHOD";

    }

    /**
     * This method allows the user to have a turn at Pig. The user rolls, and
     * continues to roll and accumulate points until the user rolls a 1 (in which
     * case the player receive a 0 for the turn), or until the user decides to stop
     * (in which case the method return the total of each dice roll in this turn).
     * <p>
     * This method should call getYNAnswer and roll. Uses constants Pig.YES and
     * Pig.NO. Do not use "magic" values like "y".
     * 
     * @param kbd
     *                the Scanner method. It is important NOT to create a new
     *                Scanner object in any method. If you do, your junit tests will
     *                fail.
     * @return the total points for this turn
     */
    public static int takeTurn(Scanner kbd) {

        return Integer.MIN_VALUE; // @todo - fix this method

    }

    /**
     * This simulates a computer turn. The computer rolls a random number of times
     * between 1 and maxComputerRolls. If the computer rolls a 1, the turn is over,
     * and the computer receives a 0. Otherwise, the computer continues to roll the
     * random number of times chosen.
     * 
     * @param maxComputerRolls
     *                             the maximum number of times that the computer can
     *                             have in a single turn
     * @return the number of points that the computer has won on this turn
     */
    public static int takeComputerTurn(int maxComputerRolls) {

        return Integer.MIN_VALUE; // @todo - fix this method

    }

    /**
     * This method asks:
     * <ol>
     * <li>how many points will win
     * <li>the maximum number of rolls that the computer can have in a turn
     * </ol>
     * Then, play starts and continues (the user goes first). This method should
     * call takeTurn then takeComputerTurn. After each turn, this method should
     * print a message indicating the number of points that has just been accrued.
     * After one player (user or computer) reaches or exceeds the number of points
     * needed to win, this method prints a "You win" or "you lose" message, as
     * appropriate. You can choose the wording of the message, but it must contain
     * "win" if the user won, or "lose" is the user lost.
     * 
     * @param kbd
     *                Scanner where input is read. Pass this object as a parameter
     *                to any methods that have input.
     */
    public static void playGame(Scanner kbd) {

        // @todo - fix this method
    }

    /**
     * <ol>
     * <li>initializes a keyboard object for input
     * <li>initializes randGen object (use a seed to repeat tests)
     * <li>plays the game by calling playGame
     * <li>Asks the user if they want to continue, then keeps playing until user
     * enters N. Calls getYNAnswer. Uses constants YES and NO
     * <li>prints good bye message
     * <li>closes scanner object
     * </ol>
     * 
     * @param args
     *                 not used
     */
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        randGen = new Random(); // randGen should be a static field!
        playGame(kbd);
        String answer = getYNAnswer(kbd, "Do you want to play again?");
        while (answer.contentEquals(YES)) { // YES is static CONSTANT field
            playGame(kbd);
            answer = getYNAnswer(kbd, "\n\nDo you want to play again?");
        }
        System.out.println("Thank you for playing. Good bye.");
        kbd.close();
    }

}
