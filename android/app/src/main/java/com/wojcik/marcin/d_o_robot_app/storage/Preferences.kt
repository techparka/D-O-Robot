package com.wojcik.marcin.d_o_robot_app.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.wojcik.marcin.d_o_robot_app.constant.Constant
import com.wojcik.marcin.d_o_robot_app.model.Storage

class Preferences(ctx: Context) {

    private val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)

    private fun getSharedPreferencesValue(storage: Storage): String {
        val (key, default) = storage
        val value = preferences.getString(key, default)!!
        return if (value.isBlank()) default else value
    }

    fun getIpAddress(): String = getSharedPreferencesValue(Constant.IP_ADDRESS_ST0RAGE)
    fun getPort(): String = getSharedPreferencesValue(Constant.PORT_STORAGE)

    fun getMoveForwardValue(): String = getSharedPreferencesValue(Constant.MOVE_FORWARD_STORAGE)
    fun getMoveBackwardValue(): String = getSharedPreferencesValue(Constant.MOVE_BACKWARD_STORAGE)
    fun getStopValue(): String = getSharedPreferencesValue(Constant.MOVE_STOP_STORAGE)
    fun getTurnRightValue(): String = getSharedPreferencesValue(Constant.TURN_RIGHT_STORAGE)
    fun getTurnLeftValue(): String = getSharedPreferencesValue(Constant.TURN_LEFT_STORAGE)
    //======================================
    fun getMovePitchForwardValue(): String = getSharedPreferencesValue(Constant.PITCH_FORWARD_STORAGE)
    fun getMovePitchBackwardValue(): String = getSharedPreferencesValue(Constant.PITCH_BACKWARD_STORAGE)
    fun getRollLeftValue(): String = getSharedPreferencesValue(Constant.ROLL_LEFT_STORAGE)
    fun getRollRightValue(): String = getSharedPreferencesValue(Constant.ROLL_RIGHT_STORAGE)
    fun getYawLeftValue(): String = getSharedPreferencesValue(Constant.YAW_LEFT_STORAGE)
    fun getYawRightValue(): String = getSharedPreferencesValue(Constant.YAW_RIGHT_STORAGE)
    fun getBigLeftValue(): String = getSharedPreferencesValue(Constant.BIG_LEFT_STORAGE)
    fun getBigRightValue(): String = getSharedPreferencesValue(Constant.BIG_RIGHT_STORAGE)
    fun getSoundValue(): String = getSharedPreferencesValue(Constant.SOUND_STORAGE)

//    fun getActionOneValue(): String = getSharedPreferencesValue(Constant.ACTION_1_STORAGE)
//    fun getActionTwoValue(): String = getSharedPreferencesValue(Constant.ACTION_2_STORAGE)
//    fun getActionThreeValue(): String = getSharedPreferencesValue(Constant.ACTION_3_STORAGE)
//    fun getActionFourValue(): String = getSharedPreferencesValue(Constant.ACTION_4_STORAGE)
//    fun getActionFiveValue(): String = getSharedPreferencesValue(Constant.ACTION_5_STORAGE)
//    fun getActionSixValue(): String = getSharedPreferencesValue(Constant.ACTION_6_STORAGE)
//    fun getActionSevenValue(): String = getSharedPreferencesValue(Constant.ACTION_7_STORAGE)
//    fun getActionHeightValue(): String = getSharedPreferencesValue(Constant.ACTION_8_STORAGE)

//    fun getSpeechRecognitionLanguageValue(): String = getSharedPreferencesValue(Constant.SPEECH_RECOGNITION_LANGUAGE_STORAGE)
//    fun getKeywordForwardValue(): String = getSharedPreferencesValue(Constant.KEYWORD_FORWARD_STORAGE)
//    fun getKeywordBackwardValue(): String = getSharedPreferencesValue(Constant.KEYWORD_BACKWARD_STORAGE)
//    fun getKeywordRightValue(): String = getSharedPreferencesValue(Constant.KEYWORD_RIGHT_STORAGE)
//    fun getKeywordLeftValue(): String = getSharedPreferencesValue(Constant.KEYWORD_LEFT_STORAGE)

}



