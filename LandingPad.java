import java.util.Scanner;
public class LandingPad {
	private static int x;
	private static int width;
	private static int x1;
	private static int width1;
	public static void start (Scanner input) {
		//Read landing pad
		LandingPad.x = input.nextInt();
		LandingPad.width = input.nextInt();
		x1 = x;
		width1 = width;

	}
	public static void restartStart () {
		x = x1;
		width = width1;
	}
	public static void draw() {
		//Draw landing pad
		StdDraw.setPenColor (StdDraw.RED);
		StdDraw.filledRectangle(x, Scene.getHeight()-20, width, 5);
	}
	public static boolean isTouching () {
		boolean isTouching;
		isTouching = Math.abs (Player.getX()-LandingPad.x) < LandingPad.width;
		return isTouching;
	}
}