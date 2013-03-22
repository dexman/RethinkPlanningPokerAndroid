package com.rethinkbooks.rethinkplanningpoker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Grid extends Activity {

    private ImageView mBack;
    private ImageView mFront;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        mBack = (ImageView) findViewById(R.id.back);
        mBack.setOnClickListener(mBackClickListener);
        mFront = (ImageView) findViewById(R.id.front);
        mFront.setOnClickListener(mFrontClickListener);

        final ArrayList<ImageButton> buttons = new ArrayList<ImageButton>();
        collectButtons((ViewGroup) findViewById(android.R.id.content), buttons);

        final Card[] cards = Card.loadCards();
        for (int i = 0; i < cards.length; ++i) {
            final Card card = cards[i];
            final ImageButton button = buttons.get(i);
            button.setScaleType(ImageView.ScaleType.FIT_CENTER);
            button.setImageResource(card.smallFaceResId);
            button.setOnClickListener(createOnClickListener(card));
        }
    }

    private final View.OnClickListener mBackClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mBack.setVisibility(View.GONE);
            mFront.setVisibility(View.VISIBLE);
        }

    };

    private final View.OnClickListener mFrontClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mFront.setVisibility(View.GONE);
        }

    };

    private View.OnClickListener createOnClickListener(final Card card) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBack.setVisibility(View.VISIBLE);
                mFront.setImageResource(card.largeFaceResId);
            }
        };
    }

    private static void collectButtons(ViewGroup viewGroup, List<ImageButton> buttons) {
        final int count = viewGroup.getChildCount();
        for (int i = 0; i < count; ++i) {
            final View child = viewGroup.getChildAt(i);
            if (child instanceof ImageButton) {
                buttons.add((ImageButton) child);
            } else if (child instanceof ViewGroup) {
                collectButtons((ViewGroup) child, buttons);
            }
        }
    }

}
