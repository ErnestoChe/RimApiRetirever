package com.pm.course.controller;


import com.pm.course.domain.CharacterRim;
import com.pm.course.service.CharacterRimService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CharacterController {

    private final CharacterRimService characterRimService;

    public CharacterController(CharacterRimService characterRimService) {
        this.characterRimService = characterRimService;
    }

    @RequestMapping("/all")
    public String allCharacters(
            Model model,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", required = false) int page)
            throws IOException {
        List<CharacterRim> list = new ArrayList<>();
        list = characterRimService.characters(page==0?1:page);
        if(name!=null){
            list = characterRimService.characters(name);
        }
        model.addAttribute("characters", list);
        return "all";
    }



    @RequestMapping("/characterInfo")
    public String getCharacter(Model model, @RequestParam("id") int id) throws IOException {
        CharacterRim character = characterRimService.character(id);
        model.addAttribute("ch", character);
        return "characterInfo";
    }

}
