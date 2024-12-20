package br.com.isaac.verdeshop.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.isaac.verdeshop.dao.ProdutoDao
import br.com.isaac.verdeshop.databinding.ProdutoListActivityBinding
import br.com.isaac.verdeshop.extension.startActivity
import br.com.isaac.verdeshop.ui.recyclerview.adapter.ProdutoListAdapter

class ProdutoListActivity : AppCompatActivity() {

    private val binding by lazy {
        ProdutoListActivityBinding.inflate(layoutInflater)
    }
    private val dao = ProdutoDao()
    private val adapter = ProdutoListAdapter(this, dao.list())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.fabAdd.setOnClickListener {
            startActivity<ProdutoFormActivity>()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.list())
    }
}