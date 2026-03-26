import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==========================");
        System.out.println("   Number Guessing Game   ");
        System.out.println("==========================");

        while (true) {

            // generate a random number between 1 and 100
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attemptsLeft = maxAttempts;

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!\n");

            while (attemptsLeft > 0) {

                System.out.print("Attempts left: " + attemptsLeft + " — Your guess: ");
                String input = scanner.nextLine();

                // check if input is a valid number
                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                // check if guess is in range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                    continue;
                }

                attemptsLeft--;

                if (guess == secretNumber) {
                    System.out.println("\nCorrect! The number was " + secretNumber + ".");
                    System.out.println("You got it in " + (maxAttempts - attemptsLeft) + " attempt(s)!");
                    break;

                } else if (guess < secretNumber) {
                    System.out.println("Too low!");

                } else {
                    System.out.println("Too high!");
                }

                if (attemptsLeft == 0) {
                    System.out.println("\nOut of attempts! The number was " + secretNumber + ".");
                }
            }

            System.out.print("\nPlay again? (yes / no): ");
            String again = scanner.nextLine().trim().toLowerCase();

            if (!again.equals("yes")) {
                System.out.println("Thanks for playing. Bye!");
                break;
            }
        }

        scanner.close();
    }
}
