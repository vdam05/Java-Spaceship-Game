
public class Hud {
	private static int revives = 3;
	public static void draw () {
		StdDraw.setPenColor (StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.text (50, 20, "Fuel: " + Player.getFuel());
	}
	public static void winDraw (String winOrNot) {
		StdDraw. setPenColor (StdDraw.BLUE);
		StdDraw. setPenRadius (50);
		StdDraw.text (Scene.getWidth()/2, Scene.getHeight()/2 - 50, winOrNot);
	}
	public static void restartSection () {
		StdDraw.setPenColor (StdDraw.RED);
		StdDraw.text(Scene.getWidth()/2 + 200, Scene.getHeight()/2 + 100, "Naaa! (Press Q)");
		StdDraw.text(Scene.getWidth()/2 - 200, Scene.getHeight()/2 + 100, "Restart! (Press R)");
	}
	public static void drawRevives () {
		StdDraw.setPenColor (StdDraw.RED);
		StdDraw.text(60,40, "Revives Left: ");
		for (int i = 0; i < revives; i++) {
			StdDraw.filledCircle(20 + 50*i, 70, 15);
		}
	}
	public static void reviveLost() {
		revives--;
	}
	public static void refillRevives() {
		revives = 3;
	}
	public static int getRevives() {
		return revives;
	}
	}