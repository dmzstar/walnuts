package com.dmzcoding.walnuts.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/login")
class LoginController{

    @GetMapping
    fun index() = "login"

    @PostMapping
    fun login() = "login"

}