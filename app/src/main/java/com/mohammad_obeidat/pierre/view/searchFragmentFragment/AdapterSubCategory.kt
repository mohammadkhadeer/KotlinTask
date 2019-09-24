package com.mohammad_obeidat.pierre.view.searchFragmentFragment

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
import kotlinx.android.synthetic.main.adapter_sub_category.view.*

class AdapterSubCategory (val context: Context
                          , val check : Int) : RecyclerView.Adapter<ViewHolderS>() {
    override fun onBindViewHolder(holder: ViewHolderS, position: Int) {
        changeFont(context,holder)
        changeBackground(holder,position,check)
    }

    @SuppressLint("ResourceAsColor")
    private fun changeBackground(
        holder: ViewHolderS,
        position: Int,
        check: Int
    ) {
        if (check == 0)
        {
            holder.circleRL.setBackgroundResource(R.color.math)
            loadImage(R.drawable.math,holder)
            holder.subCategoryNameTV.setText("الرياضيات"+"  "+position)
        }
        if (check == 1)
        {
            holder.circleRL.setBackgroundResource(R.color.bio)
            loadImage(R.drawable.bio,holder)
            holder.subCategoryNameTV.setText("الأحياء" +"  "+position)
        }
        if (check == 2)
        {
            holder.circleRL.setBackgroundResource(R.color.generl)
            loadImage(R.drawable.generl,holder)
            holder.subCategoryNameTV.setText("العلوم العامة"+"  "+position)
        }
        if (check == 3)
        {
            holder.circleRL.setBackgroundResource(R.color.phis)
            loadImage(R.drawable.phis,holder)
            holder.subCategoryNameTV.setText("الفيزياء"+"  "+position)

        }
        if (check == 4)
        {
            holder.circleRL.setBackgroundResource(R.color.chim)
            loadImage(R.drawable.chim,holder)
            holder.subCategoryNameTV.setText("الكيمياء"+"  "+position)

        }
    }

    private fun loadImage(imageID: Int, holder: ViewHolderS) {
        Picasso.with(context).load(imageID)
            .into(holder.categoryIV)
    }

    private fun changeFont(
        context: Context,
        holder: ViewHolderS
    ) {
        holder.subCategoryNameTV.setTypeface(Functions().changeFont(context))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderS {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_sub_category, parent, false)
        return ViewHolderS(v)
    }

    override fun getItemCount(): Int {
        return 4
    }

}

class ViewHolderS (view: View) : RecyclerView.ViewHolder(view) {
    val subCategoryNameTV = view.subCategoryNameTV
    val circleRL: RelativeLayout = view.circlRL
    val categoryIV: ImageView = view.categoryImg
}