package com.example.entity;

public class FocusImage {
	private int f_id;
	private String image;       
    private String description;
    private int state;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "FocusImage{" +
                "f_id=" + f_id +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}