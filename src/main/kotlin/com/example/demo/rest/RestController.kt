package com.example.demo.rest

import com.example.demo.models.Schedule
import com.example.demo.models.Subject
import com.example.demo.models.Teacher
import com.example.demo.models.requested.RequestedSchedule
import com.example.demo.models.requested.RequestedSubject
import com.example.demo.models.response.ResponseSchedule
import com.example.demo.repos.ScheduleRepository
import com.example.demo.repos.SubjectRepository
import com.example.demo.repos.TeacherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {


    @GetMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return "Hello world!"
    }

    @Autowired
    lateinit var teacherRepository: TeacherRepository
    @Autowired
    lateinit var subjectRepository: SubjectRepository
    @Autowired
    lateinit var scheduleRepository: ScheduleRepository

    @GetMapping("/teachers/get/all")
    fun getAllTeachers(): Iterable<Teacher> {
        return teacherRepository.findAll()
    }

    @GetMapping("/teachers/get/surname")
    fun getTeacherBySurname(@RequestParam surname: String): List<Teacher> {
        return teacherRepository.findTeacherByLastname(surname)
    }

    @PostMapping("/teachers/add")
    fun addTeacher(@RequestBody teacher: Teacher): Boolean {
        teacherRepository.save(teacher)
        return true
    }

    @PostMapping("/teachers/addmany")
    fun addManyTeachers(@RequestBody teachers: Iterable<Teacher>){
        teacherRepository.saveAll(teachers)
    }

    @GetMapping("/subjects/get/all")
    fun getAllSubjects():Iterable<Subject>{
        return subjectRepository.findAll()
    }

    @PostMapping("/subjects/addmany")
    fun addManySubjects(@RequestBody requestedSubjects: Iterable<RequestedSubject>){
        val subjects = mutableListOf<Subject>()
        requestedSubjects.forEach{
            val subject = Subject()
            subject.teacher = teacherRepository.findById(it.teacher_id!!).get()
            subject.name = it.name
            subjects.add(subject)
        }
        subjectRepository.saveAll(subjects)
    }

    @GetMapping("/schedule/get/all")
    fun getAllSchedule():Iterable<Schedule>{
        return scheduleRepository.findAll()
    }


    //TODO: Сделать нормальнвй перевод из Schedule в ResponseSchedule
    @GetMapping("/schedule/get/day")
    fun getDaySchedule(
        @RequestParam(name="is_odd") isOdd: Int,
        @RequestParam(name="day") day: Int
    ):Iterable<ResponseSchedule>{
        return scheduleRepository.getScheduleByIsOddAndDay(isOdd, day)
    }

    @GetMapping("/schedule/get/week")
    fun getDaySchedule(
        @RequestParam(name="is_odd") isOdd: Int,
    ):Iterable<ResponseSchedule>{
        return scheduleRepository.getScheduleByIsOdd(isOdd)
    }

    @PostMapping("/schedule/addmany")
    fun addManySchedules(@RequestBody requestedSchedules: Iterable<RequestedSchedule>){
        val schedules = mutableListOf<Schedule>()
        requestedSchedules.forEach {
            val schedule = Schedule()
            schedule.subject = subjectRepository.findById(it.subject_id!!).get()
            schedule.day = it.day
            schedule.isOdd = it.isOdd
            schedule.room = it.room
            schedule.number_of_lesson = it.number_of_lesson
            schedules.add(schedule)
        }
        scheduleRepository.saveAll(schedules)
    }
}