package com.example.czat.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.czat.AuthActivity
import com.example.czat.Endpage
import com.example.czat.R
import kotlinx.android.synthetic.main.fragment_signin.*

class signinFragment : Fragment() {

     lateinit var loginbutton:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signin,container,false)

        loginbutton = view.findViewById(R.id.btn_signIn)
        loginbutton.setOnClickListener{
            Toast.makeText(this@signinFragment.context,"success",Toast.LENGTH_LONG).show()
        }
        return view
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        btn_signIn.setOnClickListener{
//            (activity as AuthActivity).signin()
//        }
//    }


}