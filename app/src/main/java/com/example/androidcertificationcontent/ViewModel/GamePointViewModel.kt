package com.example.androidcertificationcontent.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GamePointViewModel : ViewModel() {

    private val _principalTeamPoints = MutableLiveData<Int>(0)
    val principalTeamPoints: LiveData<Int>
        get() = _principalTeamPoints

    private val _secondaryTeamPoints = MutableLiveData<Int>(0)
    val secondaryTeamPoints: LiveData<Int>
        get() = _secondaryTeamPoints

    fun addPointToPrincipalTeam() {
        _principalTeamPoints.value = _principalTeamPoints.value?.plus(1)
    }

    fun  addPointsToSecondaryTeam() {
        _secondaryTeamPoints.value = _secondaryTeamPoints.value?.plus(1)
    }
}