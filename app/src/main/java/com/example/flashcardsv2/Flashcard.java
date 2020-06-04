package com.example.flashcardsv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Flashcard extends AppCompatActivity {

    // declare all variables
    Intent _intent;
    private String q;
    private String a;
    private String q2;
    private String a2;
    Switch sw1;
    Switch sw2;
    TextView flashcard;
    TextView flashcard2;
    Button next;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        // grab all views by ID on create
        sw1 = findViewById(R.id.switch1);
        sw2 = findViewById(R.id.switch2);
        flashcard = findViewById(R.id.Flashcard);
        flashcard2 = findViewById(R.id.Flashcard2);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        // get the intent
        _intent = getIntent();
        // get all 4 strings and set them to variables
        q = _intent.getStringExtra(MainActivity.QUESTION);
        a = _intent.getStringExtra(MainActivity.ANSWER);
        q2 = _intent.getStringExtra(MainActivity.QUESTION2);
        a2 = _intent.getStringExtra(MainActivity.ANSWER2);
        // set the two flashcards to start by showing the question
        flashcard.setText(q);
        flashcard2.setText(q2);
        // set the second flashcard stuff to be invisible on create
        sw2.setVisibility(View.INVISIBLE);
        flashcard2.setVisibility(View.INVISIBLE);
        // set the previous button to be invisible on create, since there isn't a previous card to go to at this point
        previous.setVisibility(View.INVISIBLE);

        // if statement to switch the string shown in the text view based on position of the toggle switch
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

        // same thing, but for the second switch, this starts out hidden
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String str1;
                if (sw2.isChecked())
                    str1 = a2;
                else
                    str1 = q2;
                flashcard2.setText(str1);
            }
        });
    }

    // method for the next button
    public void next(View view) {
        // set everything for card 1 invisible, and card 2 visible
        flashcard.setVisibility(View.INVISIBLE);
        sw1.setVisibility(View.INVISIBLE);
        flashcard2.setVisibility(View.VISIBLE);
        sw2.setVisibility(View.VISIBLE);
        // set previous button to visible since we now have something to go back to
        previous.setVisibility(View.VISIBLE);
        // set next button invisible since there isn't another card
        next.setVisibility(View.INVISIBLE);
    }

    // method for the previous button
    public void previous(View view) {
        // set everything for card 2 invisible, and card 1 visible
        flashcard2.setVisibility(View.INVISIBLE);
        sw2.setVisibility(View.INVISIBLE);
        flashcard.setVisibility(View.VISIBLE);
        sw1.setVisibility(View.VISIBLE);
        // hide the previous button, since we are at the start again
        previous.setVisibility(View.INVISIBLE);
        // make the next button visible again, since there are more cards to flip through now
        next.setVisibility(View.VISIBLE);
    }
}
