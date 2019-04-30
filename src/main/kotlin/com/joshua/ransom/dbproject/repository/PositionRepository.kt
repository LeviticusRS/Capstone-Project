package com.joshua.ransom.dbproject.repository

import com.joshua.ransom.dbproject.model.Position
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PositionRepository : CrudRepository<Position, Long> {

    fun findByPositionName(actorName: String): Iterable<Position>
}