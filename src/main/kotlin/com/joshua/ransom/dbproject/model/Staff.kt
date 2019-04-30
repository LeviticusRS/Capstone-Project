package com.joshua.ransom.dbproject.model

import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "Staff")
data class Staff(

        @Column(name = "StaffName", length = 40)
        val staffName: String = "",

        @Column(name = "StaffStreetAddress", length = 100)
        val staffStreetAddress: String = "",

        @Column(name = "StaffCity", length = 20)
        val staffCity: String = "",

        @Column(name = "StaffState", length = 2)
        val staffState: String = "",

        @Column(name = "StaffZipCode", length = 5)
        val staffZipcode: String = "",

        @Column(name = "StaffPhoneNumber", length = 16)
        val staffPhoneNumber: String = "",

        @Column(name = "StaffEmail", length = 40)
        val staffEmail: String = "",

        @Column(name = "SSN", nullable = false, length = 9)
        val socialSecurityNumber: String = "",

        @Enumerated(EnumType.STRING)
        @Column(name = "Gender", length = 8, columnDefinition = "CHAR")
        val staffGender: Gender = Gender.M,

        @Column(name = "DOB", nullable = false, columnDefinition = "DATE")
        val staffDateOfBirth: Long = 0,

        @Id
        @Column(name = "StaffId", length = 8, columnDefinition = "CHAR")
        val staffId: Int = 0) {

    @OneToMany(mappedBy = "staffId")
    private val ticket: Set<Ticket> = emptySet()

    @OneToMany(mappedBy = "staffId")
    private val staffPosition: Set<StaffPosition> = emptySet()

    @OneToMany(mappedBy = "staffId")
    private val staffSalary: Set<StaffSalary> = emptySet()
}