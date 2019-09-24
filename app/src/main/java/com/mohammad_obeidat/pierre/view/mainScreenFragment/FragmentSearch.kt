package com.mohammad_obeidat.pierre.view.mainScreenFragment

import android.content.res.Configuration
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import com.mohammad_obeidat.pierre.R
import com.mohammad_obeidat.pierre.utils.Functions
import java.util.*

class FragmentSearch : Fragment(){

    private lateinit var viewOfLayout: View
    lateinit var searchEDT: EditText
    lateinit var sliderRL: RelativeLayout;
    lateinit var horizontalRL: RelativeLayout;
    lateinit var categoryRL: RelativeLayout;

    companion object {

        fun newInstance(): FragmentSearch {
            return FragmentSearch()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater!!.inflate(R.layout.fragment_search, container, false)
        Functions().changeLanguage(activity!!)
        inti()
        changeFont();

        return viewOfLayout
    }

    private fun inti() {
        searchEDT = viewOfLayout.findViewById<EditText>(R.id.search_edt)
        sliderRL = viewOfLayout.findViewById<RelativeLayout>(R.id.sliderRL)
        horizontalRL = viewOfLayout.findViewById<RelativeLayout>(R.id.horizontalRL)
        categoryRL = viewOfLayout.findViewById<RelativeLayout>(R.id.categoryListRL)
    }

    private fun changeFont() {
        searchEDT.setTypeface(Functions().changeFont(this!!.activity!!))
    }

}