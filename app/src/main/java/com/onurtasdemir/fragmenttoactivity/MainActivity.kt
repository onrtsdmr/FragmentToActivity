package com.onurtasdemir.fragmenttoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FirstFragmentListener {


    private var firstFragment: FirstFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstFragment = FirstFragment()

        supportFragmentManager.beginTransaction()
                .replace(R.id.firstContainer, firstFragment!!)
                .commit()

    }

    override fun messageFromFirst(message: String) {
        txtFragmentToActivity.text = message
    }
}
