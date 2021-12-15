package com.example.assignmentfinal

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var bundle: Bundle? = null
    private lateinit var webViewAudio: WebView
    private lateinit var buttonSurah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bundle = intent.extras

        val namaSurah = bundle?.getString("nama_surah")

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Surah " + namaSurah
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeButtonEnabled(true)

        initView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    fun initView() {
        no_surah.text = bundle?.getString("no_surah")
        nama_surah.text = bundle?.getString("nama_surah")
        arti_surah.text = bundle?.getString("arti_surah")
        jumlah_ayat.text = bundle?.getString("ayat_surah")
        deskripsi_surah.text = bundle?.getString("deskripsi_surah")
        tipe_surah.text = bundle?.getString("tipe_surah")

        var noSurah = bundle?.getString("no_surah")
        var namaSurah = bundle?.getString("nama_surah")
        var audioSurah = bundle?.getString("audio_surah")

        webViewAudio = findViewById(R.id.webview_audio)
        var about: String = "<html>" +
                "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width\">" +
                "</head>" +
                "<body>" +
                "<audio controls=\"\" autoplay=\"\" name=\"media\">" +
                "<source src=\" " + audioSurah + "\" " +
                "type=\"audio/mpeg\">" +
                "</audio>" +
                "</body>" +
                "</html>"

        webViewAudio.setBackgroundColor(Color.TRANSPARENT)
        webViewAudio.settings.javaScriptEnabled = true
        webViewAudio.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return true
            }
        }

        webViewAudio.settings.domStorageEnabled = true
        webViewAudio.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        webViewAudio.settings.useWideViewPort = true
        webViewAudio.settings.javaScriptCanOpenWindowsAutomatically = true
        webViewAudio.settings.loadWithOverviewMode
        webViewAudio.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webViewAudio.settings.displayZoomControls = true
        webViewAudio.settings.databaseEnabled = true
        webViewAudio.loadData(about, "text/html", "UTF-8")

        buttonSurah = findViewById(R.id.button_surah)
        buttonSurah.setOnClickListener {
            val intent = Intent(applicationContext, AyatActivity::class.java)
            intent.putExtra("no_surah", noSurah.toString())
            intent.putExtra("nama_surah", namaSurah.toString())
            startActivity(intent)
        }
    }
}