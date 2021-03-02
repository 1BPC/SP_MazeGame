package Controllers;

import Model.Direction;
import Model.Player;
import Readers.Reader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class gameController {

	private final Player p1;

	public ImageView upBTN;
	public ImageView downBTN;
	public ImageView leftBTN;
	public ImageView rightBTN;
	public ImageView rpgBTN;
	public ImageView rifleBTN;
	public ImageView swordBTN;
	public ImageView pickupBTN;
	public ImageView dropBTN;

	@FXML
	private Label playerWealth;

	@FXML
	private Label displayLabel;

	@FXML
	public void initialize(){
		String msg = p1.getRoom().getName() + "\n" + p1.getRoom().getThreat().getName() + "\n" + p1.getRoom().getTreasure().getName();
		displayLabel.setText(msg);
	}

	@FXML
	private AnchorPane rootPaneGS;


	/**
	 * 	call the load files method from the reader class
	 * 	initialise a player at [0][0], with 0 wealth
	 * 	call the setRandomPassage method from reader
	 */
	public gameController() {
		Reader.loadFiles();
		p1 = new Player(0, 0, Reader.rooms[0][0], 0);
		Reader.setRandomPassage();
	}

	/**
	 *
	 * @throws IOException
	 */
	/*
	public void loadExitScreen() throws IOException{
		Reader.totalWealth = p1.getWealth();
		Stage primaryStage = new Stage();
		URL url = new File("TestFX/src/Views/GameEndScreen.fxml").toURI().toURL();
		Parent root = FXMLLoader.load(url);
		primaryStage.setTitle("Maze Game");
		primaryStage.setScene(new Scene(root, 1080, 720));
		primaryStage.show();
	}

	 */

		@FXML
		public void loadExitScreen() throws IOException{
		Reader.totalWealth = p1.getWealth();
		URL url = new File("TestFX/src/Views/GameEndScreen.fxml").toURI().toURL();
		AnchorPane pane = FXMLLoader.load(url);
		rootPaneGS.getChildren().setAll(pane);

	}



	/**
	 * UP PRESSED / DOWN PRESSED/ LEFT PRESSED/ RIGHT PRESSED
	 *
	 *  checks if the exit passage is true - if true, display the end game window else
	 *  check if the direction would be a valid move, if valid, check if the threat in the room is active
	 *  if not active, move the player, update the room and display appropriate message else
	 *  display threat must be defeated or if move not valid, display you cant go that way
	 *
	 * @throws IOException
	 */
	public void upPressed() throws IOException {
		boolean isExit = p1.isExit();
		if (isExit) {
			loadExitScreen();
		} else {
			upBTN.setImage(upPressed);
			boolean isValid = p1.checkNorth();
			if (!isValid) {
				displayLabel.setText("You can't go that way");
			} else {
				if(p1.getRoom().getThreat().isActive()) {
					String msg = "You must defeat the threat before leaving the room";
					displayLabel.setText(msg);
				} else{
					p1.movePlayer(Direction.NORTH);
					p1.updateRoom();
					String msg = p1.getRoom().getName() + "\n" + p1.getRoom().getThreat().getName() + "\n" + p1.getRoom().getTreasure().getName();
					displayLabel.setText(msg);
				}

			}
		}
	}

	public void downPressed() throws IOException {
		boolean isExit = p1.isExit();
		if (isExit) {
			loadExitScreen();
		} else {
			downBTN.setImage(downPressed);
			final boolean isValid = p1.checkSouth();
			if (!isValid) {
				displayLabel.setText("You can't go that way");
			} else {
				if(p1.getRoom().getThreat().isActive()) {
					String msg = "You must defeat the threat before leaving the room";
					displayLabel.setText(msg);
				}
				else {
					p1.movePlayer(Direction.SOUTH);
					p1.updateRoom();
					String msg = p1.getRoom().getName() + "\n" + p1.getRoom().getThreat().getName() + "\n" + p1.getRoom().getTreasure().getName();
					displayLabel.setText(msg);
				}

			}
		}
	}

	public void leftPressed() throws IOException {
		boolean isExit = p1.isExit();
		if (isExit) {
			loadExitScreen();
		} else {
			leftBTN.setImage(leftPressed);
			final boolean isValid = p1.checkWest();
			if (!isValid) {
				displayLabel.setText("You can't go that way");
			} else {
				if(p1.getRoom().getThreat().isActive()){
					String msg = "You must defeat the threat before leaving the room";
					displayLabel.setText(msg);
				} else {
					p1.movePlayer(Direction.WEST);
					p1.updateRoom();
					String msg = p1.getRoom().getName() + "\n" + p1.getRoom().getThreat().getName() + "\n" + p1.getRoom().getTreasure().getName();
					displayLabel.setText(msg);
				}

			}
		}
	}

	public void rightPressed() throws IOException {
		boolean isExit = p1.isExit();
		if (isExit) {
			loadExitScreen();
		} else {
			rightBTN.setImage(rightPressed);
			final boolean isValid = p1.checkEast();
			if (!isValid) {
				displayLabel.setText("You can't go that way");
			} else {
				if(p1.getRoom().getThreat().isActive()){
					String msg = "You must defeat the threat before leaving the room";
					displayLabel.setText(msg);
				}
				else {
					p1.movePlayer(Direction.EAST);
					p1.updateRoom();
					String msg = p1.getRoom().getName() + "\n" + p1.getRoom().getThreat().getName() + "\n" + p1.getRoom().getTreasure().getName();
					displayLabel.setText(msg);
				}
			}
		}
	}

	/**
	 * rifle, rpg and sword pressed
	 * sets the threat in the current room as inactive
	 */
	public void riflePressed() {
		if(p1.getRoom().getThreat().getIsDefeatedBy().getName().equals("rifle")) {
			rifleBTN.setImage(riflePressed);
			String msg = "You just defeated the " + p1.getRoom().getThreat().getName() + " You may now leave the room";
			displayLabel.setText(msg);
			p1.getRoom().getThreat().setActive(false);
		}
		else {
			String msg = "The Rifle did no damage against the " + p1.getRoom().getThreat().getName() + " try a different weapon";
			displayLabel.setText(msg);
		}
	}

	public void rpgPressed() {
		if(p1.getRoom().getThreat().getIsDefeatedBy().getName().equals("rpg")){
			rpgBTN.setImage(rpgPressed);
			String msg = "You just defeated the " + p1.getRoom().getThreat().getName() + " You may now leave the room";
			displayLabel.setText(msg);
			p1.getRoom().getThreat().setActive(false);
		}
		else {
				String msg = "The RPG did no damage against the " + p1.getRoom().getThreat().getName() + " try a different weapon";
				displayLabel.setText(msg);

		}
	}

	public void swordPressed() {
		if(p1.getRoom().getThreat().getIsDefeatedBy().getName().equals("sword")) {
			swordBTN.setImage(swordPressed);
			String msg = "You just defeated the " + p1.getRoom().getThreat().getName() + " You may now leave the room";
			displayLabel.setText(msg);
			p1.getRoom().getThreat().setActive(false);
		}
		else {
			String msg = "The Sword did no damage against the " + p1.getRoom().getThreat().getName() + " try a different weapon";
			displayLabel.setText(msg);
		}
	}


	/**
	 *  decrease the players wealth by one
	 */
	public void dropPressed() {
		dropBTN.setImage(dropPressed);
		p1.setWealth(p1.getWealth()-1);
		playerWealth.setText(String.valueOf(p1.getWealth()));
		displayLabel.setText("You just dropped a coin!");
	}

	/**
	 * checks if the treasure is present if true then call a method to update the players wealth by the treasures value
	 * that also sets the treasure in the room as inactive
	 * display appropriate labels
	 */
	public void pickupPressed() {
		if (p1.isTreasurePresent()) {
			pickupBTN.setImage(pickupPressed);
			p1.updateWealth();
			playerWealth.setText("£"+String.valueOf(p1.getWealth()));
			displayLabel.setText("You just picked up: " + p1.getRoom().getTreasure().getName());
		} else {
			displayLabel.setText("There is nothing for you to pick up");
		}
	}

	/**
	 * when button is released set the image back to normal version - gives illusion of a click
	 */
	public void upReleased() { upBTN.setImage(upReleased); }
	public void downReleased() { downBTN.setImage(downReleased); }
	public void leftReleased() { leftBTN.setImage(leftReleased); }
	public void rightReleased() { rightBTN.setImage(rightReleased); }
	public void pickupReleased() { pickupBTN.setImage(pickupReleased); }
	public void dropReleased() { dropBTN.setImage(dropReleased); }
	public void swordReleased() { swordBTN.setImage(swordReleased); }
	public void rifleReleased() { rifleBTN.setImage(rifleReleased); }
	public void rpgReleased() {rpgBTN.setImage(rpgReleased);}


	/**
	 * slightly darker images to switch to when buttons are pressed
	 * to simulate a real click
	 */
	Image upPressed = new Image("Images/up-pressed.png");
	Image upReleased = new Image("Images/up.png");
	Image downPressed = new Image("Images/down-pressed.png");
	Image downReleased = new Image("Images/down.png");
	Image leftPressed = new Image("Images/left-pressed.png");
	Image leftReleased = new Image("Images/left.png");
	Image rightPressed = new Image("Images/right-pressed.png");
	Image rightReleased = new Image("Images/right.png");
	Image rpgPressed = new Image("Images/rpg-pressed.png");
	Image rpgReleased = new Image("Images/rpg.png");
	Image swordPressed = new Image("Images/sword-pressed.png");
	Image swordReleased = new Image("Images/sword.png");
	Image riflePressed = new Image("Images/rifle-pressed.png");
	Image rifleReleased = new Image("Images/rifle.png");
	Image dropPressed = new Image("Images/drop-pressed.png");
	Image dropReleased = new Image("Images/drop.png");
	Image pickupPressed = new Image("Images/pickup-pressed.png");
	Image pickupReleased = new Image("Images/pickup.png");


}
