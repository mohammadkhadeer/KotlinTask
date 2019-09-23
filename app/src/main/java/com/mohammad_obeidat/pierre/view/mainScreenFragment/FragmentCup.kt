package com.mohammad_obeidat.pierre.view.mainScreenFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohammad_obeidat.pierre.R

class FragmentCup : Fragment(){

    companion object {

        fun newInstance(): FragmentCup {
            return FragmentCup()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cup, container, false)
    }
}