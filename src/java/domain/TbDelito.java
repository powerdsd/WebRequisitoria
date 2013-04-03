/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author u05521
 */
@Entity
@Table(name = "tb_delito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDelito.findAll", query = "SELECT t FROM TbDelito t"),
    @NamedQuery(name = "TbDelito.findByCodDelito", query = "SELECT t FROM TbDelito t WHERE t.codDelito = :codDelito"),
    @NamedQuery(name = "TbDelito.findByDescripcion", query = "SELECT t FROM TbDelito t WHERE t.descripcion = :descripcion")})
public class TbDelito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_delito")
    private String codDelito;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public TbDelito() {
    }

    public TbDelito(String codDelito) {
        this.codDelito = codDelito;
    }

    public String getCodDelito() {
        return codDelito;
    }

    public void setCodDelito(String codDelito) {
        this.codDelito = codDelito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDelito != null ? codDelito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDelito)) {
            return false;
        }
        TbDelito other = (TbDelito) object;
        if ((this.codDelito == null && other.codDelito != null) || (this.codDelito != null && !this.codDelito.equals(other.codDelito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TbDelito[ codDelito=" + codDelito + " ]";
    }
    
}
