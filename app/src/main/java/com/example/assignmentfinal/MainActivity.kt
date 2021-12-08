package com.example.assignmentfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignmentfinal.fragments.SurahFragment

class MainActivity : AppCompatActivity() {
    var surahFragment = SurahFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(surahFragment)
    }

    private fun replaceFragment(fragment: SurahFragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container_surah, fragment)
            transaction.commit()
        }
    }
}