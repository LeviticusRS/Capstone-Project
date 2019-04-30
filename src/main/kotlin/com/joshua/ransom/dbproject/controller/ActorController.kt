package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Actor
import com.joshua.ransom.dbproject.model.Gender
import com.joshua.ransom.dbproject.repository.ActorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/api/actor")
class ActorController {

    @Autowired
    lateinit var actorRepository: ActorRepository

    @GetMapping("/save")
    private final fun deploy(): String {
        var timestamp = SimpleDateFormat("dd-MM-yyyy").parse("07-01-1996").time / 1000
        actorRepository.save(Actor("Joshua Ransom", timestamp, Gender.M, 0))
        timestamp = SimpleDateFormat("dd-MM-yyyy").parse("04-05-1990").time / 1000
        actorRepository.save(Actor("Zion Williamson", timestamp, Gender.F, 1))
        return "Done - Actors"
    }

    @RequestMapping("/findAllActors")
    fun findAll(): Iterable<Actor> = actorRepository.findAll()

    @RequestMapping("/deleteActorById/{id}")
    fun deleteActorById(@PathVariable id: Long) = actorRepository.deleteById(id)

    @RequestMapping("/findByActorName/{actorName}")
    fun findByActorName(@PathVariable actorName: String) = actorRepository.findByActorName(actorName)

}