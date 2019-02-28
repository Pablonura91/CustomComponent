package com.example.customcomponent


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.customsumrest.MyViewCustom
import org.w3c.dom.Text


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentCustomComponent : Fragment(), MyViewCustom.onClickedButtonPlusListener,
    MyViewCustom.onClickedButtonMinusListener {
    var custom: MyViewCustom? = null
    var currentText: String = "0"
    lateinit var listenerCustomView: clickListenerCustomView

    interface clickListenerCustomView {
        fun customViewClicked(currentText: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_custom_component, container, false)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listenerCustomView = context as clickListenerCustomView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListener()

        custom = this.activity!!.findViewById(R.id.custom)

        custom!!.setOnClickedButtonPlusListener(this)
        custom!!.setOnClickedButtonMinusListener(this)

    }

    private fun setListener() {
        listenerCustomView.customViewClicked(currentText)
    }

    override fun onClickedButtonPlus(source: MyViewCustom, currentText: TextView) {
        Toast.makeText(this.activity, "button plus clicked", Toast.LENGTH_SHORT).show()
        currentText.text = (currentText.text.toString().toInt() + 1).toString()
        listenerCustomView.customViewClicked(currentText.text.toString())
    }

    override fun onClickedButtonMinus(source: MyViewCustom, currentText: TextView) {
        Toast.makeText(this.activity, "button minus clicked", Toast.LENGTH_SHORT).show()
        currentText.text = (currentText.text.toString().toInt() - 1).toString()
        listenerCustomView.customViewClicked(currentText.text.toString())
    }

}
