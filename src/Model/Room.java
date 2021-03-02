package Model;

public class Room {

    /**
     * Create class attributes
     * Private: restricted access (can only be accessed within the same class)
     */
    private String name;
    private Threat threat;
    private Treasure treasure;
    private Passage passage;
    private boolean isTreasureActive = true;

    /**
     * ROOM CONSTRUCTOR - used to initialise room objects
     * @param name
     * @param threat
     * @param treasure
     */
    public Room(String name, Threat threat, Treasure treasure){
        this.name = name;
        this.treasure = treasure;
        this.threat = threat;
    }

    //GETTERS - Public get methods gets the variable value
    public String getName       () {return name;}
    public Treasure getTreasure () {return treasure;}
    public Threat getThreat     () {return threat;}
    public Passage getPassage() {
        return passage;
    }
    public boolean isTreasureActive() {return isTreasureActive;}

    // SETTERS - Public set methods set the variables value
    public void setName     (String name) {
        this.name = name;
    }
    public void setThreat   (Threat threat) {
        this.threat = threat;
    }
    public void setTreasure (Treasure treasure) {
        this.treasure = treasure;
    }
    public void setPassage(Passage passage) {
        this.passage = passage;
    }
    public void setTreasureActive(boolean treasureActive) {isTreasureActive = treasureActive; }

    // TO STRING -  The toString() method returns the string representation on the object
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", threat=" + threat +
                ", treasure=" + treasure +
                '}';
    }
}
