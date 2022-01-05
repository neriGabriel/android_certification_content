package com.example.androidcertificationcontent.LifecycleObserver

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/***
 * Comumente durante o desenvolvimento de um app existe a necessidade de executar tarefas de componentes
 * em momentos especificos do ciclo de vida de uma activity ou fragment, por exemplo, inicializar
 * alguma funcionalidade no onStart e finalizar no onStop, na maioria das vezes a primeira ideia
 * de solução é adicionar as chamadas nos propios callbacks de ciclo de vida de uma activity, entretanto
 * isso é pouco perfomatico e em alguns casos pode causar crash ou memory leak.
 *
 * Umas das funcionalidades adicionadas pelo Google é o conceito de lifecycle aware components onde
 * componentes respondem a mudanças ou estados do ciclo de vida. Para criar componentes que respondam
 * a mudanças de ciclo de vida precisamos adicionar a Herança para a classe DefaultLifecycleObserver,
 * LifecycleObserver ou LifecycleEventObserver e a partir desse momento temos acesso a métodos do
 * ciclo de vida, tais como onCreate onResume e etc.
 *
 * Com esse tipo de abordagem também podemos acessar qual o estado/lifecycle que o parent está e definir
 * que o código execute alguma coisa se ao menos o lifecycle event do parent for igual a X. Para fazer
 * isso podemos utilizar do seguinte método: {lifecycle.currentState.isAtleast(STATE)}
 *
 * Ao final é necessário adicionar esse observer para qual contexto (activity ou fragment) de lifecycle
 * ele irá responder/ser anexado/observar. Neste exemplo, o observer em questão foi adicionado na
 * activity [LifeCycleOwnerActivity.onCreate] através do método: {lifecycle.addObserver(RandomNumberObserver())}
 * onde a variavel lifecycle referencia ao ciclo de vida da activity.
 */
class RandomNumberObserver : DefaultLifecycleObserver {
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("RandomNumberObserver", "onResume from RandomNumberObserver")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if(owner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            Log.d("RandomNumberObserver", "parent lifecycle is atleast started... do something!")
        }
    }
}