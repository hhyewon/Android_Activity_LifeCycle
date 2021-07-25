package com.example.rp_week2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rp_week2.databinding.ActivityMainBinding
import com.example.rp_week2.databinding.SignUpBinding


class SignUpActivity :AppCompatActivity() {
    lateinit var binding: SignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= SignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.signupBtn.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("name", binding.id.text.toString())
            intent.putExtra("passwd", binding.pw.text.toString())
            setResult(RESULT_OK,intent)
            finish()

        }



    }
}