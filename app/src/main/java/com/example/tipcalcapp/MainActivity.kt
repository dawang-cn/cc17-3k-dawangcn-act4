package com.example.tipcalcapp

import android.os.Bundle
import android.text.Editable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tipcalcapp.databinding.ActivityMainBinding
import com.example.tipcalcapp.ui.theme.TipCalcAppTheme
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }

        }


    private fun calculateTip() {
        val cost = binding.costOfService.text.toString().toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15

        }

        var tip : Double = cost*tipPercentage
        val roundUp : Boolean = binding.roundTip.isChecked
        if (roundUp){
            tip = ceil(tip)
        }

        val currencyTip: String = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, currencyTip)

    }


}