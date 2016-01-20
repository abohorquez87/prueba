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
import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "DIRECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d"),
    @NamedQuery(name = "Direccion.findByNidDireccion", query = "SELECT d FROM Direccion d WHERE d.nidDireccion = :nidDireccion"),
    @NamedQuery(name = "Direccion.findByTxtDireccion", query = "SELECT d FROM Direccion d WHERE d.txtDireccion = :txtDireccion"),
    @NamedQuery(name = "Direccion.findByFlgActivo", query = "SELECT d FROM Direccion d WHERE d.flgActivo = :flgActivo"),
    @NamedQuery(name = "Direccion.findByNidUsuario", query = "SELECT d FROM Direccion d WHERE d.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Direccion.findByTxtPc", query = "SELECT d FROM Direccion d WHERE d.txtPc = :txtPc"),
    @NamedQuery(name = "Direccion.findByTxtIp", query = "SELECT d FROM Direccion d WHERE d.txtIp = :txtIp"),
    @NamedQuery(name = "Direccion.findByFecEdicion", query = "SELECT d FROM Direccion d WHERE d.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Direccion.findByTxtCodigoDireccion", query = "SELECT d FROM Direccion d WHERE d.txtCodigoDireccion = :txtCodigoDireccion"),
    @NamedQuery(name = "Direccion.findByNidDireccionGeneral", query = "SELECT d FROM Direccion d WHERE d.nidDireccionGeneral = :nidDireccionGeneral")})
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_DIRECCION", sequenceName = "SQ_DIRECCION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIRECCION")
    @Column(name = "NID_DIRECCION")
    private BigDecimal nidDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_DIRECCION")
    private String txtDireccion;
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
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_DIRECCION")
    private String txtCodigoDireccion;
    @Column(name = "NID_DIRECCION_GENERAL")
    private BigInteger nidDireccionGeneral;
    @JoinColumn(name = "NID_UNIDAD_ORGANICA", referencedColumnName = "NID_UNIDAD_ORGANICA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadOrganica unidadOrganica;

    public Direccion() {
    }

    public Direccion(BigDecimal nidDireccion) {
        this.nidDireccion = nidDireccion;
    }

    public Direccion(BigDecimal nidDireccion, String txtDireccion, BigInteger nidUsuario) {
        this.nidDireccion = nidDireccion;
        this.txtDireccion = txtDireccion;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidDireccion() {
        return nidDireccion;
    }

    public void setNidDireccion(BigDecimal nidDireccion) {
        this.nidDireccion = nidDireccion;
    }

    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
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

    public String getTxtCodigoDireccion() {
        return txtCodigoDireccion;
    }

    public void setTxtCodigoDireccion(String txtCodigoDireccion) {
        this.txtCodigoDireccion = txtCodigoDireccion;
    }

    public BigInteger getNidDireccionGeneral() {
        return nidDireccionGeneral;
    }

    public void setNidDireccionGeneral(BigInteger nidDireccionGeneral) {
        this.nidDireccionGeneral = nidDireccionGeneral;
    }

    public UnidadOrganica getUnidadOrganica() {
        return unidadOrganica;
    }

    public void setUnidadOrganica(UnidadOrganica unidadOrganica) {
        this.unidadOrganica = unidadOrganica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDireccion != null ? nidDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.nidDireccion == null && other.nidDireccion != null) || (this.nidDireccion != null && !this.nidDireccion.equals(other.nidDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Direccion[ nidDireccion=" + nidDireccion + " ]";
    }
    
}
