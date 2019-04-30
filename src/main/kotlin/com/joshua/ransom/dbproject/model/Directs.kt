package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Directs")
data class Directs(
        @Id
        @ManyToOne
        @JoinColumn(name = "DirectorId", columnDefinition = "integer")
        val directorId: Director,

        @Id
        @ManyToOne
        @JoinColumn(name = "MovieId", columnDefinition = "integer")
        val movieId: Movie) : Serializable