package com.pfmiranda.designpatterns.redux

import com.yheriatovych.reductor.Action
import com.yheriatovych.reductor.annotations.AutoReducer
import com.yheriatovych.reductor.Reducer
import com.yheriatovych.reductor.annotations.ActionCreator


@ActionCreator
internal interface CounterActions {

    @ActionCreator.Action(INCREMENT)
    fun increment(): Action

    @ActionCreator.Action(ADD)
    fun add(value: Int): Action

    companion object {
        const val INCREMENT = "INCREMENT"
        const val ADD = "ADD"
    }
}


@AutoReducer
abstract class CounterReducer : Reducer<Int> {
    @AutoReducer.InitialState
    fun initialState(): Int {
        return 0
    }

    @AutoReducer.Action(value = CounterActions.INCREMENT, from = CounterActions::class)
    fun increment(state: Int): Int {
        return state + 1
    }

    @AutoReducer.Action(value = CounterActions.ADD, from = CounterActions::class)
    fun add(state: Int, value: Int): Int {
        return state + value
    }
    companion object {
        fun create(): CounterReducer = CounterReducerImpl()
    }
}

