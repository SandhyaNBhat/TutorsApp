package com.spcreations.tutorsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.spcreations.tutorsapp.data.User
import com.spcreations.tutorsapp.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    private val viewModel:TutorViewModel by viewModels{
        TutorViewModelFactory((application as TutorApplication).repository)

    }
    private val TAG ="REGISTRATIONACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val registerBtn= binding.btnRegister
        registerBtn.setOnClickListener {
            //Fetch the values entered in the register screen
            val name = binding.etNameInput.text.toString()
            val email = binding.etEmailInput.text.toString()
            val pwd = binding.etPwdInput.text.toString()
            val confirmpwd = binding.etConfirmpwdInput.text.toString()

            Log.i(TAG,"User name -"+name+" email "+email+" pwd "+pwd)

            if (pwd==confirmpwd) {
                val user = User(0, name, email, pwd)
                Log.i(TAG,"Password matching, proceed to insert user")
                viewModel.insertUser(user)
                Toast.makeText(this,"Congratulations!! You are now registered. Kindly Login",Toast.LENGTH_LONG).show()
            }else{
                Log.i(TAG,"Password not matching, throw message")
                Toast.makeText(this,"Password does not match",Toast.LENGTH_LONG).show()
            }
        }

        val signInBtn = binding.tvSigninMessage
        signInBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}