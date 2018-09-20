package com.example.android.tourguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openOutdoorsActivity(view: View) {
        val intent = Intent(this, OutdoorsActivity::class.java)
        startActivity(intent)

    }

    fun openArtActivity(view: View) {
        val intent = Intent(this, ArtActivity::class.java)
        startActivity(intent)

    }

    fun openDiningActivity(view: View) {
        val intent = Intent(this, DiningActivity::class.java)
        startActivity(intent)

    }

    fun openShoppingActivity(view: View) {
        val intent = Intent(this, ShoppingActivity::class.java)
        startActivity(intent)

    }

}
