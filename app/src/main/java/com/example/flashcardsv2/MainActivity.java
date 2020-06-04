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

    public static final String QUESTION = "com.example.flashcardsv2.QUESTION";
    public static final String ANSWER = "com.example.flashcardsv2.ANSWER";
    private static final String TAG = "MainActivity";
    private static final String mypreference = "mypref";
    private static final String question = "saveQuestion";
    private static final String answer = "saveAnswer";
    private String q;
    private String a;
    EditText flashcardQuestion;
    EditText flashcardAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flashcardQuestion = findViewById(R.id.question);
        flashcardAnswer = findViewById(R.id.answer);
    }

    public void saveCard (View view) {
        SharedPreferences sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(question, q);
        editor.putString(answer, a);
        editor.commit();

        //Create a Toast
        Toast toast = Toast.makeText(getApplicationContext(), "Card Saved Successfully",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void viewCard(View view) {
        Intent intent = new Intent (this, Flashcard.class);
        intent.putExtra(ANSWER, flashcardAnswer.getText().toString());
        intent.putExtra(QUESTION, flashcardQuestion.getText().toString());
        startActivity(intent);
    }

}
