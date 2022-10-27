package com.wojcik.marcin.d_o_robot_app.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*

import androidx.appcompat.app.AlertDialog
import com.wojcik.marcin.d_o_robot_app.R
import com.wojcik.marcin.d_o_robot_app.connector.CarConnector
import kotlinx.android.synthetic.main.button_control_activity.*

class ButtonControl : AppCompatActivity() {

    private lateinit var carConnector: CarConnector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.button_control_activity)
        setSupportActionBar(findViewById(R.id.toolbar_button_control))

        if (supportActionBar != null) {
            with(supportActionBar!!) {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }
        }

        carConnector = CarConnector(this@ButtonControl)

        arrow_up.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_right.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_down.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_left.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
//        =============================================================================
        arrow_pitch_forward.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_pitch_backward.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_roll_left.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_roll_right.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_yaw_left.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_yaw_right.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_big_left.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        arrow_big_right.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }
        audio_waves.setOnTouchListener { v: View, e: MotionEvent -> onTouchArrow(v, e) }

//        action_button_0.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_1.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_2.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_3.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_4.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_5.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_6.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_7.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_8.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
//        action_button_9.setOnTouchListener { v: View, e: MotionEvent -> onTouchAction(v, e) }
    }

    private fun onTouchArrow(v: View, event: MotionEvent): Boolean {
        val isTouchDown = event.action == MotionEvent.ACTION_DOWN
        val isTouchUp = event.action == MotionEvent.ACTION_UP
        if (isTouchDown) {
            when (v.id) {
                R.id.arrow_up -> {
                    carConnector.moveForward()
                    arrow_up.setBackgroundResource(R.drawable.arrow_up_pressed)
                }
                R.id.arrow_down -> {
                    carConnector.moveBackward()
                    arrow_down.setBackgroundResource(R.drawable.arrow_down_pressed)
                }
                R.id.arrow_right -> {
                    carConnector.turnRight()
                    arrow_right.setBackgroundResource(R.drawable.arrow_right_pressed)
                }
                R.id.arrow_left -> {
                    carConnector.turnLeft()
                    arrow_left.setBackgroundResource(R.drawable.arrow_left_pressed)
                }
//                %---------------------------------------------------------%
                R.id.arrow_pitch_forward -> {
                    carConnector.pitchForward()
                    arrow_pitch_forward.setBackgroundResource(R.drawable.arrow_pitch_forward_pressed)
                }
                R.id.arrow_pitch_backward -> {
                    carConnector.pitchBackward()
                    arrow_pitch_backward.setBackgroundResource(R.drawable.arrow_pitch_backward_pressed)
                }
                R.id.arrow_roll_left -> {
                    carConnector.rollLeft()
                    arrow_roll_left.setBackgroundResource(R.drawable.arrow_roll_left_pressed)
                }
                R.id.arrow_roll_right -> {
                    carConnector.rollRight()
                    arrow_roll_right.setBackgroundResource(R.drawable.arrow_roll_right_pressed)
                }
                R.id.arrow_yaw_left  -> {
                    carConnector.yawLeft()
                    arrow_yaw_left.setBackgroundResource(R.drawable.arrow_yaw_left_pressed)
                }
                R.id.arrow_yaw_right -> {
                    carConnector.yawRight()
                    arrow_yaw_right.setBackgroundResource(R.drawable.arrow_yaw_right_pressed)
                }
                R.id.arrow_big_left -> {
                    carConnector.bigLeft()
                    arrow_big_left.setBackgroundResource(R.drawable.arrow_big_left_pressed)
                }
                R.id.arrow_big_right -> {
                    carConnector.bigRight()
                    arrow_big_right.setBackgroundResource(R.drawable.arrow_big_right_pressed)
                }
                R.id.audio_waves -> {
                    carConnector.sound()
                    audio_waves.setBackgroundResource(R.drawable.audio_waves_press)
                }

            }
            return true
        }
        if (isTouchUp) {
            carConnector.stopMoving()
            when (v.id) {
                R.id.arrow_up -> arrow_up.setBackgroundResource(R.drawable.arrow_up)
                R.id.arrow_down -> arrow_down.setBackgroundResource(R.drawable.arrow_down)
                R.id.arrow_right -> arrow_right.setBackgroundResource(R.drawable.arrow_right)
                R.id.arrow_left -> arrow_left.setBackgroundResource(R.drawable.arrow_left)
//                ------------------------------------------------------------
                R.id.arrow_pitch_forward -> arrow_pitch_forward.setBackgroundResource(R.drawable.arrow_pitch_forward)
                R.id.arrow_pitch_backward -> arrow_pitch_backward.setBackgroundResource(R.drawable.arrow_pitch_backward)
                R.id.arrow_roll_left -> arrow_roll_left.setBackgroundResource(R.drawable.arrow_roll_left)
                R.id.arrow_roll_right -> arrow_roll_right.setBackgroundResource(R.drawable.arrow_roll_right)
                R.id.arrow_yaw_left -> arrow_yaw_left.setBackgroundResource(R.drawable.arrow_yaw_left)
                R.id.arrow_yaw_right -> arrow_yaw_right.setBackgroundResource(R.drawable.arrow_yaw_right)
                R.id.arrow_big_left -> arrow_big_left.setBackgroundResource(R.drawable.arrow_big_left)
                R.id.arrow_big_right -> arrow_big_right.setBackgroundResource(R.drawable.arrow_big_right)
                R.id.audio_waves -> audio_waves.setBackgroundResource(R.drawable.audio_waves)
            }
            return true
        }
        return false
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finishActivity()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_button_control_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            android.R.id.home -> {
                finishActivity()
                true
            }
            R.id.action_information -> {
                showInformationDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun finishActivity() {
        finish()
        this@ButtonControl.overridePendingTransition(
            R.anim.anim_slide_in_right,
            R.anim.anim_slide_out_right
        )
    }

    private fun showInformationDialog() {
        val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogTheme))
        with(builder) {
            setTitle(getString(R.string.button_dialog_title))
            setMessage(getString(R.string.button_dialog_message))
            setPositiveButton(getString(R.string.ok)) { _, _ -> }
            show()
        }
    }

}