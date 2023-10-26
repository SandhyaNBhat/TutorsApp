package com.spcreations.tutorsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spcreations.tutorsapp.databinding.ActivityMainDashboardBinding

class MainDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val batchCreation = binding.btnBatchCreation
        val studentRegistration = binding.btnStudentCreation
        val manageBatches = binding.btnViewBatches
        val manageStudents = binding.btnViewStudent
        val manageClasses = binding.btnManageClass
        val manageCalendar = binding.btnManageCalender

        batchCreation.setOnClickListener {
            val intent = Intent(this, BatchCreationActivity::class.java)
            startActivity(intent)
        }

        studentRegistration.setOnClickListener {
            val intent = Intent(this, StudentRegistrationActivity::class.java)
            startActivity(intent)
        }
        manageBatches.setOnClickListener {
            val intent = Intent(this, ManageBatchesActivity::class.java)
            startActivity(intent)
        }
        manageStudents.setOnClickListener {
            val intent = Intent(this, ManageStudentsActivity::class.java)
            startActivity(intent)
        }
        manageClasses.setOnClickListener {
            val intent = Intent(this, MainDashboardActivity::class.java)
            startActivity(intent)
        }
    }
}