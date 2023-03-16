package com.example.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btCheck)
        val resultTV: TextView = findViewById(R.id.textTotal)
        var flagM: String = "Chicken Burger"
        var flagS: String = "Small Fries"
        var flagD: String = "Pepsi"
        //here .. create a spinner items (options)
        val spinnerM: Spinner = findViewById(R.id.spMain)
        val spinnerS: Spinner = findViewById(R.id.spSide)
        val spinnerD: Spinner = findViewById(R.id.spDrinks)
        var optionsM = arrayOf(
            "Chicken Burger",
            "Beef Burger",
            "Chicken Shawerma",
            "Beef Shawerma",
            "Fried Chicken"
        )
        var optionsS = arrayOf(
            "Small Fries",
            "Medium Fries",
            "Large Fries"
        )
        var optionsD = arrayOf(
            "Pepsi",
            "7Up",
            "Mirinda",
            "Mountain dew"
        )
        spinnerM.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionsM)
        spinnerS.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionsS)
        spinnerD.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionsD)
        button.setOnClickListener { view ->
            //code here
            //var x: Int = flag.toString().toInt();
            //var y: Int = flag.toString().toInt();
            resultTV.text = totalCalc(flagM, flagS, flagD).toString() +"JD"
        }

        spinnerM.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flagM = optionsM.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        spinnerS.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flagS = optionsS.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        spinnerD.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flagD = optionsD.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}
public fun totalCalc(a: String, b: String, c: String): Double {
    var sum: Double = 0.0
     when (a){
         "Chicken Burger"   -> sum += 4
         "Beef Burger"      -> sum += 5
         "Chicken Shawerma" -> sum += 3
         "Beef Shawerma"    -> sum += 4
         "Fried Chicken"    -> sum += 6
    }
    when (b){
        "Small Fries"       -> sum += 0.75
        "Medium Fries"      -> sum += 1
        "Large Fries"  -> sum += 1.5
    }
    when (c){
        "Pepsi"         -> sum += 0.5
        "7Up"           -> sum += 0.5
        "Mirinda"       -> sum += 0.5
        "Mountain dew"  -> sum += 0.5
    }
    return sum
}
