package br.com.isaac.verdeshop.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.isaac.verdeshop.dao.ProdutoDao
import br.com.isaac.verdeshop.databinding.ProdutoFormActivityBinding
import br.com.isaac.verdeshop.model.Produto
import java.math.BigDecimal

class ProdutoFormActivity : AppCompatActivity() {

    private val binding by lazy {
        ProdutoFormActivityBinding.inflate(layoutInflater)
    }

    private val dao = ProdutoDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener { salvar() }
    }

    private fun salvar() {
        val nome = binding.edtNome.text.toString()
        val descricao = binding.edtDescricao.text.toString()
        val valor = binding.edtValor.text.toString()
        val produto = Produto(
            nome = nome,
            descricao = descricao,
            valor = if (valor.isBlank()) BigDecimal.ZERO else BigDecimal(valor)
        )
        dao.add(produto)
        finish()
    }
}