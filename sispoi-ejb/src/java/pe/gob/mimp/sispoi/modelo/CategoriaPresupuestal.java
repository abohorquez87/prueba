/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "CATEGORIA_PRESUPUESTAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaPresupuestal.findAll", query = "SELECT c FROM CategoriaPresupuestal c"),
    @NamedQuery(name = "CategoriaPresupuestal.findByNidCategoriaPresupuestal", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.nidCategoriaPresupuestal = :nidCategoriaPresupuestal"),
    @NamedQuery(name = "CategoriaPresupuestal.findByTxtCodCategoriaPresupuestal", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.txtCodCategoriaPresupuestal = :txtCodCategoriaPresupuestal"),
    @NamedQuery(name = "CategoriaPresupuestal.findByTxtCategoriaPresupuestal", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.txtCategoriaPresupuestal = :txtCategoriaPresupuestal"),
    @NamedQuery(name = "CategoriaPresupuestal.findByFlgActivo", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.flgActivo = :flgActivo"),
    @NamedQuery(name = "CategoriaPresupuestal.findByNidUsuario", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "CategoriaPresupuestal.findByTxtPc", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.txtPc = :txtPc"),
    @NamedQuery(name = "CategoriaPresupuestal.findByTxtIp", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.txtIp = :txtIp"),
    @NamedQuery(name = "CategoriaPresupuestal.findByFecEdicion", query = "SELECT c FROM CategoriaPresupuestal c WHERE c.fecEdicion = :fecEdicion")})
public class CategoriaPresupuestal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_CATEGORIA_PRESUPUESTAL", sequenceName = "SQ_CATEGORIA_PRESUPUESTAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA_PRESUPUESTAL")
    @Column(name = "NID_CATEGORIA_PRESUPUESTAL")
    private BigDecimal nidCategoriaPresupuestal;
    @Size(max = 10)
    @Column(name = "TXT_COD_CATEGORIA_PRESUPUESTAL")
    private String txtCodCategoriaPresupuestal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "TXT_CATEGORIA_PRESUPUESTAL")
    private String txtCategoriaPresupuestal;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaPresupuestal", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public CategoriaPresupuestal() {
    }

    public CategoriaPresupuestal(BigDecimal nidCategoriaPresupuestal) {
        this.nidCategoriaPresupuestal = nidCategoriaPresupuestal;
    }

    public CategoriaPresupuestal(BigDecimal nidCategoriaPresupuestal, String txtCategoriaPresupuestal, BigInteger nidUsuario) {
        this.nidCategoriaPresupuestal = nidCategoriaPresupuestal;
        this.txtCategoriaPresupuestal = txtCategoriaPresupuestal;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidCategoriaPresupuestal() {
        return nidCategoriaPresupuestal;
    }

    public void setNidCategoriaPresupuestal(BigDecimal nidCategoriaPresupuestal) {
        this.nidCategoriaPresupuestal = nidCategoriaPresupuestal;
    }

    public String getTxtCodCategoriaPresupuestal() {
        return txtCodCategoriaPresupuestal;
    }

    public void setTxtCodCategoriaPresupuestal(String txtCodCategoriaPresupuestal) {
        this.txtCodCategoriaPresupuestal = txtCodCategoriaPresupuestal;
    }

    public String getTxtCategoriaPresupuestal() {
        return txtCategoriaPresupuestal;
    }

    public void setTxtCategoriaPresupuestal(String txtCategoriaPresupuestal) {
        this.txtCategoriaPresupuestal = txtCategoriaPresupuestal;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public String getTxtPc() {
        return txtPc;
    }

    public void setTxtPc(String txtPc) {
        this.txtPc = txtPc;
    }

    public String getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(String txtIp) {
        this.txtIp = txtIp;
    }

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidCategoriaPresupuestal != null ? nidCategoriaPresupuestal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPresupuestal)) {
            return false;
        }
        CategoriaPresupuestal other = (CategoriaPresupuestal) object;
        if ((this.nidCategoriaPresupuestal == null && other.nidCategoriaPresupuestal != null) || (this.nidCategoriaPresupuestal != null && !this.nidCategoriaPresupuestal.equals(other.nidCategoriaPresupuestal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.CategoriaPresupuestal[ nidCategoriaPresupuestal=" + nidCategoriaPresupuestal + " ]";
    }
    
}
