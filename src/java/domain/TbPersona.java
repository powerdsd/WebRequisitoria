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
import javax.persistence.Lob;
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
@Table(name = "tb_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPersona.findAll", query = "SELECT t FROM TbPersona t"),
    @NamedQuery(name = "TbPersona.findByDniPersona", query = "SELECT t FROM TbPersona t WHERE t.dniPersona = :dniPersona"),
    @NamedQuery(name = "TbPersona.findByApePat", query = "SELECT t FROM TbPersona t WHERE t.apePat = :apePat"),
    @NamedQuery(name = "TbPersona.findByApeMat", query = "SELECT t FROM TbPersona t WHERE t.apeMat = :apeMat"),
    @NamedQuery(name = "TbPersona.findByNombres", query = "SELECT t FROM TbPersona t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TbPersona.findBySexo", query = "SELECT t FROM TbPersona t WHERE t.sexo = :sexo"),
    @NamedQuery(name = "TbPersona.findByEdad", query = "SELECT t FROM TbPersona t WHERE t.edad = :edad"),
    @NamedQuery(name = "TbPersona.findByDireccion", query = "SELECT t FROM TbPersona t WHERE t.direccion = :direccion")})
public class TbPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni_persona")
    private String dniPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ape_pat")
    private String apePat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ape_mat")
    private String apeMat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private char sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Lob
    @Size(max = 65535)
    @Column(name = "foto")
    private String foto;

    public TbPersona() {
    }

    public TbPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public TbPersona(String dniPersona, String apePat, String apeMat, String nombres, char sexo, int edad) {
        this.dniPersona = dniPersona;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.nombres = nombres;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniPersona != null ? dniPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPersona)) {
            return false;
        }
        TbPersona other = (TbPersona) object;
        if ((this.dniPersona == null && other.dniPersona != null) || (this.dniPersona != null && !this.dniPersona.equals(other.dniPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TbPersona[ dniPersona=" + dniPersona + " ]";
    }
    
}
