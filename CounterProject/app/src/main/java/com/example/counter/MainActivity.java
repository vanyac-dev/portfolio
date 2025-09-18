package com.example.counter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counterText);
        Button incrementButton = findViewById(R.id.incrementButton);
        Button resetButton = findViewById(R.id.resetButton);

        //added to make beginning's sound
        MediaPlayer launchSound = MediaPlayer.create(this, R.raw.launch_sound);
        launchSound.start();
        //optional
        launchSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        // Restore counter value after rotation
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0);
            counterText.setText(String.valueOf(counter));
        }

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                counterText.setText(String.valueOf(counter));
                //added for sound
                if (counter % 10 == 0) {
                    // Play reward sound
                    MediaPlayer rewardSound = MediaPlayer.create(MainActivity.this, R.raw.reward_sound);
                    rewardSound.start();
                    rewardSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

                    // Show toast message
                    Toast.makeText(MainActivity.this, "🎉 You reached " + counter + " taps! 🎉", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                counterText.setText(String.valueOf(counter));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter); // Save current counter value
    }
}