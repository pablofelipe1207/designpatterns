package com.pfmiranda.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.pfmiranda.designpatterns.strategy.ConcreteStrategyOne
import com.pfmiranda.designpatterns.strategy.ConcreteStrategyTwo
import com.pfmiranda.designpatterns.strategy.Context
import java.util.*

class MainActivity : AppCompatActivity() {

    val objContext = Context()
    val objStrategyOne = ConcreteStrategyOne()
    val objStrategyTwo = ConcreteStrategyTwo()
    val randomNumber = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnExecute = findViewById<Button>(R.id.btnExecute)

        btnExecute?.setOnClickListener {
            selectStrategy()
            Toast.makeText(this@MainActivity, objContext.executeStrategy(), Toast.LENGTH_LONG).show()
        }
    }

    fun selectStrategy(){
        when {
            randomNumber.nextBoolean() -> objContext.strategy = objStrategyOne
            else -> objContext.strategy = objStrategyTwo
        }
    }

}
