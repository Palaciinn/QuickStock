package com.example.quickstock

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchProductActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var productListRecyclerView: RecyclerView

    private lateinit var productAdapter: ProductAdapter
    private val productList = mutableListOf<String>("Producto 1", "Producto 2", "Producto 3", "Producto 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_product)

        // Referencias a las vistas
        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        productListRecyclerView = findViewById(R.id.productListRecyclerView)

        // Configurar RecyclerView
        productAdapter = ProductAdapter(productList)
        productListRecyclerView.layoutManager = LinearLayoutManager(this)
        productListRecyclerView.adapter = productAdapter

        // Lógica para buscar productos
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString().trim()
            if (query.isNotEmpty()) {
                // Filtrar la lista de productos (aquí puedes integrar una búsqueda real en una base de datos)
                val filteredList = productList.filter { it.contains(query, ignoreCase = true) }
                productAdapter.updateProductList(filteredList)
            }
        }
    }
}
