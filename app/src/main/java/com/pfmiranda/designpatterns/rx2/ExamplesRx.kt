package com.pfmiranda.designpatterns.rx2

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.Maybe


class ExamplesRx {


    /*
The method subscribeOn(…) allows you to move the execution of the Observable code into another thread and with an specific behaviour.

    io: intended for IO-bound work.
    computation: intended for computational work.
    newThread: creates a new Thread for each unit of work.
    test: useful for debugging.


Single
Single is an observable that emits only a single item

Maybe
Maybe is similar to Single but this time, it allows your observable the ability to not emit any item at all.

Completable
This observable is only concerned about two things, if some action is executed or an error is encountered

     */

    fun singleTest(){
        Single.just("hello").subscribe { t ->
            Log.d("Prueba", t.toString())
        }
    }

    fun maybeTest() {
        Maybe.empty<Any>().subscribe { x ->
            Log.d("Prueba", x.toString())
        }

        Maybe.just("hello").subscribe { x ->
            Log.d("Prueba", x.toString())
        }
    }

    fun observableCreateError(){
        var myObservable : Observable<String> = Observable.create { subscriber ->
            subscriber.onError(Throwable("Prueba"))
            subscriber.onNext("Prueba")
            subscriber.onComplete()
        }
        myObservable.subscribe (
            {Log.d("Rx",it.toString())},{Log.d("Rx",it.toString())}
        )
    }
    fun just(){
        Observable.just(1, 2, 3)
            .map { " :) ".repeat(it) }
            .subscribe { println(it)}
    }

    fun arrayExample() {

        val myObservable = Observable.fromArray(1, 2, 3)
        val transformation = myObservable.map { e ->
            e * 2
        }
        val filtered = transformation.filter { e ->
            e > 2
        }
        filtered.subscribe(
            { e ->
                // onNext
                Log.d("Rx","Result: " + e)
            },
            { ex ->
                // onError
                Log.e("Rx", "Error", ex)
            },
            {
                // onComplete
                Log.d("Rx","Done!")
            },
            { disposable ->
                //onSubscribe
                Log.d("Rx","Subscribed!")
            }
        )

        Observable.fromArray(1, 2, 3).map { it -> it *2  }.filter { it > 2 }.subscribe { Log.d("Prueba", it.toString()) }

    }




}