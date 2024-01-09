/* Assignment:
Given a binary value composed of n digits, 
determine if it is a byte
(8 bits and must contain only binary values) 
and convert it to a decimal value.
*/

import java.util.Scanner;   //input/output library inclusion

public class es03_ByteBinDec
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        //declaration and initialization of variables 
        String nBin;
        boolean flagByte = true;
        int valChar = (int)'0';
        char valInt;
        int position, dec = 0, i = 0, base = 2;
        
        //acquire binary value from the keyboard
        System.out.println("Enter a binary number \n(consisting only of 0/1 values and having 8 digits): \n");
        nBin = keyboard.nextLine();

        //verify the number of digits in the entered number
        if (nBin.length()==8)
        {
            //verify that all digits are binary
            for(i = 0; i < nBin.length(); i++)
            {   
                if (!(nBin.charAt(i) == '0'  || nBin.charAt(i) == '1'))
                {
                  flagByte = false;
                }
            }
            
            if (flagByte)
            {
                //convert to decimal
                for(i = 0; i < nBin.length(); i++)
                {
                    valInt = nBin.charAt(i);
                    valChar = valInt - '0';
                    dec = dec * base + valChar;
                }
                
                //output the result
                System.out.println("It is a byte");
                System.out.println("In decimal, it corresponds to: " + dec);
                
            }
            else
            {
                //output the result
                System.out.println("It is not a byte");
            }
        }
        else
            //output the result
            System.out.println("It is not a byte");

    }
}
