package com.example.bookstoreapplication

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookstoreapplication.MainAdapter.Companion.USER_KEY
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_each_row.view.*

class MainAdapter(val books: Book) : RecyclerView.Adapter<CustomViewHolder>(){

    //val bookList = mutableListOf("Literature", "Math", "Java", "Data Structure", "Physics", "Chemistry")
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val bookForEachRow = layoutInflater.inflate(R.layout.book_each_row, p0, false)
        return CustomViewHolder(bookForEachRow)
    }

    companion object {
        val USER_KEY = "USER_KEY"
    }

    override fun getItemCount(): Int {
        Log.d("StartingAdapter", "Adapter reached inside getItemCount function")
        return books.bookList.size
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        Log.d("StartingAdapter", "Adapter reached inside bind function")
        val bookName = books.bookList[p1]
        p0.view.BookName.text = bookName.name

        Picasso.get().load(bookName.imageUrl).into(p0.view.BookPic)

        p0.book = books.bookList[p1]
    }

}
class CustomViewHolder(val view: View, var book: BookListJson?=null): RecyclerView.ViewHolder(view){
    init{
        view.setOnClickListener {
            val intent = Intent(view.context, BookInfo::class.java)
            intent.putExtra(USER_KEY, book)
            view.context.startActivity(intent)
        }
    }

}