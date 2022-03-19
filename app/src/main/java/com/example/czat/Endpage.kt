package com.example.czat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.czat.fragments.About
import com.example.czat.fragments.Profile
import kotlinx.android.synthetic.main.activity_endpage.*

class Endpage : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_endpage)


        if(intent!=null){
            var optionvalue:String = intent.getStringExtra("optionName").toString()
            when(optionvalue){
                    "profile"->{
                     supportFragmentManager.beginTransaction().replace(R.id.fl_endpage,Profile()).commit()
                      toolbar_endpage.title = "Profile"
                    }
                "about"->{
                    supportFragmentManager.beginTransaction().replace(R.id.fl_endpage,About()).commit()
                    toolbar_endpage.title = "About"
                }
            }
        }
    }
}