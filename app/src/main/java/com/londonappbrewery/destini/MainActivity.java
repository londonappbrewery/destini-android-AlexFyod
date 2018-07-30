package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView mStoryTextView;
    int mStoryIndex;
    Button mButtonTop;
    Button mButtonBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mStoryIndex = 1;

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    mStoryTextView.setText(R.string.T6_End);
                    disableButtons();
                    mStoryIndex = 6;
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryTextView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    mStoryTextView.setText(R.string.T4_End);
                    disableButtons();
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                    mStoryTextView.setText(R.string.T5_End);
                    disableButtons();
                    mStoryIndex = 5;
                }
            }
        });

        if (savedInstanceState != null) {
            restoreState(savedInstanceState.getInt("StoryIndexKey"));
        }
    }

    private void disableButtons() {
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndexKey", mStoryIndex);
    }

    private void restoreState(int storyIndex) {
        if (storyIndex == 1) {
            mStoryTextView.setText(R.string.T1_Story);
            mButtonTop.setText(R.string.T1_Ans1);
            mButtonTop.setText(R.string.T1_Ans2);
        } else if (storyIndex == 2) {
            mStoryTextView.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonTop.setText(R.string.T2_Ans2);
        } else if (storyIndex == 3) {
            mStoryTextView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonTop.setText(R.string.T3_Ans2);
        } else {
            if (storyIndex == 4) {
                mStoryTextView.setText(R.string.T4_End);
            } else if (storyIndex == 5) {
                mStoryTextView.setText(R.string.T5_End);
            } else if (storyIndex == 6) {
                mStoryTextView.setText(R.string.T6_End);
            }
            disableButtons();
        }
        mStoryIndex = storyIndex;
    }
}
