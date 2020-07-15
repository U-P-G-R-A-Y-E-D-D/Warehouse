package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Barrel {
    private float height;                           // výška sudu
    private float diameter;                         // průměr sudu
    private String liquid = "Kyselina sírová";      // typ tekutiny
    private float density;                   // hustota
    private int costPerLitre;                 // cena za litr
    private int litres;                             // naplnění sudu

    public Barrel(float height, float diameter) {
        this.height = height;
        this.setDiameter(diameter);
    }

    public float getHeight() {
        return height;
    }

    public float getDiameter() {
        return diameter;
    }

    public String getLiquid() {
        return liquid;
    }

    public float getDensity() {
        return density;
    }

    public int getCostPerLitre() {
        return costPerLitre;
    }

    public int getLitres() {
        return litres;
    }

    public double getCapacity() {
        return new BigDecimal(
                Math.PI*Math.pow(diameter, 2)/4*height*1000)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getSurface() {
        return new BigDecimal(2*Math.PI*Math.pow(diameter/2, 2)+height*Math.PI*diameter).setScale(4,RoundingMode.HALF_UP).doubleValue();
    }

    public boolean isOverMaxCapacity() {
        return litres > getCapacity();
    }

    public double getWeightOfLiquid() {
        return new BigDecimal(density * getCapacity()/1000).setScale(2,RoundingMode.HALF_UP).doubleValue();
    }

    public double levelSurface() {
        return new BigDecimal(litres/(Math.PI*Math.pow(diameter, 2)/4)/1000).setScale(4,RoundingMode.HALF_UP).doubleValue();
    }

    public void fill(int param) throws Exception {
        int newVal = litres + param;
        if (newVal > getCapacity())
            throw new Exception();
    }

    public void letOut(int param) throws Exception {
        int newVal = litres - param;
        if (newVal < 0) {
            throw new Exception();
        }
        litres = newVal;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public void setCostPerLitre(int costPerLitre) {
        this.costPerLitre = costPerLitre;
    }

    public void setLitres(int litres) {
        this.litres = litres;
    }

    @Override
    public String toString() {
        return "Barrel{" + "height=" + height + ", diameter=" + diameter + ", liquid=" + liquid + ", density=" + density + ", costPerLitre=" + costPerLitre + ", litres=" + litres + '}';
    }
}
