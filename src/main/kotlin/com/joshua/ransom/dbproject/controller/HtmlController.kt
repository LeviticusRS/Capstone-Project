package com.joshua.ransom.dbproject.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun index(model: Model): String {
        model["asseturl"] = "http://localhost:8080"
        return "index"
    }

}