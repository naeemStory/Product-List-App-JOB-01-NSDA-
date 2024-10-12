package com.example.productlistjob_01nsda

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.productlistjob_01nsda.Adapter.ProductAdapter as ProductAdapter1

class ProductActivity : AppCompatActivity() {
    private  lateinit var  productViewModel: ProductViewModel
    private  lateinit var  productAdapter: ProductAdapter1
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activityproduct)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        productAdapter = ProductAdapter1(emptyList())

        val  refreshBtn: FloatingActionButton = findViewById(R.id.refreshBtn)

        refreshBtn.setOnClickListener{

            startActivity(Intent(this@ProductActivity,ProductActivity::class.java))
            finish()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.productRv)
        recyclerView.layoutManager= LinearLayoutManager(this)

        productViewModel.products.observe(this, Observer {  products ->
            productAdapter = ProductAdapter1(products)


        })
    }
}