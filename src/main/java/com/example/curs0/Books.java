package com.example.curs0;

public class Books {
    String namebook;
    String topic;
    String author;
    Integer quantity;

    public Books(String namebook, String topic, String author, Integer quantity){
        this.namebook = namebook;
        this.topic = topic;
        this.author = author;
        this.quantity = quantity;
    }
    public String getNamebook() {
        return namebook;
    }

    public String getTopic() {
        return topic;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}