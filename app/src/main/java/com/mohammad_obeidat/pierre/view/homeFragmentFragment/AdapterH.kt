package com.mohammad_obeidat.pierre.view.homeFragmentFragment

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.mohammad_obeidat.pierre.R
import com.mohammad_obeidat.pierre.utils.Functions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_adapter.view.*

class AdapterH(val categoryAL : ArrayList<String>
               , val context: Context
               ) : RecyclerView.Adapter<ViewHolder>() {

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
            holder.circleRL.setBackgroundResource(R.drawable.math_bg)
            loadImage(R.drawable.math,holder)
        }
        if (position == 1)
        {
            holder.circleRL.setBackgroundResource(R.drawable.bio_bg)
            loadImage(R.drawable.bio,holder)
        }
        if (position == 2)
        {
            holder.circleRL.setBackgroundResource(R.drawable.generl_bg)
            loadImage(R.drawable.generl,holder)
        }
        if (position == 3)
        {
            holder.circleRL.setBackgroundResource(R.drawable.phis_bg)
            loadImage(R.drawable.phis,holder)
        }
        if (position == 4)
        {
            holder.circleRL.setBackgroundResource(R.drawable.chem_bg)
            loadImage(R.drawable.chim,holder)
        }
    }

    private fun loadImage(imageID: Int, holder: ViewHolder) {
        Picasso.with(context).load(imageID)
            .into(holder.categoryIV)
    }

    private fun changeFont(
        context: Context,
        holder: ViewHolder
    ) {
        holder.categoryTV.setTypeface(Functions().changeFont(context))

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_adapter, parent, false)
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