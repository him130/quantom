package com.raysapp.quantom.Model;

public class ProductModel {

    String id;
    String img_url;
    String title;
    String price;
    String defprice;

    public ProductModel(String id, String img_url, String title, String price, String defprice) {
        this.id = id;
        this.img_url = img_url;
        this.title = title;
        this.price = price;
        this.defprice = defprice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDefprice() {
        return defprice;
    }

    public void setDefprice(String defprice) {
        this.defprice = defprice;
    }

}
