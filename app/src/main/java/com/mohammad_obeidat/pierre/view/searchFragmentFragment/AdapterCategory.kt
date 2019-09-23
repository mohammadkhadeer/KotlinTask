package com.mohammad_obeidat.pierre.view.searchFragmentFragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.mohammad_obeidat.pierre.R
import kotlinx.android.synthetic.main.home_adapter.view.*

class AdapterCategory (val categoryAL : ArrayList<String>
                       , val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.categoryTV?.text = categoryAL.get(position)
        changeFont(context,holder)
        changeBackground(context,holder,position)
    }

    @SuppressLint("ResourceAsColor")
    private fun changeBackground(
        context: Context,
        holder: ViewHolder,
        position: Int
    ) {
        if (position == 0)
        {
            holder.circleRL.setBackgroundResource(R.color.math)
            holder.categoryIV.setBackgroundResource(R.drawable.math)
        }
        if (position == 1)
        {
            holder.circleRL.setBackgroundResource(R.color.bio)
            holder.categoryIV.setBackgroundResource(R.drawable.bio)
        }
        if (position == 2)
        {
            holder.circleRL.setBackgroundResource(R.color.generl)
            holder.categoryIV.setBackgroundResource(R.drawable.generl)
        }
        if (position == 3)
        {
            holder.circleRL.setBackgroundResource(R.color.phis)
            holder.categoryIV.setBackgroundResource(R.drawable.phis)
        }
        if (position == 4)
        {
            holder.circleRL.setBackgroundResource(R.color.chim)
            holder.categoryIV.setBackgroundResource(R.drawable.chim)
        }
    }

    private fun changeFont(
        context: Context,
        holder: ViewHolder
    ) {
        val typeface = Typeface.createFromAsset(context.assets, "frutiger-lt-arabic-55-roman.ttf")
        holder.categoryTV.setTypeface(typeface)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_category, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return categoryAL.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val categoryTV = view.categoryNameTV
    val circleRL: RelativeLayout = view.circlRL
    val categoryIV: ImageView = view.categoryImg
}