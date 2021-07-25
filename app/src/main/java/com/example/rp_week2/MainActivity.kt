package com.example.rp_week2

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rp_week2.databinding.ActivityMainBinding
import com.example.rp_week2.databinding.LoginBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)



        binding.userNameTv.text=intent.getStringExtra("name")

        binding.book2Name.setOnClickListener {
            var buyUri = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=30364394"))
            startActivity(buyUri)
        }

        binding.topMenu.setOnClickListener{
            var logout = Intent(this,LoginActivity::class.java)
            val pref = this.getSharedPreferences("session",0)
            val editor=pref?.edit()
            editor?.remove("name")?.commit()
            editor?.remove("pwd")?.commit()
            startActivity(logout)
        }

        binding.book2.setOnClickListener {
            var bookContent = Intent(this, BookContentActivity::class.java)
            startActivity(bookContent)
        }


//        Toast.makeText(this,"Main-onCreate", Toast.LENGTH_SHORT).show()
    }



    override fun onStart() {
        super.onStart()
//        Toast.makeText(this,"Main-onStart", Toast.LENGTH_SHORT).show()

//        pref?.getString("name",null)
//        pref?.getString("pwd",null)

//
//        val pref = this.getSharedPreferences("session",0)
//        val editor=pref?.edit()
//        editor?.remove("id")?.commit()
//        editor?.remove("pw")?.commit()
    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this,"Main-onResume", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this,"Main-onPause", Toast.LENGTH_SHORT).show()
//        val pref = this.getSharedPreferences("session",0)
//        val editor=pref?.edit()
//        editor?.remove("name")?.commit()
//        editor?.remove("pwd")?.commit()

    }

    override fun onStop() {
        super.onStop()
//        Toast.makeText(this,"Main-onStop", Toast.LENGTH_SHORT).show()

//
//        editor?.putString("name",binding2.idEt.text.toString())
//        editor?.putString("pwd",binding2.passwordEt.text.toString())

//        editor?.remove("name")?.commit()
//        editor?.remove("pwd")?.commit()
    }

    override fun onRestart() {
        super.onRestart()
//        Toast.makeText(this,"Main-onRestart", Toast.LENGTH_SHORT).show()
//        val pref = this.getSharedPreferences("session",0)
//        val editor=pref?.edit()
//        editor?.remove("name")?.commit()
//        editor?.remove("pwd")?.commit()

//    binding.topMenu.setBackgroundColor(Color.YELLOW)


    }

    override fun onDestroy() {
        super.onDestroy()
//        Toast.makeText(this,"Main-onDestroy", Toast.LENGTH_SHORT).show()
//
//        val pref = this.getSharedPreferences("session",0)
//        val editor=pref?.edit()
//
//        editor?.remove("name")?.commit()
//        editor?.remove("pwd")?.commit()
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {//소프트바 없애기
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        }
    }



}