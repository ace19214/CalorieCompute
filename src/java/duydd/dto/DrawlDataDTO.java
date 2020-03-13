/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duydd.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class DrawlDataDTO implements Serializable{
    private String brand;
    private String title;
    private String category;
    private BigDecimal calories;
    private String unit;
    private String type;
    private BigDecimal fat;
    private BigDecimal carbs;
    private BigDecimal fiber;
    private BigDecimal protein;

    public DrawlDataDTO() {
    }

    public DrawlDataDTO(String brand, String title, String category, BigDecimal calories, String unit, String type, BigDecimal fat, BigDecimal carbs, BigDecimal fiber, BigDecimal protein) {
        this.brand = brand;
        this.title = title;
        this.category = category;
        this.calories = calories;
        this.unit = unit;
        this.type = type;
        this.fat = fat;
        this.carbs = carbs;
        this.fiber = fiber;
        this.protein = protein;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getFat() {
        return fat;
    }

    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    public BigDecimal getCarbs() {
        return carbs;
    }

    public void setCarbs(BigDecimal carbs) {
        this.carbs = carbs;
    }

    public BigDecimal getFiber() {
        return fiber;
    }

    public void setFiber(BigDecimal fiber) {
        this.fiber = fiber;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

   
    
    

   
    
    
    
}
