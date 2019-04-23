package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Actor")
data class Actor(

        @Max(40)
        @Column(name = "ActorName", nullable = false, length = 40)
        val actorName: String = "",

        @Column(name = "ActorDOB", nullable = false)
        val actorDateOfBirth: Long = 0,

        @Column(name = "ActorGender", nullable = false)
        val actorGender: Char = Gender.MALE.value,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ActorId")
        val actorId: Long = -1)

enum class Gender(val value: Char) {
    MALE('M'),
    FEMALE('F'),
}