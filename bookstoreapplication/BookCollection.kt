package com.example.bookstoreapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_collection.*

class BookCollection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_collection)

        displayinfo()
    }
    private fun displayinfo(){
        var bookName = intent.getStringExtra(BookInfo.USER_KEY_Name)

        Availability.text = "You can get the book $bookName from the BooStore."

    }
}
