package com.example.insurancecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var currentData: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentData = ViewModelProviders.of(this).get(PremiumModel::class.java)

        display()
        fun getPremium():Double{

            return when(ageSpinner.selectedItemPosition)
            {
                0 -> 60.00
                1->70.00+
                        (if(maleCheck.isChecked)50.00 else 0.0)+
                        (if(smokeCheck.isChecked)100.00 else 0.0)
                2-> 90.00 +
                        (if(maleCheck.isChecked)100.00 else 0.0)+
                        (if(smokeCheck.isChecked)150.00 else 0.0)
                3-> 120.00+
                        (if(maleCheck.isChecked)150.00 else 0.0)+
                        (if(smokeCheck.isChecked)200.00 else 0.0)
                4-> 150.00+
                        (if(maleCheck.isChecked)200.00 else 0.0)+
                        (if(smokeCheck.isChecked)250.00 else 0.0)
                else -> 150.00+
                        (if(maleCheck.isChecked)200.00 else 0.0)+
                        (if(smokeCheck.isChecked)300.00 else 0.0)
            }
        }

        calcBut.setOnClickListener {


            currentData.currentAmount = getPremium()
            display()
        }

        resetBut.setOnClickListener{
            ageSpinner.setSelection(0)

            radioGroup.clearCheck()
            smokeCheck.setChecked(false)
            totalPremCalced.text = "Total Premium :"
            currentData.currentAmount = 0.0
        }

    }

    private fun display() {
        totalPremCalced.text = "Total Premium : RM%.2f".format(currentData.currentAmount)
    }


}
