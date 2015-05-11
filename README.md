# Launchpad
A mini-replica of the Novation Launchpad built using Java.

How to use it:
-
Each key corresponds to a different sound. Press different keys in the correct order to play the song. The arrow keys will load up different sets of loops (and lighting effects).  
- First of the Year \(WIP\):  
1 5 6 7 t y u i t 5 6 7 t y u i j hjj k 5 6 7 8 8 u z x c v b g f d s  
2 5 6 7 t y u i t 5 6 7 t y u i j hjj k 5 6 7 8 8 u z x c v b g f d s \[UP\]  
, 2 2 6 6 5 6 6 5 2 2 6 6 5 6 6 4 3441 2 22 6 8 7 wert t 8 y 7 u 7 i k \[RIGHT\]  
3 5 6 7 t y u i t 5 6 7 t y u i j hjj k 5 6 7 8 8 u z x c v b \[LEFT\]  
z 6 5 6 5 4 z 6 5 7 8 x y u 4 3 \[More coming soon\]


- Bangarang \(WIP\):
1 z 2 x 3 c 4 v 5 b 6 n 7 m 8 a s d f g h j k i u y t \[LEFT\]  
\(5 6 7 8 t y 5 u i g h j k\) x3  
5 6 7 8 t y 5 u i g m ,  
\(1 z 2 x 3 c 4 v a s d f r e 1 z 2 x 3 c 4 v a s d f w q\) x2 \[More coming soon\]


How to add songs:
-
1. Create a new folder in the `/aud` directory.
2. Add sound files in the WAV format (See "File naming").
3. In `Menu.java`, call `newButton(String, String)` in the constructor (around line 41).
    - First parameter: Name of song (displayed on button).
    - Second parameter: Name of folder containing sound files (from step 1).
4. Compile and run.


File naming:
-
Each sound file will consist of 2 characters. The first character will refer to the key that the sound is mapped to. The second one will refer to the sound set that the sound file should be stored in (0, 1, or 2).
- Sets:
    - 0 - Loaded by pressing the right arrow key. This is loaded by default.
    - 1 - Loaded by pressing up arrow key.
    - 2 - Loaded by pressing left arrow key.
For example:
- "10.wav" will be played when set 0 is loaded (default) and when the '1' key is pressed.
- ",2.wav" will be played when set 2 is loaded (left arrow key) and when the ',' key is pressed.

Note: When compiling, make sure the file paths in `Sound.java`, `Menu.java`, and `LaunchpadButton.java` are correct.
