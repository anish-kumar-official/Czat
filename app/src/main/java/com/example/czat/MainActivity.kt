package com.example.czat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStateManagerControl
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.czat.fragments.CallsFragment
import com.example.czat.fragments.ChatFragment
import com.example.czat.fragments.StatusFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titles = arrayListOf("Chat","Status","Calls")

        setSupportActionBar(toolbarMain)
        val apppageradapter:AppPagerAdapter = AppPagerAdapter(this)
        viewpagerMain.adapter  = apppageradapter
        TabLayoutMediator(tabMain,viewpagerMain){
            tab,position->
            tab.text= titles[position]
        }.attach()


    }

    class AppPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> ChatFragment()
                1 -> StatusFragment()
                2 -> CallsFragment()
                else -> ChatFragment()
            }
        }

    }
}