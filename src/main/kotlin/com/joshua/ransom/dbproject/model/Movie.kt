package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Movie")
data class Movie(

        @Column(name = "MovieName", nullable = false, length = 100)
        val movieName: String = "",

        @Column(name = "MovieDescription", nullable = false, length = 1024)
        val movieDescription: String = "",

        @Column(name = "MovieRating", nullable = false, length = 5)
        val movieRating: String = "",

        @Column(name = "MovieReleaseDate", nullable = false, columnDefinition = "DATE")
        val movieReleaseDate: Long = 0,

        @Column(name = "MovieLength", nullable = false, columnDefinition = "NUMERIC")
        val movieLength: Int = 0,

        @Id
        @Column(name = "MovieId", length = 8, columnDefinition = "CHAR")
        val movieId: Long = 0) {

    @OneToMany(mappedBy = "movieId")
    private val actsIn: Set<ActsIn> = emptySet()

    @OneToMany(mappedBy = "movieId")
    private val directs: Set<Directs> = emptySet()

    @OneToMany(mappedBy = "movieId")
    private val playingInScreen: Set<PlayingInScreen> = emptySet()
}