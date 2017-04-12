

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author klash
 */
@Entity
@Table(name = "MANUFACTURERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manufacturer.findAll", query = "SELECT m FROM Manufacturer m")
    , @NamedQuery(name = "Manufacturer.findByManId", query = "SELECT m FROM Manufacturer m WHERE m.manId = :manId")
    , @NamedQuery(name = "Manufacturer.findByManName", query = "SELECT m FROM Manufacturer m WHERE m.manName = :manName")
    , @NamedQuery(name = "Manufacturer.findByLocation", query = "SELECT m FROM Manufacturer m WHERE m.location = :location")})
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAN_ID")
    private Integer manId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MAN_NAME")
    private String manName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LOCATION")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturedBy")
    private Collection<Product> productCollection;

    public Manufacturer() {
    }

    public Manufacturer(Integer manId) {
        this.manId = manId;
    }

    public Manufacturer(Integer manId, String manName, String location) {
        this.manId = manId;
        this.manName = manName;
        this.location = location;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manId != null ? manId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufacturer)) {
            return false;
        }
        Manufacturer other = (Manufacturer) object;
        if ((this.manId == null && other.manId != null) || (this.manId != null && !this.manId.equals(other.manId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Manufacturer[ manId=" + manId + " ]";
    }
    
}
