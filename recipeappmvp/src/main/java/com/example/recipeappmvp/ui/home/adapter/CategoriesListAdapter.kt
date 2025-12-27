package com.example.recipeappmvp.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recipeappmvp.data.model.ResponseCategoriesList.Category
import com.example.recipeappmvp.databinding.CategoryItemBinding
import javax.inject.Inject

class CategoriesListAdapter @Inject constructor() : RecyclerView.Adapter<CategoriesListAdapter.MyViewHolder>()  {

    private lateinit var binding: CategoryItemBinding
    private lateinit var context: Context
    private var categoriesList = emptyList<Category>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        context = parent.context
        return MyViewHolder()
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(categoriesList[position])
        holder.setIsRecyclable(true)
    }


    inner class MyViewHolder() : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Category){
            binding.apply {

                /*root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item)
                    }
                }*/

                itemCategoriesImg.load(item.strCategoryThumb){
                    crossfade(true)
                    crossfade(500)
                }

                itemCategoriesTxt.text = item.strCategory


            }
        }
    }


    private var onItemClickListener : ((Category, String) ->  Unit)? = null

    fun setOnClickListener(listener:((Category,String) ->  Unit)) {
        onItemClickListener = listener
    }

    fun setData(data:List<Category>){
        val categoriesDiffUtils = CategoriesDiffUtils(categoriesList,data)
        val diffUtils = DiffUtil.calculateDiff(categoriesDiffUtils)
        categoriesList = data
        diffUtils.dispatchUpdatesTo(this)
    }


    class CategoriesDiffUtils(private val oldItem:List<Category>, private val newItem:List<Category>) : DiffUtil.Callback(){
        override fun getOldListSize(): Int {
            return oldItem.size
        }

        override fun getNewListSize(): Int {
            return newItem.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] == newItem[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] == newItem[newItemPosition]
        }
    }



}