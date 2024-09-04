import java.util.Scanner;
public class Scene {
	//Unchanging variables
	private static int width;
	private static int height;
	private static String image;
	public static void start (Scanner input) {
		//Setup Scene data
		Scene.width = input.nextInt();
		Scene.height = input.nextInt();
		Scene.image = "assets/" +input.next();
		//Setup canvas data (size and scale)
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0.0, width); //x goes up by going right (from top)
		StdDraw.setYscale(height, 0.0); //y goes up by going downward 
	}
	public static void restartStart () {
		//no need because nothing changes overtime 
	}
	public static void draw() {
		//Draw Scene to canvas (origin at screen center)
		StdDraw.picture (width/2, height/2, image);
	}
	public static int getHeight() {
		return height;
	}
	public static int getWidth () {
		return width;
	}
}