package com.navin.melalwallet.ui.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.navin.melalwallet.R
import com.navin.melalwallet.utils.Utility
import kotlinx.android.synthetic.main.activity_kotlin.*


class KotlinActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        btn_click.setOnClickListener {

            Toast.makeText(applicationContext,"Hi", Toast.LENGTH_LONG).show()

            txt_title.setText("Welcome to Kotlin")


            val i : Utility = Utility()

            val min2 : Boolean = i.getZoj(5)  // non static

            var min = Utility.getMin(5,7) // static


        }

    }
}
