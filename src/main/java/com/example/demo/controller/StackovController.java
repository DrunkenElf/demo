package com.example.demo.controller;

import com.example.demo.entities.StackReq;
import com.example.demo.service.StackovService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1.0/stackoverflow")
public class StackovController {
    private final StackovService service = new StackovService();

    @GetMapping("/questions")
    public ResponseEntity getQuestions(
            @RequestParam(value = "topic") String topic,
            @RequestParam(value = "page", required = false, defaultValue = "0") Long page,
            @RequestParam(value = "size", required = false, defaultValue = "20") Long size
            ){

        try{
            return ResponseEntity.ok(service.getQuestions(new StackReq(topic, page, size)));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}

