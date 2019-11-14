package com.example.bookstoreapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.*
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.book_each_row.view.*
import okhttp3.*
import java.io.IOException

class BookList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        Recycler.layoutManager = LinearLayoutManager(this)
        Recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        checkUserLogin()
        fetchingJson()
    }

    private fun checkUserLogin(){
        val uid = FirebaseAuth.getInstance().uid
        if(uid == null){
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    private fun fetchingJson(){
        val url = "https://api.myjson.com/bins/y8ujg"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()

                val gson = GsonBuilder().create()
                val books = gson.fromJson(body, Book::class.java)
                //println(books)

                runOnUiThread{
                   Recycler.adapter = MainAdapter(books)
                    Log.d("StartingAdapter", "Adapter is started now")
                }
            }

        })
    }
}

// Model classes here
@Parcelize
class Book(val bookList: List<BookListJson>):Parcelable

@Parcelize
class BookListJson(var name: String, var author: String, var imageUrl: String):Parcelable



