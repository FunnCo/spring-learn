package com.example.demo.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*


@Entity
@Table(name="teachers")
class Teacher(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var firstname: String? = null
    var lastname: String? = null
    var patronymic: String? = null
    var email: String? = null
    var vk: String? = null
}