import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();

        System.out.print("Enter number of rounds to play: ");
        int n;
        while (true) {
            String line = sc.nextLine().trim();
            try {
                n = Integer.parseInt(line);
                if (n > 0) break;
            } catch (Exception e) {}
            System.out.print("Invalid! Enter a positive number: ");
        }

        String[] choices = { "Rock", "Paper", "Scissor" };
        int playerScore = 0;
        int compScore = 0;
        int drawCount = 0;

        for (int i = 1; i <= n; i++) {

            System.out.println("\nRound " + i + "-->");

            int userInput;
            while (true) {
                System.out.print("Enter 0=Rock, 1=Paper, 2=Scissor: ");

                String input = sc.nextLine().trim();
                try {
                    userInput = Integer.parseInt(input);

                    if (userInput >= 0 && userInput <= 2) break;

                } catch (Exception e) {}

                System.out.println("Invalid input! Try again.");
            }

            System.out.println(playerName + " chose: " + choices[userInput]);

            int compInput = r.nextInt(3);
            System.out.println("Computer chose: " + choices[compInput]);

            if (userInput == compInput) {
                System.out.println("It's a draw!");
                drawCount++;
            } else if ((userInput == 0 && compInput == 2) ||
                       (userInput == 1 && compInput == 0) ||
                       (userInput == 2 && compInput == 1)) {
                System.out.println(playerName + " wins this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                compScore++;
            }
        }

        System.out.println("\nFINAL RESULT ..........");

        if (playerScore == compScore) {
            System.out.println("Match Draw");
        } else if (playerScore > compScore) {
            System.out.println(playerName + " Won the Match!");
        } else {
            System.out.println("Computer Won the Match!");
        }

        System.out.println(playerName + "'s Score: " + playerScore);
        System.out.println("Computer Score: " + compScore);
        System.out.println("Draws: " + drawCount);

        sc.close();
    }
}
