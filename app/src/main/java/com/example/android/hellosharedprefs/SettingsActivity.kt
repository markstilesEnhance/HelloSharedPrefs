package com.example.android.hellosharedprefs

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    private var count = 0
    private var color = 0
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        preferences = getSharedPreferences("com.example.android.hellosharedprefs", Context.MODE_PRIVATE)
        count = preferences.getInt("count", 0)
        color = preferences.getInt("color", ContextCompat.getColor(this, R.color.default_background))
        count_settings.text = count.toString()
    }

    fun countdown(view: View) {
        if(count > 0) {
            count--
            count_settings.text = count.toString()
        }
    }

    fun countup(view: View) {
        count++
        count_settings.text=count.toString()
    }

    fun grey(view: View) {
        color = ContextCompat.getColor(this, R.color.default_background)
    }

    fun black(view: View){
        color = ContextCompat.getColor(this, R.color.black)
    }

    fun red(view: View){
        color = ContextCompat.getColor(this, R.color.red_background)
    }

    fun blue(view: View){
        color = ContextCompat.getColor(this, R.color.blue_background)
    }

    fun green(view: View){
        color = ContextCompat.getColor(this, R.color.green_background)
    }

    fun save(view: View){
        val preferencesEditor = preferences.edit()
        preferencesEditor.putInt("count", count)
        preferencesEditor.putInt("color", color)
        preferencesEditor.apply()
    }

    fun reset2(view: View){
        count = 0
        count_settings.text = "0"
        color = ContextCompat.getColor(this, R.color.default_background)
        val preferencesEditor = preferences.edit()
        preferencesEditor.clear()
        preferencesEditor.apply()
    }
}
