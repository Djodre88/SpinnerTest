package com.example.spinnertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = resources.getStringArray(R.array.Categories)
        val textView: TextView = findViewById(R.id.textView) as TextView

        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, categories)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + categories[position], Toast.LENGTH_SHORT).show()

                    textView.setText(categories[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}