package com.pfmiranda.designpatterns.strategy

class Context {

    var strategy: Strategy? = null

    fun executeStrategy(): String {
        return strategy!!.doSomething()
    }
}