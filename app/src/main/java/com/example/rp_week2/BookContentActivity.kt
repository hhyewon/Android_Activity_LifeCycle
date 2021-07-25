package com.example.rp_week2

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rp_week2.databinding.BookContentBinding


lateinit var binding: BookContentBinding

class BookContentActivity : AppCompatActivity() {
    var i: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BookContentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.bookAf.visibility=View.INVISIBLE
//        binding.bookBe.visibility=View.INVISIBLE

        //Activity가 최초 생성 되었다면 savedInstanceState는 null이다.
        //Activity가 재생성되어 onCreate()가 다시 호출 되었다면 savedInstanceState는 null이 아니다.
//        if(savedInstanceState != null){
//            bookpage = savedInstanceState.get
//        }

        val editor = getSharedPreferences("bookpage",0).edit()


        binding.bookAf.setOnClickListener {  //버튼 눌러 페이지 넘기기 (앞 페이지로)
            if (i == 0) {
                binding.bookPage1.visibility = View.VISIBLE
                binding.bookPage2.visibility = View.INVISIBLE
                binding.bookPage3.visibility = View.INVISIBLE
                i = 1
            } else if (i == 1) {

                binding.bookPage1.visibility = View.INVISIBLE
                binding.bookPage2.visibility = View.VISIBLE
                binding.bookPage3.visibility = View.INVISIBLE
                i=2
            } else if (i == 2) {
                binding.bookPage1.visibility = View.INVISIBLE
                binding.bookPage2.visibility = View.INVISIBLE
                binding.bookPage3.visibility = View.VISIBLE
                i=2
            }
        }

        binding.bookBe.setOnClickListener { //버튼 눌러 페이지 넘기기 (뒷 페이지로)
            if (i == 0) {
                binding.bookPage1.visibility = View.VISIBLE
                binding.bookPage2.visibility = View.INVISIBLE
                binding.bookPage3.visibility = View.INVISIBLE
            } else if (i == 1) {
                binding.bookPage1.visibility = View.INVISIBLE
                binding.bookPage2.visibility = View.VISIBLE
                binding.bookPage3.visibility = View.INVISIBLE
                i=0
            } else if (i == 2) {
                binding.bookPage1.visibility = View.INVISIBLE
                binding.bookPage2.visibility = View.INVISIBLE
                binding.bookPage3.visibility = View.VISIBLE
                i=1
            }
        }



        Toast.makeText(this,"Book-onCreate", Toast.LENGTH_SHORT).show()
    }


    override fun onStart() {
        super.onStart()
//        Toast.makeText(this,"Book-onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this,"Book-onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this,"Book-onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
//        Toast.makeText(this,"Book-onStop", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
//        Toast.makeText(this,"Book-onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
//        Toast.makeText(this,"Book-onDestroy", Toast.LENGTH_SHORT).show()
    }




    override fun onWindowFocusChanged(hasFocus: Boolean) { //소프트바 없애기
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        }
    }
}