# Launchpad
A mini-replica of the Novation Launchpad built using Java.

## Screenshots:  
![Menu](https://raw.githubusercontent.com/Blue9/Launchpad/master/screenshots/Menu.png "Launchpad Menu")  
![Launchpad](https://raw.githubusercontent.com/Blue9/Launchpad/master/screenshots/Launchpad.png "Launchpad in action")

## How to use it:  
1. Browse for a project folder.
2. Click start.
3. Each key corresponds to a different sound. Press different keys in the correct order to play the song. The arrow keys will load up different sets of loops (and lighting effects).

## How to add songs:  
1. Create a new folder.
2. Add sound files in the WAV format (See "File naming").
3. Run the application and browse for the folder you just created.

### Download projects:  
You can view and download some projects in the `/songs` directory. 

## File naming:  
Each sound file will consist of 2 characters. The first character will refer to the key that the sound is mapped to. The second one will refer to the sound set that the sound file should be stored in (0, 1, or 2).
- Sets:
    - 0 - Loaded by pressing the right arrow key. This is loaded by default.
    - 1 - Loaded by pressing up arrow key.
    - 2 - Loaded by pressing left arrow key.
For example:
- "10.wav" will be played when set 0 is loaded (default) and when the '1' key is pressed.
- ",2.wav" will be played when set 2 is loaded (left arrow key) and when the ',' key is pressed.

**Disclaimer:** This project is neither affiliated with nor endorsed by Novation Digital Music Systems.
