package com.spcreations.tutorsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.spcreations.tutorsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel:TutorViewModel by viewModels{
        TutorViewModelFactory((application as TutorApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginBtn = binding.btnLogin
        val signUp = binding.tvSignup
        loginBtn.setOnClickListener {
            val email = binding.etEmailInput.text.toString()
            val password = binding.etPwdInput.text.toString()

            if(email==null || password ==null){

                Toast.makeText(this,"Either email or password is empty. Enter correct values and try again!",Toast.LENGTH_LONG).show()

            }else{

                viewModel.verifyLogin(email,password).observe(this, Observer {
                        result ->
                    Log.i("TAG","result "+result)
                    if (result.equals(0)){
                        Toast.makeText(this,"Email or Password is incorrect. Try again",Toast.LENGTH_LONG).show()
                    }else{
                        val intent= Intent(this,MainDashboardActivity::class.java)
                        startActivity(intent)
                    }
                })

            }



            signUp.setOnClickListener {
                val intent = Intent(this,RegistrationActivity::class.java)
                startActivity(intent)
            }





            }
        }
    }
