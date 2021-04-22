package com.doe.compshop.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.doe.compshop.R
import com.doe.compshop.databinding.ItemHomeBinding
import com.doe.compshop.models.Product
import com.doe.compshop.util.OnClick

class ProductsRecyclerViewAdapter constructor(
    private val productsList: List<Product>,
    private val category: String,
    private val onClick: OnClick
) : RecyclerView.Adapter<ProductRecyclerviewViewHolder>() {

    private val filterProductList = productsList.filter { it.category == category }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductRecyclerviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemHomeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_home, parent, false)

        return ProductRecyclerviewViewHolder(binding)
    }

    override fun getItemCount() = filterProductList.size

    override fun onBindViewHolder(holder: ProductRecyclerviewViewHolder, position: Int) {
        val product = filterProductList[position]

        holder.bind(holder.itemView.context, product)

        holder.itemView.setOnClickListener {
            onClick.onClick(product)
        }
    }
}

class ProductRecyclerviewViewHolder(private val binding: ItemHomeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(context: Context, product: Product) {
        Glide.with(context)
            .load(context.getDrawable(product.imageUrl!!))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageViewProduct)

        binding.textViewProductName.text = product.name
        binding.textViewProductPrice.text = "USD ${product.price}"
    }

}