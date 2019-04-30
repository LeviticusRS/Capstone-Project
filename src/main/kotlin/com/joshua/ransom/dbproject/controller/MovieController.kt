package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Movie
import com.joshua.ransom.dbproject.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.Date
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/movie")
class MovieController {

    @Autowired
    lateinit var movieRepository: MovieRepository

    @GetMapping("/save")
    private final fun deploy(): String {
        var timestamp = SimpleDateFormat("dd-MM-yyyy").parse("19-12-1997").time
        movieRepository.save(Movie("Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", "7.8", Date(timestamp), 194))
        timestamp = SimpleDateFormat("dd-MM-yyyy").parse("26-04-2019").time
        movieRepository.save(Movie("Avengers: Endgame", "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to undo Thanos' actions and restore order to the universe.", "10.0", Date(timestamp), 182))
        return "Done - Movies"
    }

    @RequestMapping("/findAllMovies")
    fun findAll(): Iterable<Movie> = movieRepository.findAll()

    @RequestMapping("/deleteMovieById/{id}")
    fun deleteMovieById(@PathVariable id: Long) = movieRepository.deleteById(id)

    @RequestMapping("/findByMovieId/{id}")
    fun findByMovieId(@PathVariable movieId: Long) = movieRepository.findById(movieId)

    @RequestMapping("/findByMovieName/{movieName}")
    fun findByMovieName(@PathVariable movieName: String) = movieRepository.findByMovieName(movieName)

    @RequestMapping("/new", method = [RequestMethod.POST])
    fun createMovie(@RequestParam(value = "movieName") movieName: String,
                    @RequestParam(value = "movieDescription") movieDescription: String,
                    @RequestParam(value = "movieRating") movieRating: String,
                    @RequestParam(value = "movieLength") movieLength: Int,
                    @RequestParam(value = "movieReleaseDate") movieReleaseDate: String) : String {
        val timestamp = SimpleDateFormat("dd-MM-yyyy").parse(movieReleaseDate).time
        val newMovie = Movie(
                movieName = movieName,
                movieDescription = movieDescription,
                movieRating = movieRating,
                movieReleaseDate = Date(timestamp),
                movieLength = movieLength
        )
        movieRepository.save(newMovie)

        return "/"
    }
}