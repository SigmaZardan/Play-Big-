package com.bibek.numberguessingapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        val constraintNumberGuess = findViewById<ConstraintLayout>(R.id.clNumberGuess)



        // handling the click on the left button

        btnLeft.setOnClickListener {
            // code here will run every time the left button is clicked
            val leftNumber = btnLeft.text.toString().toInt()
            val rightNumber = btnRight.text.toString().toInt()

            // compare two numbers and set the required UI
            compareNumbersAndSetUi(leftNumber , rightNumber , constraintNumberGuess, true)

            // generate new random numbers and assign then on the buttons
            //assign the values to the button
            assignNumbersToButtons(btnLeft, btnRight)


        }


      // handling the click on the right button
        btnRight.setOnClickListener {
            // code here will run every time the left button is clicked

            val leftNumber = btnLeft.text.toString().toInt()
            val rightNumber = btnRight.text.toString().toInt()

            // compare the two numbers and set the required UI 
            compareNumbersAndSetUi(leftNumber, rightNumber,constraintNumberGuess, false)

            // generate new random numbers and assign then on the buttons
            // assign the value to the button

            assignNumbersToButtons(btnLeft, btnRight)
        }



    }


    // fun that generate  random number

    private fun assignNumbersToButtons(btnLeft: Button, btnRight: Button)  {

        val leftNumber = generateRandomNumber()
        var rightNumber = generateRandomNumber()

        while(leftNumber == rightNumber) rightNumber = generateRandomNumber()

        btnLeft.text = leftNumber.toString()
        btnRight.text = rightNumber.toString()

    }
    // generate random number

    private fun generateRandomNumber() : Int {

        return (1..100).random()
    }


    // compare numbers and set the correct UI
    private fun compareNumbersAndSetUi(leftNumber : Int , rightNumber : Int, constraintNumber : ConstraintLayout , isLeftButtonSelected : Boolean) {
        val isCorrectAnswer = if(isLeftButtonSelected) leftNumber > rightNumber else rightNumber > leftNumber
        if(isCorrectAnswer) {
            // change the background color to green
            constraintNumber.setBackgroundColor(Color.GREEN)
            // show a toast that the answer is correct
            Toast.makeText(this@MainActivity, "Correct answer!", Toast.LENGTH_SHORT).show()
        }
        else {
            // change the background color to red
            constraintNumber.setBackgroundColor(Color.RED)

            // show a toast that the answer is not correct
            Toast.makeText(this@MainActivity, "INCORRECT ANSWER" , Toast.LENGTH_SHORT).show()

        }


    }
}