package com.ankit.myapplication.Exercises

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.ankit.myapplication.R
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class Walking : AppCompatActivity(), SensorEventListener {

    private var sensorManager:SensorManager?=null

    private var running = false

    private var totalSteps = 0f
    private var previousTotalSteps = 0f

    private lateinit var tv_stepsTaken:TextView
    private lateinit var circular_progress:CircularProgressBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walking)
        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager

        tv_stepsTaken=findViewById(R.id.tv_stepsTaken);
        circular_progress=findViewById(R.id.circularProgressBar)
        loadData()
        resetSteps()
        circular_progress.progress=20.toFloat()
        tv_stepsTaken.setText("1068")


    }

    override fun onResume() {
        super.onResume()
        running = true

        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if(stepSensor == null){
            Toast.makeText(this,"No Sensor detected on the device", Toast.LENGTH_SHORT).show()

        }else{
            sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
            if(running){
                totalSteps = event!!.values[0]
                val currentSteps = totalSteps.toInt()-previousTotalSteps.toInt()
                tv_stepsTaken.text=("$currentSteps")

                circular_progress.apply {
                    setProgressWithAnimation(currentSteps.toFloat())
                }

            }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }

    fun resetSteps(){
        tv_stepsTaken.setOnClickListener{
            Toast.makeText(this,"Longtap to reset", Toast.LENGTH_SHORT).show();
        }

        tv_stepsTaken.setOnLongClickListener{
            previousTotalSteps = totalSteps
            tv_stepsTaken.text=0.toString()
            savedData()

            true

        }
    }

    private fun savedData() {
        val sharedPreferences=getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val editor =sharedPreferences.edit()
        editor.putFloat("key1",previousTotalSteps)
        editor.apply()

    }

    private fun loadData(){
        val sharedPreferences=getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val savedNumber=  sharedPreferences.getFloat("key1",0f);
        previousTotalSteps=savedNumber
    }

    public fun gotoRewards(v: View){
//        var intent = Intent(applicationContext,)
        Toast.makeText(this,"Please Complete your daily task to earn rewards",Toast.LENGTH_LONG).show()
    }
}