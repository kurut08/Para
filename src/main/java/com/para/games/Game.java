package com.para.games;

public class Game {
    private int id;
    private String title;
    private double price;
    private String descriton;
    private Integer year;

    public Game() {
    }
    public Game(int id, String title, double price, String descriton, Integer year) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.descriton = descriton;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescriton() {
        return descriton;
    }

    public void setDescriton(String descriton) {
        this.descriton = descriton;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
