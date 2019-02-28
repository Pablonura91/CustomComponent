package com.example.customcomponent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity(), FragmentCustomComponent.ClickListenerCustomView {
    override fun customViewClicked(currentText: String) {
        if (findViewById<View>(R.id.ConstraintRight) != null) {
            val fragmentDetails = BlankFragment.newInstance(currentText)
            supportFragmentManager.beginTransaction().replace(R.id.ConstraintRight, fragmentDetails)
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = FragmentCustomComponent()
        if (findViewById<View>(R.id.container) != null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentList).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.ConstrainLeft, fragmentList).commit()
        }
    }
}