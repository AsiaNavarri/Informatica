/*assignment:
create a program in java in which
5 numbers are drawn
between 1 and 90,
that they are not repeated,
insert them into a vector
and print it on the screen.
*/

import java.util.Random;    // Importing the library

public class es10_Extraction  // Creation class
{
    public static void main(String[] args)  // creation Main method
    {
        // Declaration and initialization of variables
        int[] ruota = new int[5];   // The array is a collection of data of the same type.

        System.out.println("Welcome to the Venice lottery\n");
        System.out.println("Extracted numbers: \n");

        // Invoking the method to control the numbers
        Numeri(ruota);

        // Displaying the extracted numbers
        for (int index = 0; index < ruota.length; index++)
        {
            System.out.println("Number" + (index + 1) + "=" + ruota[index]);
        }

    }//Closes main

    //Method to extract random numbers and ensure no repetition
    private static void Numeri(int[] ruota)
    {
        boolean ripetuto;

        for( int i=0; i< ruota.length; i++)
        {

            do
            {
                // Generating random numbers
                Random casuale = new Random();
                ripetuto= false;
                ruota[i]=casuale.nextInt(1, 90)+1;

                // Checking for repetition
                for( int j=0; j<i; j++)
                {
                    if(ruota[j]==ruota[i])
                    {
                        ripetuto=true;
                        break;
                    }
                }

            }while(ripetuto);
        }

    }// Closes Numbers

}// Closes class

