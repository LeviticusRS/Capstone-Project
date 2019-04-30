package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Director
import com.joshua.ransom.dbproject.repository.DirectorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.Date
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/director")
class DirectorController {

    @Autowired
    lateinit var directorRepository: DirectorRepository

    @GetMapping("/save")
    private final fun deploy(): String {
        var timestamp = SimpleDateFormat("dd-MM-yyyy").parse("07-01-1996").time
        directorRepository.save(Director("Director Joshua", Date(timestamp), 'M'))
        timestamp = SimpleDateFormat("dd-MM-yyyy").parse("04-05-1990").time
        directorRepository.save(Director("Director Zion", Date(timestamp), 'F'))
        return "Done - Directors"
    }

    @RequestMapping("/findAllDirectors")
    fun findAll(): Iterable<Director> = directorRepository.findAll()

    @RequestMapping("/deleteDirectorById/{id}")
    fun deleteDirectorById(@PathVariable id: Long) = directorRepository.deleteById(id)

    @RequestMapping("/findByDirectorName/{directorName}")
    fun findByDirectorName(@PathVariable directorName: String) = directorRepository.findByDirectorName(directorName)

    @RequestMapping("/new", method = [RequestMethod.POST])
    fun createDirector(@RequestParam(value = "directorName") directorName: String,
                    @RequestParam(value = "directorGender") directorGender: String,
                    @RequestParam(value = "directorDateOfBirth") directorDateOfBirth: String) : String {
        val timestamp = SimpleDateFormat("dd-MM-yyyy").parse(directorDateOfBirth).time
        val newDirector = Director(
                directorName = directorName,
                directorGender = when(directorGender) {
                    "M" -> { 'M'}
                    "F" -> { 'F'}
                    else -> 'M'
                },
                directorDateOfBirth = Date(timestamp)
        )
        directorRepository.save(newDirector)

        return "/"
    }
}