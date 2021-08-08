package com.example.d_bee_6.logic.model;

public class Data {
   private String image;
   private String title;
   private String url;

   public void setImage(String image) {
       this.image = image;
   }

   public String getImage() {
       return this.image;
   }

   public void setTitle(String title) {
       this.title = title;
   }

   public String getTitle() {
       return this.title;
   }

   public void setUrl(String url) {
       this.url = url;
   }

   public String getUrl() {
       return this.url;
   }

    @Override
    public String toString() {
        return "Data{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
