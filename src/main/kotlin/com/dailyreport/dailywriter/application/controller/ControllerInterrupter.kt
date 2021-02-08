package com.dailyreport.dailywriter.application.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class ControllerInterrupter {
    @ModelAttribute
    fun setAuthenticatedUser(model: Model) {
        //TODO: not implemented
    }
}
