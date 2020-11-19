package com.pm.course.service;


import com.pm.course.domain.CharacterRim;

import java.io.IOException;
import java.util.List;

public interface CharacterRimService {

    CharacterRim character(int id) throws IOException;

    List<CharacterRim> characters(String name) throws IOException;
}
