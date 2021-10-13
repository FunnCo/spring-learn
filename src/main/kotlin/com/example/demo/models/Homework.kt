package com.example.demo.models

import javax.persistence.*

@Entity
@Table(name="homework")
class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @OneToOne
    var subject: Subject? = null

    var tag: String? = null
    var content: String? = null
    var attachmentsUrl: String? = null
}