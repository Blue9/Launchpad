// Copyright GM.

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private static Clip[] clips = new Clip[96];
	private static String keys = "12345678qwertyuiasdfghjkzxcvbnm,";
	private static boolean initialized = false;
	private static File wav;
	
	public Sound() {
	}

	public static void init(File dir) {
		wav = new File("");
		int index = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 32; j++) {
				index = j + i * 32;
				try {
					clips[index] = AudioSystem.getClip();
					
					if (dir != null) {
						wav = new File(dir.getAbsolutePath() + "/" + keys.charAt(j) + i + ".wav");
						clips[index].open(AudioSystem.getAudioInputStream(wav));
					} else { // Default to Bangarang
						clips[index].open(AudioSystem.getAudioInputStream(Sound.class.getResource("aud/bangarang" + "/" + keys.charAt(j) + i + ".wav")));
					}
					
					
				} catch (Exception e) {
					System.out.println(wav.getAbsolutePath() + " not loaded");
				}
			}
		}
		initialized = true;
	}
	
	public static boolean initialized() {
		return initialized;
	}
	
	public static void play(char key) {
		int pressed = keys.indexOf(key);
		int index = pressed + SidePanel.loop() * 32;
		stop(key);
		while (clips[index].getFramePosition() != 0 && clips[index].getFramePosition() < clips[index].getFrameLength()) {
		}
		clips[index].start();
	}
	
	public static void stop(char key) {
		int index = keys.indexOf(key) + SidePanel.loop() * 32;
		clips[index].stop();
		clips[index].flush();
		clips[index].setFramePosition(0);
	}
	
	public static void stop() {
		for (int i = 0; i < clips.length; i++) {
			clips[i].stop();
			clips[i].flush();
			clips[i].setFramePosition(0);
		}
	}
}
