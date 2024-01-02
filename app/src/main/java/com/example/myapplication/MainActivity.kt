package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var math_operation: TextView
    private lateinit var result_text: TextView
    private lateinit var btn_clear: TextView
    private lateinit var btn_open_parenthesis: TextView
    private lateinit var btn_closing_parenthesis: TextView
    private lateinit var btn_division: TextView
    private lateinit var btn7: TextView
    private lateinit var btn8: TextView
    private lateinit var btn9: TextView
    private lateinit var btn_multi: TextView
    private lateinit var btn4: TextView
    private lateinit var btn5: TextView
    private lateinit var btn6: TextView
    private lateinit var btn_plus: TextView
    private lateinit var btn1: TextView
    private lateinit var btn2: TextView
    private lateinit var btn3: TextView
    private lateinit var btn_minus: TextView
    private lateinit var btn_dot: TextView
    private lateinit var btn0: TextView
    private lateinit var btn_back: TextView
    private lateinit var btn_result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        math_operation = findViewById(R.id.math_operation)
        result_text = findViewById(R.id.result_text)
        btn_clear = findViewById(R.id.btn_clear)
        btn_open_parenthesis = findViewById(R.id.btn_open_parenthesis)
        btn_closing_parenthesis = findViewById(R.id.btn_closing_parenthesis)
        btn_division = findViewById(R.id.btn_division)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn_multi = findViewById(R.id.btn_multi)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn_plus = findViewById(R.id.btn_plus)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn_minus = findViewById(R.id.btn_minus)
        btn_dot = findViewById(R.id.btn_dot)
        btn0 = findViewById(R.id.btn0)
        btn_back = findViewById(R.id.btn_back)
        btn_result = findViewById(R.id.btn_result)










        btn0.setOnClickListener{setTextFields("0")}
        btn1.setOnClickListener{setTextFields("1")}
        btn2.setOnClickListener{setTextFields("2")}
        btn3.setOnClickListener{setTextFields("3")}
        btn4.setOnClickListener{setTextFields("4")}
        btn5.setOnClickListener{setTextFields("5")}
        btn6.setOnClickListener{setTextFields("6")}
        btn7.setOnClickListener{setTextFields("7")}
        btn8.setOnClickListener{setTextFields("8")}
        btn9.setOnClickListener{setTextFields("9")}
        btn_minus.setOnClickListener{setTextFields("-")}
        btn_division.setOnClickListener{setTextFields("/")}
        btn_multi.setOnClickListener{setTextFields("*")}
        btn_plus.setOnClickListener{setTextFields("+")}
        btn_closing_parenthesis.setOnClickListener{setTextFields(")")}
        btn_open_parenthesis.setOnClickListener{setTextFields("(")}
        btn_dot.setOnClickListener { setTextFields(".") }

        btn_back.setOnClickListener {
            val str = math_operation.toString()
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1 )
            result_text.text = ""
        }

        btn_clear.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }

        btn_result.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            }catch (e:Exception){
                Log.d("Error", "message: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String){
        if (result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.append(str)
    }
}