package com.example.expensemanager

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val category:Category =  intent.getSerializableExtra("category") as Category

        tvCatName.text = category.name
        imageView.setImageResource(category.imageId)
        btnAdd.setOnClickListener {
            val expense:Double = et.text.toString().toDouble()
            Log.d("TOTALE", expense.toString())
            val rintent = Intent()
            rintent.putExtra("result", expense)
            setResult(Activity.RESULT_OK,rintent)
            finish()
        }
    }
}
