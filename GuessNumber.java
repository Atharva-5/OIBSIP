import java.util.*;

public class GuessNumber {
    public static void main(String[] args) {

        Scanner X = new Scanner(System.in);
        int guesses = 0;
        int max = 100;
        int min = 1;
        int original = (int)(Math.random()*(max-min+1)+min);
        int points = 100;

        while (true) {
            System.out.println("Enter your guess (1-100): ");
            int num = X.nextInt();

            if (num == original) {
                System.out.println("Correct!! You win. ");
                guesses++;
                points += 60;
                System.out.println("You needed " + guesses + " number of guesses to guess the number.");
                System.out.println("You got reward of 60 points");
                break;

            } else if (num > original) {
                System.out.println("Wrong !! The correct number is smaller.");
                guesses++;
                points -= 20;
            } else {
                System.out.println("Wrong !! The correct number is greater.");
                guesses++;
                points -= 20;
            }
            if (points == 0) {
                System.out.println();
                System.out.println("You cannot guess due to insufficient points !!");
                System.out.println("Better luck next time!! ");
                break;
            }
            System.out.println("Score points : " + points);
        }
        System.out.println("Final Score points : " + points);
        System.out.println("Number is "+original);

        X.close();
    }
}
