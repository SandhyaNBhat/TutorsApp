package com.spcreations.tutorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spcreations.tutorsapp.databinding.ActivityLoginBinding
import com.spcreations.tutorsapp.databinding.ActivityManageBatchesBinding

class ManageBatchesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManageBatchesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBatchesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}