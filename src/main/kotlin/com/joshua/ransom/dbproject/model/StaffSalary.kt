package com.joshua.ransom.dbproject.model

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.Min

@Entity
@Table(name = "StaffSalary")
data class StaffSalary(
        @Id
        @ManyToOne
        @JoinColumn(name = "StaffId", columnDefinition = "integer")
        val staffId: Staff,

        @Id
        @ManyToOne
        @JoinColumn(name = "PositionId", columnDefinition = "integer")
        val positionId: Position,

        @Min(1)
        @Column(name = "Salary", nullable = false, columnDefinition = "NUMERIC")
        val salary: Double = 1.0,

        @Id
        @Column(name = "EffectiveDate", nullable = false, columnDefinition = "DATE")
        val endingDate: Long = 0) : Serializable