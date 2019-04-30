package com.joshua.ransom.dbproject.repository

import com.joshua.ransom.dbproject.model.Staff
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StaffRepository : CrudRepository<Staff, Long> {

    fun findByStaffName(actorName: String): Iterable<Staff>
}