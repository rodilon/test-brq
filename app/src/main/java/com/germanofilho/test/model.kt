package com.germanofilho.test

data class MontadoraAgregador(val montadoras: ArrayList<Montadora>?)

data class Montadora(val id: String?,
                     val nome: String?,
                     val carros: List<Carro>?)

data class Carro(val id: String?,
                 val nome: String?,
                 val pecas: List<Peca>?)

data class Peca(val id: String?,
                val nome: String?)