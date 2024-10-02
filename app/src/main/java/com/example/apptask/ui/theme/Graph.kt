package com.example.applaunchwork.ui.theme

import android.content.Context
import com.example.apptask.ui.theme.database.AppDatabase

object Graph {
     lateinit var db: AppDatabase
        private set

    fun provide(context:Context){
        db= AppDatabase.getDatabase(context)!!

    }

}