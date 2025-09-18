#Counter Project

A simple Android app that lets users increment a counter with a fun reward
every 10 taps.

#Features
- Tap a button to increment a counter
- Reset the counter at any time
- Plays a launch sound when the app starts
- Plays a reward sound and displays a 🎉 toast message every 10 taps
- Maintains the counter state during screen rotation (using 'onSaveInstanceState')

#Built with
- Kotlin
- Android Studio
- Android SDK
- XML Layouts
- 'MediaPlayer' for sound effects
- 'Toast' messages for user feedback

##Project Structure
- 'MainActivity.java' - Core logic for the counter, sounds, and state saving
- 'activity_main.xml' - UI layout with buttons and text view
- 'res/raw/' - Sound files ('launch_sound.mp3' and 'reward_sound.mp3')

#How to Run
1. Clone the repository (in bash):
git clone https://github.com/vanyac-dev/portfolio.git
2. Navigate to project folder
cd portfolio/CounterProject
3. Open the project in Android studio
Go to File > Open, then select CounterProject folder
4. Run the app
Click the green "Run" button or press Shift + F10
5. The app should launch and play startup sound. Tap the button to increment the counter. Every 10 taps, you'll get a reward sound and toast message!
