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
@Table(name = "DISTRITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
    @NamedQuery(name = "Distrito.findByNidDistrito", query = "SELECT d FROM Distrito d WHERE d.nidDistrito = :nidDistrito"),
    @NamedQuery(name = "Distrito.findByCidDistrito", query = "SELECT d FROM Distrito d WHERE d.cidDistrito = :cidDistrito"),
    @NamedQuery(name = "Distrito.findByTxtDistrito", query = "SELECT d FROM Distrito d WHERE d.txtDistrito = :txtDistrito"),
    @NamedQuery(name = "Distrito.findByFlgActivo", query = "SELECT d FROM Distrito d WHERE d.flgActivo = :flgActivo"),
    @NamedQuery(name = "Distrito.findByNidUsuario", query = "SELECT d FROM Distrito d WHERE d.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Distrito.findByTxtPc", query = "SELECT d FROM Distrito d WHERE d.txtPc = :txtPc"),
    @NamedQuery(name = "Distrito.findByTxtIp", query = "SELECT d FROM Distrito d WHERE d.txtIp = :txtIp"),
    @NamedQuery(name = "Distrito.findByFecEdicion", query = "SELECT d FROM Distrito d WHERE d.fecEdicion = :fecEdicion")})
public class Distrito implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_DISTRITO", sequenceName = "SQ_DISTRITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DISTRITO")
    @Column(name = "NID_DISTRITO")
    private BigDecimal nidDistrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CID_DISTRITO")
    private String cidDistrito;
    @Size(max = 512)
    @Column(name = "TXT_DISTRITO")
    private String txtDistrito;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
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
    @JoinColumn(name = "NID_PROVINCIA", referencedColumnName = "NID_PROVINCIA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Provincia provincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distrito", fetch = FetchType.LAZY)
    private List<ZonaInfluencia> zonaInfluenciaList;

    public Distrito() {
    }

    public Distrito(BigDecimal nidDistrito) {
        this.nidDistrito = nidDistrito;
    }

    public Distrito(BigDecimal nidDistrito, String cidDistrito) {
        this.nidDistrito = nidDistrito;
        this.cidDistrito = cidDistrito;
    }

    public BigDecimal getNidDistrito() {
        return nidDistrito;
    }

    public void setNidDistrito(BigDecimal nidDistrito) {
        this.nidDistrito = nidDistrito;
    }

    public String getCidDistrito() {
        return cidDistrito;
    }

    public void setCidDistrito(String cidDistrito) {
        this.cidDistrito = cidDistrito;
    }

    public String getTxtDistrito() {
        return txtDistrito;
    }

    public void setTxtDistrito(String txtDistrito) {
        this.txtDistrito = txtDistrito;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<ZonaInfluencia> getZonaInfluenciaList() {
        return zonaInfluenciaList;
    }

    public void setZonaInfluenciaList(List<ZonaInfluencia> zonaInfluenciaList) {
        this.zonaInfluenciaList = zonaInfluenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDistrito != null ? nidDistrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.nidDistrito == null && other.nidDistrito != null) || (this.nidDistrito != null && !this.nidDistrito.equals(other.nidDistrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Distrito[ nidDistrito=" + nidDistrito + " ]";
    }
    
}
