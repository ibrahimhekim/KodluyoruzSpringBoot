package com.ibrahim.springMongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Getter
@Setter
@Document(collection = "tutorials")
//tutorials ın karşılığı olarak javada Tutorial.
public class Tutorial {
    //anotasyon MongoDB ye bu field in id olacağını söyler
    @Id
    private String id;
    private String title;
    private String description;
    private Boolean published;

    public Tutorial(String title, String description, Boolean published){
        this.title = title;
        this.description = description;
        this.published = published;
    }

    //objenin çağrıldığında string olarak nasıl gösterileceğini gerçekleştiren metod
    @Override
    public String toString() {
        return "Tutorial{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
