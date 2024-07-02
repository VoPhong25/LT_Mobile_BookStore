package com.example.bookstore;

public class Products {

    private int id;
    private int image;
    private String name;
    private double price;
    private String author; // Đã thay đổi từ brand thành author
    private int pieces;
    private String description;
    private double discount;
    private float rating;
    private int quantity;

    public Products(int image, String name, double price, String author, int pieces, String description, double discount, float rating) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.author = author;
        this.pieces = pieces;
        this.description = description;
        this.discount = discount;
        this.rating = rating;
    }

    public Products(int id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Products(int id, int image, String name, double price, float rating) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Products(int image, String name, double price, double discount, float rating) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.rating = rating;
    }

    public Products(int id, int image, String name, double price, String author, int pieces, String description, double discount) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.author = author;
        this.pieces = pieces;
        this.description = description;
        this.discount = discount;
    }

    public Products(int id, int image, String name, double price, String author, float rating, int quantity) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.author = author;
        this.rating = rating;
        this.quantity = quantity;
    }

    public Products(int image, String name, double price, String author, float rating, int quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.author = author;
        this.rating = rating;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products(int image, String name, double price, String author, int pieces, String description, double discount) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.author = author;
        this.pieces = pieces;
        this.description = description;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
