import java.util.Scanner;
public class Player {
	//Unchanging numbers/strings
		//Ship images
	private static String shipImage;
	private static String thrusterUpImage;
	private static String thrusterLeftImage;
	private static String thrusterRightImage;
	private static String shipLandedImage;
	private static String shipCrashedImage;
		//Current ship image
	private static String sprite;
		//ship dimensions
	private static int width;
	private static int height;
	//ship initial position
	private static double x;
	private static double y;
	//Ship fuel
	private static int fuel;
	//ship initial position and initial fuel (duplicated)
	private static double x1;
	private static double y1;
	private static int fuel1;
	//game status for win/loss 
	private static int gameStatus;
	public static void start (Scanner input) { // I shortened the code by removing unneccessaries for all variables
		//Read ship art assets
		shipImage = "assets/" + input.next();
		thrusterUpImage = "assets/" + input.next();
		thrusterLeftImage = "assets/" + input.next();
		thrusterRightImage = "assets/" + input.next();
		shipLandedImage = "assets/" + input.next();
		shipCrashedImage = "assets/" + input.next();
		//set current image
		sprite = shipImage;
		//Read ship dimesions
		width = input.nextInt();
		height = input.nextInt();
		//Read the ship initial position:
		x = input.nextDouble();
		y = input.nextDouble();
		//Read fuel
		fuel = input.nextInt();
		//Duplicating the start variables into the restart variables (only the necessaries)
		x1 = x;
		y1 = y;
		fuel1 = fuel;
	}
	public static void restartStart () {
		sprite = shipImage;
		x = x1;
		y = y1;
		fuel = fuel1;
	}
	public static void draw() {
		//Draw ship to scene
		StdDraw.picture (x, y, sprite);
	}
	public static void update() {
		if (fuel > 0) {
			Player.move();
		} else {
			sprite = shipImage;
		}
		Physics.update();
		y += Physics.getVelocityY();
		x += Physics.getVelocityX();
		if ( (y+height) > (Scene.getHeight()-15) ) {
			if ( LandingPad.isTouching() == true && Physics.isSurvivableSpeed() == true) {
				sprite = shipLandedImage;
				gameStatus = 0;
			} else {	
				sprite = shipCrashedImage;
				gameStatus = 1;
			}
		Game.setGameOver(true);
		}
		}
	public static void move() {
		if (StdDraw.hasNextKeyTyped ()) {
			char ch = StdDraw.nextKeyTyped();
			if (ch == 'w') {
				Physics.thrustUp ();
				sprite = thrusterUpImage;
				fuel--; 
			} else if (ch == 'd') {
				Physics.thrustRight();
				sprite = thrusterLeftImage;
				fuel--; 
			} else if (ch == 'a') {	
				sprite = thrusterRightImage;
				Physics.thrustLeft();
				fuel--;	
			} else {
				sprite = shipImage; //if no key then sprite is the same
			}
			}
			}
	public static int getFuel () { //Have a getter method to get the number rather than able to access the instance var(but cant because private)
		return fuel;
	}
	public static double getX () {
		return x;
	}
	public static int getGameStatus () {
		return gameStatus;
	}
	}




