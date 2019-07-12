package com.germanofilho.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import java.util.*

class MainActivity : AppCompatActivity() {

    val TAG = "test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val montadoraResponse = Gson().fromJson(getJsonFromAssets(), MontadoraAgregador::class.java)

        val montadoraAux: MutableList<Montadora> = ArrayList()

        for (item in 0 until montadoraResponse.montadoras.size) {
            if ("3".equals(montadoraResponse.montadoras[item].id)) {

                montadoraAux.add(montadoraResponse.montadoras[item])
//                montadoraResponse.montadoras.removeAt(item)
//                montadoraResponse.montadoras[item] = montadoraResponse.montadoras[item+1]

//                Log.d(TAG, "ta funcionando? ${montadoraResponse.montadoras[item]}")
            }
        }

        Log.d(TAG, "ta funcionando? $montadoraAux")


    }

    private fun getJsonFromAssets(): String {
        return application.assets.open("montadoras.json").bufferedReader().use {
            it.readText()
        }
    }
}
