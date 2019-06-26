package com.pfmiranda.designpatterns.strategy

class ConcreteStrategyOne : Strategy {
    override fun doSomething(): String {
        return "Concrete Strategy One"
    }
}