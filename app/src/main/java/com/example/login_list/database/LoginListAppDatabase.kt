package com.example.login_list.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.login_list.data.Project

@Database(entities = [Project::class], version = 1)
abstract class LoginListAppDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}