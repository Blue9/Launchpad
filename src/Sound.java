// Copyright GM.

// Credit to GHET1 for Bangarang samples.
// Credit to SoNevable for First of the Year samples.

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private static Clip[] clips = new Clip[96];
	private static String keys = "12345678qwertyuiasdfghjkzxcvbnm,";
	private static boolean initialized = false;
	
	public Sound() {
	}

	public static void init(String song) {
		try {
			int index = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 32; j++) {
					index = j + i * 32;
					clips[index] = AudioSystem.getClip();
					try {
						clips[index].open(AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream("aud/" + song + "/" + keys.charAt(j) + i + ".wav")));
					} catch (Exception e) {
					}
				}
			}
			initialized = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		if (pressed >= 0) {
			clips[index].start();
		}
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
