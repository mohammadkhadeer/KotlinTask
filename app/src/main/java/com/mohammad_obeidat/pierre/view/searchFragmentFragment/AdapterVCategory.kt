package com.mohammad_obeidat.pierre.view.searchFragmentFragment

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohammad_obeidat.pierre.R
import com.mohammad_obeidat.pierre.utils.Functions
import kotlinx.android.synthetic.main.adapter_list_category.view.*

class AdapterVCategory (val categoryAL : ArrayList<String>
                        , val context: Context
) : RecyclerView.Adapter<ViewHolderV>() {
    
    override fun onBindViewHolder(holder: ViewHolderV, position: Int) {
        holder?.categoryTV?.text = categoryAL.get(position)
        changeFont(context,holder)
        createSubCategory(position,holder,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderV {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_list_category, parent, false)
        return ViewHolderV(v)
    }

    override fun getItemCount(): Int {
        return categoryAL.size
    }

    private fun createSubCategory(position: Int, holder: ViewHolderV, context: Context) {
        holder.subCategoryRV.apply {
            layoutManager = LinearLayoutManager(context,OrientationHelper.HORIZONTAL,false)

            adapter = AdapterSubCategory( context!!.applicationContext,position)
        }
    }


    private fun changeFont(
        context: Context,
        holder: ViewHolderV
    ) {
        holder.categoryTV.setTypeface(Functions().changeFont(context))
        holder.seeAllTV.setTypeface(Functions().changeFont(context))
    }

}

class ViewHolderV (view: View) : RecyclerView.ViewHolder(view) {
    val categoryTV = view.categoryNameTV
    val seeAllTV = view.seeAllTV
    val subCategoryRV = view.rv_h_sub_category
}
