package com.example.flashcardsv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Flashcard extends AppCompatActivity {

    private static final String TAG = "DisplayQuestion";
    public static final String ANSWER = "com.example.flashme.ANSWER2";
    private static final String mypreference = "mypref";
    private static final String question = "saveQuestion";
    private static final String answer = "saveAnswer";
    Intent _intent;
    private String q;
    private String a;
    Switch sw1;
    TextView flashcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        sw1 = findViewById(R.id.switch1);
        flashcard = findViewById(R.id.Flashcard);
        _intent = getIntent();
        q = _intent.getStringExtra(MainActivity.QUESTION);
        a = _intent.getStringExtra(MainActivity.ANSWER);
        flashcard.setText(q);

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String str1;
                if (sw1.isChecked())
                    str1 = a;
                else
                    str1 = q;
                flashcard.setText(str1);
            }
        });
    }
}
