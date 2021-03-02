package Model;

public class Treasure extends Item {
	/*
    Create class attributes
    - Private: Restricted access (can only be accessed within the same class)
    */
	private int intValue;
	private String stringValue;

	/*
    TREASURE CONSTRUCTOR - used to initialise treasure objects
    When this constructor is called, we pass in the parameters name and string value
    */
	public Treasure(String name, String stringValue) {
		this.name = name;
		this.stringValue = stringValue;
	}

	// TO STRING -  The toString() method returns the string representation on the object
	@Override
	public String toString() {
		return "Treasure{" +
				"Name=" + name +
				", Value='" + getIntValue() + '\'' +
				'}';
	}

	// GETTERS - Public get methods get the variables value
	// converts a string to an int and throws a numberFormatException if it cannot be converted
	public int getIntValue() {
		intValue = Integer.parseInt(stringValue);
		return intValue;
	}

	// SETTERS - Public set methods set the variables value
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
}
