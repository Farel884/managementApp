package com.example.managementapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.managementapp.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data dari form saat tombol simpan diklik
        binding.tombolSave.setOnClickListener {
            val mapel = binding.editMapel.text.toString().trim()
            val judulTugas = binding.editJudulTugas.text.toString().trim()
            // Diperbaiki: Mengambil dari editDeskripsi, bukan labelDeskripsi
            val deskripsi = binding.editDeskripsi.text.toString().trim()

            if (mapel.isEmpty() || judulTugas.isEmpty()) {
                Toast.makeText(
                    this, "Mata Pelajaran dan Judul Wajib Diisi",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Berhasil disimpan, Anda bisa menambahkan logika simpan database/SharedPreferences di sini
                Toast.makeText(
                    this, "Tugas '$judulTugas' berhasil disimpan",
                    Toast.LENGTH_SHORT
                ).show()

                // Opsional: Menutup activity setelah berhasil disimpan kembali ke halaman utama
                // finish()
            }
        }
    }
}