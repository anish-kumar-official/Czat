package com.example.czat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStateManagerControl
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.czat.fragments.CallsFragment
import com.example.czat.fragments.ChatFragment
import com.example.czat.fragments.StatusFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuprofile -> {
                val intent = Intent(this,Endpage::class.java)
                intent.putExtra("optionName","profile")
                startActivity(intent)
            }
            R.id.menuabout -> {
                val intent = Intent(this,Endpage::class.java)
                intent.putExtra("optionName","about")
                startActivity(intent)
            }
            R.id.menulogout ->{
                Toast.makeText(this,"logout Clicked",Toast.LENGTH_LONG).show()
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this,AuthActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}