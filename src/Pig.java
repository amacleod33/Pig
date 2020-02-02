import java.util.Random;
import java.util.Scanner;

/**
 * Pig plays the game Pig as outlined by the rules on Wikipedia:
 * https://en.wikipedia.org/wiki/Pig_(dice_game)
 * 
 * @author Alex MacLeod
 * @version 1.0
 */
public class Pig {

    /** YES is Constant used to define proper "Yes" answer */
    static final String YES = "Y";
    /** NO is Constant used to define proper "No" answer */
    static final String NO  = "N";
    /** randGen is instance of java random number generator */
    static Random       randGen;
    /** maxPoints is a static variable that can be used the whole program */
    static int          maxPoints;
    // -------------------------------
    // Method definitions go below

    /**
     * getRandom returns a random number between start and end (or between end
     * and start if end {@literal <} start) based on the Random object randGen,
     * inclusive of both end points.
     * 
     * @param start
     *            the lowest possible number
     * @param end
     *            the highest possible number
     * @return an integer between (and including) start and end
     */
    public static int getRandom(int start, int end) {
        if (end < start) {
            return randGen.nextInt(start - end + 1) + end;
        }
        return randGen.nextInt(end - start + 1) + start;

    }


    /**
     * Returns a number between 1 and 6. Calls getRandom
     * 
     * @return a number between 1 and 6
     */
    public static int roll() {
        return getRandom(1, 6);

    }


    /**
     * Returns "Y" or "N" based on what the user enters If the user enters y or
     * Y as the first character, getYNAnswer returns Pig.YES. Otherwise, it
     * returns Pig.NO
     * 
     * @param kbd
     *            reference of single scanner object created to handle keyboard
     *            input
     * @param prompt
     *            user prompt string that should be printed
     * @return Y or N based on user input
     */
    public static String getYNAnswer(Scanner kbd, String prompt) {
        System.out.println(prompt);
        String finalAns = kbd.next();
        System.out.print("First Letter: " + finalAns.substring(0));
        if (Character.toUpperCase(finalAns.charAt(0)) == 'Y') {
            return Pig.YES;
        }
        return Pig.NO;

    }


    /**
     * This method allows the user to have a turn at Pig. The user rolls, and
     * continues to roll and accumulate points until the user rolls a 1 (in
     * which case the player receive a 0 for the turn), or until the user
     * decides to stop (in which case the method return the total of each dice
     * roll in this turn).
     * <p>
     * This method should call getYNAnswer and roll. Uses constants Pig.YES and
     * Pig.NO. Do not use "magic" values like "y".
     * 
     * @param kbd
     *            the Scanner method. It is important NOT to create a new
     *            Scanner object in any method. If you do, your junit tests will
     *            fail.
     * @return the total points for this turn
     */
    public static int takeTurn(Scanner kbd) {
        System.out.println("Player's turn");
        System.out.println("-------------");
        int totalPoints = 0;
        String answer = "";

        while (totalPoints < maxPoints) {
            answer = getYNAnswer(kbd, "Roll? Y/N");
            if (answer.equals(Pig.YES)) {
                int roll = roll();
                if (roll == 1) {
                    System.out.println("Oh no! You rolled a 1!");
                    totalPoints = 0;
                    return totalPoints;
                }
                else {
                    totalPoints += roll;
                }
                System.out.println("ROLL: " + roll);
                System.out.println("Points: " + totalPoints);

            }
            else if (answer.equals(Pig.NO)) {
                return totalPoints;
            }

        }
        return totalPoints;
    }


    /**
     * This simulates a computer turn. The computer rolls a random number of
     * times between 1 and maxComputerRolls. If the computer rolls a 1, the turn
     * is over, and the computer receives a 0. Otherwise, the computer continues
     * to roll the random number of times chosen.
     * 
     * @param maxComputerRolls
     *            the maximum number of times that the computer can have in a
     *            single turn
     * @return the number of points that the computer has won on this turn
     */
    public static int takeComputerTurn(int maxComputerRolls) {
        System.out.println("Computer's turn");
        System.out.println("----------------");
        int totalPoints = 0;
        for (int i = 0; i < maxComputerRolls; ++i) {
            int roll = roll();
            if (roll == 1) {
                System.out.println("ROLLED A 1. 0 POINTS.");
                totalPoints = 0;

                return totalPoints;
            }
            else {
                System.out.println("Rolled a " + roll);
                totalPoints += roll;
            }
        }
        return totalPoints;

    }


    /**
     * This method asks:
     * <ol>
     * <li>how many points will win
     * <li>the maximum number of rolls that the computer can have in a turn
     * </ol>
     * Then, play starts and continues (the user goes first). This method should
     * call takeTurn then takeComputerTurn. After each turn, this method should
     * print a message indicating the number of points that has just been
     * accrued. After one player (user or computer) reaches or exceeds the
     * number of points needed to win, this method prints a "You win" or "you
     * lose" message, as appropriate. You can choose the wording of the message,
     * but it must contain "win" if the user won, or "lose" is the user lost.
     * 
     * @param kbd
     *            Scanner where input is read. Pass this object as a parameter
     *            to any methods that have input.
     */
    public static void playGame(Scanner kbd) {
        int playerPoints = 0;
        int computerPoints = 0;
        int computerRolls;
        System.out.println("How many points will win? -> ");
        maxPoints = kbd.nextInt();
        System.out.println("How many times can the computer roll?");
        computerRolls = kbd.nextInt();
        while (playerPoints <= maxPoints && computerPoints <= maxPoints) {

            playerPoints += takeTurn(kbd);
            System.out.println();
            if (playerPoints >= maxPoints) {
                System.out.println("You win!");
                break;
            }
            System.out.println("Player Points: " + playerPoints);
            computerPoints += takeComputerTurn(computerRolls);
            System.out.println();
            System.out.println("Computer Points: " + computerPoints);
            if (computerPoints >= maxPoints) {
                System.out.println("You lose :=(");
            }

        }
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
     *            not used
     */
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        randGen = new Random(); // randGen should be a static field!
        playGame(kbd);
        String answer = getYNAnswer(kbd, "Do you want to play again? Y/N");
        while (answer.contentEquals(YES)) { // YES is static CONSTANT field
            playGame(kbd);
            answer = getYNAnswer(kbd, "\n\nDo you want to play again?");
        }
        System.out.println("Thank you for playing. Good bye.");
        kbd.close();
    }

}
