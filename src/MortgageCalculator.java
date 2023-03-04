import java.util.Scanner;

/**
 * This program lets the user input mortgage, amortization and interest rates, housing fee and writes to the screen monthly cost
 *
 * @author Peter Hector
 */

public class MortgageCalculator
{
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {


        while (true)
        {
            // present menu choices
            menu();
            try
            {
                switch (input())
                {
                    case 1 -> calculateMortgage();
                    case 2 -> System.exit(0);
                    default -> System.out.println("Invalid input");
                }
            } catch (Exception e)
            {
                System.out.println("Invalid input");
                userInput.nextLine(); // clear input
            }
        }

    }

    /**
     * This function takes an int as parameter
     *
     * @return integer value
     */
    public static int input()
    {
        int inputvalue = userInput.nextInt();

        return inputvalue;
    }


    /**
     * This function prints a menu to the screen
     */
    public static void menu()
    {
        System.out.println("Calculate monthly cost based on current mortgage");
        System.out.println("--------------------------");
        System.out.println("1. Calculate monthly cost");
        System.out.println("2. Exit program");
        System.out.println("--------------------------");
        System.out.print("");
    }

    public static void calculateMortgage()
    {
        final int TWELVEMONTHS = 12;
        final int PERCENT = 100;
        double mortgage = 0, amortizationAmount = 0, interestRate = 0, housingFee = 0, monthlyCost = 0, sumMonthlyCost = 0;
        //userInput.useDelimiter("\\s"); // ignore whitespace


        System.out.println("Input number of mortgages: ");
        double noOfMortages = userInput.nextDouble();
        userInput.nextLine();


        for (int i = 0; i < noOfMortages; i++)
        {
            System.out.println("Input mortgage: ");
            mortgage = userInput.nextDouble();
            userInput.nextLine();
            System.out.println("Input amortization amount: ");
            amortizationAmount = userInput.nextDouble();
            userInput.nextLine();
            System.out.println("Input interest rate (%): ");
            interestRate = userInput.nextDouble();
            userInput.nextLine();
            System.out.println("Input current housing fee: ");
            housingFee = userInput.nextDouble();
            userInput.nextLine();

            // calculations
            monthlyCost = ((interestRate / PERCENT) * mortgage) / TWELVEMONTHS + amortizationAmount;
            sumMonthlyCost += monthlyCost;
            sumMonthlyCost += housingFee;
        }

        // print monthly cost
        System.out.println("##########################");
        System.out.printf("%s%.0f %s%n", "Monthly cost: ", sumMonthlyCost, "SEK");
        System.out.println("##########################");


    }


}