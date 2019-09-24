package com.mohammad_obeidat.pierre.view.homeFragmentFragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohammad_obeidat.pierre.R
import com.mohammad_obeidat.pierre.model.ImageModel
import com.viewpagerindicator.CirclePageIndicator
import java.util.*

class Slider : Fragment(){
    private val myImageList = intArrayOf(R.drawable.f, R.drawable.s)
    private var imageModelArrayList: ArrayList<ImageModel>? = null
    private lateinit var viewOfLayout: View

    companion object {
        private var mPager: ViewPager? = null
        private var currentPage = 0
        private var NUM_PAGES = 0

        fun newInstance(): Slider {
            return Slider()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        imageModelArrayList = ArrayList()
        imageModelArrayList = populateList()

        viewOfLayout = inflater!!.inflate(R.layout.fragment_slider, container, false)
        init(viewOfLayout)

        return viewOfLayout

    }

    private fun populateList(): ArrayList<ImageModel> {

        val list = ArrayList<ImageModel>()

        for (i in 0..1) {
            val imageModel = ImageModel()
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }

    private fun init(viewOfLayout: View) {

        mPager = viewOfLayout.findViewById(R.id.pager) as ViewPager
        mPager!!.adapter = SlidingImageAdapter(this!!.getActivity()!!, this.imageModelArrayList!!)

        val indicator = viewOfLayout.findViewById(R.id.indicator) as CirclePageIndicator

        indicator.setViewPager(mPager)

        val density = resources.displayMetrics.density

        //Set circle indicator radius
        indicator.setRadius(5 * density)

        NUM_PAGES = imageModelArrayList!!.size

        // Auto start of viewpager
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            mPager!!.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 3000, 3000)

        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                currentPage = position

            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(pos: Int) {

            }
        })

    }

}