package com.ebookfrenzy.lifecycleaware

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.ebookfrenzy.lifecycleaware.ui.main.MainFragment
import com.ebookfrenzy.lifecycleaware.ui.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.time.format.DateTimeFormatter


//THE WHOLE POINT OF THE TIME IS TO DISPLAY AN INCREMENTED NUMBER EVERY SECOND IN A SENSE COUNTING SECONDS.  THIS IS JUST TO MIMIC SOMETHING THAT WOULD BE FEEDING INFORMATION TO THE MAIN VIEW MODEL


class DemoObserver: LifecycleObserver {
    private val myCoroutineScope = CoroutineScope(Dispatchers.Main)
    var mv = MainViewModel


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
     fun onResume(){
        mv.addStates("onResume was fired on "+ LocalTime.now() + "\n" +
                "*****")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        mv.addStates("onPause was fired on "+ LocalTime.now() + " \n" +
                "*****")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mv.addStates("onCreate was fired on  "+ LocalTime.now())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        mv.addStates("onStart was fired on "+ LocalTime.now())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        mv.addStates("onStop was fired on "+ LocalTime.now())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mv.addStates("onDestroy was fired on "+ LocalTime.now() + "\n" + "*****")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        //Log.i(LOG_TAG, "Custom Observer" + owner.lifecycle.currentState.name)
    }

}