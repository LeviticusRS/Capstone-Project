package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Position")
data class Position(
        @Max(20)
        @Column(name = "PositionName", nullable = false, length = 20)
        val positionName: String = "",

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "PositionId", length = 8, columnDefinition = "integer")
        val positionId: Long = 0) {

    @OneToMany(mappedBy = "positionId")
    private val staffPosition: Set<StaffPosition> = emptySet()

    @OneToMany(mappedBy = "positionId")
    private val staffSalary: Set<StaffSalary> = emptySet()
}