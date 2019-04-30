package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Director")
data class Director(

        @Max(40)
        @Column(name = "DirectorName", nullable = false, length = 40)
        val directorName: String = "",

        @Column(name = "DirectorDOB")
        val directorDateOfBirth: Long = 0,

        @Column(name = "DirectorGender", nullable = false, columnDefinition = "CHAR")
        val directorGender: Gender = Gender.M,

        @Id
        @Column(name = "DirectorId", length = 8, columnDefinition = "CHAR")
        val directorId: Long = 0) {

    @OneToMany(mappedBy = "directorId")
    private val directs: Set<Directs> = emptySet()
}