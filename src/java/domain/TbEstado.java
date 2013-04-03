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
@Table(name = "tb_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEstado.findAll", query = "SELECT t FROM TbEstado t"),
    @NamedQuery(name = "TbEstado.findByCodEstado", query = "SELECT t FROM TbEstado t WHERE t.codEstado = :codEstado"),
    @NamedQuery(name = "TbEstado.findByDescripcion", query = "SELECT t FROM TbEstado t WHERE t.descripcion = :descripcion")})
public class TbEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_estado")
    private String codEstado;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public TbEstado() {
    }

    public TbEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
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
        hash += (codEstado != null ? codEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstado)) {
            return false;
        }
        TbEstado other = (TbEstado) object;
        if ((this.codEstado == null && other.codEstado != null) || (this.codEstado != null && !this.codEstado.equals(other.codEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TbEstado[ codEstado=" + codEstado + " ]";
    }
    
}
