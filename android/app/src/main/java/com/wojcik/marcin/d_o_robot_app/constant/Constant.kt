package com.wojcik.marcin.d_o_robot_app.constant

import com.wojcik.marcin.d_o_robot_app.model.Storage

object Constant {

    val IP_ADDRESS_ST0RAGE = Storage("ip_address", "192.168.4.1")
    val PORT_STORAGE = Storage("port", "8080")

    val MOVE_FORWARD_STORAGE = Storage("move_forward", "F")
    val MOVE_BACKWARD_STORAGE = Storage("move_backward", "B")
    val MOVE_STOP_STORAGE = Storage("move_stop", "S")
    val TURN_RIGHT_STORAGE = Storage("turn_right", "R")
    val TURN_LEFT_STORAGE = Storage("turn_left", "L")
    //------------------------------
    val PITCH_FORWARD_STORAGE = Storage("pitch_forward", "E")
    val PITCH_BACKWARD_STORAGE = Storage("pitch_backward", "M")
    val ROLL_LEFT_STORAGE = Storage("roll_left", "N")
    val ROLL_RIGHT_STORAGE = Storage("roll_right", "O")
    val YAW_LEFT_STORAGE = Storage("yaw_left", "T")
    val YAW_RIGHT_STORAGE = Storage("yaw_right", "U")
    val BIG_LEFT_STORAGE = Storage("big_left", "C")
    val BIG_RIGHT_STORAGE = Storage("big_right", "D")
    val SOUND_STORAGE = Storage("sound", "W")

//    val ACTION_0_STORAGE = Storage("action_0", "0")
//    val ACTION_1_STORAGE = Storage("action_1", "1")
//    val ACTION_2_STORAGE = Storage("action_2", "2")
//    val ACTION_3_STORAGE = Storage("action_3", "3")
//    val ACTION_4_STORAGE = Storage("action_4", "4")
//    val ACTION_5_STORAGE = Storage("action_5", "5")
//    val ACTION_6_STORAGE = Storage("action_6", "6")
//    val ACTION_7_STORAGE = Storage("action_7", "7")
//    val ACTION_8_STORAGE = Storage("action_8", "8")
//    val ACTION_9_STORAGE = Storage("action_9", "9")

//    val SPEECH_RECOGNITION_LANGUAGE_STORAGE = Storage("speech_recognition_language", "en_US")
//    val KEYWORD_FORWARD_STORAGE = Storage("keyword_forward", "forward")
//    val KEYWORD_BACKWARD_STORAGE = Storage("keyword_backward", "backward")
//    val KEYWORD_RIGHT_STORAGE = Storage("keyword_right", "right")
//    val KEYWORD_LEFT_STORAGE = Storage("keyword_left", "left")
}