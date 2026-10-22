package com.example.managementapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.managementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //deklarasikan binding untuk main dashboart kita

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        //mengubah teks agar menjadi dinamis
        binding.tvNamaSiswa.text = "Lionel Nasri (XII RPL 5)"
        binding.tvJumlahTugas.text = "4"
        binding.tvRataNilai.text = "90,0"

        //Aksi ketika klik tombol navigasi ke from tugas
        binding.TombolForm.setOnClickListener {
            val intent = Intent( this,
                AddTaskActivity::class.java)
            startActivity(intent)
        }

        //binding.btnBukaForm.setOnClickListener{

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}