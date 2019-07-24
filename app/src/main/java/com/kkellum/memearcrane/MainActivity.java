package com.kkellum.memearcrane;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public Button mNext_Button;


    private TextView mTextView;
    private EditText mEditText;

    private LinearLayout mFillTheBlankContainer;

    private Button mNextButton;
    private Button mCheckButton;

    private Question[] mQuestions;
    private int mIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNextButton = (Button) findViewById(R.id.next_button);
        mCheckButton = (Button) findViewById(R.id.check_button);


        mFillTheBlankContainer = (LinearLayout) findViewById(R.id.fill_the_blank_container);

        mEditText = (EditText) findViewById(R.id.edit_text);


        mNextButton.setOnClickListener(this);
        mCheckButton.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.text_view);

        // Initialize an array of questions.
        mQuestions = new Question[5];
        mIndex = 0;

        // Initialize each slot in the array.
        String[] q0Answers = new String[0];
        mQuestions[0] = new FillTheBlankQuestion(R.string.question_1, R.string.question_1_hint, q0Answers);
        String[] q1Answers = new String[1];
        mQuestions[1] = new FillTheBlankQuestion(R.string.question_2, R.string.question_2_hint, q1Answers);
        String[] q2Answers = new String[2];
        mQuestions[2] = new FillTheBlankQuestion(R.string.question_3, R.string.question_3_hint, q2Answers);
        String[] q3Answers = new String[3];
        mQuestions[3] = new FillTheBlankQuestion(R.string.question_4, R.string.question_4_hint, q3Answers);
        String[] q4Answers = new String[4];
        mQuestions[4] = new FillTheBlankQuestion(R.string.question_5, R.string.question_5_hint, q4Answers);


        q0Answers = getResources().getStringArray(R.array.question_1_answers);
        q1Answers = getResources().getStringArray(R.array.question_2_answers);
        q2Answers = getResources().getStringArray(R.array.question_3_answers);
        q3Answers = getResources().getStringArray(R.array.question_4_answers);
        q4Answers = getResources().getStringArray(R.array.question_5_answers);


        //setup the first question.
        setupQuestion();

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.check_button)
        {
            checkAnswer(mEditText.getText().toString());
        }
        else if (view.getId() == R.id.next_button) {

            // change to the next question...

            //Increment the index by one.
            mIndex++;

            //do if statement here:
            // if the mIdex is greater than or equal to mQuestions.length
            //  -set mIndex to 0
            // - end the quiz

            //change text in view.
            mTextView.setText(mQuestions[mIndex].getTextResId());
            
            //do if statement here:
            // -set mIndex to 0
            //-after every question

            //change in text in view.
            setupQuestion();

        }

    }

    public void setupQuestion()
    {
        mTextView.setText(mQuestions[mIndex].getTextResId());

    }

    public boolean checkAnswer(String userInput)
    {
        if (mQuestions[mIndex].checkAnswer(userInput)) {
            Toast myToast = Toast.makeText(this, "you are incorrect", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        } else {
            Toast myToast = Toast.makeText(this, "you are correct", Toast.LENGTH_SHORT);
            myToast.show();
            return true;
        }
    }
}





