package com.pfmiranda.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pfmiranda.designpatterns.redux.CounterActions
import com.pfmiranda.designpatterns.redux.CounterReducer
import com.yheriatovych.reductor.Actions
import com.yheriatovych.reductor.Store

class ReduxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redux)

        val counterStore = Store.create(CounterReducer.create())

        val actions = Actions.from(CounterActions::class.java)

        counterStore.subscribe { state -> Toast.makeText(this@ReduxActivity, "Valor:"+ state, Toast.LENGTH_LONG).show() }

        counterStore.dispatch(actions.increment()); //print 1

        counterStore.dispatch(actions.increment()); //print 2

        counterStore.dispatch(actions.add(5));      //print 7

    }
}
