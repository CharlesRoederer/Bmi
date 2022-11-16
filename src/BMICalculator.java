import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * converts and calculates user's BMI based on height and weight
 * @version 11/16/2022
 * @author me
 */
public class BMICalculator {
    /**
     * Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data
     * @param inches user's height in inches
     * @param pounds user's weight in pounds
     * @return User's BMI weight(kg)/height(m)^2 a double
     */
    public static double computeBMI(int inches,int pounds) {
        double kgs,meters;
        meters=inches*0.0254;
        kgs=pounds*0.454;
        if (inches <=0|| pounds<=0){
            return 0;
        }
        return kgs/(meters*meters);
    }

    /**
     /** Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information. */
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String userin =new String();
    int inches, pounds;
    DecimalFormat df= new DecimalFormat("0.00");
    while (true) {
        try {
            System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit: ");
            //System.out.println();
            userin = in.nextLine();
            if (userin.equals("0"))
                break;
            inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12;
            inches += Integer.parseInt(userin.substring(userin.indexOf("'") +1, userin.length()-1));
            //System.out.println("Debug: "+ inches);
            System.out.print("Enter your weight in pounds: ");
            //System.out.println();
            userin = in.nextLine();
            pounds= Integer.parseInt(userin);
            System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches,pounds)) + " kg/m^2");
        }
        catch (Exception e) {
            System.out.println("There was an error, see here: " + e.toString());
        }
    }
        
    }
}
