package com.example.androidcertificationcontent.ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidcertificationcontent.R

class ViewModelActivity : AppCompatActivity() {

    private lateinit var mPrimaryTeamViewPoints: TextView
    private lateinit var mSecondaryTeamViewPoints: TextView
    private lateinit var mAddPrimaryTeamPoint: Button
    private lateinit var mAddSecondaryTeamPoint: Button

    private val mGamePointViewModel: GamePointViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        mPrimaryTeamViewPoints = findViewById(R.id.pointsPrimaryTeam)
        mSecondaryTeamViewPoints = findViewById(R.id.pointsSecondaryTeam)
        mAddPrimaryTeamPoint = findViewById(R.id.addPointPrimaryTeam)
        mAddSecondaryTeamPoint = findViewById(R.id.addPointSecondaryTeam)

        mGamePointViewModel.principalTeamPoints.observe(this, {
            mPrimaryTeamViewPoints.text = it.toString()
        })

        mGamePointViewModel.secondaryTeamPoints.observe(this, {
            mSecondaryTeamViewPoints.text = it.toString()
        })

        mAddPrimaryTeamPoint.setOnClickListener {
            mGamePointViewModel.addPointToPrincipalTeam()
        }

        mAddSecondaryTeamPoint.setOnClickListener {
            mGamePointViewModel.addPointsToSecondaryTeam()
        }
    }
}