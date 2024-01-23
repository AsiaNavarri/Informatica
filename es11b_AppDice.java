/*Delivery:
Modify the exercise to include the menu seen in class.
Remove any redundancies present within the exercise.
Make a "please" improvement to the exercise.
*/

// Importing libraries
import java.util.Random;
import java.util.Scanner;

public class es11b_AppDice  // Creating the class
{
    public static void main(String[] args)  // Creating the main method
    {
        Scanner keyboard = new Scanner(System.in);   // Scanner constructor
        // Declaration and initialization of variables
        int scelta=0;
        int valoreFaccia1 = 0, valoreFaccia2 = 0, vincitore;
        String giocatore1 = "";
        String giocatore2 = "";

        // Array of strings containing a set of constant values
        String[] opzioni =
                {
                        "=== APP Gara Dadi ===",
                        "[1]-Sfida tra due giocatori",
                        "[2]-Sfida contro il computer",
                        "[3]-Fine"
                };

        scelta=menu(opzioni, keyboard);
        Wait(2000);

        if(scelta!=3) {
            if (scelta == 1) {
                System.out.println("Inserisci il nome del primo giocatore: ");
                // Acquiring player1's name
                giocatore1 = keyboard.nextLine();
            }


            if (scelta == 1) {
                System.out.println("Inserisci il nome del secondo giocatore: ");
                // Acquiring player2's name
                giocatore2 = keyboard.nextLine();
            }

            Random faccia = new Random();
            // Rolling the die for player1
            if (scelta == 1) {
                System.out.println("Turno di " + giocatore1 + ":\n");
            } else if (scelta == 2) {
                System.out.println("E' il tuo turno:\n");
            }

            for (int i = 1; i <= 7; i++) {
                if (i == 7) {
                    Wait(500);
                    ClrScr();
                    System.out.println("E' uscito il numero: ");
                    valoreFaccia1 = faccia.nextInt(0, 6) + 1;
                } else {
                    Wait(500);
                    ClrScr();
                    valoreFaccia1 = i;
                }

                FacceDado(valoreFaccia1);
            }

            Wait(2000);
            // Rolling the die for player2/computer


            if (scelta == 1) {
                System.out.println("Turno di " + giocatore2 + ":\n");
            } else if (scelta == 2) {
                System.out.println("\nTurno del computer: \n");
            }

            for (int i = 1; i <= 7; i++) {
                if (i == 7) {
                    Wait(500);
                    ClrScr();
                    System.out.println("E' uscito il numero: ");
                    valoreFaccia2 = faccia.nextInt(0, 6) + 1;
                } else {
                    Wait(500);
                    ClrScr();
                    valoreFaccia2 = i;
                }

                FacceDado(valoreFaccia2);
            }

            Wait(1000);

            // Displaying the winner on the screen
            vincitore = DeterminaVincitore(valoreFaccia1, valoreFaccia2);

            if (vincitore == 0) {
                System.out.println("Pareggio!");
            } else if (vincitore == 1) {
                if (scelta == 1) {
                    System.out.println(giocatore1 + " vince!");
                } else if (scelta == 2) {
                    System.out.println("Vince il computer!");
                }
            } else if (vincitore == 2) {
                if (scelta == 1)
                    System.out.println(giocatore2 + " vince!");
                else if (scelta == 2) {
                    System.out.println("Vince il computer!");
                }
            }
        }

        }// Closing main method


    // Method to display the menu and acquire the choice
    private static int menu(String opzioni[], Scanner keyboard)
    {
        int scelta;

        do
        {
            ClrScr();

            // Displaying the title
            System.out.println("-----------------------");
            System.out.println(opzioni[0]);
            System.out.println("-----------------------");
            // Displaying the menu
            for (int i = 1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);

            }

            // Acquiring the choice
            scelta = keyboard.nextInt();

            // Verifying the choice
            if ((scelta < 1) || (scelta > opzioni.length - 1))
            {
                System.out.println("Opzione sbagliata");
                Wait(1000);
            }

        } while ((scelta < 1) || (scelta > opzioni.length - 1));

        keyboard.nextLine();
        return scelta;
    }

    // Method to clear the screen
    private static void ClrScr()
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

    // Method to pause the program for a defined time
    private static void Wait(int attesa)
    {
        try
        {
            Thread.sleep(attesa);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    // Method to display the faces of the dice on the screen
    private static void FacceDado(int valoreFaccia)
    {
        switch (valoreFaccia) //utilizzo switch case per visualizzare le facce del dado
        {
            case 1:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 2:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 3:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }//Closing dice faces method

    // Method to determine the winner
    private static int DeterminaVincitore (int valoreFaccia1, int valoreFaccia2)
    {
        // Case of a tie
        if (valoreFaccia1==valoreFaccia2)
        {
            return 0;
        }

        // Case where player 1 wins
        else if (valoreFaccia1>valoreFaccia2)
        {
            return 1;
        }

        // Case where player 2 wins
        else if (valoreFaccia1<valoreFaccia2)
        {
            return 2;
        }
        else
        {
            return 3;
        }

    }// Closing determine winner method

}   // Closing class

