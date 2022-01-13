package com.example.androidcertificationcontent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidcertificationcontent.ActivityLifeCycle.ActivityLifeCycle
import com.example.androidcertificationcontent.BasicWidgets.BasicWidgetsActivity
import com.example.androidcertificationcontent.Coroutines.CoroutinesActivity
import com.example.androidcertificationcontent.LifecycleObserver.LifeCycleOwnerActivity
import com.example.androidcertificationcontent.ViewModel.ViewModelActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.lifecycle_module).setOnClickListener {
            var lifeCycleIntent = Intent(applicationContext, ActivityLifeCycle::class.java)
            startActivity(lifeCycleIntent)
        }

        findViewById<Button>(R.id.lifecycle_observer_module).setOnClickListener {
            var lifeCycleOwnerIntent = Intent(applicationContext, LifeCycleOwnerActivity::class.java)
            startActivity(lifeCycleOwnerIntent)
        }

        findViewById<Button>(R.id.widgets_module).setOnClickListener {
            var basicWidgetsIntent = Intent(applicationContext, BasicWidgetsActivity::class.java)
            startActivity(basicWidgetsIntent)
        }

        findViewById<Button>(R.id.coroutines_module).setOnClickListener {
            var coroutinesModuleIntent = Intent(applicationContext, CoroutinesActivity::class.java)
            startActivity(coroutinesModuleIntent)
        }

        findViewById<Button>(R.id.viewmodel_module).setOnClickListener {
            var viewModelModuleIntent = Intent(applicationContext, ViewModelActivity::class.java)
            startActivity(viewModelModuleIntent)
        }
    }
}