/* Assignment:
Create software that works like this:
- Menu with choice of whether to execute job 1, job 2 or job 3
- Job 1: cook lots of Christmas eggs until the user is tired
- Job 2: pay the bill for vegan burgers and reindeer burgers (they cost double) and non-alcoholic and alcoholic Christmas drinks (they cost double), communicated by the individual user. If you exceed 10 euros there is a 15% discount for amounts over 10 euros.
- Job 3: Print the entire receipt for the day.

Design with functional and technical analysis. Integrate each gap in the text with your own reasons
Build the code
Plan future improvements
*/

import java.util.Scanner;   // Input/output library import

public class es07_Jobs // Class creation
{
    private static double dailyEarnings = 0.00;   // Declaration and initialization of variables

    public static void main(String[] args)  // Main function
    {
        Scanner keyboard = new Scanner(System.in);
        
        // Program termination variable
        boolean endProgram = false;

        // Loop until specified program termination
        do {
            // Print various jobs
            System.out.println("Select the job to perform:");
            System.out.println("Job 1: Cook as many Christmas eggs until the user gets tired");
            System.out.println("Job 2: Pay the bill for vegan and reindeer burgers (cost double) and non-alcoholic and alcoholic Christmas drinks (cost double), as communicated by the user. If it exceeds 10 euros, there is a 15% discount on amounts over 10 euros.");
            System.out.println("Job 3: Print the total earnings of the day.");

            // Input request with error checking
            int input;
            do {
                System.out.print("\nChoice: ");
                input = keyboard.nextInt();

                if(input < 1 || input > 3)
                    System.out.println("Error: The entered number must be between 1 and 3");
            } while (input < 1 || input > 3);

            // Execution of the requested job
            switch(input) 
            {
                case 1 : CookEgg(keyboard);
                break;
                
                case 2 : BurgerBill(keyboard);
                break;
                
                case 3 : PrintEarnings();
                break;

                default : System.out.println("An error occurred during input validation");
                break;
            }

            // Request program termination
            System.out.print("If you want to end the program, type 'S': ");
            char userInput = keyboard.next().toUpperCase().charAt(0);
            
            // Input check
            if(userInput == 'S')
                endProgram = true;

        } while(!endProgram);

         // End of the program
        System.out.println("End of the program");
    }

    private static void CookEgg (Scanner input) // Main function
    {
        // Variable declaration
        char choice;

        // User input
        System.out.println("\nDo you want to eat an egg? Costs $3\nType 'S' if you want an egg: ");
        choice = input.next().toUpperCase().charAt(0);
        
        // Choice verification
        while (choice == 'S')
        {
            // Preparing the egg
            System.out.println("\nNow you get the egg");
            Sleep();
            System.out.println("\nHere is the cooked egg");
            dailyEarnings = dailyEarnings + 3.00;

            // Request for repetition
            System.out.println("\nDo you want to eat another egg?\nType 'S' if you want an egg: ");
            choice = input.next().toUpperCase().charAt(0);
        }
    }

    // Function to wait for a specified time
    private static void Sleep() 
    {
        try
        {
            Thread.sleep(8000); // "Locks" execution for the specified time (milliseconds)
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void BurgerBill(Scanner keyboard)
    {
        // Declaration and initialization of variables
        int quantity1, quantity2;
        int choice1, choice2;
        char input, repeat;
        double total=0;

        // Constants declaration
        final double burgerPrice=3.5;
        final double doubleBurgerPrice = burgerPrice * 2;
        final double drinkPrice=1.25;
        final double doubleDrinkPrice = drinkPrice * 2;

        do {
            // Menu selection
            System.out.println("Welcome!");
            System.out.println("Would you like to take a burger? Type S to confirm: ");
            input = keyboard.next().charAt(0);

            // Selection verification
            if(input=='s' || input=='S')
            {
                // Burger type selection
                do {
                    System.out.println("Choose a burger:\n1 - Vegan Burger\n2 - Reindeer Burger");
                    choice1=keyboard.nextInt();
                } while(choice1<1 || choice1>2);

                // Acquisition of the quantity of burgers to purchase
                do {
                    System.out.println("Quantity of burgers to purchase: ");
                    quantity1=keyboard.nextInt();
                } while(quantity1<=0);

                // Calculation of the price added to the total
                if(choice1==1)
                    total = total + (burgerPrice*quantity1);
                else
                    total = total + (doubleBurgerPrice*quantity1);
            }

            System.out.println("\nWould you like to buy a drink? Type S to confirm: ");
            input = keyboard.next().charAt(0);

            // Selection verification
            if(input=='s' || input=='S')
            {
                // Drink type selection
                do 
                {
                    System.out.println("Choose a drink:\n1 - Non-alcoholic\n2 - Alcoholic");
                    choice2=keyboard.nextInt();
                } while(choice2<1 || choice2>2);

                // Acquisition of the quantity of drinks to purchase
                do 
                {
                    System.out.println("Enter quantity: ");
                    quantity2=keyboard.nextInt();
                } while(quantity2<=0);

                // Calculation of the price added to the total
                if(choice2==1)
                    total+=drinkPrice*quantity2;
                else
                    total+=doubleDrinkPrice*quantity2;
            }

            // Display of the total amount to be paid on the screen
            System.out.println("The total amount to pay is "+total);
            
            // Request for a new purchase or closing the cash register
            do 
            {
                System.out.println("Would you like to make a new purchase? Type S to proceed, N to close the cash register");
                repeat=keyboard.next().charAt(0);
            } while(repeat!='s' && repeat!='S' && repeat!='n' && repeat!='N');
            
        } while(repeat=='s' || repeat=='S');

        // Calculation of the daily earnings
        dailyEarnings = dailyEarnings + total;
    }

    private static void PrintEarnings() // Function to print the total earnings of the day
    {
        System.out.println("Total earnings of the day: " + dailyEarnings + " euros");
    }
}
