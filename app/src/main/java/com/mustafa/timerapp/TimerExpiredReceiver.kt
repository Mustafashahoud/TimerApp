package com.mustafa.timerapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mustafa.timerapp.util.NotificationUtil
import com.mustafa.timerapp.util.PreferenceUtil

class TimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        NotificationUtil.showTimerExpired(context)

        PreferenceUtil.setTimerState(TimerActivity.TimerState.Stopped, context)
        PreferenceUtil.setAlarmSetTime(0, context)
    }
}
