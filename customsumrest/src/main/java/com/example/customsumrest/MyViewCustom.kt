package com.example.customsumrest

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView


/**
 * TODO: document your custom view class.
 */
class MyViewCustom : ConstraintLayout, View.OnClickListener {
    private var textView_showResult: TextView? = null
    private var button_minus: Button? = null
    private var button_plus: Button? = null
    private var mCallback: OnClickedButton? = null

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.button_plus){
                mCallback!!.onClickedButton(this, textView_showResult!!, v)
            } else if (v.id == R.id.button_minus){
                mCallback!!.onClickedButton(this, textView_showResult!!, v)
            }
        }
    }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.my_view_custom, this)

        textView_showResult = findViewById(R.id.textView_showResult) as TextView
        button_plus = findViewById(R.id.button_plus) as Button
        button_minus = findViewById(R.id.button_minus) as Button

        button_plus!!.setOnClickListener(this)
        button_minus!!.setOnClickListener(this)

    }

    interface OnClickedButton{
        fun onClickedButton(source: MyViewCustom, currentText: TextView, view: View)
    }

    fun setOnClickedButton(listener: OnClickedButton){
        mCallback = listener
    }
}
