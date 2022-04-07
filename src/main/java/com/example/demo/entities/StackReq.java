package com.example.demo.entities;

public class StackReq {
    private final String topic;
    private final Long page;
    private final Long size;


    public StackReq(String topic, Long page, Long size) {
        this.topic = topic;
        this.page = page == null ? 0 : page;
        this.size = size == null ? 20 : size;
    }

    public String getTopic() {
        return topic;
    }

    public Long getPage() {
        return page;
    }

    public Long getSize() {
        return size;
    }
}
