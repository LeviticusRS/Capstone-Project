package com.joshua.ransom.dbproject.repository

import com.joshua.ransom.dbproject.model.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, Long> {

    fun findByMovieName(movieName: String): Iterable<Movie>
}