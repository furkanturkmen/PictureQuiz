package com.example.furkan_asus.picturequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Local variables

    private int currentImageIndex = 0;
    private int[] mImageNames;
    private ImageView mImageView;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheckButton;
    private RadioGroup mGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        mGroup = findViewById(R.id.radioGroup);
        mNextButton = findViewById(R.id.nButton);
        mPrevButton = findViewById(R.id.pButton);
        mCheckButton = findViewById(R.id.cButton);

        mImageNames = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3};

        // Define what happens when the user clicks the "next image" button
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentImageIndex++;
                if(currentImageIndex >= mImageNames.length){
                    currentImageIndex = 0;
                }
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }
        });

        // Define what happens when the user clicks the "previous image" button
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentImageIndex--;
                if(currentImageIndex < 0){
                    currentImageIndex = 2;
                }
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }
        });

        // Define what happens when the user clicks the "check image" button
        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioButtonID = mGroup.getCheckedRadioButtonId();
                View radioButton = mGroup.findViewById(radioButtonID);
                int answerIndex = mGroup.indexOfChild(radioButton);

                checkAnswer(answerIndex);
            }
        });
    }

    private void checkAnswer(int answer) {
        String message;
        if (answer == currentImageIndex) {
            message = "Great";
        } else {
            message = "Wrong";
        }
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
