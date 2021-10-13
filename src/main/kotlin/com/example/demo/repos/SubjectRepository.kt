package com.example.demo.repos

import com.example.demo.models.Subject
import com.example.demo.models.Teacher
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface SubjectRepository : CrudRepository<Subject, Int>{
    @Query("select subjects.id, subjects.name, teachers.id, teachers.firstname, teachers.lastname, teachers.patronymic from teachers where subjects.teacher_id = teachers.id and subjects.id = ?1", nativeQuery = true)
    fun getTeacherBySubjectID(id: Int): List<Teacher>


}