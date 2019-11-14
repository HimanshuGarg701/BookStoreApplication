package com.example.bookstoreapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_book_info.*

class BookInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)

        displayUserInfo()

        RentButton.setOnClickListener {
            performGetAction()
        }

        BuyButton.setOnClickListener {
            performGetAction()
        }

    }
    companion object {
        val USER_KEY_Name = "USER_KEY"
        val USER_KEY_AUTHOR = "AUTHOR_NAME"
    }

    private fun performGetAction(){
        var book_info = intent.getParcelableExtra<BookListJson>(MainAdapter.USER_KEY)
        val intent = Intent(this, BookCollection::class.java)
        intent.putExtra(USER_KEY_Name, book_info.name)
        startActivity(intent)
    }

    private fun displayUserInfo(){
        var book_info = intent.getParcelableExtra<BookListJson>(MainAdapter.USER_KEY)
        BookInfoName.text = book_info.name
        BookInfoAuthor.text = book_info.author

         Picasso.get().load(book_info.imageUrl).into(BookInfoPic)
    }

}
