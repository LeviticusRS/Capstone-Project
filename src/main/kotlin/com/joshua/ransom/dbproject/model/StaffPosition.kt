package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "StaffPosition")
data class StaffPosition(
        @Id
        @ManyToOne
        @JoinColumn(name = "StaffId", columnDefinition = "CHAR")
        val staffId: Staff,

        @Id
        @ManyToOne
        @JoinColumn(name = "PositionId", columnDefinition = "CHAR")
        val positionId: Position,

        @Id
        @ManyToOne
        @JoinColumn(name = "TheaterId", columnDefinition = "CHAR")
        val theaterId: Theater,

        @Id
        @Column(name = "StartingDate", columnDefinition = "DATE")
        val startingDate: Long = 0,

        @Column(name = "EndingDate", columnDefinition = "DATE")
        val endingDate: Long = 0) : Serializable