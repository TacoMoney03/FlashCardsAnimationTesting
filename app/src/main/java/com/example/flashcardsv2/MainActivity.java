package com.example.flashcardsv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare variables for preferences, logging, strings, and text views
    public static final String QUESTION = "com.example.flashcardsv2.QUESTION";
    public static final String ANSWER = "com.example.flashcardsv2.ANSWER";
    public static final String QUESTION2 = "com.example.flashcardsv2.QUESTION2";
    public static final String ANSWER2 = "com.example.flashcardsv2.ANSWER2";
    private static final String TAG = "MainActivity";
    private static final String mypreference = "mypref";
    private static final String question = "saveQuestion";
    private static final String answer = "saveAnswer";
    private static final String question2 = "saveQuestion2";
    private static final String answer2 = "saveAnswer2";
    private String q;
    private String a;
    private String q2;
    private String a2;
    EditText flashcardQuestion;
    EditText flashcardAnswer;
    EditText flashcardQuestion2;
    EditText flashcardAnswer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // grab the 4 views by ID on create - keeps later methods cleaner
        flashcardQuestion = findViewById(R.id.question);
        flashcardAnswer = findViewById(R.id.answer);
        flashcardQuestion2 = findViewById(R.id.question2);
        flashcardAnswer2 = findViewById(R.id.answer2);
    }

    // method for save button on main activity
    public void saveCard (View view) {
        // open a shared preferences editor
        SharedPreferences sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        // put the data from all 4 edit views into the shared preferences
        editor.putString(question, q);
        editor.putString(answer, a);
        editor.putString(question2, q2);
        editor.putString(answer2, a2);
        editor.commit();

        //Create a Toast
        Toast toast = Toast.makeText(getApplicationContext(), "Card Saved Successfully",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    // method to call next activity to view flashcards
    public void viewCard(View view) {
        // create the intent
        Intent intent = new Intent (this, Flashcard.class);
        // pass all 4 strings into the intent
        intent.putExtra(ANSWER, flashcardAnswer.getText().toString());
        intent.putExtra(QUESTION, flashcardQuestion.getText().toString());
        intent.putExtra(ANSWER2, flashcardAnswer2.getText().toString());
        intent.putExtra(QUESTION2, flashcardQuestion2.getText().toString());
        startActivity(intent);
    }

}
