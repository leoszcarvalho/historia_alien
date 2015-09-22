package com.carvalho.leonardo.historiaalienigena.models;

/**
 * Created by Leonardo on 19/09/2015.
 */
public class Choice
{

    private String mText;
    private int mNextPage;

    public Choice(String text, int next)
    {
        mText = text;
        mNextPage = next;

    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }


}
