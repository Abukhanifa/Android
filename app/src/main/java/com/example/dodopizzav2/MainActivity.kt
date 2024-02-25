package com.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.dodopizzav2.adapter.PizzaAdapter
import com.example.dodopizzav2.PizzaList
import com.example.dodopizzav2.PizzaDataSource
import com.example.dodopizzav2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var adapter: PizzaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        PizzaAdapter(
            onPizzaClick = {
                handleMovieClick(it)
            }
        )
        adapter  = PizzaAdapter(
            onPizzaClick = {
                handleMovieClick(it)
            }
        )

        binding.editText.addTextChangedListener {
            val searchQuery = it.toString()
            if(searchQuery.isEmpty()){
                adapter?.setData(PizzaDataSource.pizzaList)
            }
            else{
                val list = PizzaDataSource.pizzaList.filter {
                    it.title.lowercase().contains(searchQuery.lowercase())
                }
                adapter?.setData(ArrayList(list))
            }
        }

        binding.recyclerView.adapter = adapter
        adapter?.setData(PizzaDataSource.pizzaList)

    }
    private fun handleMovieClick(pizza: PizzaList){
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra(MainActivity2.KEY_RESULT, pizza.title)
        intent.putExtra(MainActivity2.KEY_DESCRIPTION, pizza.description)
        intent.putExtra(MainActivity2.KEY_IMAGE, pizza.img)
        intent.putExtra(MainActivity2.KEY_CART, pizza.cart)
        intent.putExtra(MainActivity2.KEY_SIZE, pizza.size)
        startActivity(intent)
    }

}