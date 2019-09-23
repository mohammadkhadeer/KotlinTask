package com.mohammad_obeidat.pierre


import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                visibilHomeFragment();
                changeStutsBarColor()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                visibilSearchFragment();
                statusBarColor();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cup -> {
                visibilCupFragment();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                visibilProfileFragment();
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    lateinit var homeRL: RelativeLayout
    lateinit var searchRL: RelativeLayout
    lateinit var cupRL: RelativeLayout
    lateinit var profileRL: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changelanguage()
        intiActivityComp()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun changelanguage() {
        val lang = "ar"
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
    }
    private fun changeStutsBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }
    }

    private fun statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.test)
        }
    }
    private fun intiActivityComp() {
        homeRL = findViewById<RelativeLayout>(R.id.homeRL)
        searchRL = findViewById<RelativeLayout>(R.id.searchRL)
        cupRL = findViewById<RelativeLayout>(R.id.cupRL)
        profileRL = findViewById<RelativeLayout>(R.id.profileRL)
    }

    private fun visibilProfileFragment() {
        homeRL.visibility =  View.GONE
        searchRL.visibility =  View.GONE
        cupRL.visibility =  View.GONE
        profileRL.visibility =  View.VISIBLE
    }

    private fun visibilCupFragment() {
        homeRL.visibility =  View.GONE
        searchRL.visibility =  View.GONE
        cupRL.visibility =  View.VISIBLE
        profileRL.visibility =  View.GONE
    }

    private fun visibilSearchFragment() {
        homeRL.visibility =  View.GONE
        searchRL.visibility =  View.VISIBLE
        cupRL.visibility =  View.GONE
        profileRL.visibility =  View.GONE

    }

    private fun visibilHomeFragment() {
        homeRL.visibility =  View.VISIBLE
        searchRL.visibility =  View.GONE
        cupRL.visibility =  View.GONE
        profileRL.visibility =  View.GONE
    }

}
