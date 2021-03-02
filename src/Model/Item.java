package Model;

public class Item {

    /**
     * Create class attributes
     * Private: Restricted access (can only be accessed within the same class)
     */
    String name;
    private boolean isActive = true;


    /**
     *  GETTERS - public get methods to get the variable values
     */
    public String getName() {return name;}
    public boolean isActive() {return isActive;}

    // SETTERS - Public set methods set the variables value

    /**
     * SETTERS - public set methods set the varible vallues
     */
    public void setName(String name) {this.name = name;}
    public void setActive(boolean active) {isActive = active;}

    // TO STRING -  The toString() method returns the string representation on the object

    /**
     * TO STING - the toString() method returns the string representation of the object
     * @return
     */
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }




}
