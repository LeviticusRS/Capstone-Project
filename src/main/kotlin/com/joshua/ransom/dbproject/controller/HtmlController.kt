package com.joshua.ransom.dbproject.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun index(model: Model): String {
        model["asseturl"] = "http://localhost"
        return "index"
    }

    @GetMapping("/movies")
    fun movies(model: Model): String {
        return "movies"
    }

    @GetMapping("/actors")
    fun actors(model: Model): String {
        return "actors"
    }

    @GetMapping("/directors")
    fun directors(model: Model): String {
        return "directors"
    }

    @GetMapping("/staff")
    fun staff(model: Model): String {
        return "staff"
    }

    @GetMapping("/position")
    fun position(model: Model): String {
        return "position"
    }

}