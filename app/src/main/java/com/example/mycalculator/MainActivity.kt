package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

  var NewOp = true
  var OldNumber = ""
  var Op = "+"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    ///////////digits click function body////////////////////////////

    fun DigitClickEvent(view: View) {

        if (NewOp)
            EditText.setText("")
            NewOp = false
        var Bt_Click = EditText.text.toString()  //get text
        var Bu_Select = view as Button
        when(Bu_Select.id){

            OneBtn.id -> {Bt_Click += "1"}
            TwoBtn.id -> {Bt_Click += "2"}
            ThreeBtn.id -> {Bt_Click += "3"}
            FourBtn.id -> {Bt_Click += "4"}
            FiveBtn.id -> {Bt_Click += "5"}
            SixBtn.id -> {Bt_Click += "6"}
            SevenBtn.id -> {Bt_Click += "7"}
            EightBtn.id -> {Bt_Click += "8"}
            NineBtn.id -> {Bt_Click += "9"}
            DotBtn.id -> {Bt_Click += "."}
            ZeroBtn.id -> {Bt_Click += "0"}
            PlusMinusBtn.id -> {Bt_Click = "-$Bt_Click"}
}

            EditText.setText(Bt_Click)

    }

    ///////////operators click body///////////////////////////

    fun OperatorClickEvent(view: View) {

        NewOp = true
        OldNumber = EditText.text.toString()
        var Bu_Select = view as Button

        when(Bu_Select.id){

            PlusBtn.id -> {Op = "+"}
            MinusBtn.id -> {Op = "-"}
            MultiplyBtn.id -> {Op = "*"}
            DivideBtn.id -> {Op = "/"}
        }
    }

    //calculation method after clicking "equal" button

    fun equalevent(view: View) {
        var NewNumber = EditText.text.toString()
        var Result = 0.0

        when(Op){

            "+" -> { Result = OldNumber.toDouble() + NewNumber.toDouble()}
            "-" -> { Result = OldNumber.toDouble() - NewNumber.toDouble()}
            "*" -> { Result = OldNumber.toDouble() * NewNumber.toDouble()}
            "/" -> { Result = OldNumber.toDouble() / NewNumber.toDouble()}
        }
          EditText.setText(Result.toString())
    }

    //"Ac" button function body

    fun acevent(view: View) {
        EditText.setText("0")
        NewOp = true
    }

    //percentage "Mode" function body

    fun percentageevent(view: View) {
        var no = EditText.text.toString().toDouble()/100
        EditText.setText(no.toString())
        NewOp = true

    }
}