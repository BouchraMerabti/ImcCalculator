package com.example.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ivImage, imEmoji;
    EditText etWeight, etHeight;

    Button btnCalculate;

    TextView tvResult;

    double weight, height, IMC;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImage = findViewById(R.id.ivImage);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        imEmoji = findViewById(R.id.imEmoji);

        tvResult.setVisibility(View.GONE);
        imEmoji.setVisibility(View.GONE);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    weight = Double.parseDouble(etWeight.getText().toString());
                    height = Double.parseDouble(etHeight.getText().toString()) / 100;

                    IMC = weight / (height * height);


                    String resultText = "";
                    if (IMC < 18.5) {
                        resultText = "Insufficient weight";
                        imEmoji.setImageResource(R.drawable.bad);
                    } else if (IMC >= 18.5 && IMC <= 24.9) {
                        resultText = "Normal weight";
                        imEmoji.setImageResource(R.drawable.big_smile);
                    } else if (IMC >= 25 && IMC <= 26.9) {
                        resultText = "Overweight grade 1";
                        imEmoji.setImageResource(R.drawable.ok);
                    } else if (IMC >= 27 && IMC <= 29.9) {
                        resultText = "Overweight grade 2 (Pre-obesity)";
                        imEmoji.setImageResource(R.drawable.very_bad);
                    } else if (IMC >= 30 && IMC <= 34.9) {
                        resultText = "Type 1 obesity";
                        imEmoji.setImageResource(R.drawable.very_bad);
                    } else if (IMC >= 35 && IMC <= 39.9) {
                        resultText = "Type 2 obesity";
                        imEmoji.setImageResource(R.drawable.very_bad);
                    } else if (IMC >= 40 && IMC <= 49.9) {
                        resultText = "Type 3 obesity (Morbid)";
                        imEmoji.setImageResource(R.drawable.very_bad);
                    } else {
                        resultText = "Type 4 obesity (Extreme)";
                        imEmoji.setImageResource(R.drawable.very_bad);
                    }


                    tvResult.setText("You are : " + resultText);
                    tvResult.setVisibility(View.VISIBLE);
                    imEmoji.setVisibility(View.VISIBLE);
                } catch (Exception e) {

                    tvResult.setText("Please enter a valid number");
                    tvResult.setVisibility(View.VISIBLE);
                    imEmoji.setVisibility(View.VISIBLE);


                }
            }
        });
    }
}