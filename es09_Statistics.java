/*consegna:
delivery:
create a program in java in which
it is calculated how many times the values are output
of a dice rolled 100 times.
*/

import java.util.Random;    // import library
public class es09_Statistics  // class creation
{
    public static void main(String[] args)  // main method creation
    {
        // declaration and initialization of variables
        int [] frequenze  = new int[6];   // The array is a collection of data of the same type.
        int valore=0;

        // loop to repeat the extraction 100 times
        for( int i=0; i<100; i++)
        {
            valore = valoreRandom(0, 6);

            FacceDado(valore);  // invoke the FacceDado method

            frequenze[valore-1]++;  // increment the value of the frequency corresponding to the rolled face

            // print data to the screen
            for(int index=0; index<frequenze.length; index++)
            {
                System.out.println("Faccia"+(index+1)+"="+frequenze[index]);
            }
        }
    }

    private static int valoreRandom(int minValue, int maxValue) // method creation to extract a random number
    {
        Random casuale = new Random(); // Method with no parameters, called a constructor.

        return  casuale.nextInt(minValue,maxValue)+1;
    }

    private static void FacceDado(int valoreFaccia1)    // method creation to print dice faces to the screen
    {
        switch (valoreFaccia1)
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
}