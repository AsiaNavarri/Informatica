/*Delivery:
Modify the dice game so that,
through a menu,
you can play between two players
or against the computer.

=== APP Dice Game ===
[1] Challenge between two players
[2] Challenge against the computer
[3] Quit
*/

// Importing libraries
import java.util.Random;
import java.util.Scanner;

public class es11_DiceGame // Class creation
{
    public static void main(String[] args)  // Main function creation
    {
        Scanner keyboard = new Scanner(System.in);   // Scanner constructor method
        // Declaration and initialization of variables
        int scelta = 0;
        boolean exit = true;

        // Game mode selection
        do
        {
            ClrScr();   // Invoke clear screen method
            Menù(); // Invoke menu method


            // User choice
            scelta = keyboard.nextInt();
            ClrScr();

            switch (scelta)
            {
                case 1:
                    System.out.println("Sfida tra due giocatori: ");

                    // Invoke 2 players method
                    DueGiocatori();
                    Wait(2000);
                    break;

                case 2:
                    System.out.println("Sfida contro il computer: ");

                    // Invoke computer method
                    Computer();
                    Wait(2000);
                    break;

                case 3:
                    exit = false;
                    Wait(2000);
                    break;

                default:
                    System.out.println("Scelta errata ");
                    Wait(200);

            }
        }while (exit);
    }

    // Method to display the menu
    private static void Menù ()
    {
        System.out.println("=== APP Gara Dadi === ");
        System.out.println("[1] [1]-Sfida tra due giocatori ");
        System.out.println("[2] Sfida contro il computer ");
        System.out.println("[3] Exit ");
    }

    // Method for 2 players mode
    public static void DueGiocatori()
    {
        Random faccia = new Random();

        // Variables declaration
        int valoreFaccia1=0, valoreFaccia2=0, vincitore;

        // Player 1 dice roll
        System.out.println("Dado gicatore 1: \n");

        for(int i = 1; i <= 7; i++)
        {
            if (i == 7)
            {
                Wait(500);
                ClrScr();
                System.out.println("E' uscito il numero: ");
                valoreFaccia1 = faccia.nextInt(0, 6) + 1;
            }

            else
            {
                Wait(500);
                ClrScr();
                valoreFaccia1 = i;
            }

            FacceDado(valoreFaccia1);
        }

        Wait(2000);

        // Player 2 dice roll
        System.out.println("\nDado giocatore 2: \n");
        for(int i = 1; i <= 7; i++)
        {
            if (i == 7)
            {
                Wait(500);
                ClrScr();
                System.out.println("E' uscito il numero: ");
                valoreFaccia2 = faccia.nextInt(0, 6) + 1;
            }

            else
            {
                Wait(500);
                ClrScr();
                valoreFaccia2 = i;
            }

            FacceDado(valoreFaccia2);
        }

        Wait(2000);

        // Display the winner on the screen
        vincitore= DeterminaVincitore ( valoreFaccia1,valoreFaccia2);

        if (vincitore == 0)
        {
            System.out.println ("Pareggio!");
        }

        else if (vincitore == 1)
        {
            System.out.println ("Giocatore 1 vince!");
        }

        else if (vincitore == 2)
        {
            System.out.println ("Giocatore 2 vince!");
        }

    }

    // Method for computer mode
    public static void Computer()
    {
        Random faccia = new Random();

        // Variables declaration
        int valoreFaccia1=0, valoreFaccia2=0, vincitore;

        // Player's dice roll
        System.out.println("E' il tuo turno: \n");

        for(int i = 1; i <= 7; i++)
        {
            if (i == 7)
            {
                Wait(500);
                ClrScr();
                System.out.println("E' uscito il numero: ");
                valoreFaccia1 = faccia.nextInt(0, 6) + 1;
            }

            else
            {
                Wait(500);
                ClrScr();
                valoreFaccia1 = i;
            }

            FacceDado(valoreFaccia1);
        }

        Wait(2000);

        // Computer's dice roll
        System.out.println("\nTurno del computer: \n");
        for(int i = 1; i <= 7; i++)
        {
            if (i == 7)
            {
                Wait(500);
                ClrScr();
                System.out.println("E' uscito il numero: ");
                valoreFaccia2 = faccia.nextInt(0, 6) + 1;
            }

            else
            {
                Wait(500);
                ClrScr();
                valoreFaccia2 = i;
            }

            FacceDado(valoreFaccia2);
        }

        Wait(2000);

        // Display the winner on the screen
        vincitore= DeterminaVincitore ( valoreFaccia1,valoreFaccia2);

        if (vincitore == 0)
        {
            System.out.println ("Pareggio!");
        }

        else if (vincitore == 1)
        {
            System.out.println ("Hai vinto!");
        }

        else if (vincitore == 2)
        {
            System.out.println ("Il computer vince!");
        }

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

    // Method to print the dice faces on the screen
    private static void FacceDado(int valoreFaccia)
    {
        switch (valoreFaccia) //utilizzo switch case per visualizzare le facce del dado
        {
            case 1 :
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
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

    //metodo per determina il vincitore
    private static int DeterminaVincitore (int valoreFaccia1, int valoreFaccia2)
    {
        //caso di pareggio
        if (valoreFaccia1==valoreFaccia2)
        {
            return 0;
        }

        //caso in cui giocatore 1 vince
        else if (valoreFaccia1>valoreFaccia2)
        {
            return 1;
        }

        //caso in cui giocatore 2 vince
        else if (valoreFaccia1<valoreFaccia2)
        {
            return 2;
        }
        else
        {
            return 3;
        }

    }
}

