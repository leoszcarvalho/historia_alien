package com.carvalho.leonardo.historiaalienigena.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.carvalho.leonardo.historiaalienigena.R;
import com.carvalho.leonardo.historiaalienigena.models.Page;
import com.carvalho.leonardo.historiaalienigena.models.Story;

public class StoryActivity extends AppCompatActivity {

    private String nome;
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mStoryTextView;
    private Button mChoice1;
    private Button mChoice2;
    private Page page;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        nome = intent.getStringExtra("nome");

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choice1Button);
        mChoice2 = (Button) findViewById(R.id.choice2Button);

        loadPage(0);

    }

    private void loadPage(int pageNumber)
    {

        page = mStory.getPage(pageNumber);

        Drawable drawable = ContextCompat.getDrawable(StoryActivity.this, page.getImageId());
        mImageView.setImageDrawable(drawable);

        String textoMain = page.getText();

        String.format(textoMain, nome);

        mStoryTextView.setText(String.format(textoMain, nome));

        if(!page.isFinal())
        {

            mChoice1.setText(page.getChoice1().getText());
            mChoice2.setText(page.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    loadPage(page.getChoice1().getNextPage());

                }

            });


            mChoice2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    loadPage(page.getChoice2().getNextPage());

                }

            });


        }
        else
        {

            mChoice1.setVisibility(View.INVISIBLE);

            mChoice2.setText("Play Again");

            mChoice2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    finish();
                }

            });

        }

    }




}
