package com.example.demo.models.requested

import com.example.demo.models.Teacher
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

class RequestedSubject {
    var id: Int = 0
    var name: String? = null
    var teacher_id: Int? = null
}