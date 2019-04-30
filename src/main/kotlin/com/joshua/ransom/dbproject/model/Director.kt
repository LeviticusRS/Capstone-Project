package com.joshua.ransom.dbproject.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Director")
data class Director(

        @Max(40)
        @Column(name = "DirectorName", nullable = false, length = 40)
        val directorName: String = "",

        @Column(name = "DirectorDOB", columnDefinition = "DATE")
        val directorDateOfBirth: Date? = null,

        @Column(name = "DirectorGender", length = 1, nullable = false, columnDefinition = "character(1)")
        val directorGender: Char = 'M',

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "DirectorId", length = 8, columnDefinition = "integer")
        val directorId: Long = 0) {

    @OneToMany(mappedBy = "directorId")
    private val directs: Set<Directs> = emptySet()
}