import java.util.Scanner;
import java.util.Random;

public class RPC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter no. of times you want to play game at running once: ");
        int n = sc.nextInt();

        String[] choices = { "Rock", "Paper", "Scissor" };
        int userCount = 0;
        int compCount = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("\nEnter 0 for Rock, 1 for Paper, and 2 for Scissor: ");
            int userInput = sc.nextInt();

            
            if (userInput < 0 || userInput > 2) {
                System.out.println("Invalid Choice! Please enter 0, 1, or 2.");
                i--; 
                continue;
            }

            
            System.out.println("Your Input: " + choices[userInput]);

            
            int compInput = r.nextInt(3);
            System.out.println("Computer's Input: " + choices[compInput]);

            
            if (userInput == compInput) {
                System.out.println("It's a draw!");
            } else if ((userInput == 0 && compInput == 2) ||
                       (userInput == 1 && compInput == 0) ||
                       (userInput == 2 && compInput == 1)) {
                System.out.println("You win this round!");
                userCount++;
            } else {
                System.out.println("Computer wins this round!");
                compCount++;
            }
        }

        System.out.println("\nFINAL RESULT ..........");
        if (userCount == compCount) {
            System.out.println("Match Draw");
        } else if (userCount > compCount) {
            System.out.println("User Won");
        } else {
            System.out.println("Computer Won");
        }

        System.out.println("Your Score: " + userCount + " Times!");
        System.out.println("Computer Score: " + compCount + " Times!");

        sc.close();
    }
}
