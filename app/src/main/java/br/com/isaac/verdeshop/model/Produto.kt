package br.com.isaac.verdeshop.model

import java.math.BigDecimal

data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal = BigDecimal.ZERO,
    val urlImagem: String? = null
)
