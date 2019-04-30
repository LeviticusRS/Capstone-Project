package com.joshua.ransom.dbproject.controller

import com.joshua.ransom.dbproject.model.Position
import com.joshua.ransom.dbproject.repository.PositionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/position")
class PositionController {

    @Autowired
    lateinit var positionRepository: PositionRepository

    @GetMapping("/save")
    private final fun deploy(): String {
        positionRepository.save(Position("Marketing Manager"))
        positionRepository.save(Position("CEO"))
        return "Done - Position"
    }

    @RequestMapping("/findAllPositions")
    fun findAll(): Iterable<Position> = positionRepository.findAll()

    @RequestMapping("/deletePositionById/{id}")
    fun deleteActorById(@PathVariable id: Long) = positionRepository.deleteById(id)

    @RequestMapping("/findByPositionName/{positionName}")
    fun findByActorName(@PathVariable positionName: String) = positionRepository.findByPositionName(positionName)

    @RequestMapping("/new", method = [RequestMethod.POST])
    fun createPosition(@RequestParam(value = "positionName") positionName: String) : String {
        val newPosition = Position(
                positionName = positionName
        )
        positionRepository.save(newPosition)

        return "/"
    }
}