package com.example.managementapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.managementapp.data.AppDatabase
import com.example.managementapp.data.TaskEntity
import com.example.managementapp.databinding.ActivityAddTaskBinding
import kotlinx.coroutines.launch

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
            val deskripsi = binding.editDeskripsi.text.toString().trim()

            if (mapel.isEmpty() || judulTugas.isEmpty()) {
                Toast.makeText(
                    this, "Mata Pelajaran dan Judul Wajib Diisi",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val newTask = TaskEntity(
                    mapel = mapel,
                    judulTugas = judulTugas,
                    deskripsi = deskripsi
                )

                lifecycleScope.launch {
                    val db = AppDatabase.getDatabase(applicationContext)
                    db.taskDao().insertTask(newTask)

                    Toast.makeText(
                        this@AddTaskActivity,
                        "Tugas '$judulTugas' berhasil disimpan",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()
                }
            }
        }
    }
}
