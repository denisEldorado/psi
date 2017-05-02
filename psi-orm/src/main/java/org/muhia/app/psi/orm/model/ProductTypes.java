package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_PRODUCT_TYPES")
public class ProductTypes {
    private Long id;
    private String name;
    private String description;

    private String prePost;
    private int status;
    private Collection<ProductsMaster> productsMastersCollection;
    private ProductCategory category;

    @Id
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION", length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Basic
    @Column(name = "PRE_POST", length = 50)
    public String getPrePost() {
        return prePost;
    }

    public void setPrePost(String prePost) {
        this.prePost = prePost;
    }

    @Basic
    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductTypes that = (ProductTypes) o;

        return (id != null ? id.equals(that.id) : that.id == null) && (name != null ? name.equals(that.name) : that.name == null) && (description != null ? description.equals(that.description) : that.description == null) && (category != null ? category.equals(that.category) : that.category == null) && (prePost != null ? prePost.equals(that.prePost) : that.prePost == null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (prePost != null ? prePost.hashCode() : 0);

        return result;
    }

    @OneToMany(mappedBy = "productType")
    public Collection<ProductsMaster> getProductsMastersCollection() {
        return productsMastersCollection;
    }

    public void setProductsMastersCollection(Collection<ProductsMaster> cfgProductsMastersById) {
        this.productsMastersCollection = cfgProductsMastersById;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY", referencedColumnName = "ID", nullable = false)
    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory cfgProductCategoryByCategory) {
        this.category = cfgProductCategoryByCategory;
    }
}
