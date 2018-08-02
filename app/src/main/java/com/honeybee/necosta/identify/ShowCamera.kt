package com.honeybee.necosta.identify

import android.view.SurfaceHolder
import android.content.Context
import android.content.res.Configuration
import android.hardware.Camera
import android.view.SurfaceView


class ShowCamera(context: Context, private val camera: Camera) : SurfaceView(context), SurfaceHolder.Callback {

    init {
        val surfaceHolder = this.holder
        surfaceHolder.addCallback(this)
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        val params = camera.parameters
        if (this.resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            params.set("orientation", "portrait")
            camera.setDisplayOrientation(90)
            params.setRotation(90)
        } else {
            params.set("orientation", "landscape")
            camera.setDisplayOrientation(0)
            params.setRotation(0)
        }
        try {
            camera.parameters = params
            camera.setPreviewDisplay(surfaceHolder)
            camera.startPreview()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {

    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        camera.stopPreview()
        camera.release()
    }
}
