package com.example.applicationmydog.ui.main;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "DOG")
public class Dog implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private Integer id;
    @ColumnInfo(name = "NAME")
    private String name = "";
    @ColumnInfo(name = "IMAGE")
    private String image = "";
    @ColumnInfo(name = "DESCRIPTION")
    private String description = "";
    @ColumnInfo(name = "GENDER")
    private String gender = "";
    @ColumnInfo(name = "TYPE")
    private String type ="";
    @ColumnInfo(name = "AGE")
    private Integer age = 0;
    @ColumnInfo(name = "WEIGHT")
    private Integer weight = 0;
    @ColumnInfo(name = "POSTED_BY")
    private String postedBy = "";

    @Ignore
    public Dog() {
    }

    public Dog(String name, String image, String description, String gender, String type, Integer age, Integer weight, String postedBy) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.gender = gender;
        this.type = type;
        this.age = age;
        this.weight = weight;
        this.postedBy = postedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String  image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + image +
                ", description='" + description + '\'' +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", postedBy='" + postedBy + '\'' +
                '}';
    }
}
