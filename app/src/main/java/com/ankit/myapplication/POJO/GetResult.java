package com.ankit.myapplication.POJO;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.ankit.myapplication.HttpHandler;
import com.ankit.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class GetResult extends AsyncTask<Void, Void, Void> {

    private ProgressDialog progressDialog;
    private Context context;
    private TextView result;
    private ImageView imageResult;
    private Result resultDetails;
    private int pregnancies;
    private int glucose;
    private int bloodPressure;
    private int skinThickess;
    private int insulin;
    private double bmi;
    private int age;
    private HashMap<String, String> resultHash;

    public GetResult(Context context, TextView result, ImageView imageResult, Result resultDetails, String pregnancies, String glucose, String bloodPressure,
                     String skinThickess, String insulin, String bmi, String age) {
        this.context = context;
        this.result = result;
        this.imageResult = imageResult;
        this.resultDetails = resultDetails;
        this.pregnancies = Integer.parseInt(pregnancies);
        this.glucose = Integer.parseInt(glucose);
        this.bloodPressure = Integer.parseInt(bloodPressure);
        this.skinThickess = Integer.parseInt(skinThickess);
        this.insulin = Integer.parseInt(insulin);
        this.bmi = Double.parseDouble(bmi);
        this.age = Integer.parseInt(age);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Fetching your result..");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        String url = "https://testtakeone.herokuapp.com/api/?pregnancies=" + this.pregnancies +
                "&glucose=" + this.glucose +
                "&bloodpressure=" + this.bloodPressure +
                "&skinthickness=" + this.skinThickess +
                "&insulin=" + this.insulin + "&bmi= " + this.bmi + "&age=" + this.age;

        HttpHandler httpHandler = new HttpHandler();
        String jsonStr = httpHandler.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                Log.e("ResultActicity", jsonStr);
                final JSONObject jsonResult = new JSONObject(jsonStr);

                resultHash = new HashMap<String, String>() {{
                    put("result", jsonResult.getString("result"));
                }};
            } catch (final JSONException e) {
                Log.e("ResultActivity", "Json parsing error: " + e.getMessage());
            }
        } else {
            Log.e("ResultActivity", "Couldn't get json from server.");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        resultDetails.setValue(pregnancies, glucose, bloodPressure, skinThickess, insulin, bmi, age, resultHash.get("result"));

        if (resultHash.get("result").equals("NORMAL")) {
            imageResult.setImageResource(R.drawable.ic_undraw_feeling_happy);
        } else {
            imageResult.setImageResource(R.drawable.ic_undraw_feeling_sad);
        }

        result.setText(resultHash.get("result"));
    }

}
