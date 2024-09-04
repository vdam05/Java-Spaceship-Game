import java.util.Scanner;
import java.awt.event.KeyEvent; //KeyEvent has to be imported
public class Game {
	private static boolean gameOver;
	private static boolean restartNot = true;
	private static boolean firstTimeRestart= true;
	public static void main (String[] args) {
		Music.RunMusic("assets/Try To Talk.wav");
		fullStart();
	}
	public static void fullStart () {
		startGame();
		endGame();
		restartGame();
		}
	public static void startGame () {
		if (firstTimeRestart) {
		start();
		} else {
			restartStart();
		}
		while(gameOver == false) { //update method updates by while
			update();
			render();
		}
		}
	public static void endGame () { //check for gameStatus
		if (Player.getGameStatus() == 0) {
			Hud.winDraw("YOU WIN!");
			Hud.refillRevives();
		} 
		if (Player.getGameStatus() == 1) {
			Hud.winDraw ("YOU LOSE! RETRY?");
			Hud.reviveLost();
		}
		Hud.restartSection();
		StdDraw.show(0);
		}
	public static void restartGame() { 
	/*check for keyOption, using isKeyPressed which uses keycode (found on stddraw), 
	if restart it would rescan the Scanner System.in
	Therefore, would most likely have to invoke a mass reset of numbers (to 0 and the others);
	*/

		while (restartNot) {
				if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
					restartNot = false;
					firstTimeRestart = false;
					if (Hud.getRevives() >= 0) {
 					StdDraw.clear();
					fullStart();
					} else {
					restartNot = true;

					continue;
					}
				}
			if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
				System.exit(0);
			}
		}
	}
	public static void start () { //first start
		gameOver = false;
		Scanner input = new Scanner (System.in);
		Scene.start (input);
		Player.start(input);
		Physics.start(input);
		LandingPad.start(input);
	}
	public static void restartStart () {
		gameOver = false;
		restartNot = true;
		Scene.restartStart();
		Player.restartStart();
		Physics.restartStart();
		LandingPad.restartStart();
	}
	public static void update () {
		Player.update();//get player input
						//update data
	}
	public static void render() {
		Scene.draw(); 		//draw scene
		Player.draw();		//draw player
		LandingPad.draw();
		Hud.draw();			//draw hud
		Hud.drawRevives();
		StdDraw.show(100);  //show graphics
	}
	public static void setGameOver (boolean gameOver) {
		Game.gameOver = gameOver;
	}
}