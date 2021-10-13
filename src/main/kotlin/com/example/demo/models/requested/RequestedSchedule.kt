package com.example.demo.models.requested

import com.example.demo.models.Subject
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

class RequestedSchedule {
    var id: Int = 0
    var subject_id: Int? = null
    var room: String? = null
    var isOdd: Int? = null
    var day: Int? = null
    var number_of_lesson: Int? = null
}