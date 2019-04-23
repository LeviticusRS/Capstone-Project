package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Actor
import com.joshua.ransom.dbproject.model.Gender
import com.joshua.ransom.dbproject.repository.ActorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat

@RestController
class ActorController {

    @Autowired
    lateinit var actorRepository: ActorRepository

    private final fun deploy() {
        var timestamp = SimpleDateFormat("dd-MM-yyyy").parse("07-01-1996").time / 1000
        actorRepository.save(Actor("Joshua Ransom", timestamp, Gender.MALE.value))
        timestamp = SimpleDateFormat("dd-MM-yyyy").parse("04-05-1990").time / 1000
        actorRepository.save(Actor("Zion Williamson", timestamp, Gender.FEMALE.value))
    }

    @RequestMapping("/findAllActors")
    fun findAll() = actorRepository.findAll()

    @RequestMapping("findByActorName/{actorName}")
    fun findByActorName(@PathVariable actorName: String) = actorRepository.findByActorName(actorName)

}