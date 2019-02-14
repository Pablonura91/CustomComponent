package com.example.customcomponent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.customsumrest.MyViewCustom

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val fragmentList = FragmentCustomComponent()

        supportFragmentManager.beginTransaction().replace(R.id.container, fragmentList).commit()
    }
}