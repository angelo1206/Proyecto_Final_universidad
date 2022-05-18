package com.unicaldas.room_database

import androidx.room.*

@Dao
interface ToDoDAO {

    @Query("SELECT * from ToDo")
    suspend fun getAllTasks(): List<ToDo>

    @Query("SELECT * From ToDo WHERE id = :id")
    suspend fun findById(id:Int): ToDo

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: ToDo): Long

    @Update
    suspend fun updateTask (task: ToDo)

    @Delete
    suspend fun deleteTask (task: ToDo)


}