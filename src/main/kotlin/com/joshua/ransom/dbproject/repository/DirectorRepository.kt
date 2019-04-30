package com.joshua.ransom.dbproject.repository

import com.joshua.ransom.dbproject.model.Director
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DirectorRepository : CrudRepository<Director, Long> {

    fun findByDirectorName(actorName: String): Iterable<Director>
}