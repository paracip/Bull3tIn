package com.example.gs.firebaserecycler;

/**
 * Created by GS on 08-04-2017.
 */
public class ModelClass {
    String title,image,desc,node;

    public ModelClass(String image, String title, String desc, String node) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.node = node;
    }

    public ModelClass() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) { this.image = image; }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) { this.desc = desc; }

    public String getNode() {
        return title;
    }
    public void getNode(String node) {
        this.node = node;
    }
}