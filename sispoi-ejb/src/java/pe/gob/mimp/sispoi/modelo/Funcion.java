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
@Table(name = "FUNCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findByNidFuncion", query = "SELECT f FROM Funcion f WHERE f.nidFuncion = :nidFuncion"),
    @NamedQuery(name = "Funcion.findByTxtCodigoFuncion", query = "SELECT f FROM Funcion f WHERE f.txtCodigoFuncion = :txtCodigoFuncion"),
    @NamedQuery(name = "Funcion.findByFlgActivo", query = "SELECT f FROM Funcion f WHERE f.flgActivo = :flgActivo"),
    @NamedQuery(name = "Funcion.findByNidUsuario", query = "SELECT f FROM Funcion f WHERE f.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Funcion.findByTxtPc", query = "SELECT f FROM Funcion f WHERE f.txtPc = :txtPc"),
    @NamedQuery(name = "Funcion.findByTxtIp", query = "SELECT f FROM Funcion f WHERE f.txtIp = :txtIp"),
    @NamedQuery(name = "Funcion.findByFecEdicion", query = "SELECT f FROM Funcion f WHERE f.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Funcion.findByTxtFuncion", query = "SELECT f FROM Funcion f WHERE f.txtFuncion = :txtFuncion")})
public class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_FUNCION", sequenceName = "SQ_FUNCION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCION")
    @Column(name = "NID_FUNCION")
    private BigDecimal nidFuncion;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_FUNCION")
    private String txtCodigoFuncion;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Size(max = 20)
    @Column(name = "TXT_PC")
    private String txtPc;
    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_FUNCION")
    private String txtFuncion;
    @JoinColumn(name = "NID_ACTIVIDAD_PRODUCTO", referencedColumnName = "NID_ACTIVIDAD_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ActividadProducto actividadProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcion", fetch = FetchType.LAZY)
    private List<DivisionFuncional> divisionFuncionalList;

    public Funcion() {
    }

    public Funcion(BigDecimal nidFuncion) {
        this.nidFuncion = nidFuncion;
    }

    public Funcion(BigDecimal nidFuncion, BigInteger nidUsuario, String txtFuncion) {
        this.nidFuncion = nidFuncion;
        this.nidUsuario = nidUsuario;
        this.txtFuncion = txtFuncion;
    }

    public BigDecimal getNidFuncion() {
        return nidFuncion;
    }

    public void setNidFuncion(BigDecimal nidFuncion) {
        this.nidFuncion = nidFuncion;
    }

    public String getTxtCodigoFuncion() {
        return txtCodigoFuncion;
    }

    public void setTxtCodigoFuncion(String txtCodigoFuncion) {
        this.txtCodigoFuncion = txtCodigoFuncion;
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

    public String getTxtFuncion() {
        return txtFuncion;
    }

    public void setTxtFuncion(String txtFuncion) {
        this.txtFuncion = txtFuncion;
    }

    public ActividadProducto getActividadProducto() {
        return actividadProducto;
    }

    public void setActividadProducto(ActividadProducto actividadProducto) {
        this.actividadProducto = actividadProducto;
    }

    @XmlTransient
    public List<DivisionFuncional> getDivisionFuncionalList() {
        return divisionFuncionalList;
    }

    public void setDivisionFuncionalList(List<DivisionFuncional> divisionFuncionalList) {
        this.divisionFuncionalList = divisionFuncionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidFuncion != null ? nidFuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.nidFuncion == null && other.nidFuncion != null) || (this.nidFuncion != null && !this.nidFuncion.equals(other.nidFuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Funcion[ nidFuncion=" + nidFuncion + " ]";
    }
    
}
