package com.myu.myurecipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.myu.myurecipeapp.databinding.RowRecipeAdapterBinding
import com.myu.myurecipeapp.fragment.HomeFragmentDirections
import com.myu.myurecipeapp.models.Result

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding : RowRecipeAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object  :DiffUtil.ItemCallback<Result> (){
        override fun areItemsTheSame(oldItem:Result , newItem: Result): Boolean {
           return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallBack)
    var recipe:List<Result>
    get() = differ.currentList
    set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            RowRecipeAdapterBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currRecipe = recipe[position]

        holder.binding.apply {
            textView.text = currRecipe.title
            imageView.load(currRecipe.thumbnail) {
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener { mView ->
            val direction  =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(currRecipe)
            mView.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int {
       return recipe.size
    }

}