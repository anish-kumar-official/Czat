package com.example.czat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

class AuthActivity : AppCompatActivity(),FirebaseAuth.AuthStateListener {

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

//    override fun onStart() {
//        super.onStart()
//        Log.d("startmainactivity","onstart begin")
//        FirebaseAuth.getInstance().addAuthStateListener(this)
//        if(FirebaseAuth.getInstance()!=null){
//            startmainactivity()
//        }
//
//    }
//
    override fun onStop() {
        super.onStop()
        FirebaseAuth.getInstance().removeAuthStateListener(this)
    }

    override fun onAuthStateChanged(p0: FirebaseAuth) {
        Log.d("startmainactivity","authstate changed")
        if(p0.currentUser!=null){
            startmainactivity()
        }

    }

    private fun startmainactivity() {
        Log.d("startmainactivity","startmainactivity started")
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}