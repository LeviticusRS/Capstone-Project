package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Directs")
data class Directs(
        @Id
        @ManyToOne
        @JoinColumn(name = "DirectorId", columnDefinition = "CHAR")
        val directorId: Director,

        @Id
        @ManyToOne
        @JoinColumn(name = "MovieId", columnDefinition = "CHAR")
        val movieId: Movie) : Serializable