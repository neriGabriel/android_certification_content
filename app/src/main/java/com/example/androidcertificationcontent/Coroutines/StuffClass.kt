package com.example.androidcertificationcontent.Coroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.random.Random

class StuffClass {

    /***
     * Funções suspensas (suspend key) podem ser resumidas ou pausadas sem causar problemas na main
     * thread. Sua execução não congela a main thread, sendo assim, podemos ter o conceito de
     * multitasking.
     *
     * Funções marcadas com o modificador suspend só podem ser chamadas por outras suspending
     * functions ou dentro de uma coroutine.
     */
    suspend fun doSomething() {
        //INICIO PROCESSAMENTO PESADO
        delay(1000)
        //FIM PROCESSAMENTO PESADO
        Log.d(TAG, "doSomething method inside StuffClass")
    }

    suspend fun doOtherthing() {
        //INICIO PROCESSAMENTO PESADO
        delay(2000)
        //FIM PROCESSAMENTO PESADO
        Log.d(TAG, "doOtherthing method inside StuffClass")
    }

    suspend fun doSomethingWithContext() {
        withContext(Dispatchers.IO) {
            //INICIO PROCESSAMENTO PESADO
            delay(3000)
            //FIM PROCESSAMENTO PESADO
            Log.d(TAG, "doSomethingWithContext method inside StuffClass")
        }
    }

    suspend fun getBoolean(): Boolean {
        delay(1000)
        return Random.nextInt(1, 10) == 3
    }

    suspend fun raiseExcepetion(): String {
        delay(1000)

        val randomInt = Random.nextInt(
            1,
            3
        )
        Log.d(TAG, "random int: $randomInt")
        if(randomInt == 2)
            throw  Exception("raising expcetion error for test purpose")
        else
            return "No excpetion was thrown"
    }

    companion object {
        private val TAG = StuffClass::class.java.simpleName
    }
}