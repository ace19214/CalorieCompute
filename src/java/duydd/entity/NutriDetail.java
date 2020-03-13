/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duydd.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "nutri_detail", catalog = "Calories_Compute", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NutriDetail.findAll", query = "SELECT n FROM NutriDetail n")
    , @NamedQuery(name = "NutriDetail.findByNutriDetailId", query = "SELECT n FROM NutriDetail n WHERE n.nutriDetailId = :nutriDetailId")
    , @NamedQuery(name = "NutriDetail.findByUnit", query = "SELECT n FROM NutriDetail n WHERE n.unit = :unit")
    , @NamedQuery(name = "NutriDetail.findByCalories", query = "SELECT n FROM NutriDetail n WHERE n.calories = :calories")
    , @NamedQuery(name = "NutriDetail.findByFat", query = "SELECT n FROM NutriDetail n WHERE n.fat = :fat")
    , @NamedQuery(name = "NutriDetail.findByCarbs", query = "SELECT n FROM NutriDetail n WHERE n.carbs = :carbs")
    , @NamedQuery(name = "NutriDetail.findByFiber", query = "SELECT n FROM NutriDetail n WHERE n.fiber = :fiber")
    , @NamedQuery(name = "NutriDetail.findByProtein", query = "SELECT n FROM NutriDetail n WHERE n.protein = :protein")
    , @NamedQuery(name = "NutriDetail.findByType", query = "SELECT n FROM NutriDetail n WHERE n.type = :type")})
public class NutriDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nutri_detail_id", nullable = false)
    private Integer nutriDetailId;
    @Column(name = "unit", length = 200)
    private String unit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calories", precision = 53)
    private Double calories;
    @Column(name = "fat", precision = 53)
    private Double fat;
    @Column(name = "carbs", precision = 53)
    private Double carbs;
    @Column(name = "fiber", precision = 53)
    private Double fiber;
    @Column(name = "protein", precision = 53)
    private Double protein;
    @Column(name = "type", length = 100)
    private String type;
    @JoinColumn(name = "categories_id", referencedColumnName = "category_id")
    @ManyToOne
    private Categories categoriesId;

    public NutriDetail() {
    }

    public NutriDetail(Integer nutriDetailId) {
        this.nutriDetailId = nutriDetailId;
    }

    public Integer getNutriDetailId() {
        return nutriDetailId;
    }

    public void setNutriDetailId(Integer nutriDetailId) {
        this.nutriDetailId = nutriDetailId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Categories getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Categories categoriesId) {
        this.categoriesId = categoriesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nutriDetailId != null ? nutriDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NutriDetail)) {
            return false;
        }
        NutriDetail other = (NutriDetail) object;
        if ((this.nutriDetailId == null && other.nutriDetailId != null) || (this.nutriDetailId != null && !this.nutriDetailId.equals(other.nutriDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duydd.entity.NutriDetail[ nutriDetailId=" + nutriDetailId + " ]";
    }
    
}
