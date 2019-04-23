package com.joshua.ransom.dbproject.repository

import com.joshua.ransom.dbproject.model.Actor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActorRepository : CrudRepository<Actor, Long> {

    fun findByActorName(actorName: String): Iterable<Actor>
}