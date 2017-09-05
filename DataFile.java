import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.net.*;
import java.math.*;
import java.lang.*;
import java.text.*;
/**
	* DataFile implements the data from CSV file and return a DataFile object.
*/
public class DataFile{
	/** *Contains the order pairs */
	private ArrayList<Pair> orders; 
	/** *Contains the target price the program is looking for*/
	private Pair targetPrice;
	/** *Contains the fileName the program is using*/
	private String fileName;
	/** *Contains the currencyValue in big decimal value for accuracy*/
	private BigDecimal currencyValue;
	/**
		* constructor to initalize the order list and set targetPrice as null to begin with.
	*/
	public DataFile(){
		orders = new  ArrayList<Pair>();
		targetPrice = null;
	}
	/**
		* Set the target price
		* @param name of target price.
		* @param price is the value.
	*/
	public void setTargetPrice(String name, String price){
		targetPrice = new Pair(name,price);
	}
	/**
		* Add a found order pair from file to orders list
		* @param name of order.
		* @param price of order.
	*/
	public void addOrder(String name, String price){
		orders.add(new Pair(name,price));
	}
	/**
		* Get the list of orders.
		* @return orders list. 
	*/
	public ArrayList<Pair> getValues(){
		return orders;
	}
	/**
		* Get the target Price
		* @return target price
	*/
	public String getTargetPrice(){
		return targetPrice.getValue();
	}
	/**
		* Get the target name
		* @return target name
	*/
	public String getOrderName(){
		return targetPrice.getName();
	}
	/**
		* Set the filename
		* @param f the filename that is going to be passed.
	*/
	public void setFilename(String f){
		fileName = f;
	}
	/**
		* Get the filename.
		* @return the filename.
	*/
	public String getFilename(){
		return fileName;
	}
	/**
		* Take all numerics in the String money and convert to a BigDecimal value. BigDecimal is keen on keeping decimals accurate.
		* @param money is the price is string format.
	*/
	public void convertCurrencyToNumeric(String money){
		try{
			NumberFormat format = NumberFormat.getCurrencyInstance();
			format.setMinimumFractionDigits(2);
			Number number = format.parse(money);
			currencyValue = new BigDecimal(number.doubleValue());
		}
		catch(ParseException e){

		}
    }
    /**
    	* Get the currency value
    	*@return the currency value.
    */
    public final BigDecimal getCurrencyValue(){
    	return currencyValue;
    }
}