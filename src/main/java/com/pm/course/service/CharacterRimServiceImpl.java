package com.pm.course.service;


import com.pm.course.domain.CharacterRim;
import com.pm.course.domain.enums.Status;
import com.pm.course.util.ApiRetriever;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class CharacterRimServiceImpl implements CharacterRimService{

    private final ApiRetriever apiRetriever;

    public CharacterRimServiceImpl(ApiRetriever apiRetriever) {
        this.apiRetriever = apiRetriever;
    }

    @Override
    public CharacterRim character(int id) throws IOException {
        String url = "https://rickandmortyapi.com/api/character/" + String.valueOf(id);
        JSONObject json = apiRetriever.readJsonFromUrl(url);

        CharacterRim toReturn = new CharacterRim(
                json.get("name").toString(),
                json.get("image").toString(),
                json.get("species").toString(),
                Status.valueOf(json.get("status").toString()),
                json.get("gender").toString(),
                json.getJSONObject("location").get("name").toString(),
                Long.valueOf(json.get("id").toString())
        );
        return toReturn;

    }

    @Override
    public List<CharacterRim> characters(String name) throws IOException {
        String url = "https://rickandmortyapi.com/api/character/?name=" + name;
        JSONObject json = apiRetriever.readJsonFromUrl(url);

        JSONArray data = json.getJSONArray("results");
        List<CharacterRim> list = new ArrayList<>();
        System.out.println(data.length());
        for (int i = 0; i < data.length(); i++) {
            list.add(new CharacterRim(data.getJSONObject(i)));
        }
        return list;
    }
}
