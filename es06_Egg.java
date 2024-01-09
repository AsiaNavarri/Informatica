/* Assignment:
It takes 3 minutes to cook an egg.
Using the method created in the laboratory
create a program that allows you to
time the cooking of the egg
simulating the cooking phases
with created figures
using ASCII characters.
*/

public class es06_Egg // Class creation
{
    public static void main(String[] args) // Main function creation
    {
        // Set of system.out.println to represent the raw egg
        System.out.println("\n      .'''.     ");
        System.out.println("     :     :    ");
        System.out.println("    :       :               Raw Egg");
        System.out.println("    :       :   ");
        System.out.println("     '.___.'    ");
        System.out.println("________________ \n\n");

        // Invoke uovoCrudo function to wait for the specified time (3 sec)
        rawEgg();

        // Invoke ClrScr function to clear the screen
        clearScreen();

        // Set of system.out.println to represent the boiling egg
        System.out.println("\n      .'''.  ");
        System.out.println("     :     :  ");
        System.out.println("    :       :               The egg is boiling ");
        System.out.println("    :       :               Cooking time: 3 minutes");
        System.out.println("     '.___.'  ");
        System.out.println(" ____^_____^____  ");
        System.out.println("(///@///@///@///) ");
        System.out.println("__________________ \n\n");

        // Invoke boilingEgg function to wait for the specified time (3 min)
        boilingEgg();

        // Invoke ClrScr function to clear the screen
        clearScreen();

        // Set of system.out.println to represent the cooked egg
        System.out.println("\n        (       ");
        System.out.println("    (    )  (    ");
        System.out.println("     )  (   )   ");
        System.out.println("    (      (    ");
        System.out.println("      .'''.     ");
        System.out.println("     :  _  :    ");
        System.out.println("    :  ; ;  :               The egg is cooked ");
        System.out.println("    :  '_'  :   ");
        System.out.println("     '.___.'    ");
        System.out.println("________________ \n\n");

        // Invoke cookedEgg function to wait for the specified time (3 sec)
        cookedEgg();

        // Invoke ClrScr function to clear the screen
        clearScreen();
    }

    // Function to clear the screen
    private static void clearScreen() 
    {
        try // Handle exceptions (Does not interrupt the programs)
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // DOS commands to execute
        }

        catch (Exception e) // Handle exceptions (Does not interrupt the programs)
        {
            e.printStackTrace();
        }
    }

    // Function representing the raw egg
    private static void rawEgg() 
    {
        // Error handling
        try 
        {
            Thread.sleep(3000); // Pause program execution for the specified time (3000 milliseconds = 3 seconds)
        }

        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

    // Function representing the boiling egg
    private static void boilingEgg() 
    {
        // Error handling
        try 
        {
            Thread.sleep(180000); // Pause program execution for the specified time (180000 milliseconds = 3 minutes)
        }

        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

    // Function representing the cooked egg
    private static void cookedEgg() 
    {
        // Error handling
        try 
        {
            Thread.sleep(3000); // Pause program execution for the specified time (3000 milliseconds = 3 seconds)
        }

        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}
