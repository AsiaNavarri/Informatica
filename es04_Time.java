/* Assignment:
Enter an integer that
represents the seconds elapsed since the beginning of today
and outputs the current time expressed in hh:mm:ss (hours:minutes:seconds).
If the user enters a null value or a value greater than one day
ask for reinstatement.
Example 1:
102(seconds) = 0(hours):1(minute):42(seconds);
Example 2:
6662(seconds) = 1(hour):51(minutes):2(seconds)
*/

import java.util.Scanner;

public class es04_Time
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        // Declaration and initialization of variables
        int n, sec, min = 0, hours = 0;

        // Acquiring the number of seconds from the user
        System.out.println("Enter the number of seconds elapsed since the beginning of the day: ");
        n = keyboard.nextInt();

        // Verifying the entered number
        while(n <= 0 || n > 86400)
        {
            if(n <= 0)
            {
                System.out.println("The entered number is not valid");
                System.out.println("Enter a number > 0: ");
                n = keyboard.nextInt();
            }
            else
            {
                System.out.println("The entered number is not valid");
                System.out.println("Enter a number < 86400: ");
                n = keyboard.nextInt();
            }
        }

        sec = n;

        // Calculating minutes
        while (sec >= 60)
        {
            sec = sec - 60;
            min = min + 1;
        }

        // Calculating hours
        while (min >= 60)
        {
            min = min - 60;
            hours = hours + 1;
        }

        // Displaying the time
        System.out.println("The number of seconds: " + n);
        System.out.println("\nCorresponds to the time: " + hours + " (hours) : " + min + " (minutes) : " + sec+ " (seconds)");
        System.out.println("\n(The time is expressed in the format hh:mm:ss)");
    }
}

