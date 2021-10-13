package com.example.demo.repos

import com.example.demo.models.Schedule
import com.example.demo.models.response.ResponseSchedule
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ScheduleRepository : CrudRepository<Schedule, Int> {

    @Query(
        "select schedules.day, subjects.name, concat(teachers.firstname + ' ' + teachers.lastname + ' ' +teachers.patronymic) as 'teacher_name', schedules.room, schedules.number_of_lesson " +
                "from subjects, teachers, schedules " +
                "where subjects.teacher_id = teachers.id and schedules.subject_id = subjects.id and schedules.is_odd = ?1 " +
                "order by  schedules.day,schedules.number_of_lesson", nativeQuery = true
    )
    fun getScheduleByIsOdd(isOdd: Int): Iterable<ResponseSchedule>


    @Query(
        "select schedules.day, subjects.name, concat(teachers.firstname + ' ' + teachers.lastname + ' ' +teachers.patronymic) as 'teacher_name', schedules.room, schedules.number_of_lesson " +
                "from subjects, teachers, schedules " +
                "where subjects.teacher_id = teachers.id and schedules.subject_id = subjects.id and schedules.is_odd = ?1 and schedules.day = ?2" +
                "order by  schedules.day,schedules.number_of_lesson", nativeQuery = true
    )
    fun getScheduleByIsOddAndDay(isOdd: Int, day: Int): Iterable<ResponseSchedule>
}