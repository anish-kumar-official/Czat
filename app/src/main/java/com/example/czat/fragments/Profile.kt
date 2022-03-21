package com.example.czat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.czat.R
import kotlinx.android.synthetic.main.fragment_profile.*

class Profile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        var btn_update = view.findViewById<Button>(R.id.btn_update_profilefragment)
        var btn_save = view.findViewById<Button>(R.id.btn_save_profilefragment)

        btn_update.setOnClickListener{
            profile_name.visibility = View.GONE
            tv_email_profilefragment.visibility = View.GONE
            tv_status_profilefragment.visibility  = View.GONE
            et_email_profilefragment.visibility = View.VISIBLE
            et_name_profilefragment.visibility = View.VISIBLE
            et_status_profilefragment.visibility = View.VISIBLE
            btn_save.visibility = View.VISIBLE
            btn_update.visibility = View.GONE
        }
        btn_save.setOnClickListener{
            profile_name.visibility = View.VISIBLE
            tv_email_profilefragment.visibility = View.VISIBLE
            tv_status_profilefragment.visibility  = View.VISIBLE
            et_email_profilefragment.visibility = View.GONE
            et_name_profilefragment.visibility = View.GONE
            et_status_profilefragment.visibility = View.GONE
            btn_save.visibility = View.GONE
            btn_update.visibility = View.VISIBLE

        }



       return view
    }

}