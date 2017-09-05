import java.util.*;
import java.math.*;
import java.text.*;
/**
	* Shopping class implements a dynamic subset algortihm and figures out if there is a order that equals the targetPrice.
*/
public class Shopping{
	/**
		*@param currentCombination contains all order pairs
		*@param targetPrice contains the value that a valid order needs to be
	*/
	// ArrayList<Pair> currentCombination includes all order with values from file. int targetPrice is for valid price.
	public void checkForValidOrder(ArrayList<Pair> currentCombination, int targetPrice){
		boolean subset[][] = new boolean[targetPrice+1][currentCombination.size()+1]; // Make two dimensional array with rows = targetPrice - rows and columns currentCombination.size() - columns
		for (int i = 0; i <= currentCombination.size(); i++) // A sub value of zero from targerPrice is first column equals always true.
          subset[0][i] = true;
      	for (int i = 1; i <= (targetPrice); i++) // First value in the row is the empty set. Therefore, it will always be false.
          subset[i][0] = false; 

        // Check if current element subset[i][j] has a sum from current or previous solutions that equals int targerPrice.
      	for (int i = 1; i <= targetPrice; i++)
         {
           for (int j = 1; j <= currentCombination.size(); j++)
           {
             subset[i][j] = subset[i][j-1];
             if (i >= FormatServices.convertCurrencyToInt(currentCombination.get(j-1).getValue())){	
               subset[i][j] = subset[i][j] || 
               subset[i - FormatServices.convertCurrencyToInt(currentCombination.get(j-1).getValue())][j-1];}
           } 
         }
         // After all subset solutions are calculated, we check if ArrayList<Pair> currentCombination contains a sequence that equals int targetPrice.
         ShoppingServices.checkIfSolutionExists(targetPrice,currentCombination.size(),subset, currentCombination,targetPrice);
	}
}