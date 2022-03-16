package com.example.czat.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.czat.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_signup.*

class signupFragment : Fragment() {

   lateinit var auth:FirebaseAuth
   lateinit var fstore:FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup,container,false)
        var btnsignup = view.findViewById<Button>(R.id.btn_register)
        auth = FirebaseAuth.getInstance()
        fstore = FirebaseFirestore.getInstance()
        btnsignup.setOnClickListener{
            val email = et_registerEmail.text.toString()
            val password = et_registerPassword.text.toString()
            val name = et_Name.text.toString()
            if(TextUtils.isEmpty(email)){
                 et_registerEmail.error = "Email Field cannot be empty"
            }
            else if(TextUtils.isEmpty(password)){
                et_registerPassword.error = "Password Field cannot be empty"
            }
            else if(password.length < 6 ){
                et_registerPassword.error = "password is too short"
            }
            else{
                CreateAccount(email,password)
            }
        }
        return view
    }

}

class CreateAccount(email: String, password: String) {


}
