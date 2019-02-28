package com.example.customcomponent


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.customsumrest.MyViewCustom


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentCustomComponent : Fragment(), MyViewCustom.OnClickedButton {
    var custom: MyViewCustom? = null
    lateinit var listenerCustomView: ClickListenerCustomView

    interface ClickListenerCustomView {
        fun customViewClicked(currentText: String)
    }

    override fun onClickedButton(source: MyViewCustom, currentText: TextView, view: View) {
        when (view.id) {
            custom!!.findViewById<View>(R.id.button_plus).id -> {
                Toast.makeText(this.activity, getString(R.string.Text_toast_button_plus), Toast.LENGTH_SHORT).show()
                currentText.text = (currentText.text.toString().toInt() + 1).toString()
                listenerCustomView.customViewClicked(currentText.text.toString())
            }

            custom!!.findViewById<View>(R.id.button_minus).id -> {
                Toast.makeText(this.activity, getString(R.string.Text_toast_button_minus), Toast.LENGTH_SHORT)
                    .show()
                currentText.text = (currentText.text.toString().toInt() - 1).toString()
                val currentText = custom!!.findViewById<View>(R.id.textView_showResult) as TextView
                listenerCustomView.customViewClicked(currentText.text.toString())
            }
        }
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
        listenerCustomView = context as ClickListenerCustomView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        custom = this.activity!!.findViewById(R.id.custom)

        setListener()
        custom!!.setOnClickedButton(this)

    }

    private fun setListener() {
        val currentText = custom!!.findViewById<View>(R.id.textView_showResult) as TextView
        listenerCustomView.customViewClicked(currentText.text.toString())
    }

}
