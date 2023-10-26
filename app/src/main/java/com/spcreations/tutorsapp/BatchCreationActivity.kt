package com.spcreations.tutorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spcreations.tutorsapp.databinding.ActivityBatchCreationBinding

class BatchCreationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBatchCreationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBatchCreationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}