package com.mohammad_obeidat.pierre.view.mainScreenFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.mohammad_obeidat.pierre.R


class FragmentHome : Fragment(){

    lateinit var sliderRL: RelativeLayout;
    lateinit var searchPartRL: RelativeLayout;
    lateinit var subjectRL: RelativeLayout;

    companion object {

        fun newInstance(): FragmentHome {
            return FragmentHome()
        }
    }

    //3
    private lateinit var viewOfLayout: View

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater!!.inflate(R.layout.fragment_home, container, false)
        sliderRL = viewOfLayout.findViewById<RelativeLayout>(R.id.sliderRL)
        searchPartRL = viewOfLayout.findViewById<RelativeLayout>(R.id.searchPartRL)
        subjectRL = viewOfLayout.findViewById<RelativeLayout>(R.id.subjectRL)
        return viewOfLayout
    }
}

