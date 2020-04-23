/**
 * Game of Dice
 *
 * This program randomly selects two numbers from 1 - 6 (just like rolling two dice).
 * Show the dice rolls. It also shows the running score.
 * Prompts the user to either roll again or lose their turn.
 * A player scores the sum of the two dice thrown and gradually reaches a higher score as they continue to roll
 * If a single number 1 is thrown on either die, the score for that whole turn is lost. However a double 1 counts as 25.
 * When the score reaches 100 (or more) the game ends.
 */

import java.util.Random;
import java.util.Scanner;

public class GameOfDice {
    public static void main(String[] args) {

        // instantiation to generate Random number
        Random rnd = new Random();
        Scanner keyboard = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;
        int score = 0;
        boolean cont1 = true;
        boolean cont2;
        String input;

        // Welcome to the game statement
        System.out.println("Welcome! Let's play Roll Dice!");

        while (cont1 == true) {

            // The control (cont2) makes sure the program gets
            // confirmation the user to Roll again.
            cont2 = true;

            // generate two random numbers
            num1 = 1 + rnd.nextInt(6);
            num2 = 1 + rnd.nextInt(6);

            // calculate score
            if (num1 == 1 && num2 == 1) {
                score +=  25;
            }
            else if (num1 == 1 || num2 == 1) {
                //score +=  0;
            }
            else {
                score += (num1 + num2);
            }

            // Display the results
            System.out.printf("\nYour rolls %d & %d\n", num1, num2);
            System.out.printf("Score: %d\n", score);

            // check score value is not passing the limit (100)
            if(score >= 100){
                System.out.println("\nYou have scored over 100.");
                System.out.println("Thank you for playing");

                // the while loops end by assigning each control false
                cont1 = cont2 = false;
            }

            // Get User's interest to continue.
            while (cont2 == true) {
                // prompt user to decide to Roll again
                System.out.print("Roll again? ");

                // scan what user has entered
                input = keyboard.nextLine();

                /* check user's response if user needs to roll again?
                 * if user wants to quit the game?
                 * if user hit wrong key unintentionally?
                 */
                // if user needs to Roll again
                if (input.equalsIgnoreCase("yes")) {
                    // default answer is yes
                    cont2 = false;
                }
                // if user needs to quit
                else if (input.equalsIgnoreCase("no")) {
                    // only "n" or "N" is taken as no
                    cont1 = false;
                    cont2 = false;
                    System.out.println("\nThank you for playing!");
                }
                // if user hits wrong key unintentionally
                else {
                    System.out.print("\nWrong key entered. ");
                    // chance is given for another trial assuming user made unconscious error.
                    cont1 = true;
                    cont2 = true;
                }

            } // end of second while

        }   //end of first while

    }   //end of main
}