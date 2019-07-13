package com.germanofilho.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val TAG = "test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val montadoraResponse = Gson().fromJson(getJsonFromAssets(), MontadoraAgregador::class.java)
        val montadoraAux: ArrayList<Montadora> = ArrayList()
        var contadorCarros = 0
        var contadorPecas = 0

        montadoraResponse.montadoras?.let {listaMontadora ->
            for (i in 0 until listaMontadora.size) {
                listaMontadora[i].carros?.let {listaCarros ->
                    if (listaCarros.isNotEmpty()) {
                        for (j in 0 until listaCarros.size) {
                            listaCarros[j].pecas?.let {
                                if (listaCarros[j].pecas!!.isNotEmpty()) {
                                    for (x in 0 until listaCarros[j].pecas!!.size) {
                                        contadorPecas++
                                    }
                                    if (!listaCarros[j].nome.isNullOrEmpty()) {
                                        Log.d(TAG, "A quantidade de peças do Carro: ${listaCarros[j].nome} = $contadorPecas")
                                    } else {
                                        Log.d(TAG, "A quantidade de peças em cada carro = $contadorPecas")
                                    }
                                } else {
                                    Log.d(TAG, "A quantidade de peças em cada carro quando a lista de pecas for vazia : 0")
                                }
                                contadorPecas = 0
                            }
                            contadorCarros++
                        }
                        if (!listaMontadora[i].nome.isNullOrEmpty()) {
                            Log.d(TAG, "A quantidade de carros da Montadora: ${listaMontadora[i].nome} = $contadorCarros")
                        } else {
                            Log.d(TAG, "A quantidade de carros em cada montadora = $contadorCarros")
                        }
                    }
                }
                contadorCarros = 0
            }
        }

        montadoraResponse.montadoras?.let {listaMontadora ->
            for (item in (listaMontadora.size - 1) downTo 1) {
                if ("3".equals(listaMontadora[item].id)) {
                    montadoraAux.add(listaMontadora[item])
                    listaMontadora.removeAt(item)
                }
            }

            for (i in 0 until montadoraAux.size) {
                listaMontadora.add(montadoraAux[i])
            }
            Log.d(TAG, "Lista ordenada: $listaMontadora")


            for (i in 0 until listaMontadora.size) {
                Log.d(TAG, "Validando posicao $i: ${listaMontadora[i]}")
            }
        }
    }

    private fun getJsonFromAssets(): String {
        return application.assets.open("montadoras.json").bufferedReader().use {
            it.readText()
        }
    }
}
