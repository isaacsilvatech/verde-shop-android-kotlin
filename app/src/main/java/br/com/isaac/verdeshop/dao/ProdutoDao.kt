package br.com.isaac.verdeshop.dao

import br.com.isaac.verdeshop.model.Produto
import java.math.BigDecimal

class ProdutoDao {

    fun add(produto: Produto) {
        produtos.add(produto)
    }

    fun list(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                nome = "Banana",
                descricao = "Banana prata",
                valor = BigDecimal("6.99")
            ),
            Produto(
                nome = "Abacate",
                descricao = "Abacate Hass",
                valor = BigDecimal("14.99")
            ),
            Produto(
                nome = "Mamão",
                descricao = "Mamão papaia",
                valor = BigDecimal("10.99")
            ),
        )
    }
}
