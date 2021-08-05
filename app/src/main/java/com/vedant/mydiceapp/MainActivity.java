package com.vedant.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imgdice1);
        ImageView imageView1 = findViewById(R.id.imgdice2);
     final   MediaPlayer mp= MediaPlayer.create(this,R.raw.dice_sound);

             int [] diceimage = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyDiceApp","this is clicked");

                Random random = new Random();

                int randomNumber = random.nextInt(6);
               int randomNumber1 = random.nextInt(6);
                Log.i("MyDiceApp",randomNumber + "");

                imageView.setImageResource(diceimage[randomNumber]);
              imageView1.setImageResource(diceimage[randomNumber1]);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(imageView);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(imageView1);
               mp.start();

            }
        });



    }
}