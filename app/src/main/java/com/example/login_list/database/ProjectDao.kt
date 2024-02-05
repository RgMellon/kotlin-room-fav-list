package com.example.login_list.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.login_list.data.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Insert(onConflict = REPLACE)
    suspend fun addProject(project: Project)

    @Query ("SELECT * FROM Project")
    fun getAll(): Flow<List<Project>>
}

