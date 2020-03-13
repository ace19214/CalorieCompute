/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duydd.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "title", catalog = "Calories_Compute", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Title.findAll", query = "SELECT t FROM Title t")
    , @NamedQuery(name = "Title.findByTitleId", query = "SELECT t FROM Title t WHERE t.titleId = :titleId")
    , @NamedQuery(name = "Title.findByTitleName", query = "SELECT t FROM Title t WHERE t.titleName = :titleName")})
public class Title implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "title_id", nullable = false)
    private Integer titleId;
    @Column(name = "title_name", length = 100)
    private String titleName;
    @OneToMany(mappedBy = "titleId")
    private Collection<Categories> categoriesCollection;
    @OneToMany(mappedBy = "titleId")
    private Collection<BrandTitle> brandTitleCollection;

    public Title() {
    }

    public Title(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @XmlTransient
    public Collection<Categories> getCategoriesCollection() {
        return categoriesCollection;
    }

    public void setCategoriesCollection(Collection<Categories> categoriesCollection) {
        this.categoriesCollection = categoriesCollection;
    }

    @XmlTransient
    public Collection<BrandTitle> getBrandTitleCollection() {
        return brandTitleCollection;
    }

    public void setBrandTitleCollection(Collection<BrandTitle> brandTitleCollection) {
        this.brandTitleCollection = brandTitleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titleId != null ? titleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Title)) {
            return false;
        }
        Title other = (Title) object;
        if ((this.titleId == null && other.titleId != null) || (this.titleId != null && !this.titleId.equals(other.titleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duydd.entity.Title[ titleId=" + titleId + " ]";
    }
    
}
