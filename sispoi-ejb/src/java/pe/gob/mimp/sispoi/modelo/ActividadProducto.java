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
@Table(name = "ACTIVIDAD_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadProducto.findAll", query = "SELECT a FROM ActividadProducto a"),
    @NamedQuery(name = "ActividadProducto.findByNidActividadProducto", query = "SELECT a FROM ActividadProducto a WHERE a.nidActividadProducto = :nidActividadProducto"),
    @NamedQuery(name = "ActividadProducto.findByTxtActividadProducto", query = "SELECT a FROM ActividadProducto a WHERE a.txtActividadProducto = :txtActividadProducto"),
    @NamedQuery(name = "ActividadProducto.findByTxtCodigoActividadProducto", query = "SELECT a FROM ActividadProducto a WHERE a.txtCodigoActividadProducto = :txtCodigoActividadProducto"),
    @NamedQuery(name = "ActividadProducto.findByFlgActivo", query = "SELECT a FROM ActividadProducto a WHERE a.flgActivo = :flgActivo"),
    @NamedQuery(name = "ActividadProducto.findByNidUsuario", query = "SELECT a FROM ActividadProducto a WHERE a.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "ActividadProducto.findByTxtPc", query = "SELECT a FROM ActividadProducto a WHERE a.txtPc = :txtPc"),
    @NamedQuery(name = "ActividadProducto.findByTxtIp", query = "SELECT a FROM ActividadProducto a WHERE a.txtIp = :txtIp"),
    @NamedQuery(name = "ActividadProducto.findByFecEdicion", query = "SELECT a FROM ActividadProducto a WHERE a.fecEdicion = :fecEdicion")})
public class ActividadProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ACTIVIDAD_PRODUCTO", sequenceName = "SQ_ACTIVIDAD_PRODUCTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACTIVIDAD_PRODUCTO")
    @Column(name = "NID_ACTIVIDAD_PRODUCTO")
    private BigDecimal nidActividadProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "TXT_ACTIVIDAD_PRODUCTO")
    private String txtActividadProducto;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_ACTIVIDAD_PRODUCTO")
    private String txtCodigoActividadProducto;
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
    @JoinColumn(name = "NID_PRODUCTO", referencedColumnName = "NID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadProducto", fetch = FetchType.LAZY)
    private List<Funcion> funcionList;

    public ActividadProducto() {
    }

    public ActividadProducto(BigDecimal nidActividadProducto) {
        this.nidActividadProducto = nidActividadProducto;
    }

    public ActividadProducto(BigDecimal nidActividadProducto, String txtActividadProducto, BigInteger nidUsuario) {
        this.nidActividadProducto = nidActividadProducto;
        this.txtActividadProducto = txtActividadProducto;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidActividadProducto() {
        return nidActividadProducto;
    }

    public void setNidActividadProducto(BigDecimal nidActividadProducto) {
        this.nidActividadProducto = nidActividadProducto;
    }

    public String getTxtActividadProducto() {
        return txtActividadProducto;
    }

    public void setTxtActividadProducto(String txtActividadProducto) {
        this.txtActividadProducto = txtActividadProducto;
    }

    public String getTxtCodigoActividadProducto() {
        return txtCodigoActividadProducto;
    }

    public void setTxtCodigoActividadProducto(String txtCodigoActividadProducto) {
        this.txtCodigoActividadProducto = txtCodigoActividadProducto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public List<Funcion> getFuncionList() {
        return funcionList;
    }

    public void setFuncionList(List<Funcion> funcionList) {
        this.funcionList = funcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidActividadProducto != null ? nidActividadProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadProducto)) {
            return false;
        }
        ActividadProducto other = (ActividadProducto) object;
        if ((this.nidActividadProducto == null && other.nidActividadProducto != null) || (this.nidActividadProducto != null && !this.nidActividadProducto.equals(other.nidActividadProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.ActividadProducto[ nidActividadProducto=" + nidActividadProducto + " ]";
    }
    
}
