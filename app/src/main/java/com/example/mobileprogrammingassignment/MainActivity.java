package com.example.mobileprogrammingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button share, butQuiz, butLout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        share=(Button) findViewById(R.id.share);
        butQuiz = findViewById(R.id.Question1);
        butLout = findViewById(R.id.logOut);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Your Body Here";
                String shareSub = "Your Subject Here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent,"Share Using"));
            }
        });

        butQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuizActivity();
            }
        });

        butLout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoutActivity();
            }
        });

    }




    protected void onPause() {
        super.onPause();
        startService(new Intent(this, Notification.class));
    }

    public void openQuizActivity(){

        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

    public void openLoutActivity(){

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}