package com.honeybee.necosta.identify

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.hardware.Camera
import android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK
import android.widget.FrameLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonStartClick(v: View) {
        setContentView(R.layout.activity_video)
        val cameraLayout = findViewById<View>(R.id.cameraLayout) as FrameLayout
        // open camera
        val camera = Camera.open(CAMERA_FACING_BACK)
        val showCamera = ShowCamera(this, camera)
        cameraLayout.addView(showCamera)
    }
}
