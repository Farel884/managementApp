package com.example.managementapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val mapel: String,
    val judulTugas: String,
    val deskripsi: String,
    val estTime: Int = 0
)
