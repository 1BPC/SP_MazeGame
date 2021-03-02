package Model;

public class Threat extends Item{

    /*
    Create class attributes
    - Private: Restricted access (can only be accessed within the same class)
    */
    private String action;
    private Action isDefeatedBy;

    // Constructor used to initialise a threat object
        public Threat(String name, Action isDefeatedBy){
        this.name = name;
        this.isDefeatedBy = isDefeatedBy;
    }

    // SETTERS - Public set methods set the variables value
    public void setIsDefeatedBy(Action isDefeatedBy) {
        this.isDefeatedBy = isDefeatedBy;
    }

    // GETTERS - Public get methods get the variables value
    public Action getIsDefeatedBy() {
        return isDefeatedBy;
    }

    // TO STRING -  The toString() method returns the string representation on the object
    @Override
    public String toString(){
        return super.toString()+ isDefeatedBy.toString();
    }

}
