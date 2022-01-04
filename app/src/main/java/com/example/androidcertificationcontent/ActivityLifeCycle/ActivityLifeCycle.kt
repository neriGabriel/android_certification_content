package com.example.androidcertificationcontent.ActivityLifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidcertificationcontent.R
/***
 * A classe Activity fornece seis callbacks relecionados ao paradigma do ciclo de vida, sendo eles
 * respectivamente em orde de execução:
onCreate -> onStart -> onResume -> onPause -> onStop -> onDestroy
 */
class ActivityLifeCycle : AppCompatActivity() {

    /***
     * onSaveInstanceState: Salvar informações do estado atual da UI, método executado antes da UI
     * ser destruida, caso qualquer informação seja salva no parametro outState, quando o método on
     * create é executado o parametro savedInstanceState recebe esse valor.
     *
     * 1. Usar onSaveInstanceState() como backup para lidar com o encerramento do
     * processo iniciado pelo sistema.
     *
     * 2. Usar ViewModel para lidar com mudanças de configuração
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("ActivityLifeCycle", "onSaveInstanceState")
    }
    /***
    * onCreate: sempre deve ser chamado, ele é responsável por iniciar a atividade, internamente
    * a plataforma android executa o método onCreate quando uma representação da classe Activity é
    * executada.
    ***/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d("ActivityLifeCycle", "onCreate")
    }

    /***
     * onStart: torna a activity visível para o usuário, internamente a plataforma android executa o
     * método onStart para inicializar componentes visuais ou códigos referentres a UI.
     *
     * [EXECUÇÃO MUITO RÁPIDA]
     */
    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifeCycle", "onStart")
    }

    /***
     * onResume: move a atividade para o primeiro ponto, é nesse método que uma atividade permanece
     * até o momento em que qualquer outro app ou ação solicite o foco/atenção, quando isso acontece
     * a atividade é movida para o estado de PAUSE.
     *
     * Caso a atividade tenha o foco/atenção retomado, o estado de RESUME é chamado novamente
     *
     * [EXECUÇÃO MAIS DEMORADA]
     */
    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifeCycle", "onResume")
    }

    /***
     * onPause: método chamado quando há uma primeira indicação que a atividade está sendo deixada,
     * embora nem sempre signifique que a atividade vai ser destruida, este método indica que a
     * atividade não está mais em primeiro plano embora ainda possa estar visível no modo
     * multi-janelas.
     *
     * O método onPause deve ser utilizado para pausar métodos ou ações que não devem continuar
     * enquanto a Activity estiver no modo PAUSE.
     *
     * [EXECUÇÃO MUITO RAPIDA]
     */
    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifeCycle", "onPause")
    }

    /***
     * onStop: método executado quando a atividade não estiver mais visível ao usuario, neste método
     * o aplicativo liberará recursos desnecessários enquanto não estiver visível ao usuario (ex.
     * pausar animações, operações de trabalho pesado da CPU).
     *
     * O uso do onStop pode ser mais viavel referente a alterações de UI visto que no onPause o
     * usuario ainda pode ter visibilidade da tela.
     *
     * [EXECUÇÃO MAIS DEMORADA]
     */
    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifeCycle", "onStop")
    }

    /***
     * onDestroy: método executado antes da atividade ser destruida, pode ser invocado a partir de
     * duas ações:
     *
     * 1. atividade sendo finalizada, (pelo usuario ou devido ao finish() ser chamado)
     * 2. o sistema pode estar destruindo a atividade temporariamente devido a uma mudança na
     * configuração (rotação do dispositivo/modo multijanelas).
     */
    override fun onDestroy() {
        Log.d("ActivityLifeCycle", "onDestroy")
        super.onDestroy()
    }

}