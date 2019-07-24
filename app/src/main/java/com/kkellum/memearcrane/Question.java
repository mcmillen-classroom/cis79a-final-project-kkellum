package com.kkellum.memearcrane;

public class Question
{
    private int mTextResId;
    private int mHintTextResId;

    public int getHintTextResId() {
        return mHintTextResId;
    }

    public void setHintTextResId(int hintTextResId) {
        mHintTextResId = hintTextResId;
    }

    public Question(int textResId, int hintTextResId) {
        mTextResId = textResId;
        mHintTextResId = hintTextResId;
    }

    // stub method
    // only applies to fill the blank question
    public boolean checkAnswer(String userAnswer) {
        return false;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }


}

