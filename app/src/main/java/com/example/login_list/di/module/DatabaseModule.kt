package com.example.login_list.di.module

import android.content.Context
import androidx.room.Room
import com.example.login_list.database.LoginListAppDatabase
import com.example.login_list.database.ProjectDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LoginListAppDatabase {
        return Room.databaseBuilder(
            context,
            LoginListAppDatabase::class.java,
            "loginlist.db"
        ).build()
    }

    @Provides
    fun provideProjectDao(db: LoginListAppDatabase): ProjectDao {
        return  db.projectDao()
    }
}