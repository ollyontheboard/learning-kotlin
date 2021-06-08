package com.example.mykotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declaring operators as stings


    }
    val ADD: String = "+"
    val SUBTRACT: String = "-"
    val MULTIPLY: String = "*"
    val DIVIDE: String = "/"

    val ERROR = "an error occured"
    val testOperandOne = 5.0
    val testOperandTwo = 4.0


    fun main(args: Array<String>){
          //user types in operator which enters into args array at the start of the program
            val OperatorSymbol = args[0]
            start(OperatorSymbol)



        }
    //Single line expression syntax: for methods tha do not require full code block. juust an expression
    fun displayResult(result: String)= Log.d("Result",result)



    //function call w no return type
    fun start(operatorSymbol: String) {
        //Call method to check if valid operator was entered
        if(checksArgument(operatorSymbol)){
            //perform claculation after opeator has been checked
            displayResult(evaluateBinomial(testOperandOne, testOperandTwo,operatorSymbol)  )      }
        else displayResult(ERROR)



        }
    fun evaluateBinomial(OpOne:Double, OpTwo:Double, Sym:String): String{
        //performing and returnin as string the value of operation depending on the operator
        return when(Sym){
            ADD -> (OpOne+OpTwo).toString()
            SUBTRACT-> (OpOne-OpTwo).toString()
            MULTIPLY -> (OpOne*OpTwo).toString()
            DIVIDE -> (OpOne-OpTwo).toString()

            else-> ERROR
        }

    }


    //function call w return type
    fun checksArgument(operatorSymbol: String):Boolean{
       //specify boolean value to return depending on the operator
        return when(operatorSymbol){
            ADD -> true
            SUBTRACT-> true
            MULTIPLY -> true
            DIVIDE -> true

            else-> false
        }

    }
    }
