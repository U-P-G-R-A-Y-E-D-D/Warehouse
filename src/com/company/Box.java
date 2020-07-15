package com.company;

public class Box {
    private float height;                           // výška bedny
    private float depth;                            // hloubka bedny
    private float width;                            // šířka bedny
    private String description = "Dynamit";                     // popis
    private int quantity = 10;                           // počet kusů
    private int weightKg;                             // váha
    private int maxQuantity = 15;
    private double price = 300.90;


    public Box(float height, float depth, float width) {
        this.height = height;
        this.depth = depth;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCapacity() {
        return width*height*depth;
    }

    public double getSurface() {
        return 2*(width*height + width*depth + depth*height);
    }

    /*public boolean isOverMaxCapacity() {
        return getCapacity > getCapacity();
    }*/

    @Override
    public String toString() {
        return "Box{" + "Výška=" + height + ", Šířka=" + width + ", Hloubka=" + depth + ", Obsah=" + description + ", Počet kusů=" + maxQuantity + ", Váha 1 ks=" + weightKg + ", Cena jednoho kusu=" + price +'}';
    }


}

