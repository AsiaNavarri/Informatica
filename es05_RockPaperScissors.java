/* Assignment:
Carry out the Chinese morra program.
In which:
2 players can choose between: rock, paper and scissors.
Rules:
paper wins over stone
rock wins over scissors
scissors win on paper

The game must be made in such a way that i
two players can challenge each other
using the keyboard.
It is supposed to be for the first player
enabled to use the keys
A = paper, S = rock, D = scissors,
while for the second
J = paper,K = rock,L = scissors.
Key typing does not have to be
visible.

Project specifications:
- race C( valid only if the values read in input
belong to the set of validityC;
- The program must repeat untilC( one of the two
players does not enter <X>;.
*/

import java.util.Scanner;   // Input/output library

public class es05_RockPaperScissors
{
    public static void main (String[]args)
    {
        Scanner scanner = new Scanner (System.in);

        // Declaration and initialization of variables
        boolean game = true;
        char player1Choice = 0, player2Choice = 0;
        int winner;

        // Displaying commands
        System.out.println ("Player 1: A = paper, S = rock, D = scissors");
        System.out.println ("Player 2: J = paper, K = rock, L = scissors");
        System.out.println ("Press 'X' to exit");

        while (game)
        {
            // Reading player 1's choice
            System.out.print ("\nPlayer 1, enter a letter (A/S/D): ");
            player1Choice = scanner.next ().toUpperCase ().charAt (0);
            clearScreen ();

            // Checking if the game should continue
            if (player1Choice == 'X')
            {
                System.out.print ("\nEnd of the game");
                game = false;
            }
            else
            {
                // Validating player 1's choice
                while (player1Choice != 'A' && player1Choice != 'S' && player1Choice != 'D')
                {
                    System.out.println ("Invalid input. Try again.");
                    player1Choice = scanner.next ().toUpperCase ().charAt (0);
                    clearScreen ();
                }
            }

            // Reading player 2's choice
            if (game)
            {
                System.out.print ("\nPlayer 2, enter a letter (J/K/L): ");
                player2Choice = scanner.next ().toUpperCase ().charAt (0);
                clearScreen ();

                // Checking if player 2 wants to play
                if (player2Choice == 'X')
                {
                    System.out.print ("\nEnd of the game");
                    game = false;
                }
                else
                {
                    // Validating player 2's choice
                    while (player2Choice != 'J' && player2Choice != 'K' && player2Choice != 'L')
                    {
                        System.out.println ("Invalid input. Try again.");
                        player2Choice = scanner.next ().toUpperCase ().charAt (0);
                        clearScreen ();
                    }
                }
            }

            if (game)
            {
                // Determining the winner
                winner = determineWinner (player1Choice, player2Choice);

                // Displaying the result of the game
                if (winner == 0)
                {
                    System.out.println ("It's a tie!");
                }
                else if (winner == 1)
                {
                    System.out.println ("Player 1 wins!");
                }
                else
                {
                    System.out.println ("Player 2 wins!");
                }
            }
        }

        scanner.close ();
    }

    // Creating a function to determine the winner
    private static int determineWinner (char player1Choice, char player2Choice)
    {
        // Cases of a tie
        if ((player1Choice == 'A' && player2Choice == 'J') ||
            (player1Choice == 'S' && player2Choice == 'L') || 
            (player1Choice == 'D' && player2Choice == 'L'))
        {
            return 0;
        }

        // Cases where player 1 wins
        else if ((player1Choice == 'A' && player2Choice == 'K') ||
                (player1Choice == 'S' && player2Choice == 'A') || 
                (player1Choice == 'D' && player2Choice == 'J'))
        {
            return 1;
        }

        // Cases where player 2 wins
        else
        {
            return 2;
        }
    }

    // Creating a function to clear the screen
    private static void clearScreen ()
    {
        try
        {
            new ProcessBuilder ("cmd", "/c", "cls").inheritIO ().start ().waitFor ();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
}