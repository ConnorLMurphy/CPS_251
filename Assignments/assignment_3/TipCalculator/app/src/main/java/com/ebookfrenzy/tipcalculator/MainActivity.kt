package com.ebookfrenzy.tipcalculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.tipcalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val savedTips = "savedTips"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            val saveTips = savedInstanceState.getString(savedTips)
            binding.Tips.text = saveTips
        }



        binding.calcTip.setOnClickListener{

            if(binding.BillAmount.text.isNotEmpty()){
                val billVal = binding.BillAmount.text.toString().toInt()

                val tenPer = billVal + (billVal * 0.10)
                val fifPer = billVal + (billVal * 0.15)
                val twenPer = billVal + (billVal * 0.20)
                val tipCalced= "10% = " +tenPer +" " +
                        "15% = " + fifPer + " " +
                        "20% = " + twenPer
                binding.Tips.text = tipCalced

            }else{
                binding.Tips.text = "input a value"


            }

        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val saveTips: String = binding.Tips.text.toString()
        outState.putString(savedTips, saveTips)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val saveTips = savedInstanceState.getString(savedTips)
       
    }



}