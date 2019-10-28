package com.onurtasdemir.fragmenttoactivity


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.ClassCastException


class FirstFragment : Fragment() {

    private var firstFragmentListener: FirstFragmentListener? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        val btn = view.findViewById<Button>(R.id.firstFragmentBtn)
        val edtText = view.findViewById<EditText>(R.id.firstFragmentEdt)

        btn.setOnClickListener {
            val message: String = edtText.text.toString()
            firstFragmentListener?.messageFromFirst(message)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            firstFragmentListener = context as FirstFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context FirstFragmentListener implement edilmeli.")
        }
    }

    override fun onDetach() {
        super.onDetach()
        firstFragmentListener = null
    }
}
