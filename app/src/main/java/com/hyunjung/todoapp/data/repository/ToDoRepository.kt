package com.hyunjung.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.hyunjung.todoapp.data.ToDoDao
import com.hyunjung.todoapp.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDao.insertData(toDoData)
    }
}