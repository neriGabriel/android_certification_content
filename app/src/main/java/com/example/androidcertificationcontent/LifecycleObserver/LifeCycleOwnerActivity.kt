package com.example.androidcertificationcontent.LifecycleObserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.androidcertificationcontent.R

class LifeCycleOwnerActivity : AppCompatActivity() {
    /***
     * Nesse momento precisamos registrar o lifecycle observer criado na activity/fragment, por
     * padrão de boas práticas, registramos no método onCreate() e onStart().
     *
     * a variavel lifecycle é referente ao lifecycle do contexto, nesse caso a activity. Sendo
     * assim, estamos dizendo que nosso observer vai responder as mudanças do ciclo de vida da
     * activity em questão.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_owner)
        lifecycle.addObserver(RandomNumberObserver())
    }

}