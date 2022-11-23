package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Class App
 * @version 1.0
 */
public class App {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try
            {
                try
                {
                    Equations eq = new Equations();
                    out.print("Enter X: ");
                    fout.print(eq.calculate(in.nextInt()));
                }
                finally
                {
                    fout.flush();
                    fout.close();
                }
            }
            catch (CalcException ex)
            {
                out.print(ex.getMessage());
            }
        }
        catch (FileNotFoundException ex)
        {
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}

/**
 * Class CalcException
 * @version 1.0
 */
class CalcException extends ArithmeticException
{
    public CalcException(){}

    public CalcException(String cause)
    {
        super(cause);
    }
}

/**
 * Class Equations
 * @version 1.0
 */
class Equations
{
    /**
     * Method for calculating
     * @param x input value
     * @throws CalcException
     */
    public double calculate(int x) throws CalcException
    {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try
        {
            y = (x - 4) / Math.sin(3 * x - 1);
            if (y==Double.NaN || y==Double.NEGATIVE_INFINITY || y==Double.POSITIVE_INFINITY || x==90 || x== -90)
                throw new ArithmeticException();
        }
        catch (ArithmeticException ex)
        {
            if (rad==Math.PI/2.0 || rad==-Math.PI/2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");

            else if (x==0)
                throw new CalcException("Exception reason: X = 0");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
        }
        return y;
    }
}