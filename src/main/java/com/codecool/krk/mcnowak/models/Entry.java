package com.codecool.krk.mcnowak.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String content;
    @NotEmpty
    private String name;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Entry() {
    }

    public Entry(String content, String name) {
        this.content = content;
        this.name = name;
        this.date = new Date();
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String formattedDate = dateFormatter.format(this.date);

        return formattedDate;
    }
}
