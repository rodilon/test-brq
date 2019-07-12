package com.germanofilho.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val montadoraResponse = Gson().fromJson(getJsonFromAssets(), Any::class.java/*TODO Change object*/)
    }

    private fun getJsonFromAssets(): String {
        return application.assets.open("montadoras.json").bufferedReader().use {
            it.readText()
        }
    }
}
