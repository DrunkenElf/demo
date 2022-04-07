package com.example.demo.entities;

import java.util.List;

public class StackResp {
    private List<QuestionLink> questions_list;

    public StackResp(List<QuestionLink> questions_list) {
        this.questions_list = questions_list;
    }

    public List<QuestionLink> getQuestions_list() {
        return questions_list;
    }

    public void setQuestions_list(List<QuestionLink> questions_list) {
        this.questions_list = questions_list;
    }
}

