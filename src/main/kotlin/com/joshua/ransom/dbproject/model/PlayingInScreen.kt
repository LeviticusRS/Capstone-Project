package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "PlayingInScreen")
data class PlayingInScreen(
        @Id
        @OneToOne
        @JoinColumns(
                JoinColumn(name="ScreenId", referencedColumnName="screenId"),
                JoinColumn(name="TheaterId", referencedColumnName="theaterId")
        )
        val test: Screen,

        @Id
        @Column(name = "StartTime", nullable = false, columnDefinition = "DATE")
        val startTime: Long = 0,

        @ManyToOne
        @JoinColumn(name = "MovieId", columnDefinition = "integer")
        val movieId: Movie): Serializable {

    @OneToMany(mappedBy = "test")
    private val startTimes: Set<Ticket> = emptySet()
}

