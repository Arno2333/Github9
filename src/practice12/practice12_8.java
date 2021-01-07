package practice12;
import java.util.Scanner;

class HexToDecUseHexFormatException
{
    String hexString;

    public HexToDecUseHexFormatException(String hexString)
        throws HexFormatException
    {
        setHexString(hexString);
    }

    public void setHexString(String hexString)
        throws HexFormatException
    {
        for (int i = 0; i < hexString.length(); i++)
        {
            if (judge(hexString.charAt(i)) == -1)
            {
                throw new HexFormatException(hexString + " is not a hex string");
            }
        }

        this.hexString = hexString;
    }

    public String getHexString()
    {
        return hexString;
    }

    private int judge(char ch)
    {
        if ((ch >= '0') && (ch <= '9'))
        {
            return (ch - '0');
        }
        else if ((ch >= 'A') && (ch <= 'F'))
        {
            return (ch - 'A' + 10);
        }
        else
            return -1;
    }

    public int hexToDec()
    {
        int result = 0;
        for (int i = hexString.length() - 1; i >= 0; i--)
        {
            result += judge(hexString.charAt(i)) * (Math.pow(16, (hexString.length() - i - 1)));
        }
        return result;
    }
}

class HexFormatException extends Exception
{
    String hexString;

    public HexFormatException(String hexString)
    {
        super("HexFormatException: " + hexString);
        this.hexString = hexString;
    }

    public String getHexString()
    {
        return hexString;
    }
}

public class practice12_8
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.print("Enter a hex string: ");
            HexToDecUseHexFormatException hex = 
                new HexToDecUseHexFormatException(input.next());
            System.out.println("The decimal value for hex number " 
                + hex.getHexString() + " is " + hex.hexToDec());
        }
        catch (HexFormatException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}