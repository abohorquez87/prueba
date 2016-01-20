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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByNidProducto", query = "SELECT p FROM Producto p WHERE p.nidProducto = :nidProducto"),
    @NamedQuery(name = "Producto.findByTxtCodigoProducto", query = "SELECT p FROM Producto p WHERE p.txtCodigoProducto = :txtCodigoProducto"),
    @NamedQuery(name = "Producto.findByTxtProducto", query = "SELECT p FROM Producto p WHERE p.txtProducto = :txtProducto"),
    @NamedQuery(name = "Producto.findByFlgActivo", query = "SELECT p FROM Producto p WHERE p.flgActivo = :flgActivo"),
    @NamedQuery(name = "Producto.findByNidUsuario", query = "SELECT p FROM Producto p WHERE p.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Producto.findByTxtPc", query = "SELECT p FROM Producto p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "Producto.findByTxtIp", query = "SELECT p FROM Producto p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "Producto.findByFecEdicion", query = "SELECT p FROM Producto p WHERE p.fecEdicion = :fecEdicion")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_PRODUCTO", sequenceName = "SQ_PRODUCTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUCTO")
    @Column(name = "NID_PRODUCTO")
    private BigDecimal nidProducto;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_PRODUCTO")
    private String txtCodigoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_PRODUCTO")
    private String txtProducto;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<ActividadProducto> actividadProductoList;
    @JoinColumn(name = "NID_CATEGORIA_PRESUPUESTAL", referencedColumnName = "NID_CATEGORIA_PRESUPUESTAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaPresupuestal categoriaPresupuestal;

    public Producto() {
    }

    public Producto(BigDecimal nidProducto) {
        this.nidProducto = nidProducto;
    }

    public Producto(BigDecimal nidProducto, String txtProducto, BigInteger nidUsuario) {
        this.nidProducto = nidProducto;
        this.txtProducto = txtProducto;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidProducto() {
        return nidProducto;
    }

    public void setNidProducto(BigDecimal nidProducto) {
        this.nidProducto = nidProducto;
    }

    public String getTxtCodigoProducto() {
        return txtCodigoProducto;
    }

    public void setTxtCodigoProducto(String txtCodigoProducto) {
        this.txtCodigoProducto = txtCodigoProducto;
    }

    public String getTxtProducto() {
        return txtProducto;
    }

    public void setTxtProducto(String txtProducto) {
        this.txtProducto = txtProducto;
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
    public List<ActividadProducto> getActividadProductoList() {
        return actividadProductoList;
    }

    public void setActividadProductoList(List<ActividadProducto> actividadProductoList) {
        this.actividadProductoList = actividadProductoList;
    }

    public CategoriaPresupuestal getCategoriaPresupuestal() {
        return categoriaPresupuestal;
    }

    public void setCategoriaPresupuestal(CategoriaPresupuestal categoriaPresupuestal) {
        this.categoriaPresupuestal = categoriaPresupuestal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidProducto != null ? nidProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.nidProducto == null && other.nidProducto != null) || (this.nidProducto != null && !this.nidProducto.equals(other.nidProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Producto[ nidProducto=" + nidProducto + " ]";
    }
    
}
