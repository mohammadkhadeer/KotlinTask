package com.mohammad_obeidat.pierre.view.mainScreenFragment

import android.content.res.Configuration
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mohammad_obeidat.pierre.R
import com.mohammad_obeidat.pierre.view.searchFragmentFragment.AdapterCategory
import com.mohammad_obeidat.pierre.view.searchFragmentFragment.AdapterVCategory
import kotlinx.android.synthetic.main.category_list_fragment.*
import kotlinx.android.synthetic.main.fragment_subject.*
import kotlinx.android.synthetic.main.horizontal_rv_fragment.*
import java.util.*

class CategoryListFragment : Fragment(){

    private lateinit var viewOfLayout: View
    lateinit var labelTV: TextView
    val categoryAL: ArrayList<String> = ArrayList()

    companion object {

        fun newInstance(): FragmentCup {
            return FragmentCup()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        changelanguage()
        viewOfLayout = inflater!!.inflate(R.layout.category_list_fragment, container, false)
        labelTV = viewOfLayout.findViewById<TextView>(R.id.labelTV)

        changeFont()
        addCategory()

        return viewOfLayout

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_v_category.apply {
            layoutManager = LinearLayoutManager(activity)
            rv_v_category.layoutManager = LinearLayoutManager(activity)
            rv_v_category.layoutManager = GridLayoutManager(activity, 1)
            adapter = AdapterVCategory(categoryAL, activity!!.applicationContext)
        }
    }

    private fun addCategory() {
        categoryAL.add("الرياضيات")
        categoryAL.add("الأحياء")
        categoryAL.add("العلوم العامة")
        categoryAL.add("الفيزياء")
        categoryAL.add("الكيمياء")

    }

    private fun changeFont() {
        val typeface = Typeface.createFromAsset(activity!!.assets, "frutiger-lt-arabic-55-roman.ttf")
        labelTV.setTypeface(typeface)

    }


    private fun changelanguage() {
        val lang = "ar"
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        getActivity()!!.baseContext.resources.updateConfiguration(
            config,
            getActivity()!!.baseContext.resources.displayMetrics
        )
    }

}