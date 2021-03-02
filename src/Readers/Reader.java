package Readers;

import Model.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Reader {

	/**
	 * Create class attributes
	 */
	private static final String MAZE_FILE = "mazeConfig.properties";
	private static final String THREAT_FILE = "threats.properties";
	private static final String TREASURE_FILE = "treasures.properties";
	public static final String CONFIGS = "configs";

	public static List<Treasure> treasureList = new ArrayList<>();
	public static List<Threat> threatsList = new ArrayList<>();
	public static Room[][] rooms;
	private static final Set<Integer> uniqueNumbers = new HashSet<>();
	private static String mazeRows;
	private static String mazeCols;
	public static int totalWealth = 0;

	/**
	 * Load the 3 config files one by one into a properties instance
	 * Call the fill methods which populate the threat list and treasure list arrays
	 */
	public static void loadFiles() {
		try {
			Properties threats = new Properties();
			threats.load(new FileInputStream(CONFIGS + File.separator + THREAT_FILE));
			fillThreats(threats);
			Properties treasures = new Properties();
			treasures.load(new FileInputStream(CONFIGS + File.separator + TREASURE_FILE));
			fillTreasures(treasures);
			Properties maze = new Properties();
			maze.load(new FileInputStream(CONFIGS + File.separator + MAZE_FILE));
			fillRooms(maze);
		} catch (Exception e) {
			System.out.println("Could not load the file");
		}
	}

	/**
	 * Initialise a 2d array with number of rows and columns from the config file
	 * Rooms are assigned randomly to the array, and room numbers are also generated dynamically based
	 * on the number of rows and the columns
	 * @param maze
	 */
	private static void fillRooms(Properties maze) {
		mazeRows = maze.getProperty("mazeRows");
		mazeCols = maze.getProperty("mazeCols");
		rooms = new Room[Integer.parseInt(mazeRows)][Integer.parseInt(mazeCols)];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				final int maximum = Integer.parseInt(mazeRows) * Integer.parseInt(mazeCols);
				int randomNum = randomRoomNumber(maximum);
				while (uniqueNumbers.contains(randomNum)) {
					randomNum = randomRoomNumber(maximum);
				}
				final Room room = new Room("Room " + randomNum,
						randomThreat(threatsList), randomTreasure(treasureList));
				rooms[i][j] = room;
				uniqueNumbers.add(randomNum);
			}
		}
	}

	/**
	 * for each key in the map it gets the value and splits it at the ","
	 * calling the threat constructor and passing in the values to create a new threat object
	 * and then adding each threat to the threatList
	 * key:value (threat):(name,action)
	 * @param threats
	 */
	private static void fillThreats(Properties threats) {
		for (Object key : threats.keySet()) {
			String value = threats.getProperty((String) key);
			Threat threat = new Threat(value.split(",")[0], new Action(value.split(",")[1]));
			threatsList.add(threat);
		}
	}


	/**
	 * for each key in the map it gets the value and splits it at the ","
	 * calling the treasure constructor and passing in the values to create a new treasure object
	 * then adding each treasure to the treasureList
	 * key:value (treasure):(name,treasureValue)
	 *
	 * @param treasures
	 */
	private static void fillTreasures(Properties treasures) {
		for (Object key : treasures.keySet()) {
			String value = treasures.getProperty((String) key);
			Treasure treasure = new Treasure(value.split(",")[0], value.split(",")[1]);
			treasureList.add(treasure);
		}
	}

	/**
	 * @param list
	 * @return a random threat from the threat arrayList
	 */
	private static Threat randomThreat(List<Threat> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}


	/**
	 * @param list
	 * @return a random treasure from the treasure arraylist
	 */
	private static Treasure randomTreasure(List<Treasure> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}


	/**
	 * @param maximum
	 * @return a random number within the max range
	 */
	private static int randomRoomNumber(int maximum) {
		Random rand = new Random();
		return 1 + rand.nextInt((maximum - 1) + 1);
	}

	/**
	 * generate a random index from the row and column
	 * then combine to generate a random index for a room
	 */
	public static void setRandomPassage() {
		Random rand = new Random();
		int randRow = rand.nextInt((Integer.parseInt(mazeRows) - 1) + 1);
		int randCol = rand.nextInt((Integer.parseInt(mazeCols) - 1) + 1);
		rooms[randRow][randCol].setPassage(new Passage());
	}


	/**
	 * checks if x and y are within the matrix range
	 * @param x position
	 * @param y position
	 * @return true of x,y is within the matrix range else false
	 */
	public static boolean withInBound(int x, int y) {
		return x >= 0 && x <= Integer.parseInt(mazeRows) - 1 &&
				y >= 0 && y <= Integer.parseInt(mazeCols) - 1;
	}

	/**
	 * Set the treasure inactive for a room for which player has already picked up the treasure
	 * iterates over each and every room and check
	 * @param room the room on which check has to be set
	 */
	public static void setTreasureInactive(Room room) {
		for (Room[] value : rooms) {
			for (Room room2 : value) {
				if (room2.getName().equals(room.getName())) {
					room2.setTreasureActive(false);
				}
			}
		}
	}
}
