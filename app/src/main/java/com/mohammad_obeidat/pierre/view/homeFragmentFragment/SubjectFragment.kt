package com.mohammad_obeidat.pierre.view.mainScreenFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.mohammad_obeidat.pierre.R
import com.mohammad_obeidat.pierre.view.homeFragmentFragment.AdapterH

import kotlinx.android.synthetic.main.fragment_subject.*
import java.util.ArrayList


class SubjectFragment : Fragment(){

    private lateinit var viewOfLayout: View
    val categoryAL: ArrayList<String> = ArrayList()

    companion object {

        fun newInstance(): SubjectFragment {
            return SubjectFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater!!.inflate(R.layout.fragment_subject, container, false)
        addCategory()

        return viewOfLayout
    }

    private fun addCategory() {
        categoryAL.add("الرياضيات")
        categoryAL.add("الأحياء")
        categoryAL.add("العلوم العامة")
        categoryAL.add("الفيزياء")
        categoryAL.add("الكيمياء")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_category.apply {
            layoutManager = LinearLayoutManager(activity)
            rv_category.layoutManager = LinearLayoutManager(activity)
            rv_category.layoutManager = GridLayoutManager(activity, 3)
            adapter = AdapterH(categoryAL, activity!!.applicationContext)
        }
    }


}