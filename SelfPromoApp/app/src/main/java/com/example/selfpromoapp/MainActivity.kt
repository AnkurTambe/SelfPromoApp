package com.example.selfpromoapp

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview.setOnClickListener {
            if (edit_text_contact_name.text.toString()
                    .isEmpty() || edit_text_display_name.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Give Proper Information", Toast.LENGTH_SHORT).show();
            } else
                onPreviewClicked()
        }

        val spinnerValues = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_list.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)

        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_display_name.text.toString(),
            edit_text_available_from_date.text.toString(),
            check_box_include_junior.isChecked,
            check_box_immediate_start.isChecked,
            spinner_list.selectedItem?.toString()
        )

        previewActivityIntent.putExtra("Mes", message)

        startActivity(previewActivityIntent)

    }
}