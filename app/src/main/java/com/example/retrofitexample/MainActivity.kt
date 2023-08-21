package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quote=RetrofitHelper.getInstance().create(QuotesApi::class.java)

        GlobalScope.launch(Dispatchers.IO){
            val result=quote.getQuotes(1)
            if(result!=null){
                val quote=result.body()
                if(quote!=null){
                    quote.results.forEach{
                        Log.v("Retrofit",it.content)
                    }
                }
            }

        }


    }
}