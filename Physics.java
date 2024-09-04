//Note: Can do mass compile by javac java1.java java2.java etc
import java.util.Scanner;
public class Physics {
	//Changing variables
	private static double velocityX;
	private static double velocityY;
	//Unchanging variables
	private static double gravity;
	private static double maxSurvivableVelocity;
	private static double thrust;
	public static void start (Scanner input) {
		gravity = input.nextDouble();
		velocityX = 0.0;
		velocityY = 0.0;
		maxSurvivableVelocity = input.nextDouble();
		thrust = input.nextDouble();
	}
	public static void restartStart () {
		//only changing variables so resets
		velocityX = 0.0;
		velocityY = 0.0;
	}
	public static void update () {
		velocityY -= gravity; //height is deducted by gravity (gravity is negative)
	}
	public static double getVelocityX() {
		return velocityX;
	}
	public static double getVelocityY() {
		return velocityY;
	}
	public static void thrustUp () {
		velocityY -= thrust; //thrust is positive so velocity increases because 0 is top, height is bottom
	}
	public static void thrustLeft () {
		velocityX -= thrust;
	}
	public static void thrustRight () {
		velocityX += thrust;
	}
	public static boolean isSurvivableSpeed () {
		return (velocityY < maxSurvivableVelocity);
	}
	
}