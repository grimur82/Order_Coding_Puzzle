import java.math.*;
/**
	* Pair class contains name and value of a order.
*/
public class Pair{
	/**
		* name of order.
	*/
	private String name;
	/**
		* Price of order.
	*/
	private String value;
	/**
		* Constructor that initalizes the name and price of order.
		* @param name of order.
		* @param value of order. 
	*/
	public Pair(String name, String value){
		this.name = name;
		this.value = value;
	}
	/**
		* Name of order.
		* @return name of order.
	*/
	public String getName(){
		return name;
	}
	/**
		* Value of order.
		* @return value of order.
	*/
	public String getValue(){
		return value;
	}
}