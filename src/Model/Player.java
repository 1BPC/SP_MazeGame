package Model;

import Readers.Reader;

public class Player {

	/**
	 * Create class attributes
	 - private: restricted access (can only be accessed within the same class)
	 */
	private int wealth;
	private Room room;
	private int x;
	private int y;


	/**
	 * PLAYER CONSTRUCTOR - used to initialise player objects
	 * @param x position
	 * @param y position
	 * @param room room
	 * @param wealth wealth
	 */
	public Player(int x, int y, Room room, int wealth) {
		this.wealth = wealth;
		this.room = room;
		this.x = x;
		this.y = y;
	}

	/**
	 * sets the room by indexing into the room array
	 */
	public void updateRoom() {
		setRoom(Reader.rooms[getX()][getY()]);
	}

	// returns true or false if the treasure is active in the room

	/**
	 * @return true if treasure is present else false
	 */
	public boolean isTreasurePresent() {
		return room.isTreasureActive();
	}

	// Increases the players wealth by the value of the treasure and sets the treasure inactive

	/**
	 *  increases the players wealth by the value of the treasure in the room
	 *  sets the treasure inactive after its been "collected"
	 */
	public void updateWealth() {
		this.wealth = wealth + room.getTreasure().getIntValue();
		Reader.setTreasureInactive(room);
	}

	/**
	 * MOVE PLAYER -
	 *
	 * North: subtract 1 from its row
	 * East: add 1 to its column
	 * South: add 1 to its row
	 * West: subtract 1 from its column
	 *
	 * @param d - takes direction enum as parameter
	 */
	public void movePlayer(Direction d) {
		switch (d) {
			case NORTH -> {
				setX(getX() - 1);
				break;
			}
			case EAST -> {
				setY(getY() + 1);
				break;
			}
			case SOUTH -> {
				setX(getX() + 1);
				break;
			}
			case WEST -> {
				setY(getY() - 1);
				break;
			}
		}
	}

	/**
	 *
	 * @return true if the exit passage is true else false
	 */
	public boolean isExit() {
		final Passage passage = getRoom().getPassage();
		if (passage != null) {
			return passage.isExit();
		}
		return false;
	}

	/**
	 * @return true if a move in the desired direction is within bounds else false
	 */
	public boolean checkNorth() {
		return Reader.withInBound(getX() - 1, getY());
	}
	public boolean checkSouth() {
		return Reader.withInBound(getX() + 1, getY());
	}
	public boolean checkWest() {
		return Reader.withInBound(getX(), getY() - 1);
	}
	public boolean checkEast() {
		return Reader.withInBound(getX(), getY() + 1);
	}

	//GETTERS
	public int getX() {
		return x;
	}
	public Room getRoom() {
		return room;
	}
	public int getY() {
		return y;
	}
	public int getWealth() {
		return wealth;
	}

	//SETTERS
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public void setWealth(int wealth) {
		this.wealth = wealth;
	}

}
