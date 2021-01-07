package practice12;

import java.util.Scanner;

public class practice12_6
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.print("Enter a hex number: ");
            String hexString = input.next();
            int decNumber = hexToDex(hexString);
            System.out.println("The decimal value for hex number " 
                + hexString + " is " + decNumber);
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex.toString() + " not a hex string.");
        }
    }

    public static int hexToDex(String hexString) throws NumberFormatException
    {
        int result = 0;
        for (int i = hexString.length() - 1; i >= 0; i--)
        {
            int judge = judge(hexString.charAt(i));
            if (judge == -1)
            {
                throw new NumberFormatException(hexString);
            }
            else
                result += judge * Math.pow(16, (hexString.length() - i - 1));
        }

        return result;
    }

    public static int judge(char ch)
    {
        if (ch >= '0' && ch <= '9')
        {
            return (ch - '0');
        }
        else if (ch >= 'A' && ch <= 'F')
        {
            return (ch - 'A' + 10);
        }
        else
            return -1;
    }
}
