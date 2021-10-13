package com.example.demo.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="schedules")
class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="subject_id")
    var subject: Subject? = null

    var room: String? = null
    var isOdd: Int? = null
    var day: Int? = null
    var number_of_lesson: Int? = null
}