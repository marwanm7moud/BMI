package com.example.bmi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import com.example.bmi.Result
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val male=findViewById<LinearLayout>(R.id.male)
        val female=findViewById<LinearLayout>(R.id.female)
        val seekbar = findViewById<SeekBar>(R.id.seek)
        val cm = findViewById<TextView>(R.id.cm)
        val weight = findViewById<TextView>(R.id.weight)
        val age = findViewById<TextView>(R.id.age)
        val wplus = findViewById<Button>(R.id.wplus)
        val wminus = findViewById<Button>(R.id.wminus)
        val aplus = findViewById<Button>(R.id.aplus)
        val aminus = findViewById<Button>(R.id.aminus)
        val calc = findViewById<Button>(R.id.calc)


        var isMale:Boolean?= true
        var intheight:Int = 130;
        var intWeight:Int = 40;
        var intage:Int = 15;
        var result:Double=0.0


        wplus.setOnClickListener(){
            intWeight++
            weight.setText(intWeight.toString())
        }
        wminus.setOnClickListener(){
            intWeight--
            weight.setText(intWeight.toString())
        }
        aplus.setOnClickListener(){
            intage++
            age.setText(intage.toString())
        }
        aminus.setOnClickListener(){
            intage--
            age.setText(intage.toString())
        }

        seekbar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                intheight=p1
                cm.setText(p1.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        female.setOnClickListener{
            it.setBackgroundColor(Color.rgb(63 , 94 , 209))
            male.setBackgroundColor(Color.rgb(142 , 138 , 138))
            isMale=false
        }
        male.setOnClickListener{
            it.setBackgroundColor(Color.rgb(63 , 94 , 209))
            female.setBackgroundColor(Color.rgb(142 , 138 , 138))
            isMale=true
        }

        calc.setOnClickListener(){
            val intent = Intent(this , Result::class.java)
            val extras = Bundle()

            result= (intWeight/((intheight/100).toDouble().pow(2))).toDouble()

            extras.putDouble("Result" , result)
            extras.putInt("age" , intage)
            if(isMale==true){
                extras.putString("gender" , "Male")
            }else{
                extras.putString("gender" , "Female")
            }
            intent.putExtras(extras)
            startActivity(intent)
        }



    }



}