import java.util.ArrayList;
import java.math.*;
import java.text.*;

/**
	* ShoppingServices checks for valid orders from DataFiles.
*/
public abstract class ShoppingServices{
	/**
		* Go through each dataFile and check if a valid order exists.
		* @param dataFiles a sequence where each containts the orders and targetprice.
	*/
	public static void checkForValidOrders(ArrayList<DataFile> datafiles){
		for(DataFile f : datafiles){
			Shopping shop = new Shopping(); // Initalized each time because of mutable and immutable objects.
			FormatServices.padRight(FormatServices.repeatValue("-",28),40); // Make space for '-' values.
			FormatServices.newLine(); 
			FormatServices.getFilename(f.getFilename()); // Output current filename.
			shop.checkForValidOrder(f.getValues(),FormatServices.convertCurrencyToInt(f.getTargetPrice())); // Pass the orders and the targetprice for validation.
			FormatServices.padRight(FormatServices.repeatValue("-",28),40); // Make space for '-' values.
			FormatServices.newLine(); 
			FormatServices.padRight(f.getOrderName(),20); // Make space for order name.
			FormatServices.padRight(f.getTargetPrice(),20); // Make space for target price.
			FormatServices.newLine();
		}
	}
	/**
		* Method checks if there is a valid order solution.
		* @param i row of dimensional array
		* @param j column of dimensinal array
		* @param sum the two dimensional array that includes all combinations from 0 - targetprice and pairs in current
		* @param targetPrice used to check if the combinations of dimensional array contains the targetprice.
	*/
  	public static void checkIfSolutionExists(int i, int j, boolean[][] sum, ArrayList<Pair> current, int targetPrice){
  		if(sum[i][j] == false){  // The end of list will determine if boolean[][] sum includes a valid order solution. If not output there isn't a valid order.
  			FormatServices.outputNoSolution(); 
  		}
  		else{
  			while(i >=1 && j >= 0){ // Loop through boolean[][] sum until all the orders have been tested.
  				if(sum[i][j] == true && sum[i][j-1] == false){ // If there is a valid value sum[i][j] and it isn't coming from a previous values sum[i-1][j] it is known the value is included in the solution.
  					FormatServices.outputSolution(current.get(j-1).getName(),current.get(j-1).getValue()); // Output the value that is included in the valid order.
  					i = Math.abs(i-FormatServices.convertCurrencyToInt(current.get(j-1).getValue())); // Go further up the list to find the next valid value for order.
  				}
  				else{ // If the current value j isn't included in the order list. Go to the next value. 
  					j = j - 1; 
  				}
  			
  			}
  		}		
  	}
}