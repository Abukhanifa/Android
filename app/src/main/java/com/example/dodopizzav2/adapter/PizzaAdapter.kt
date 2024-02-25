package com.example.dodopizzav2.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizzav2.PizzaList
import com.example.dodopizzav2.databinding.ItemPizzaBinding

class PizzaAdapter (
        private val onPizzaClick: (PizzaList)-> Unit,
    ):RecyclerView.Adapter<PizzaAdapter.ViewHolder>(){

        private val pizzaList: ArrayList<PizzaList> = ArrayList()
        fun setData(pizzas:ArrayList<PizzaList>){
            pizzaList.clear()
            pizzaList.addAll(pizzas)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemPizzaBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

        override fun getItemCount() = pizzaList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(pizzaList[position])
        }

        inner class ViewHolder(
            private val binding: ItemPizzaBinding
        ): RecyclerView.ViewHolder(binding.root){
            fun bind(pizza: PizzaList){
                with(binding) {
                    pizzaImage.setImageResource(pizza.img)
                    pizzaTitle.text = pizza.title
                    pizzaDescription.text = pizza.description
                    pizzaPrice.text= pizza.price

                    root.setOnClickListener{
                        onPizzaClick(pizza)
                    }


                }
            }

        }

    }
