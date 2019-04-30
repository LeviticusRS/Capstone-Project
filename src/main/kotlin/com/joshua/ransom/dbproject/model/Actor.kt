package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Actor")
data class Actor(

        @Max(40)
        @Column(name = "ActorName", nullable = false, length = 40)
        val actorName: String = "",

        @Column(name = "ActorDOB", nullable = false, columnDefinition = "DATE")
        val actorDateOfBirth: Long = 0,

        @Column(name = "ActorGender", nullable = false, columnDefinition = "CHAR")
        val actorGender: Gender = Gender.M,

        @Id
        @Column(name = "ActorId", length = 8, columnDefinition = "CHAR")
        val actorId: Long = 0) {

    @OneToMany(mappedBy = "actorId")
    private val actsIn: Set<ActsIn> = emptySet()
}

enum class Gender {
    M,
    F,
}