package com.example.czat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.czat.fragments.signinFragment
import com.example.czat.fragments.signupFragment
import com.google.android.gms.tasks.Task
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.fragment_signin.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val auth_titles = arrayListOf("SignIn","SignUp")
        val authpageradapter:Authpageradapter = Authpageradapter(this)
        vp_auth.adapter = authpageradapter
        TabLayoutMediator(tab_auth,vp_auth){
            tab,position->
            tab.text=auth_titles[position]
        }.attach()


    }

    internal fun signin(){
        val intent = Intent(this,Endpage::class.java)
        startActivity(intent)
    }

    class Authpageradapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
           return when(position){
               0->signinFragment()
               1->signupFragment()
               else -> signinFragment()
           }
        }

    }
}