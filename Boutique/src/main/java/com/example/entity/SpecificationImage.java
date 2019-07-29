package com.example.entity;

public class SpecificationImage {
     private int specificationImageId;
     private int productId;
     private String  imageURL;
     private String description;
     private int  state;

     public int getSpecificationImageId() {
          return specificationImageId;
     }

     public void setSpecificationImageId(int specificationImageId) {
          this.specificationImageId = specificationImageId;
     }

     public int getProductId() {
          return productId;
     }

     public void setProductId(int productId) {
          this.productId = productId;
     }

     public String getImageURL() {
          return imageURL;
     }

     public void setImageURL(String imageURL) {
          this.imageURL = imageURL;
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
}
