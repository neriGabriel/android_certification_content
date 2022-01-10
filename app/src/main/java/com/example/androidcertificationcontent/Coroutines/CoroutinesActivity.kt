package com.example.androidcertificationcontent.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidcertificationcontent.R
import kotlinx.coroutines.*
import java.lang.Exception

class CoroutinesActivity : AppCompatActivity() {

    private lateinit var mStuffClass: StuffClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        mStuffClass = StuffClass()
    }

    /***
     * Coroutine nada mais é do que um escopo onde funções suspend (funções que precisam ser
     * executadas em background) são executadas sem bloquear a main thread.
     *
     * Para iniciar uma coroutine podemos fazer isso de 3 maneiras:
     * 1. <scope>.launch (com contexto ou sem contexto)
     * 2. async
     * 3. runBlocking
     * */

    /***
     * Nas viewModels podemos fazer do seguinte jeito:
     * suspend fun getUser(): User = viewModelScope{
     *    val result = async(Dispatchers.IO) {
     *       fetchUserData()
     *    }
     *    result.await()
     * }
     * */
    override fun onStart() {
        super.onStart()



        //Primeiro jeito de criar uma coroutine
        GlobalScope.launch {

            /***
             * Coroutines que não tem retorno, apenas execução de métodos, sendo assim não é necessário
             * executar nada mais além da chamada da função suspend dentro de uma coroutine.
             */
            mStuffClass.doSomething()
            mStuffClass.doOtherthing()
            mStuffClass.doSomethingWithContext()

        }

        //Segundo jeito de criar uma coroutine
        GlobalScope.launch {
            val resultFromAsyncCoroutine = async {
                Log.d(TAG, "Executing async method from resultFromAsyncCoroutine")
                mStuffClass.getBoolean()

            }
            Log.d(TAG, "resultFromAsyncCoroutine: ${resultFromAsyncCoroutine.await()}")
        }


        //Terceiro jeito de criar uma coroutine
        sampleRunBlocking()

        /***
         * Capturando uma exception lançada em uma coroutine.
         */
        GlobalScope.launch {
            try {
                mStuffClass.raiseExcepetion()
            } catch (e: Exception) {
                Log.d(TAG, "logging the test exception: ${e}")
            }
        }
    }

    /***
     * Simples exemplo de como lançar uma coroutine na main thread bloqueando a execução
     */
    fun sampleRunBlocking(){
        Log.d(TAG, "First statement of runBlocking")
        runBlocking {
            delay(3000L)
            Log.d(TAG, "Middle  statement of runBlocking")
        }
        Log.d(TAG, "Last statement of runBlocking")
    }

    companion object {
        private val TAG = CoroutinesActivity::class.java.simpleName
    }
}