import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.net.*;
import java.math.*;
import java.lang.*;
import java.text.*;
/**
	* DataServices is a abstract class that provides options to read, validate and convert data.
*/
public abstract class DataServices{
	/**
		* read incoming and parse incoming filenames to a list
		* @param fileArray contains list of incoming filename 
		* @return list of DataFiles 
	*/
	public static ArrayList<DataFile> readFiles(String[] fileArray){
		ArrayList<DataFile> files = new ArrayList<DataFile>();
		try{
			for(int i=0; i < fileArray.length;i++){
   				DataFile data = new DataFile();
    			data.setFilename(fileArray[i]);
    			Scanner scanner = new Scanner(new File(fileArray[i]));
        		scanner.useDelimiter("\\R+"); // Eliminate empty lines
        		while(scanner.hasNext()){
        			String[] currentData = scanner.next().split(",");
        			if(checkValidData(currentData)){
        				DataServices.typeData(FormatServices.removeSpaces(currentData[0].toUpperCase()),FormatServices.removeSpaces(currentData[1]),data);
        			}	
          		}
        		scanner.close();
        		files.add(data);
			}
        	return files;
    	}
		catch( IOException ioException ) {
    		System.out.println("Exception: "+ioException);
		}
		return files;
	}
	/**
		* Converts string to BigDecimal 
		* @param money is the currency found in the CSV files.
		* @return null if the conversion wasn't possible.
	*/
	public static BigDecimal convertCurrencyToNumeric(String money){
		try{
			NumberFormat format = NumberFormat.getCurrencyInstance();
			format.setMinimumFractionDigits(2);
			Number number = format.parse(money);
			return new BigDecimal(number.doubleValue());
		}
		catch(ParseException e){

		}
		return null;
    }
    /**
		* Checks if the current pair data contains name and value.
		* @param current pair
		* @return If the data contains a name and value give a true. Else give a false.
    */
	public static boolean checkValidData(String[] pair){
		if(pair.length == 2){
			return true;
		}
		else{
			return false;
		}
	}
	/**
		* For each data that is going to be past through. The program is going to check if one contains a pair with name targetprice.
		* @param name of pair
		* @param price of pair
		* @param d is the datafile the pair belongs to.
	*/
	public static void typeData(String name, String price,DataFile d){
		if(name.equals("TARGETPRICE")){
			d.setTargetPrice(name,price);
			d.convertCurrencyToNumeric(price);
		}
		else{
			d.addOrder(name,price);
		}
	}
}