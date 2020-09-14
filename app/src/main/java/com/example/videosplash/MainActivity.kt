package com.example.videosplash

import android.content.Intent
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var videoView: VideoView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        videoView = findViewById<View>(R.id.videoView) as VideoView
        val video = Uri.parse("android.resource://" + packageName + "/" + R.raw.videosplash)
        videoView!!.setVideoURI(video)
        videoView!!.setOnCompletionListener(OnCompletionListener {
            if (isFinishing) return@OnCompletionListener
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            finish()
        })
        videoView!!.start()
    }
}