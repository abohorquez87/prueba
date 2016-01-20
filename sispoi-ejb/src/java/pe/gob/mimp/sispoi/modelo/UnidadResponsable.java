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
@Table(name = "UNIDAD_RESPONSABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadResponsable.findAll", query = "SELECT u FROM UnidadResponsable u"),
    @NamedQuery(name = "UnidadResponsable.findByNidUnidadResponsable", query = "SELECT u FROM UnidadResponsable u WHERE u.nidUnidadResponsable = :nidUnidadResponsable"),
    @NamedQuery(name = "UnidadResponsable.findByTxtUnidadResponsable", query = "SELECT u FROM UnidadResponsable u WHERE u.txtUnidadResponsable = :txtUnidadResponsable"),
    @NamedQuery(name = "UnidadResponsable.findByFlgActivo", query = "SELECT u FROM UnidadResponsable u WHERE u.flgActivo = :flgActivo"),
    @NamedQuery(name = "UnidadResponsable.findByNidUsuario", query = "SELECT u FROM UnidadResponsable u WHERE u.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "UnidadResponsable.findByTxtPc", query = "SELECT u FROM UnidadResponsable u WHERE u.txtPc = :txtPc"),
    @NamedQuery(name = "UnidadResponsable.findByTxtIp", query = "SELECT u FROM UnidadResponsable u WHERE u.txtIp = :txtIp"),
    @NamedQuery(name = "UnidadResponsable.findByFecEdicion", query = "SELECT u FROM UnidadResponsable u WHERE u.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "UnidadResponsable.findByTxtCodigoUnidadResponsable", query = "SELECT u FROM UnidadResponsable u WHERE u.txtCodigoUnidadResponsable = :txtCodigoUnidadResponsable")})
public class UnidadResponsable implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_UNIDAD_RESPONSABLE", sequenceName = "SQ_UNIDAD_RESPONSABLE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_UNIDAD_RESPONSABLE")
    @Column(name = "NID_UNIDAD_RESPONSABLE")
    private BigDecimal nidUnidadResponsable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_UNIDAD_RESPONSABLE")
    private String txtUnidadResponsable;
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
    @Column(name = "TXT_CODIGO_UNIDAD_RESPONSABLE")
    private String txtCodigoUnidadResponsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadResponsable", fetch = FetchType.LAZY)
    private List<ActividadProgramada> actividadProgramadaList;

    public UnidadResponsable() {
    }

    public UnidadResponsable(BigDecimal nidUnidadResponsable) {
        this.nidUnidadResponsable = nidUnidadResponsable;
    }

    public UnidadResponsable(BigDecimal nidUnidadResponsable, String txtUnidadResponsable, BigInteger nidUsuario) {
        this.nidUnidadResponsable = nidUnidadResponsable;
        this.txtUnidadResponsable = txtUnidadResponsable;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidUnidadResponsable() {
        return nidUnidadResponsable;
    }

    public void setNidUnidadResponsable(BigDecimal nidUnidadResponsable) {
        this.nidUnidadResponsable = nidUnidadResponsable;
    }

    public String getTxtUnidadResponsable() {
        return txtUnidadResponsable;
    }

    public void setTxtUnidadResponsable(String txtUnidadResponsable) {
        this.txtUnidadResponsable = txtUnidadResponsable;
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

    public String getTxtCodigoUnidadResponsable() {
        return txtCodigoUnidadResponsable;
    }

    public void setTxtCodigoUnidadResponsable(String txtCodigoUnidadResponsable) {
        this.txtCodigoUnidadResponsable = txtCodigoUnidadResponsable;
    }

    @XmlTransient
    public List<ActividadProgramada> getActividadProgramadaList() {
        return actividadProgramadaList;
    }

    public void setActividadProgramadaList(List<ActividadProgramada> actividadProgramadaList) {
        this.actividadProgramadaList = actividadProgramadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidUnidadResponsable != null ? nidUnidadResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadResponsable)) {
            return false;
        }
        UnidadResponsable other = (UnidadResponsable) object;
        if ((this.nidUnidadResponsable == null && other.nidUnidadResponsable != null) || (this.nidUnidadResponsable != null && !this.nidUnidadResponsable.equals(other.nidUnidadResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.UnidadResponsable[ nidUnidadResponsable=" + nidUnidadResponsable + " ]";
    }
    
}
