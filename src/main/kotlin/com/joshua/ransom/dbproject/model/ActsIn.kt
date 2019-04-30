package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "ActsIn")
data class ActsIn(
        @Id
        @ManyToOne
        @JoinColumn(name = "ActorId", columnDefinition = "integer")
        val actorId: Actor,

        @Id
        @ManyToOne
        @JoinColumn(name = "MovieId", columnDefinition = "integer")
        val movieId: Movie) : Serializable