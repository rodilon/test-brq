package com.germanofilho.test

data class MontadoraAgregador(val montadoras: MutableList<Montadora>)

data class Montadora(val id: String? = "0",
                     val nome: String? = "0",
                     val carros: List<Carro>?)

data class Carro(val id: String?,
                 val nome: String?,
                 val pecas: List<Peca>)

data class Peca(val id: String?,
                val nome: String?)