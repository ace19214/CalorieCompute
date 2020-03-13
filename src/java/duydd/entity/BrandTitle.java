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
@Table(name = "brand_title", catalog = "Calories_Compute", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandTitle.findAll", query = "SELECT b FROM BrandTitle b")
    , @NamedQuery(name = "BrandTitle.findByBrandTitleId", query = "SELECT b FROM BrandTitle b WHERE b.brandTitleId = :brandTitleId")})
public class BrandTitle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "brand_title_id", nullable = false)
    private Integer brandTitleId;
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    @ManyToOne
    private Brand brandId;
    @JoinColumn(name = "title_id", referencedColumnName = "title_id")
    @ManyToOne
    private Title titleId;

    public BrandTitle() {
    }

    public BrandTitle(Integer brandTitleId) {
        this.brandTitleId = brandTitleId;
    }

    public Integer getBrandTitleId() {
        return brandTitleId;
    }

    public void setBrandTitleId(Integer brandTitleId) {
        this.brandTitleId = brandTitleId;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public Title getTitleId() {
        return titleId;
    }

    public void setTitleId(Title titleId) {
        this.titleId = titleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandTitleId != null ? brandTitleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandTitle)) {
            return false;
        }
        BrandTitle other = (BrandTitle) object;
        if ((this.brandTitleId == null && other.brandTitleId != null) || (this.brandTitleId != null && !this.brandTitleId.equals(other.brandTitleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duydd.entity.BrandTitle[ brandTitleId=" + brandTitleId + " ]";
    }
    
}
