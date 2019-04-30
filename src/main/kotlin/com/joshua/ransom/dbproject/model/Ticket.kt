package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "Ticket")
data class Ticket(
        @Id
        @Column(name = "TicketId", columnDefinition = "CHAR")
        val ticketId: Long = 0,

        @OneToOne
        @JoinColumns(
            JoinColumn(name="ScreenId", referencedColumnName="screenId"),
            JoinColumn(name="TheaterId", referencedColumnName="theaterId"),
            JoinColumn(name="StartTime", referencedColumnName="startTime")
        )
        val test: PlayingInScreen,

        @ManyToOne
        @JoinColumn(name = "StaffId")
        val staffId: Staff,

        @Column(name = "Price", nullable = false, columnDefinition = "NUMERIC")
        val price: Double = 0.0,

        @Id
        @Column(name = "SellingTimeStamp", columnDefinition = "DATE")
        val sellingTimeStamp: Long = 0) : Serializable
