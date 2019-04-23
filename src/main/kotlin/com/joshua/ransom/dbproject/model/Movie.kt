package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Movie")
data class Movie(

        @Max(100)
        @Column(name = "MovieName", nullable = false, length = 100)
        val movieName: String = "",

        @Max(1024)
        @Column(name = "MovieDescription", nullable = false, length = 1024)
        val movieDescription: String = "",

        @Max(5)
        @Column(name = "MovieRating", nullable = false, length = 5)
        val movieRating: String = "",

        @Column(name = "MovieReleaseDate", nullable = false)
        val movieReleaseDate: Long = 0,

        @Column(name = "MovieLength", nullable = false)
        val movieLength: Int = 0,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "MovieId")
        val movieId: Long = -1)