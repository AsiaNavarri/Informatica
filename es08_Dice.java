/* Assignment:
create a program in java in which
a competition can be held between two players,
who will throw dice,
determining the winner.
*/

// Importing library
import java.util.Random;

public class es08_Dice  // Class creation
{
    public static void main(String[] args)  // Main function
    {
        Random face = new Random();

        // Declaration of variables
        int faceValue1 = 0, faceValue2 = 0, winner;

        // Player 1's dice roll
        System.out.println("Player 1's Dice: \n");

        for(int i = 1; i <= 7; i++)
        {
            if (i == 7)
            {
                Wait();
                ClrScr();
                System.out.println("It landed on: ");
                faceValue1 = face.nextInt(6) + 1;
            }

            else
            {
                Wait();
                ClrScr();
                faceValue1 = i;
            }

            DiceFaces(faceValue1);
        }

        Wait2();
        // Player 2's dice roll
        System.out.println("\nPlayer 2's Dice: \n");
        for(int i = 1; i <= 7; i++)
        {
            if (i == 7)
            {
                Wait();
                ClrScr();
                System.out.println("It landed on: ");
                faceValue2 = face.nextInt(6) + 1;
            }

            else
            {
                Wait();
                ClrScr();
                faceValue2 = i;
            }

            DiceFaces(faceValue2);
        }

        Wait2();
        // Determination and display of the winner
        winner = DetermineWinner(faceValue1, faceValue2);

        if (winner == 0)
        {
            System.out.println ("It's a tie!");
        }

        else if (winner == 1)
        {
            System.out.println ("Player 1 wins!");
        }

        else if (winner == 2)
        {
            System.out.println ("Player 2 wins!");
        }

    }

    private static void DiceFaces(int faceValue) // Function to display the dice faces on the screen
    {
        // ALT + 201 ╔
        // ALT + 188 ╝
        // ALT + 187 ╗
        // ALT + 200 ╚
        // ALT + 205 ═
        // ALT + 186 ║

        switch (faceValue) // Switch case used to display the dice faces
        {
            case 1 :
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 2 :
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 3 :
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 :
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 :
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 :
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }

    // Function to determine the winner
    private static int DetermineWinner (int faceValue1, int faceValue2)
    {
        // Tie case
        if (faceValue1 == faceValue2)
        {
            return 0;
        }

        // Player 1 wins case
        else if (faceValue1 > faceValue2)
        {
            return 1;
        }

        // Player 2 wins case
        else if (faceValue1 < faceValue2)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }

    private static void ClrScr()    // Function to clear the screen
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void Wait()  // Function to "pause" the program for 200 milliseconds (0.2 sec)
    {
        try
        {
            Thread.sleep(200);
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void Wait2()  // Function to "pause" the program for 2000 milliseconds (2 sec)
    {
        try
        {
            Thread.sleep(2000);
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
