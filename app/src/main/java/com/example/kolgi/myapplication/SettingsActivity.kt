package com.example.kolgi.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val extras = intent.extras ?: return
        val message = extras.getInt("Precision").toString()
        precision.setText(message)
        setTitle("Ustawienia")
    }

    override fun finish(){
        val data = Intent()


        data.putExtra("precision",precision.text.toString())
      //  data.putExtra("color",color.)
        setResult(Activity.RESULT_OK,data)
        super.finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

}
