package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurancepremiumcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            //Determine the age group
            val age = binding.spinnerAge.selectedItemPosition
            var basicPremium = 0;
            when (age) {
                0 -> basicPremium = 60
                1 -> basicPremium = 70
                2 -> basicPremium = 90
                3 -> basicPremium = 120
                4 -> basicPremium = 150
                else -> basicPremium = 150

            }
            // basicPremium = when(age){
            // 0 -> 60
            //1 -> 70
            // }
            //Determine the gender
            val gender = binding.radioGroupGender.checkedRadioButtonId
            var malePremium = 0
            if (gender == binding.radioButtonMale.id) {
                //Male extra payment
                when (age) {
                    0 -> malePremium = 0
                    1 -> malePremium = 50
                    2 -> malePremium = 100
                    3 -> malePremium = 150
                    4 -> malePremium = 200
                    else -> malePremium = 200
                }
            }
            //Determine the smoker
            var smokerPremium = 0;
            if (binding.checkBoxSmoker.isChecked) {
                when (age) {
                    0 -> smokerPremium = 0
                    1 -> smokerPremium = 100
                    2 -> smokerPremium = 150
                    3 -> smokerPremium = 200
                    4 -> smokerPremium = 250
                    else -> smokerPremium = 300

                }
            }
            //Calculate the total insurance premium
            var ans = basicPremium + malePremium + smokerPremium

            //Display output
            if (binding.checkBoxSmoker.isChecked) {
                binding.textViewSmokerPremium.text = "RM" + smokerPremium
            }else{
                binding.textViewSmokerPremium.text = ""
            }


        binding.textViewTotal.text = "RM" + ans


    }


        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            binding.textViewSmokerPremium.text = ""
            binding.textViewTotal.text = ""

        }
    }
}