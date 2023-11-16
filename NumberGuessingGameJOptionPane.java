import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGameJOptionPane {
    public static void main(String[] args) {
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\nTry to guess the number between " + lowerBound + " and " + upperBound + ".");

        while (true) {
            int secretNumber = generateRandomNumber(random, lowerBound, upperBound);
            int attempts = 0;

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Enter your guess:");

                if (input == null) {
                    break; // User closed the input dialog
                }

                try {
                    int userGuess = Integer.parseInt(input);

                    if (userGuess < lowerBound || userGuess > upperBound) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between " + lowerBound + " and " + upperBound + ".");
                        continue;
                    }

                    attempts++;

                    if (userGuess < secretNumber) {
                        JOptionPane.showMessageDialog(null, "Try a higher number. Attempts left: " + (maxAttempts - attempts));
                    } else if (userGuess > secretNumber) {
                        JOptionPane.showMessageDialog(null, "Try a lower number. Attempts left: " + (maxAttempts - attempts));
                    } else {
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                        int points = maxAttempts - attempts + 1;
                        score += points;
                        JOptionPane.showMessageDialog(null, "You scored " + points + " points for this round.");
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play another round?\nYour current score: " + score, "Play Again?", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.NO_OPTION) {
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "Thank you for playing! Your final score: " + score);
    }

    public static int generateRandomNumber(Random random, int lowerBound, int upperBound) {
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
