package practice12;
import java.util.Scanner;

public class practice12_7
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.print("Enter a binary string: ");
            String str = input.next();
            System.out.println("The binary value for decimal number " + str + " is " + bin2Dex(str));
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex.getMessage() + " not a decimal string");
        }

    }

    public static int bin2Dex(String str) throws NumberFormatException
    {
        int result = 0;
        for (int i = str.length() - 1; i >= 0; i--)
        {
            if (!(str.charAt(i) == '0' || str.charAt(i) == '1'))
            {
                throw new NumberFormatException(str);
            }
            else
                result += Math.pow(2, (str.length() - i - 1)) * (str.charAt(i) - '0');
        }

        return result;
    }
}