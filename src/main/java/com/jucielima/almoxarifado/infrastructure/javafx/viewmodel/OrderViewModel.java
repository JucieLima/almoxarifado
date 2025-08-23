package com.jucielima.almoxarifado.infrastructure.javafx.viewmodel;

import javafx.beans.property.*;

import java.time.LocalDateTime;

public class OrderViewModel {
    StringProperty material = new SimpleStringProperty();
    StringProperty category = new SimpleStringProperty();
    StringProperty author = new SimpleStringProperty();
    StringProperty staus = new SimpleStringProperty();
    IntegerProperty amount = new SimpleIntegerProperty();
    ObjectProperty<LocalDateTime> date = new SimpleObjectProperty<>();

    public String getMaterial() {
        return material.get();
    }

    public StringProperty materialProperty() {
        return material;
    }

    public void setMaterial(String material) {
        this.material.set(material);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getStaus() {
        return staus.get();
    }

    public StringProperty stausProperty() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus.set(staus);
    }

    public int getAmount() {
        return amount.get();
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public LocalDateTime getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDateTime> dateProperty() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date.set(date);
    }
}
