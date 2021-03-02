package Model;

public class Action {

    /**
     * Create class attributes
     * Private: Restricted access (can only be accessed within the same class)
     */
    private String name;

    /**
     * ACTION CONSTRUCTOR - used to initialise action objects
     * @param name
     */
    public Action(String name){
        this.name = name;
    }


    // GETTERS - Public get methods get the variable values
    public String getName() {return name;}

    // SETTERS - Public set methods set the variable values
    public void setName(String name) {this.name = name;}

    // TO STRING -  The toString() method returns the string representation on the object
    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                '}';
    }
}
