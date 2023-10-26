package com.spcreations.tutorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spcreations.tutorsapp.databinding.ActivityLoginBinding
import com.spcreations.tutorsapp.databinding.ActivityManageBatchesBinding
import com.spcreations.tutorsapp.databinding.ActivityManageStudentsBinding

class ManageStudentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManageStudentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}