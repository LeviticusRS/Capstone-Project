package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Movie
import com.joshua.ransom.dbproject.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/movie")
class MovieController {

    @Autowired
    lateinit var movieRepository: MovieRepository

    @GetMapping("/save")
    private final fun deploy(): String {
        var timestamp = SimpleDateFormat("dd-MM-yyyy").parse("19-12-1997").time / 1000
        movieRepository.save(Movie("Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", "7.8", timestamp, 194))
        timestamp = SimpleDateFormat("dd-MM-yyyy").parse("26-04-2019").time / 1000
        movieRepository.save(Movie("Avengers: Endgame", "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to undo Thanos' actions and restore order to the universe.", "10.0", timestamp, 182))
        return "Done - Movies"
    }

    @RequestMapping("/findAllMovies")
    fun findAll() = movieRepository.findAll()

    @RequestMapping("/deleteMovieById/{id}")
    fun deleteMovieById(@PathVariable movieId: Long) = movieRepository.deleteById(movieId)

    @RequestMapping("/findByMovieId/{id}")
    fun findByMovieId(@PathVariable movieId: Long) = movieRepository.findById(movieId)

    @RequestMapping("/findByMovieName/{movieName}")
    fun findByMovieName(@PathVariable movieName: String) = movieRepository.findByMovieName(movieName)

}