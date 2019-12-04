package com.sadewawicak.livedataapps

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*


class MainViewModel : ViewModel {

    private val ONE_SECOND: Long = 1000
    private var mInitialTime: Long = 0

    private val mElapsedTime = MutableLiveData<Long>()

    constructor() {
        mInitialTime = SystemClock.elapsedRealtime()
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000

                mElapsedTime.postValue(newValue)
            }

        }, ONE_SECOND, ONE_SECOND)
    }

    fun getElapsedTime(): LiveData<Long?>? {
        return mElapsedTime
    }

}