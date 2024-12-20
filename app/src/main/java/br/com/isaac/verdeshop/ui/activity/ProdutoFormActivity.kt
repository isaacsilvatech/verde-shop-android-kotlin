package br.com.isaac.verdeshop.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.isaac.verdeshop.R
import br.com.isaac.verdeshop.dao.ProdutoDao
import br.com.isaac.verdeshop.databinding.ProdutoFormActivityBinding
import br.com.isaac.verdeshop.databinding.ProdutoFormDialogBinding
import br.com.isaac.verdeshop.model.Produto
import coil3.load
import coil3.request.fallback
import java.math.BigDecimal

class ProdutoFormActivity : AppCompatActivity() {
    private val binding by lazy {
        ProdutoFormActivityBinding.inflate(layoutInflater)
    }

    private val dao = ProdutoDao()

    private var urlImagem: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.vwImagem.setOnClickListener {

            var bindingDialog = ProdutoFormDialogBinding.inflate(layoutInflater)
            bindingDialog.btnCarregar.setOnClickListener {
                urlImagem = bindingDialog.edtUrlImage.text.toString()
                bindingDialog.vwImagem.load(urlImagem)
            }

            AlertDialog.Builder(this)
                .setView(bindingDialog.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    urlImagem = bindingDialog.edtUrlImage.text.toString()
                    binding.vwImagem.load(urlImagem) {
                        error(R.drawable.imagem_padrao)

                    }
                }
                .setNegativeButton("Cancelar") { _, _ ->
                }
                .show()
        }
        binding.btnSalvar.setOnClickListener { salvar() }
    }

    private fun salvar() {
        val nome = binding.edtNome.text.toString()
        val descricao = binding.edtDescricao.text.toString()
        val valor = binding.edtValor.text.toString()
        val produto = Produto(
            nome = nome,
            descricao = descricao,
            valor = if (valor.isBlank()) BigDecimal.ZERO else BigDecimal(valor),
            urlImagem = urlImagem
        )
        dao.add(produto)
        finish()
    }
}