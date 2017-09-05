import java.util.*;
import java.math.*;
import java.text.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
  * FormatServices abstract class is used for output and format relevant data to the program.
*/
public abstract class FormatServices{
  /**
    * Make space from String to the right
    * @param s is the value
    * @param n is the number of space needed for output.
  */
	public static void padRight(String s, int n) {
   	 	System.out.print(String.format("%1$-" + n + "s", s));
  	}
  	/**
    * Make space from String to the left
    * @param s is the value
    * @param n is the number of space needed for output.
  */
    public static void padLeft(String s, int n) {
    	System.out.print(String.format("%1$" + n + "s", s));
  	}
    /**
      * Repeat a string * n times.
      * @param name of value.
      * @param n is the amount to repeat.
      * @return the string 
    */
  	public static String repeatValue(String name, int n){
  		StringBuilder s = new StringBuilder();
  		for(int i=0; i < n; i++){
  			s.append(name);
  		}
  		return s.toString();
  	}
   	/**
      * newLine for the current output.
    */
  	public static void newLine(){
  		System.out.println();
  	}
    /**
      * Makes sure there isn't whitespaces in the current string
      * @param name contains the incoming value
      * @return the string without whitespaces.
    */
  	 public static String removeSpaces(String name){
		return name.replaceAll("\\s+",""); 
	}
  /**
    * convert incoming string to currency leaving the numeric values.
    * @param money is incoming value
    * @return new BigDecimal value of currency.
    * @return null if string could not be converted to big decimal currency.
  */
	public static BigDecimal convertCurrencyToNumeric(String money){
		try{
			NumberFormat format = NumberFormat.getCurrencyInstance();
			format.setMinimumFractionDigits(2);
      format.setMaximumFractionDigits(2);
			Number number = format.parse(money);
			return new BigDecimal(number.doubleValue());
		}
		catch(ParseException e){
		}
		return null;
    }
    /**
    * convert incoming string to currency leaving the numeric values.
    * @param money is incoming value
    * @return new integer value of currency.
  */
    public static int convertCurrencyToInt(String money){
        BigDecimal d = FormatServices.convertCurrencyToNumeric(money);
        d = d.multiply(new BigDecimal(100.00));
        d = d.setScale(2, BigDecimal.ROUND_HALF_UP);
        return d.intValue();
    }
    /**
      * Output a two dimensional array
      * @param sum contains solution combinations solution from 0 to targetprice and the nList.
      * @param nList is the size of order list.
    */
    public static void outputTwoDimensionalSolution(boolean[][] sum, int targetPrice, int nList){
        for (int i = 0; i <= targetPrice; i++)
         {
           for (int j = 0; j <= nList; j++)
             System.out.print(sum[i][j]);
         } 
         System.out.println();
    }
    /**
      * Outputs the filename.
    */
    public static void getFilename(String f){
      System.out.println(f);
    }
    /**
      * Output no solution found.
      */
    public static void outputNoSolution(){
      System.out.println("No valid order was found");
    }
    /**
      * Output solution found.
      */
    public static void outputSolution(String name, String value){
      System.out.println(name + " " + value);
    }
}