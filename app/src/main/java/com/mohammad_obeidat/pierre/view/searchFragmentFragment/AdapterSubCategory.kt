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
import kotlinx.android.synthetic.main.adapter_sub_category.view.*

class AdapterSubCategory (val context: Context
                          , val check : Int) : RecyclerView.Adapter<ViewHolderS>() {
    override fun onBindViewHolder(holder: ViewHolderS, position: Int) {
        changeFont(context,holder)
        changeBackground(holder,position,check)    }


    @SuppressLint("ResourceAsColor")
    private fun changeBackground(
        holder: ViewHolderS,
        position: Int,
        check: Int
    ) {
        if (check == 0)
        {
            holder.circleRL.setBackgroundResource(R.color.math)
            holder.categoryIV.setBackgroundResource(R.drawable.math)
            holder.subCategoryNameTV.setText("الرياضيات"+"  "+position)
        }
        if (check == 1)
        {
            holder.circleRL.setBackgroundResource(R.color.bio)
            holder.categoryIV.setBackgroundResource(R.drawable.bio)
            holder.subCategoryNameTV.setText("الأحياء" +"  "+position)
        }
        if (check == 2)
        {
            holder.circleRL.setBackgroundResource(R.color.generl)
            holder.categoryIV.setBackgroundResource(R.drawable.generl)
            holder.subCategoryNameTV.setText("العلوم العامة"+"  "+position)
        }
        if (check == 3)
        {
            holder.circleRL.setBackgroundResource(R.color.phis)
            holder.categoryIV.setBackgroundResource(R.drawable.phis)
            holder.subCategoryNameTV.setText("الفيزياء"+"  "+position)

        }
        if (check == 4)
        {
            holder.circleRL.setBackgroundResource(R.color.chim)
            holder.categoryIV.setBackgroundResource(R.drawable.chim)
            holder.subCategoryNameTV.setText("الكيمياء"+"  "+position)

        }
    }

    private fun changeFont(
        context: Context,
        holder: ViewHolderS
    ) {
        val typeface = Typeface.createFromAsset(context.assets, "frutiger-lt-arabic-55-roman.ttf")
        holder.subCategoryNameTV.setTypeface(typeface)

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