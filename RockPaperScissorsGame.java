import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please make your move ([r]ock, [p]aper, [s]cissors) or (stop) to end the game: ");
        String playerMove = scan.nextLine();
        int gamesPlayed = 0;

        while (!playerMove.equalsIgnoreCase("stop")) {
            if (!playerMove.equalsIgnoreCase("rock") && !playerMove.equalsIgnoreCase("r")
                    && !playerMove.equalsIgnoreCase("paper") && !playerMove.equalsIgnoreCase("p")
                    && !playerMove.equalsIgnoreCase("scissors") && !playerMove.equalsIgnoreCase("s")) {
                System.out.println("Wrong input, try again!");
            } else {
                String player = (setPlayerMove(playerMove)); //determine player's move
                String computer = (setComputerMove());//determine computer's move
                System.out.printf("Computer has chosen - %s.%n", computer);
                findWinner(player, computer);// compare player's vs computer's choice
                gamesPlayed++;
                System.out.printf("Games played so far %d.%n", gamesPlayed);
            }
            System.out.print("Please make your move ([r]ock, [p]aper, [s]cissors) or (stop) to end the game: ");
            playerMove = scan.nextLine();
        }
        if (playerMove.equalsIgnoreCase("stop")) {
            System.out.printf("You stopped the game. %d games played total.", gamesPlayed);
        }
    }

    public static void findWinner(String p, String c) {
        if ((p.equals("paper") && c.equals("rock")) || (p.equals("rock") && c.equals("scissors"))
                || (p.equals("scissors") && c.equals("paper"))) {
            System.out.println("You won!");
        } else if ((c.equals("paper") && p.equals("rock")) || (c.equals("rock") && p.equals("scissors"))
                || (c.equals("scissors") && p.equals("paper"))) {
            System.out.println("Computer won!");
        } else {
            System.out.println("Draw");
        }
    }

    public static String setComputerMove() {
        Random rd = new Random();
        int computerRandomInt = rd.nextInt(3);
        String[] possibleMoves = new String[]{"rock", "paper", "scissors"};
        return possibleMoves[computerRandomInt];
    }

    public static String setPlayerMove(String playerMove) {
        if (playerMove.equalsIgnoreCase("rock") || playerMove.equalsIgnoreCase("r")) {
            return "rock";
        } else if (playerMove.equalsIgnoreCase("paper") || playerMove.equalsIgnoreCase("p")) {
            return "paper";
        } else if (playerMove.equalsIgnoreCase("scissors") || playerMove.equalsIgnoreCase("s")) {
            return "scissors";
        }
        return playerMove;
    }
}
