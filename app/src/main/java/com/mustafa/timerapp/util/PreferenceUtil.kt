package com.mustafa.timerapp.util

import android.content.Context
import android.preference.PreferenceManager
import com.mustafa.timerapp.TimerActivity

class PreferenceUtil {

    //Members which are defined inside the companion object are Static
    companion object {


        private const val PREVIOUS_TIMER_LENGTH_SECONDS_ID = "com.mustafa.timerapp.previous_timer_length"

        private const val TIMER_STATE_ID = "com.mustafa.timerapp.timer_state"

        private const val SECONDS_REMAINING_ID = "com.mustafa.timerapp.seconds_remaining"

        private const val ALARM_SET_TIME_ID = "com.mustafa.timerapp.backgrounded_time"

        private const val TIMER_LENGTH_ID = "com.mustafa.timerApp.timer_length"



        /**
         * @param context the context
         * @return the timer length in minutes
         */
        fun getTimerLength(context : Context) : Int {
            val preference = PreferenceManager.getDefaultSharedPreferences(context)
            return preference.getInt(TIMER_LENGTH_ID, 1)
        }

        /**
         * You have a timer set for 20 minutes and its running then you decided to change the length of the timer from 20 to 30 min
         * remember the timer is running then you exist the timer Activity and then you go the setting activity and then you change the length of the timer
         * So even if the timer is running the current timer length will be saved and returned here.
         *
         * @param context the context
         * @return Previous Timer Length in Seconds
         */
        fun getPreviousTimerLengthSeconds (context: Context) : Long {
            val preference = PreferenceManager.getDefaultSharedPreferences(context)
            return preference.getLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, 0)
        }

        /**
         * Set the Timer Previous Timer Length in Seconds
         * @param seconds the seconds
         * @param context the context
         */
        fun setPreviousTimerLengthSeconds(seconds : Long, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, seconds)
            editor.apply()
        }

        /**
         * @param context the context
         * @return the timer state, 0 is the default state which is Stopped
         */
        fun getTimerState(context: Context) : TimerActivity.TimerState {
            val preference = PreferenceManager.getDefaultSharedPreferences(context)
            val ordinal = preference.getInt(TIMER_STATE_ID, 0)
            return TimerActivity.TimerState.values()[ordinal]
        }

        /**
         * Set the timer state
         * @param timerState the timer state to be set
         * @param context the context
         */
        fun setTimerState (timerState: TimerActivity.TimerState, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            val ordinal = timerState.ordinal
            editor.putInt(TIMER_STATE_ID, ordinal)
            editor.apply()
        }


        /**
         * @param context the context
         * @return the seconds remaining
         */
        fun getSecondsRemaining (context: Context) : Long {
            val preference = PreferenceManager.getDefaultSharedPreferences(context)
            return preference.getLong(SECONDS_REMAINING_ID, 0)
        }

        /**
         * set the seconds remaining
         * @param seconds the seconds
         * @param context the context
         */
        fun setSecondsRemaining(seconds : Long, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(SECONDS_REMAINING_ID, seconds)
            editor.apply()
        }


        fun getAlarmSetTime (context: Context): Long {
            val preference = PreferenceManager.getDefaultSharedPreferences(context)
            return preference.getLong(ALARM_SET_TIME_ID, 0)
        }


        fun setAlarmSetTime (time: Long, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(ALARM_SET_TIME_ID, time)
            editor.apply()
        }


    }
}