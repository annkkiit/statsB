package com.ankit.myapplication.ui.check;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ankit.myapplication.R;
import com.ankit.myapplication.ResultActivity;
import com.ankit.myapplication.BaseActivity;
import com.ankit.myapplication.detection.monumodelDetect;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class CheckFragment extends Fragment {

    private CheckViewModel checkViewModel;
    private ArrayList<TextInputEditText> editTexts;
    private TextInputEditText pregnancies;
    private TextInputEditText glucose;
    private TextInputEditText bloodPressure;
    private TextInputEditText skinThickness;
    private TextInputEditText insulin;
    private TextInputEditText weight;
    private TextInputEditText height;
    private TextInputEditText age;
    private CardView checkButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        checkViewModel = ViewModelProviders.of(this).get(CheckViewModel.class);
        View root = inflater.inflate(R.layout.fragment_check, container, false);

        initializeUI(root);

        initializeOnClickListener();

        return root;
    }

    private void initializeUI(View root) {
        pregnancies = root.findViewById(R.id.pregnancies);
        glucose = root.findViewById(R.id.glucose_level);
        bloodPressure = root.findViewById(R.id.blood_pressure);
        skinThickness = root.findViewById(R.id.skin_thickness);
        insulin = root.findViewById(R.id.insulin_level);
        weight = root.findViewById(R.id.weight);
        height = root.findViewById(R.id.height);
        age = root.findViewById(R.id.age);

        checkButton = root.findViewById(R.id.buttonCheck);
        editTexts = new ArrayList<TextInputEditText>() {{
            add(pregnancies);
            add(glucose);
            add(bloodPressure);
            add(skinThickness);
            add(insulin);
            add(weight);
            add(height);
            add(age);
        }};
    }

    private void initializeOnClickListener() {
        pregnancies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean allFilled = true;

                for (int i = 0; i < editTexts.size(); i++) {

                    if (TextUtils.isEmpty(editTexts.get(i).getText())&& i!=1 && i!=2 && i!=3 && i!=4 ) {


                        editTexts.get(i).setError("This field is required!");
                        allFilled = false;
                    }

                    if(TextUtils.isEmpty(editTexts.get(i).getText())&& i==1){
                        glucose.setText("100");
                    }

                    if(TextUtils.isEmpty(editTexts.get(i).getText())&& i==2){
                        bloodPressure.setText("120");
                    }

                    if(TextUtils.isEmpty(editTexts.get(i).getText())&& i==3){
                        skinThickness.setText("18");
                    }

                    if(TextUtils.isEmpty(editTexts.get(i).getText())&& i==4){
                        insulin.setText("20");
                    }
                }

                if (allFilled) {
                    Intent intent = new Intent(CheckFragment.super.getContext(), ResultActivity.class);
                    intent.putExtra("pregnancies", pregnancies.getText().toString());
                    intent.putExtra("glucose", glucose.getText().toString());
                    intent.putExtra("blood_pressure", bloodPressure.getText().toString());
                    intent.putExtra("skin_thickness", skinThickness.getText().toString());
                    intent.putExtra("insulin", insulin.getText().toString());
                    intent.putExtra("bmi", Double.toString(countBMI()));
                    intent.putExtra("age", age.getText().toString());
                    startActivity(intent);
                    clearForm();
                }
            }
        });
    }

    private void clearForm() {
        for (TextInputEditText a : editTexts) {
            a.setText("");
        }
    }

    private double countBMI() {
        double weight = Double.parseDouble(this.weight.getText().toString());
        double height = Double.parseDouble(this.height.getText().toString());

        return weight / Math.pow(height, 2);
    }

    public void openEyes(View v){
        BaseActivity b = new BaseActivity();

        Intent intent = new Intent(getActivity(), monumodelDetect.class);
        startActivity(intent);
    }

}