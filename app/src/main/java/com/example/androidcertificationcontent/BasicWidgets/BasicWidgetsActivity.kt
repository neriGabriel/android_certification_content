package com.example.androidcertificationcontent.BasicWidgets

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.androidcertificationcontent.R
import kotlin.random.Random

class BasicWidgetsActivity : AppCompatActivity() {

    private lateinit var mTitleView: TextView
    private lateinit var mImageView: ImageView
    private lateinit var mCalendarView: CalendarView
    private lateinit var mIndeterminateBar: ProgressBar
    private lateinit var mDeterminateBar: ProgressBar
    private lateinit var mSeekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_widgets)
    }

    @SuppressLint("ShowToast")
    override fun onStart() {
        super.onStart()
        mTitleView = findViewById(R.id.title)
        mImageView = findViewById(R.id.image_view)
        mCalendarView = findViewById(R.id.calendar_view)
        mIndeterminateBar = findViewById(R.id.indeterminate_bar)
        mDeterminateBar = findViewById(R.id.determinate_bar)
        mSeekBar = findViewById(R.id.seek_bar)


        mTitleView.setOnClickListener {
            Toast.makeText(applicationContext,
                getString(R.string.summary_toast_basic_widgets, "TextView"),
                Toast.LENGTH_SHORT).show()
            changeIndeterminateBarVisibility(false)
            changeDeterminaBarProgress()
        }

        mImageView.setOnClickListener {
            Toast.makeText(applicationContext,
            getString(R.string.summary_toast_basic_widgets, "ImageView"),
            Toast.LENGTH_LONG).show()
            changeIndeterminateBarVisibility(true)
            changeDeterminaBarProgress()
            mSeekBar.progress = 3
        }


        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Log.d(TAG,
                    "onProgressChanged: current progress position: ${p1}, changed by user: $p2")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Log.d(TAG, "onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Log.d(TAG, "onStopTrackingTouch")
            }

        })

    }

    private fun changeIndeterminateBarVisibility(isVisible: Boolean) {
        mIndeterminateBar.visibility = if(isVisible) View.VISIBLE else View.INVISIBLE
    }

    private fun changeDeterminaBarProgress() {
        val randomPosition = Random.nextInt(1, mDeterminateBar.max)
        mDeterminateBar.progress = randomPosition
    }

    companion object {
       private val TAG = BasicWidgetsActivity::class.java.simpleName
    }
}