package practice12;
import java.util.Scanner;
public class practice12_9 {
	public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.print("Enter a bin string: ");
            Bin2DecUseBinaryFormatException bin = new
                 Bin2DecUseBinaryFormatException(input.next());
            System.out.println("The binary value for decimal number " +
                bin.getBinString() + " is " + bin.bin2Dec());
        }
        catch (BinaryFormatException ex)
        {
            System.out.println(ex.getMessage());
        }
}
class  BinaryFormatException extends Exception
{
    String binString;

    public BinaryFormatException(String binString)
    {
        super(binString);
        this.binString = binString;
    }

    public String getBinString()
    {
        return binString;
    }
}
class Bin2DecUseBinaryFormatException
{
    String binString;

    public  Bin2DecUseBinaryFormatException(String binString)
        throws BinaryFormatException
    {
        setBinString(binString);
    }

    public void setBinString(String binString)
        throws BinaryFormatException
    {
        for (int i = 0; i <  binString.length(); i++)
        {
            if ((binString.charAt(i) != '0') && (binString.charAt(i) != '1'))
            {
                throw new BinaryFormatException(binString + " is not a binary string");
            }
        }

        this.binString = binString;
    }

    public String getBinString()
    {
        return binString;
    }

    public int bin2Dec()
    {
        int result = 0;
        for (int i = binString.length() - 1; i >= 0; i--)
        {
            result += (binString.charAt(i) - '0') * Math.pow(2, binString.length() - i - 1);
        }

        return result;
    }
}
