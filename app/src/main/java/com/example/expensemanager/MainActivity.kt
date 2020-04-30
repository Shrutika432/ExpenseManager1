package com.example.expensemanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var total:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var categories = listOf<Category>(Category("Home Rent", R.drawable.home),Category("Eating Out", R.drawable.donate),Category("Travel", R.drawable.followup),Category("Shopping", R.drawable.event_image))
        var categoriesName = categories.map { category -> category.name }
        LvExpense.adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,categoriesName)

        LvExpense.setOnItemClickListener { parent, view, position, id ->
            var intent=Intent(this,second::class.java)
            intent.putExtra("category", categories[position])
            startActivityForResult(intent, 2)
        }
        showResult()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data!!.getDoubleExtra("result", 10.0)
                total += result
                Log.d("TOTALE", total.toString())
                showResult()
            }
            if (resultCode == Activity.RESULT_CANCELED) { //Write your code if there's no result
            }
        }

    }

    fun showResult(){
        tvResult.text = "Your total spend: $total $"
    }
}

