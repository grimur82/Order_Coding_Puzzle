/**
* Driver class implements the filenames args and passes them to check if there exists a valid order. 
*/
public class Driver{
	/**	
		*readFiles is going to data parse the filenames.
		* checkForValidOrders is going to check if the data contains a valid order for a given target price.
		*@param args contains all the filenames
	*/
	public static void main(String[] args){
		ShoppingServices.checkForValidOrders(DataServices.readFiles(args));
	}
}