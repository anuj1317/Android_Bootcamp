package com.example.android_bootcamp_anuj

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class ViewActivity : AppCompatActivity() {
    val TAG2 = "observables"
    val TAG3 = "types"
    val TAG4 = "operators"
    val TAG5 = "filter"
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        /**
        Observables emits the values
        Observer observes the values
        Operator is used to modify the data from one form to another
         */



        /**
         Creational Operators
         */
    //Creational Operators i.e creating observable so that it can emit values

        //Just can emit only 10 values of same type
        Observable.just("Apple", "Orange", "Banana")
            .subscribe(//Onsubscribe
                { value -> Log.e(TAG2,"Received: $value")}, // onNext
                { error -> Log.e(TAG2,"Error: $error") },    // onError
                { Log.e(TAG2,"Completed") }                 // onComplete
            )


          //fromArray

        Observable.fromArray("fromArray", "Orange", "Banana")
            .subscribe { Log.e(TAG2, it) }

        Observable.fromIterable(listOf("Apple", "Orange", "Banana"))
            .subscribe(
                { value -> Log.e(TAG2,"ReceivedfromIterable: $value") },      // onNext
                { error -> Log.e(TAG2,"ErrorIterable: $error")},         // onError
                {  Log.e(TAG2,"CompletedIterable") }                       // onComplete
            )



     //Create

        fun getObservableFromList(myList: List<String>) =
            Observable.create<String> { emitter ->
                myList.forEach { kind ->
                    if (kind == "") {
                        emitter.onError(Exception("There's no value to show"))
                    }
                    emitter.onNext(kind)
                }
                emitter.onComplete()
            }

        getObservableFromList(listOf("Blue", "Red", "Black"))
            .subscribe { Log.e(TAG2," Received: $it") }



     //Error Demonstration by removing one item from list
        getObservableFromList(listOf("Apple", "", "Banana"))
            .subscribe(
                { v -> Log.e(TAG2," Received: $v")  },
                { e -> Log.e(TAG2," Error: $e") }
            )




        //Range

        // With the custom crafted function
        fun printEven(value: Int) {
            if (value % 2 == 0) {
                Log.e(TAG2,"$value")
            }
        }
        Observable.range(0, 9).subscribe(::printEven)





        /**
        Emitter Types
         */


        /**
        Flowable - It works exactly like an Observable but it supports Backpressure.
         */

        Flowable.just("This is a Flowable")
            .subscribe(//Onsubscribe
                { value -> Log.e(TAG3,"Received: $value")}, // onNext
                { error -> Log.e(TAG3,"Error: $error") },    // onError
                { Log.e(TAG3,"Completed") }                 // onComplete
            )

        /**
        Maybe
        This class is used when you’d like to return a single optional value.
        The methods are mutually exclusive, in other words, only one of them
         is called. If there is an emitted value, it calls onSuccess ,
         if there’s no value, it calls onComplete or if there’s an error,
         it calls onError.
         */

        Maybe.just("This is a Maybe")
            .subscribe(//Onsubscribe
                { value -> Log.e(TAG3,"Received: $value")}, // onSuccess
                { error -> Log.e(TAG3,"Error: $error") },    // onError
                { Log.e(TAG3,"Completed") }                 // onComplete
            )



        /**
        Single
       It’s used when there’s a single value to be returned.
       If we use this class and there is a value emitted,
       onSuccess will be called. If there’s no value, onError will be called.
         */

        Single.just("This is a Single")
            .subscribe( //OnSubscribe
                { v -> Log.e(TAG3," Received: $v")  },//OnSuccess
                { e -> Log.e(TAG3," Error: $e") }//OnError
            )

        /**
        Completable
        A completable won’t emit any data, what it does is let you know
        whether the operation was successfully completed.
        If it was, it calls onComplete and if it wasn’t it calls onError .
         */
        Completable.create { emitter ->
            emitter.onComplete()
            emitter.onError(Exception())
        }

        /**
        Backpressure is the process of handling an emitter that will produce
        a lot of items very fast.

        The solution is easy. Instead of an Observable you can use a Flowable
        which will handle the Backpressure for you since it takes it into
        consideration whereas Observable do not.

         */

        /**
         This will lead to Backpressure
         */
//
//        val observable = PublishSubject.create<Int>()
//        observable.observeOn(Schedulers.computation())
//            .subscribe (
//                {
//                  Log.e(TAG3,"Number is $it")
//                },
//                {t->
//                    print(t.message)
//                }
//            )
//        for (i in 0..1000000){
//            observable.onNext(i)
//        }

        /**
         Using Flowable to prevent Backpressure
         */
        val observable = PublishSubject.create<Int>()
        observable
            .toFlowable(BackpressureStrategy.DROP)
            .observeOn(Schedulers.computation())
            .subscribe (
                {
                    Log.e(TAG3,"Number is $it")
                },
                {t->
                    print(t.message)
                }
            )
        for (i in 0..1000000){
            observable.onNext(i)
        }


     //Schedulers
        Observable.just("Apple", "Orange", "Banana")
            .subscribeOn(Schedulers.io())//observable emits values on IO
            .observeOn(AndroidSchedulers.mainThread()) //Values will be observed on mainThread
            .subscribe{ v -> Log.e(TAG3,"Received: $v") }






        /**
         Transforming Operators
         */



        /**
        map()
        Transforms values emitted by an Observable stream into a single value.
         */

        Observable.just("Water", "Fire", "Wood")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { m -> m + " 2" }
            .subscribe { v -> Log.e(TAG4,"ReceivedMap: $v") }


        /**
        flatMap()
        Unlike the map() operator, the flatMap() will transform each
        value in an Observable stream into another Observable,
        which are then merged into the output Observable after processing.

         */

        Observable.just("Water", "Fire", "Wood")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { m ->
                Observable.just(m + " 2")
                    .subscribeOn(Schedulers.io())
            }
            .subscribe { v -> Log.e(TAG4,"ReceivedFlatMap: $v") }



        /**
        concat()
        As the name suggests, concat() will concatenate (join together)
        two or more Observable.
         */

        val test1 = Observable.just("Apple", "Orange", "Banana")
        val test2 = Observable.just("Microsoft", "Google")
        val test3 = Observable.just("Grass", "Tree", "Flower", "Sunflower")

        Observable.concat(test1, test2, test3)
            .subscribe{ x -> Log.e(TAG4,"Concat: $x") }





        /**
         Filtering Operators
         */

        /**
         Filter,Distinct
         */

        Observable.just(2,2, 30, 22, 5,5, 60, 1)
            .filter{ x -> x < 10 }
            .distinct()
            .subscribe{ x -> Log.e(TAG5,"Filtered: $x") }

        /**
         Skip,SkipLast
         */
        Observable.just(2, 30, 22, 5, 60, 1)
            .skip(2)
            .skipLast(2)
            .subscribe{ x -> Log.e(TAG5,"Received: $x") }


        /**
        repeat()
        This operator will repeat the emission of the values
        however many times we may need.
         */

        Observable.just("Anuj", "Singh")
            .repeat(2)
            .subscribe { v ->  Log.e(TAG5,"Repeated: $v") }

        /**
        take()
        The take() operator is meant to grab however many emissions you’d like.
         */

        Observable.just("Apple", "Orange", "Banana")
            .take(2)
            .subscribe { v -> Log.e(TAG5,"Took: $v")}


        /**
        CompositeDisposable -> Dispose multiple Observable
         */

        val compositeDisposable = CompositeDisposable()

        val observableOne = Observable.just("Tree")
            .subscribe { v -> Log.e(TAG5,"Received: $v") }
        val observableTwo = Observable.just("Blue")
            .subscribe { v ->  Log.e(TAG5,"Received: $v") }

        compositeDisposable.add(observableOne)
        compositeDisposable.add(observableTwo)
        compositeDisposable.clear()








    }
}