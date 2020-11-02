package com.justin.didi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list : MutableList<String> = ArrayList()
        for (i in 1..1040)
            list.add("Item $i")

        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list)
        spnTest.adapter = adapter

        spnTest.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val item = list[p2]
                    Toast.makeText(this@MainActivity, "$item selected", Toast.LENGTH_SHORT).show()
            }
        }

        limitDropDownHeight(spnTest)
    }

    fun limitDropDownHeight(spnTest: Spinner){
        val popup = Spinner::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true

        val popupWindow = popup.get(spnTest) as ListPopupWindow
        popupWindow.height = (100 * resources.displayMetrics.density).toInt()
    }
}