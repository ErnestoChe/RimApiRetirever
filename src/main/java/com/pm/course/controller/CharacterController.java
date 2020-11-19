package com.pm.course.controller;


import com.pm.course.domain.CharacterRim;
import com.pm.course.service.CharacterRimService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class CharacterController {

    private final CharacterRimService characterRimService;

    public CharacterController(CharacterRimService characterRimService) {
        this.characterRimService = characterRimService;
    }

    @RequestMapping("/characterInfo")
    public String getCharacter(Model model, @RequestParam("id") int id) throws IOException {
        CharacterRim character = characterRimService.character(id);
        model.addAttribute("ch", character);
        return "characterInfo";
    }

}
