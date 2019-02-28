package com.example.customsumrest

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


/**
 * TODO: document your custom view class.
 */
class MyViewCustom : ConstraintLayout, View.OnClickListener {
    private var textView_showResult: TextView? = null
    private var button_minus: Button? = null
    private var button_plus: Button? = null
    private var mCallbackPlus: onClickedButtonPlusListener? = null
    private var mCallbackMinus: onClickedButtonMinusListener? = null

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.button_plus){
                mCallbackPlus!!.onClickedButtonPlus(this, textView_showResult!!)
            } else if (v.id == R.id.button_minus){
                mCallbackMinus!!.onClickedButtonMinus(this, textView_showResult!!)
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

        val a = context.obtainStyledAttributes(attrs, R.styleable.MyViewCustom, defStyle, 0)

        val s = a.getString(R.styleable.MyViewCustom_hintText)
        if (s != null) {
            setHintText(s.toString())
        }

        button_plus!!.setOnClickListener(this)
        button_minus!!.setOnClickListener(this)

        a.recycle()
    }

    private fun setHintText(toString: String) {
        textView_showResult!!.setHint(toString)
        invalidate()
        requestLayout()
    }

    //Button plus
    interface onClickedButtonPlusListener{
        fun onClickedButtonPlus(source: MyViewCustom, currentText: TextView)
    }

    fun setOnClickedButtonPlusListener(listener: onClickedButtonPlusListener){
        mCallbackPlus = listener
    }

    //Button minus
    interface onClickedButtonMinusListener{
        fun onClickedButtonMinus(source: MyViewCustom, currentText: TextView)
    }

    fun setOnClickedButtonMinusListener(listener: onClickedButtonMinusListener){
        mCallbackMinus = listener
    }

}
