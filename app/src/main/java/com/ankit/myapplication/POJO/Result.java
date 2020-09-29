package com.ankit.myapplication.POJO;

public class Result {

    private int pregnancies;
    private int glucose;
    private int bloodPressure;
    private int skinThickess;
    private int insulin;
    private double bmi;
    private int age;
    private String result;

    public Result() {}

    public void setValue(int pregnancies, int glucose, int bloodPressure, int skinThickess,
                         int insulin, double bmi, int age, String result) {
        this.pregnancies = pregnancies;
        this.glucose = glucose;
        this.bloodPressure = bloodPressure;
        this.skinThickess = skinThickess;
        this.insulin = insulin;
        this.bmi = bmi;
        this.age = age;
        this.result = result;
    }

    public int getPregnancies() {
        return pregnancies;
    }

    public int getGlucose() {
        return glucose;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public int getSkinThickess() {
        return skinThickess;
    }

    public int getInsulin() {
        return insulin;
    }

    public double getBmi() {
        return bmi;
    }

    public int getAge() {
        return age;
    }

    public String getResult() {
        return result;
    }
}
