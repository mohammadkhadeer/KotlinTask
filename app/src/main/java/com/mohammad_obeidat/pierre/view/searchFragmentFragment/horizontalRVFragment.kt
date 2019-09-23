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
import android.widget.RelativeLayout
import android.widget.TextView
import com.mohammad_obeidat.pierre.R
import com.mohammad_obeidat.pierre.view.homeFragmentFragment.AdapterH
import com.mohammad_obeidat.pierre.view.searchFragmentFragment.AdapterCategory
import kotlinx.android.synthetic.main.fragment_subject.*
import kotlinx.android.synthetic.main.horizontal_rv_fragment.*
import java.util.*

class horizontalRVFragment : Fragment(){

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
        viewOfLayout = inflater!!.inflate(R.layout.horizontal_rv_fragment, container, false)
        labelTV = viewOfLayout.findViewById<TextView>(R.id.labelTV)

        changeFont()
        addCategory()

        return viewOfLayout

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_h_category.apply {
            layoutManager = LinearLayoutManager(activity,OrientationHelper.HORIZONTAL,false)

            adapter = AdapterCategory(categoryAL, activity!!.applicationContext)
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