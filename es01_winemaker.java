/*Assignment: 
To carry out an advertising campaign, a wine merchant launches a sales campaign for Barbera wine in bottles.
Design and code a program that 
allows determining the total amount each customer has to pay, 
considering that the applied VAT is 21%.
Project Specifications:
-Each bottle has a capacity of 1.5L.
-The cost per liter is 1 Euro.
Print the receipt with the following information for each customer:
-The number of purchased bottles.
-The total selling price (cost per liter multiplied by liters).
Calculate the applied VAT on the taxable total.
The total selling price including VAT.
Code the proposed program in Java.
*/

import java.util.Scanner; // input/output library inclusion

public class es01_winemaker
{
	public static void main(String[] args) 
	{
        // declaration and initialization of variables 
        int numberOfBottles;
        double bottleCapacity = 1.5, literCost = 1, vatPercentage = 21, totalCost, totalWithVat, vat;
		
		// acquiring the number of purchased bottles from the keyboard
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of purchased bottles: ");
        numberOfBottles = scanner.nextInt();
		
		// calculating the cost, applied VAT, and the price with included VAT
        totalCost = numberOfBottles * bottleCapacity * literCost;
        vat = (totalCost * vatPercentage) / 100;
        totalWithVat = totalCost + vat;
		
		// printing the receipt
        System.out.println("Number of purchased bottles: " + numberOfBottles);
        System.out.println("Total cost: " + totalCost + " euros");
        System.out.println("Applied VAT: " + vat + " euros");
        System.out.println("Total price including VAT: " + totalWithVat + " euros");
	}
}
