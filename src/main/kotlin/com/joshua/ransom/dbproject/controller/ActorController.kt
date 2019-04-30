package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Actor
import com.joshua.ransom.dbproject.repository.ActorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.Date
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/actor")
class ActorController {

    @Autowired
    lateinit var actorRepository: ActorRepository

    @GetMapping("/save")
    private final fun deploy(): String {
        var timestamp = SimpleDateFormat("dd-MM-yyyy").parse("07-01-1996").time
        actorRepository.save(Actor("Joshua Ransom", Date(timestamp), 'M'))
        timestamp = SimpleDateFormat("dd-MM-yyyy").parse("04-05-1990").time
        actorRepository.save(Actor("Zion Williamson", Date(timestamp), 'F'))
        return "Done - Actors"
    }

    @RequestMapping("/findAllActors")
    fun findAll(): Iterable<Actor> = actorRepository.findAll()

    @RequestMapping("/deleteActorById/{id}")
    fun deleteActorById(@PathVariable id: Long) = actorRepository.deleteById(id)

    @RequestMapping("/findByActorName/{actorName}")
    fun findByActorName(@PathVariable actorName: String) = actorRepository.findByActorName(actorName)

    @RequestMapping("/new", method = [RequestMethod.POST])
    fun createActor(@RequestParam(value = "actorName") actorName: String,
                    @RequestParam(value = "actorDateOfBirth") actorDateOfBirth: String,
                    @RequestParam(value = "actorGender") actorGender: String) : String {
        val timestamp = SimpleDateFormat("dd-MM-yyyy").parse(actorDateOfBirth).time
        val newActor = Actor(
                actorName = actorName,
                actorDateOfBirth = Date(timestamp),
                actorGender = when(actorGender) {
                    "M" -> { 'M'}
                    "F" -> { 'F'}
                    else -> 'M'
                }
        )
        actorRepository.save(newActor)

        return "/"
    }
}