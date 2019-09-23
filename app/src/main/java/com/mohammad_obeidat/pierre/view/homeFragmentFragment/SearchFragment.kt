package com.mohammad_obeidat.pierre.view.mainScreenFragment

import android.content.res.Configuration
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import com.mohammad_obeidat.pierre.R
import java.util.*

class SearchFragment : Fragment(){

    private lateinit var viewOfLayout: View
    lateinit var searchTV: TextView
    lateinit var searchEDT: EditText

    companion object {

        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        changelanguage()
        viewOfLayout = inflater!!.inflate(R.layout.fragment_search_part_in_home_fragment, container, false)
        searchTV = viewOfLayout.findViewById<TextView>(R.id.search_tv)
        searchEDT = viewOfLayout.findViewById<EditText>(R.id.search_edt)
        changeFont();

        return viewOfLayout
    }

    private fun changeFont() {
        val typeface = Typeface.createFromAsset(activity!!.assets, "frutiger-lt-arabic-55-roman.ttf")
        searchTV.setTypeface(typeface)
        searchEDT.setTypeface(typeface)

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