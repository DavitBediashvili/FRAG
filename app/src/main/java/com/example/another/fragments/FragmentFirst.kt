package com.example.another.fragments

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.another.R
import android.content.SharedPreferences
import android.view.View


class FragmentFirst : Fragment(R.layout.fragment_first) {
        private lateinit var editTextNote: EditText
        private lateinit var buttonAdd: Button
        private lateinit var textView: TextView
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            init()
            val sharedPreferances = requireActivity()
                .getSharedPreferences("pref", Context.MODE_PRIVATE)

            val text = sharedPreferances.getString("note", "")
            textView.text = text
            buttonAdd.setOnClickListener(){
                var note = editTextNote.text.toString()
                var text = textView.text.toString()
                var result = note + "\n" + text
                textView.text = result
                sharedPreferances.edit().putString("note", result).apply()
            }
        }
        private fun init(){
            editTextNote = requireView().findViewById(R.id.editTextNote)
            buttonAdd = requireView().findViewById(R.id.buttonAdd)
            textView = requireView().findViewById(R.id.textView)
        }
    }

