package com.pfmiranda.designpatterns.redux

import com.yheriatovych.reductor.Action

class CounterReducerImpl : CounterReducer() {
    override fun reduce(state: Int?, action: Action?): Int {
        var stateTemp = state

        if (stateTemp == null) {
            stateTemp = initialState()
        }
        return when (action!!.type) {
            "INCREMENT" -> increment(stateTemp)
            "ADD" -> add(stateTemp, action.getValue(0))
            else -> stateTemp
        }
    }
}