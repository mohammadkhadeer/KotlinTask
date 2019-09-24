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
import com.mohammad_obeidat.pierre.utils.Functions
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
        Functions().changeLanguage(activity!!)
        viewOfLayout = inflater!!.inflate(R.layout.fragment_search_part_in_home_fragment, container, false)
        init()
        changeFont();

        return viewOfLayout
    }

    private fun init() {
        searchTV = viewOfLayout.findViewById<TextView>(R.id.search_tv)
        searchEDT = viewOfLayout.findViewById<EditText>(R.id.search_edt)
    }

    private fun changeFont() {
        searchTV.setTypeface(Functions().changeFont(activity!!))
        searchEDT.setTypeface(Functions().changeFont(activity!!))
    }

}