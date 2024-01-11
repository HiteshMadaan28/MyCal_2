package com.example.mycal2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.displayTV
import kotlinx.android.synthetic.main.activity_main.resultTV


class MainActivity : AppCompatActivity() {

    private var canAddOperation=false
    private var canAddDecimal=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view :View){
        if(view is Button){
            if(view.text=="."){
                if(canAddOperation)
                    displayTV.append(view.text)
                canAddDecimal=false
            }
            else
                displayTV.append(view.text)
            canAddOperation=true
        }
    }

    fun operationAction(view: View){
        if(view is Button && canAddOperation){
            displayTV.append(view.text)
            canAddOperation=false
            canAddDecimal=true
        }
    }

    fun allClearAction(view:View){
        displayTV.text=""
        resultTV.text=""
    }
    fun backSpaceAction(view:View){
        val length=displayTV.length();
        if(length>0)
        {
            displayTV.text=displayTV.text.subSequence(0,length-1)
        }
    }
    fun equalsAction(view:View){}

}