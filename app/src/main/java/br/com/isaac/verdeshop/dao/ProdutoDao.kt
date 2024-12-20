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
                valor = BigDecimal("6.99"),
                urlImagem = "https://images.pexels.com/photos/2872755/pexels-photo-2872755.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            ),
            Produto(
                nome = "Abacate",
                descricao = "Abacate Hass",
                valor = BigDecimal("14.99"),
                urlImagem = "https://images.pexels.com/photos/2228553/pexels-photo-2228553.jpeg?auto=compress&cs=tinysrgb&w=600"
            ),
            Produto(
                nome = "Mamão",
                descricao = "Mamão papaia",
                valor = BigDecimal("10.99"),
                urlImagem = "https://images.pexels.com/photos/7656863/pexels-photo-7656863.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            )
        )
    }
}
