package com.example.czat.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.czat.MainActivity
import com.example.czat.R
import com.google.firebase.auth.FirebaseAuth
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
            val email = et_email.text.toString()
            val password=et_password.text.toString()
            if(TextUtils.isEmpty(email)){
                et_email.error = "Wrong Email"
            }
            else if(TextUtils.isEmpty(password)){
                et_password.error = "Wrong password"
            }
            else{
                signIn(email,password)
            }
        }
        return view
    }

    private fun signIn(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener{
            if(it.isSuccessful){
                val intent = Intent(this@signinFragment.context,MainActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this@signinFragment.context,"Email/password is wrong",Toast.LENGTH_LONG).show()
            }
        }
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        btn_signIn.setOnClickListener{
//            (activity as AuthActivity).signin()
//        }
//    }


}