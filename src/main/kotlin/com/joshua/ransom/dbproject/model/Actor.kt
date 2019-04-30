package com.joshua.ransom.dbproject.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Actor")
data class Actor(

        @Max(40)
        @Column(name = "ActorName", nullable = false, length = 40)
        val actorName: String = "",

        @Column(name = "ActorDOB", nullable = false, columnDefinition = "DATE")
        val actorDateOfBirth: Date? = null,

        @Column(name = "ActorGender", length = 1, nullable = false, columnDefinition = "character(1)")
        val actorGender: Char = 'M',

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ActorId", length = 8, columnDefinition = "integer")
        val actorId: Long = 0) {

    @OneToMany(mappedBy = "actorId")
    private val actsIn: Set<ActsIn> = emptySet()
}