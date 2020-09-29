package com.ankit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultDetail extends AppCompatActivity {

    private TextView pregnancies;
    private TextView glucose;
    private TextView bloodPressure;
    private TextView skinThickness;
    private TextView insulin;
    private TextView bmi;
    private TextView age;
    private TextView result;
    private ImageView imageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_detail);

        Intent intent = getIntent();

        initializeUI();
        initializeValue(intent);
    }

    private void initializeUI() {
        pregnancies = findViewById(R.id.res_pregnancies);
        glucose = findViewById(R.id.res_glucose);
        bloodPressure = findViewById(R.id.res_blood_pressure);
        skinThickness = findViewById(R.id.res_skin_thickness);
        insulin = findViewById(R.id.res_insulin_level);
        bmi = findViewById(R.id.res_bmi);
        age = findViewById(R.id.res_age);
        result = findViewById(R.id.result);
        imageResult = findViewById(R.id.res_img);
    }

    private void initializeValue(Intent intent) {
        pregnancies.setText(intent.getStringExtra("pregnancies"));
        glucose.setText(intent.getStringExtra("glucose"));
        bloodPressure.setText(intent.getStringExtra("blood_pressure"));
        skinThickness.setText(intent.getStringExtra("skin_thickness"));
        insulin.setText(intent.getStringExtra("insulin"));
        bmi.setText(intent.getStringExtra("bmi"));
        age.setText(intent.getStringExtra("age"));
        result.setText(intent.getStringExtra("result"));

        if (result.getText().toString().equals("NORMAL")) {
            imageResult.setImageResource(R.drawable.ic_undraw_feeling_happy);
        } else {
            imageResult.setImageResource(R.drawable.ic_undraw_feeling_sad);
        }
    }

}
