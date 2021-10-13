package com.example.demo.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="subjects")
class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var name: String? = null

    @ManyToOne
    @JoinColumn(name="teacher_id")
    var teacher: Teacher? = null
}