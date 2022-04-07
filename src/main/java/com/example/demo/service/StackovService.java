package com.example.demo.service;


import com.example.demo.entities.QuestionLink;
import com.example.demo.entities.StackReq;
import com.example.demo.entities.StackResp;
import org.jsoup.Jsoup;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class StackovService {
    private static final String template
            = "https://api.stackexchange.com/2.3/questions?page=%1$s&pagesize=%2$s&" +
            "&sort=activity&tagged=%3$s&site=stackoverflow";

    public StackResp getQuestions(StackReq req){
        String link = String.format(template, req.getPage(), req.getSize(), req.getTopic());
        List<QuestionLink> questions = new LinkedList<>();
        try {
            String data = Jsoup.connect(link).ignoreContentType(true).ignoreHttpErrors(true)
                    .get().body().text();
            JSONObject obj = new JSONObject(data);
            JSONArray arr = obj.getJSONArray("items");
            for (int i=0; i < arr.length(); i++) {
                questions.add(new QuestionLink(arr.getJSONObject(i).getString("link")));
            }
            return new StackResp(questions);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}