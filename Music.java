

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;



public class Music{


	//add this code under startGame() in Game.java: Music.RunMusic("assets/pacman_intro.wav");

	

	public static void RunMusic(String location) {
		
		try{
			File musicPath = new File(location);
			if(musicPath.exists()){
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(clip.LOOP_CONTINUOUSLY);

			}
			else{
				System.out.println("cant find file");
			}

			
	}
	catch(Exception e){
		System.out.println(e);
	}

}
}