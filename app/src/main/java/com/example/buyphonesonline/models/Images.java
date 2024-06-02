package com.example.buyphonesonline.models;

public class Images {
    private Long id;
    private String name;
    private String url;
    Long relation_id;
    String type;

    public Images(Long id, String name, String url, Long relation_id, String type) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.relation_id = relation_id;
        this.type = type;
    }

    public Images(String name, String url, Long relation_id, String type) {
        this.name = name;
        this.url = url;
        this.relation_id = relation_id;
        this.type = type;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String url() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long relation_id() {
        return relation_id;
    }

    public void setRelation_id(Long relation_id) {
        this.relation_id = relation_id;
    }

    public String type() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
