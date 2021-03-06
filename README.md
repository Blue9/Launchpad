# Launchpad
A mini-replica of the Novation Launchpad built using Java.

## Screenshots:  
![Menu](https://raw.githubusercontent.com/Blue9/Launchpad/master/screenshots/Menu.png "Launchpad Menu")  
![Launchpad](https://raw.githubusercontent.com/Blue9/Launchpad/master/screenshots/Launchpad.png "Launchpad in action")

## How to use it:  
1. Browse for a project folder.
2. Click start.
3. Each key corresponds to a different sound. Press different keys in the correct order to play the song. The arrow keys will load up different sets of loops (and lighting effects).

## Projects:  
By default, [Skrillex - Bangarang](https://youtu.be/cR2XilcGYOo) will be loaded. See [How to play Bangarang](https://github.com/Blue9/Launchpad#how-to-play-bangarang).  
You can view and download additional projects in the `/songs` directory or add your own.

## How to add songs:  
1. Create a new folder.
2. Add sound files in the WAV format (See "File naming").
3. Run the application and browse for the folder you just created.

## File naming:  
Each sound file will consist of 2 characters. The first character will refer to the key that the sound is mapped to. The second one will refer to the sound set that the sound file should be stored in (0, 1, or 2).
- Sets:
    - 0 - Loaded by pressing the right arrow key. This is loaded by default.
    - 1 - Loaded by pressing up arrow key.
    - 2 - Loaded by pressing left arrow key.
For example:
- "10.wav" will be played when set 0 is loaded (default) and when the '1' key is pressed.
- ",2.wav" will be played when set 2 is loaded (left arrow key) and when the ',' key is pressed.

### How to play Bangarang:  
1 z 2 x 3 c 4 v 5 b 6 n 7 m 8 a s d f g h j k i u y t \[LEFT\]  
\(5 6 7 8 t y 5 u i g h j k\) x3  
5 6 7 8 t y 5 u i g m ,  
\(1 z 2 x 3 c 4 v a s d f r e 1 z 2 x 3 c 4 v a s d f w  
1 z 2 x 3 c 4 v a s d f r e 1 z 2 x 3 c 4 v a s d f w q\) x2  
b \[UP\]  
1 2 3 4 5 6 7 1 2 3 4 8 z x c v b n m , q n m , 7 n m , q 8 e r t y u i \[RIGHT\]  
q w e r \[UP\]  
\(a s d f\) x2  
g h j k 1 2 3 4 5 6 7 1 2 3 4 8 z x c v b n m , q n m , 7 n m , q 8 z x c v b \[LEFT\]  
1 z 2 x 3 c 4 v a s d f r e 1 z 2 x 3 c 4 v a s d f w 1 z 2 x 3 c 4 v a s d f r e 1 z 2 x 3 c 4 v a s d f w q n

Credit to [GHET1](https://www.youtube.com/channel/UCE65SfxnGGkudvPYlfRobCg) for some Bangarang samples.

**Disclaimer:** This project is neither affiliated with nor endorsed by Novation Digital Music Systems.
