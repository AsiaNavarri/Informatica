/*Assignment:
Wine bottle acquisition,

Bottle capacity = 1.5L
VAT = 21%
Available wine types:
1-Barbera 1.5 Euro per Liter
2-Lugana 2 Euro per Liter
3-Merlot 1 Euro per Liter.

Calculate and print:
Purchased bottle count,
Price without VAT,
Price with VAT
*/  

import java.util.Scanner; //input/output library inclusion

public class es02_winemaker 
{
  
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        
        //declaration and initialization of variables 
        int bottleCount = 0, customerCount = 0;   //integer variables
        double liters, price, vat, totalCost = 0;   //double variables 
        final double capacity = 1.5, barberaCost = 1.5, luganaCost = 2, merlotCost = 1;  //constants
        String response, choice;

        do   
        {
            //acquire the type of wine to purchase    
            System.out.println("Enter the type of wine:\nAvailable Wines:\n BARBERA\n LUGANA\n MERLOT\n ");
            choice = keyboard.nextLine().toUpperCase();
                
            //verify the wine choice
            if (choice.equals("BARBERA"))
            {
                //acquire the number of bottles to purchase
                System.out.println("Enter the number of bottles to purchase: ");
                bottleCount = keyboard.nextInt();
                    
                //verify the entered bottle count
                while (bottleCount < 0)    
                {
                        
                    System.out.println("Invalid value entered");

                    //acquire the new value    
                    System.out.println("Enter the number of bottles to purchase: ");
                    bottleCount = keyboard.nextInt();
                    
                }

                //perform calculations
                liters = capacity * bottleCount; //calculate the number of liters
                price = liters * barberaCost; //calculate the price without VAT
                vat = (price * 21) / 100 + price; //calculate applied VAT
                totalCost = totalCost + vat; //calculate the price with VAT
                    
                //print the receipt
                System.out.println("Number of purchased bottles: " + bottleCount);
                System.out.println("Price without VAT = \n" + bottleCount + "x" + capacity + "x" + barberaCost + "= " + price + " Euro");
                System.out.println("Price with VAT: " + vat + " Euro");

                //calculate the number of served customers
                customerCount = customerCount + 1;
                
            }
            
            //verify the wine choice
            else if (choice.equals("LUGANA"))
            {
                //acquire the number of bottles
                System.out.println("Enter the number of bottles to purchase: ");
                bottleCount = keyboard.nextInt();

                //verify the entered value
                while (bottleCount < 0)
                {    
                    System.out.println("Invalid value entered");    
                    //acquire the new value
                    System.out.println("Enter the number of bottles to purchase: ");
                    bottleCount = keyboard.nextInt();
                }
                    
                //perform calculations
                liters = capacity * bottleCount; //calculate the number of liters
                price = liters * luganaCost; //calculate the price without VAT
                vat = (price * 21) / 100 + price; //calculate applied VAT
                totalCost = totalCost + vat; //calculate the price with VAT
                
                //print the receipt
                System.out.println("Number of purchased bottles: " + bottleCount);   
                System.out.println("Price without VAT = \n" + bottleCount + "x" + capacity + "x" + luganaCost + "= " + price + " Euro");
                System.out.println("Price with VAT: " + vat + " Euro");
                
                //calculate the number of customers
                customerCount = customerCount + 1;

            }
                
            //verify the entered wine type
            else if (choice.equals("MERLOT"))    
            {
                //acquire the number of bottles
                System.out.println("Enter the number of bottles to purchase: ");    
                bottleCount = keyboard.nextInt();
                        
                //verify the entered value
                while (bottleCount < 0)
                {    
                    System.out.println("Invalid value entered");
                    //acquire the new value    
                    System.out.println("Enter the number of bottles to purchase: ");
                    bottleCount = keyboard.nextInt();
                        
                }
                        
                //perform calculations
                liters = capacity * bottleCount; //calculate the number of liters
                price = liters * merlotCost; //calculate the price without VAT
                vat = (price * 21) / 100 + price; //calculate applied VAT
                totalCost = totalCost + vat; //calculate the price with VAT
                        
                //print the receipt
                System.out.println("Number of bottles purchased: " + bottleCount);
                System.out.println("Price without VAT = \n" + bottleCount + "x" + capacity + "x" + merlotCost + "= " + price + " Euro");
                System.out.println("Price with VAT: " + vat + " Euro");
                        
                //calculate the number of served customers
                customerCount = customerCount + 1;
                
            }
            
            else
            {      
                System.out.println("No wine selected, type anything to confirm");
            }   
            
            //acquire response
            response = keyboard.nextLine().toUpperCase();   
            System.out.println("Another customer? (Y/N)");
            response = keyboard.nextLine().toUpperCase();
                
        } while (response.equals("Y")); //verify the choice
            
        //cash register closure
        System.out.println("-----------------------------------");
        System.out.println("\nClosed Cash Register");
        System.out.println("Number of served customers: " + customerCount);
        System.out.println("Total Expense: " + totalCost + " Euro");
            
    }
}
