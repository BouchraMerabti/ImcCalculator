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

    ImageView ivImage;
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

        tvResult.setVisibility(View.GONE);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                IMC = weight / (height * height);



                if (IMC < 18.5){
                    tvResult.setText("Insufficient weight");
                } else if (IMC >= 18.5 &  IMC <= 24.9) {
                    tvResult.setText("Normal weight");
                } else if (IMC >= 25 & IMC <= 26.9) {
                    tvResult.setText("Overweight grade 1");
                }else if (IMC >= 27 & IMC <= 29.9) {
                    tvResult.setText("Overweight grade 2 (Pre-obesity)");
                }else if (IMC >= 30 & IMC <= 34.9) {
                    tvResult.setText("Type 1 obesity");
                }else if (IMC >= 35 & IMC <= 39.9) {
                    tvResult.setText("Type 2 obesity");
                }else if (IMC >= 40 & IMC <= 49.9) {
                    tvResult.setText("Type 3 obesity (Morbid)");
                }else if (IMC >= 50) {
                    tvResult.setText("Type 4 obesity (Extreme)");
                }
 




            }
        });
    }
}