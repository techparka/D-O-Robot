package com.wojcik.marcin.d_o_robot_app.fragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

import com.wojcik.marcin.d_o_robot_app.R
import com.wojcik.marcin.d_o_robot_app.constant.Constant
import com.wojcik.marcin.d_o_robot_app.model.Storage


class ConfigurationFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)

        setPreferenceOnChange(Constant.IP_ADDRESS_ST0RAGE)
        setPreferenceOnChange(Constant.PORT_STORAGE)

        setPreferenceMoveOnChange(Constant.MOVE_FORWARD_STORAGE)
        setPreferenceMoveOnChange(Constant.MOVE_BACKWARD_STORAGE)
        setPreferenceMoveOnChange(Constant.MOVE_STOP_STORAGE)
        setPreferenceMoveOnChange(Constant.TURN_LEFT_STORAGE)
        setPreferenceMoveOnChange(Constant.TURN_RIGHT_STORAGE)
        //======================
        setPreferenceMoveOnChange(Constant.PITCH_FORWARD_STORAGE)
        setPreferenceMoveOnChange(Constant.PITCH_BACKWARD_STORAGE)
        setPreferenceMoveOnChange(Constant.ROLL_LEFT_STORAGE)
        setPreferenceMoveOnChange(Constant.ROLL_RIGHT_STORAGE)
        setPreferenceMoveOnChange(Constant.YAW_LEFT_STORAGE)
        setPreferenceMoveOnChange(Constant.YAW_RIGHT_STORAGE)
        setPreferenceMoveOnChange(Constant.BIG_LEFT_STORAGE)
        setPreferenceMoveOnChange(Constant.BIG_RIGHT_STORAGE)
        setPreferenceMoveOnChange(Constant.SOUND_STORAGE)

//        setPreferenceActionOnChange(Constant.ACTION_0_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_1_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_2_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_3_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_4_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_5_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_6_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_7_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_8_STORAGE)
//        setPreferenceActionOnChange(Constant.ACTION_9_STORAGE)

//        setPreferenceSpeechRecognitionLanguageOnChange(Constant.SPEECH_RECOGNITION_LANGUAGE_STORAGE)
//
//        setPreferenceOnChange(Constant.KEYWORD_FORWARD_STORAGE)
//        setPreferenceOnChange(Constant.KEYWORD_BACKWARD_STORAGE)
//        setPreferenceOnChange(Constant.KEYWORD_RIGHT_STORAGE)
//        setPreferenceOnChange(Constant.KEYWORD_LEFT_STORAGE)
    }

    private fun setPreferenceOnChange(storage: Storage) {
        val (key, default) = storage
        val preference: EditTextPreference? = findPreference(key)
        preference?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { pref ->
            val value = pref.text
            if (value.isNullOrBlank()) default else value
        }
    }

    private fun setPreferenceMoveOnChange(storage: Storage) {
        val (key, default) = storage
        val preference: EditTextPreference? = findPreference(key)
        preference?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { pref ->
            val value = pref.text
            "/move?dir=${if (value.isNullOrBlank()) default else value}"
        }
    }

    private fun setPreferenceActionOnChange(storage: Storage) {
        val (key, default) = storage
        val preference: EditTextPreference? = findPreference(key)
        preference?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { pref ->
            val value = pref.text
            "/action?type=${if (value.isNullOrBlank()) default else value}"
        }
    }

    private fun setPreferenceSpeechRecognitionLanguageOnChange(storage: Storage) {
        val (key, default) = storage
        val preference: ListPreference? = findPreference(key)
        preference?.summaryProvider = Preference.SummaryProvider<ListPreference> { pref ->
            val value = pref.value
            if (value.isNullOrBlank()) default else value
        }
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

    }


}