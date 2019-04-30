package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Theater")
data class Theater(

        @Max(40)
        @Column(name = "TheaterName", nullable = false, length = 40)
        val theaterName: String = "",

        @Max(100)
        @Column(name = "StreetAddress", nullable = false, length = 100)
        val streetAddress: String = "",

        @Max(40)
        @Column(name = "City", nullable = false, length = 40)
        val city: String = "",

        @Max(2)
        @Column(name = "State", nullable = false, length = 2)
        val state: String = "",

        @Max(5)
        @Column(name = "ZipCode", nullable = false, length = 5)
        val zipcode: String = "",

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "TheaterId", columnDefinition = "integer")
        val movieId: Long = 0) {

    @OneToMany(mappedBy = "theaterId")
    private val staffPosition: Set<StaffPosition> = emptySet()

}