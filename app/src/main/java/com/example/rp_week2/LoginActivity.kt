package com.example.rp_week2

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rp_week2.databinding.DialogLoginBinding
import com.example.rp_week2.databinding.LoginBinding

class LoginActivity : AppCompatActivity(), MyCustomDialogInterface{

    private lateinit var binding: LoginBinding
    private lateinit var binding2: DialogLoginBinding
//    private lateinit var binding2: DialogLoginBinding

    //[화면 레이아웃 정의, 뷰 생성, 데이터 바인딩] // 최초 실행 시에만 해야할 작업
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        binding2 = DialogLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.loginBtn.setOnClickListener {
//            val editor: SharedPreferences.Editor = appData.edit()
//            editor.putString("id",binding.idEt.text.toString().trim())
//            editor.putString("pwd",binding.passwordEt.text.toString().trim())
//            editor.apply()
////        }
//        binding.idEt.text=intent.getStringExtra("name")
//        binding.passwordEt.text=intent.getStringExtra("passwd")

//        restoreState()




        val dialogActivity = DialogActivity(this,this)


        val idSize=binding.idEt.text.toString()!!.length
        val pwdSize=binding.passwordEt.text.toString()!!.length



        binding.loginBtn.setOnClickListener {

                intent = Intent(this, DialogActivity::class.java)

            if (idSize!! <10){
                binding2.textView3.text="아이디를 10글자 이하로 입력해주세요"
                Log.d(this.toString(), binding2.textView3.text.toString())
                intent.putExtra("msg",binding2.textView3.text.toString())
                intent.putExtra("len",idSize.toString())
                dialogActivity.show()

            }
//            if(pwdSize!! <10){
//                binding2.textView3.text="비밀번호를 10글자 이하로 입력해주세요"
//                dialogActivity.show()
//            }

            if(binding.idEt.text.toString().length==0){
//                binding2.textView3.text="아이디를 10글자 이하로 입력해주세요"
//                dialogActivity.show()
            }else if(binding.passwordEt.text.toString().length==0) {
//                binding2.textView3.text="아이디를 10글자 이하로 입력해주세요"
//                dialogActivity.show()
            }else{
                val pref = getSharedPreferences("session",0)
                val editor=pref.edit()
                var intent = Intent(this, MainActivity::class.java)
                Log.d(this.toString(),binding.idEt.text.toString())
                Log.d(this.toString(),binding.passwordEt.text.toString())
                editor.putString("name", binding.idEt.text.toString())
                editor.putString("pwd", binding.passwordEt.text.toString())
                editor.commit()

                intent.putExtra("name", binding.idEt.text.toString())
                startActivity(intent)
                finish()
        }

        }



//        Toast.makeText(this, "Login-onCreate", Toast.LENGTH_SHORT).show()
    }


    private fun showMessageDialog(){
        val customDialog = CustomDialog(finishApp = {finish()})
        customDialog.show(supportFragmentManager, "CustomDialog")
    }

    private fun onClick() {
        var dialog = Intent(this, DialogActivity::class.java)
        startActivity(dialog)
    }

    override fun onYes() {

    }


    //[화면에 진입할 때마다 실행되어야 하는 코드] id와 pw가 입력되있으면(사용자라면) 바로 다음 페이지로
    override fun onStart() {
        super.onStart()
//        Toast.makeText(this, "Login-onStart", Toast.LENGTH_SHORT).show()
        val pref = this.getSharedPreferences("session",0)
//        val editor=pref.edit()

        binding.idEt.setText(pref?.getString("name",null))
        binding.passwordEt.setText(pref?.getString("pwd",null))
        Log.d(this.toString(),binding.idEt.text.toString())
        Log.d(this.toString(),binding.passwordEt.text.toString())
        if(binding.idEt.text.length != 0 && binding.passwordEt.text.length != 0){
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", binding.idEt.text.toString())
            startActivity(intent)
            finish()
        }

    }

    //[일시정지 되었다가 돌아오는 경우, 재개되었을 때 실행해야 할 코드]
    override fun onResume() {
        super.onResume()
//        Toast.makeText(this, "Login-onResume", Toast.LENGTH_SHORT).show()
//
        restoreState()
//
//        binding.idEt.setText("")
//        binding.passwordEt.setText("")

//        val pref = getSharedPreferences("session",0)
//        val editor=pref.edit()
////
////        pref.getString("name", binding.idEt.text.toString())
////        pref.getString("pwd", binding.passwordEt.text.toString())
//        binding.idEt.setText(pref?.getString("name",""))
//        binding.passwordEt.setText(pref?.getString("pwd",""))
    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this, "Login-onPause", Toast.LENGTH_SHORT).show()


        /*
        액티비티 사이의 이동이 있을 경우 //만약 로그아웃을 했다하면
        onPause(A) - onCreate(B) - onStart(B) - onResume(B) - onStop(A) 의 순서로 실행된다.
        아이디와 비밀번호를 입력한 후 버튼을 눌러 다음 액티비티로 넘어간다.
        다음 액티비티로 넘어갈 때 보안을 위해 아이디와 비밀번호를 초기화 해준다.
       */
//        binding.idEt.setText("")
//        binding.passwordEt.setText("")  //X

//
        saveState()


    }

    override fun onStop() {
        super.onStop()
//        Toast.makeText(this, "Login-onStop", Toast.LENGTH_SHORT).show()
//
//        val pref = this.getSharedPreferences("session",0)
//        val editor: SharedPreferences.Editor = pref.edit()
//        binding.idEt.setText(pref?.getString("name",""))
//        binding.passwordEt.setText(pref?.getString("pwd",""))


//        val pref = this.getSharedPreferences("session",0)
//        val editor=pref.edit()
//        val pref = this.getSharedPreferences("session",0)
//        val editor=pref.edit()
//        editor?.putString("name",binding.idEt.text.toString())
//        editor?.putString("pwd",binding.passwordEt.text.toString())

//        val pref = this.getSharedPreferences("session",0)
////        val editor=pref.edit()
//
//        binding.idEt.setText(pref?.getString("name",null))
//        binding.passwordEt.setText(pref?.getString("pwd",null))

//
        saveState()
    }

    override fun onRestart() {
        super.onRestart()
//        Toast.makeText(this, "Login-onRestart", Toast.LENGTH_SHORT).show()


    }

    override fun onDestroy() {
        super.onDestroy()
//        Toast.makeText(this, "Login-onDestroy", Toast.LENGTH_SHORT).show()
//
//        binding.idEt.text=null
//        binding.passwordEt.text=null
//        val prefs: SharedPreferences = getSharedPreferences("session",Activity.MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = prefs.edit()
//        editor.putString("id",binding.idEt.text.toString())
//        editor.putString("pwd",binding.passwordEt.text.toString())
//        editor.commit()

//        saveState()
//
//        val pref = getSharedPreferences("session",0)
//        val editor=pref.edit()
//        editor.putString("name", binding.idEt.text.toString())
//        editor.putString("pwd", binding.passwordEt.text.toString())
//        editor.commit()


        val pref = getSharedPreferences("sessions",0)
        val editor=pref.edit()
//        editor?.remove("nae")?.commit()
        editor?.remove("pw")?.commit()
    }

    protected fun saveState() {
        val prefs= getSharedPreferences("sessions",Activity.MODE_PRIVATE)
        val editor=prefs.edit()
        editor.putString("nae", binding.idEt.text.toString())
        editor.putString("pw", binding.passwordEt.text.toString())
        editor.apply()
    }

    protected fun restoreState() {

        val prefs=getSharedPreferences("sessions",Activity.MODE_PRIVATE)

        binding.idEt.setText(prefs.getString("nae",""))
        binding.passwordEt.setText(prefs.getString("pw",""))
    //        if ((prefs != null) && (prefs.contains("name")) && (prefs.contains("passwd"))) {
//
//            prefs.getString("name", binding.idEt.text.toString())
//            prefs.getString("passwd", binding.passwordEt.text.toString())
//
//
//        }
    }


    //화면 전환에 따라 layout을 다르게 바꿔주고 싶다면 사용하기

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        if (resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
//        // landscape recycler_view.layoutManager = glManager // grid layout }
//        // else {
//        // portrait recycler_view.layoutManager = llManager // linear layout }
//        // }
//        }


            override fun onWindowFocusChanged(hasFocus: Boolean) { //소프트바 없애기
                super.onWindowFocusChanged(hasFocus)
                if (hasFocus) {
                    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

                }
            }
        }