package br.com.isaac.verdeshop.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.isaac.verdeshop.databinding.ProdutoListItemBinding
import br.com.isaac.verdeshop.extension.toCurrency
import br.com.isaac.verdeshop.model.Produto

class ProdutoListAdapter(val context: Context, produtos: List<Produto>) :
    RecyclerView.Adapter<ProdutoListAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutoListAdapter.ViewHolder {
        var binding = ProdutoListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutoListAdapter.ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.bind(produto)
    }

    override fun getItemCount(): Int {
        return produtos.size;
    }

    fun update(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ProdutoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(produto: Produto) {
            produto.run {
                binding.txNome.text = nome
                binding.txDescricao.text = descricao
                binding.txValor.text = valor.toCurrency()
            }
        }

    }
}
