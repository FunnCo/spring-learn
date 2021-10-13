package com.example.demo.repos

import com.example.demo.models.Teacher
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface TeacherRepository : CrudRepository<Teacher, Int> {

    fun findTeacherByLastname(surname: String) : List<Teacher>

    @Query("select teachers.id, teachers.lastname, teachers.firstname, teachers.patronymic from teachers", nativeQuery = true)
    fun getAllTeachers() : List<Teacher>


}