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
import javax.persistence.ManyToMany;
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
@Table(name = "MEDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medio.findAll", query = "SELECT m FROM Medio m"),
    @NamedQuery(name = "Medio.findByNidMedio", query = "SELECT m FROM Medio m WHERE m.nidMedio = :nidMedio"),
    @NamedQuery(name = "Medio.findByTxtMedio", query = "SELECT m FROM Medio m WHERE m.txtMedio = :txtMedio"),
    @NamedQuery(name = "Medio.findByFlgActivo", query = "SELECT m FROM Medio m WHERE m.flgActivo = :flgActivo"),
    @NamedQuery(name = "Medio.findByNidUsuario", query = "SELECT m FROM Medio m WHERE m.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Medio.findByTxtPc", query = "SELECT m FROM Medio m WHERE m.txtPc = :txtPc"),
    @NamedQuery(name = "Medio.findByTxtIp", query = "SELECT m FROM Medio m WHERE m.txtIp = :txtIp"),
    @NamedQuery(name = "Medio.findByFecEdicion", query = "SELECT m FROM Medio m WHERE m.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Medio.findByTxtCodigoMedio", query = "SELECT m FROM Medio m WHERE m.txtCodigoMedio = :txtCodigoMedio")})
public class Medio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_MEDIO", sequenceName = "SQ_MEDIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MEDIO")
    @Column(name = "NID_MEDIO")
    private BigDecimal nidMedio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_MEDIO")
    private String txtMedio;
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
    @Column(name = "TXT_CODIGO_MEDIO")
    private String txtCodigoMedio;
    @ManyToMany(mappedBy = "medioList", fetch = FetchType.LAZY)
    private List<ActividadProgramada> actividadProgramadaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medio", fetch = FetchType.LAZY)
    private List<Verificacion> verificacionList;

    public Medio() {
    }

    public Medio(BigDecimal nidMedio) {
        this.nidMedio = nidMedio;
    }

    public Medio(BigDecimal nidMedio, String txtMedio, BigInteger nidUsuario) {
        this.nidMedio = nidMedio;
        this.txtMedio = txtMedio;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidMedio() {
        return nidMedio;
    }

    public void setNidMedio(BigDecimal nidMedio) {
        this.nidMedio = nidMedio;
    }

    public String getTxtMedio() {
        return txtMedio;
    }

    public void setTxtMedio(String txtMedio) {
        this.txtMedio = txtMedio;
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

    public String getTxtCodigoMedio() {
        return txtCodigoMedio;
    }

    public void setTxtCodigoMedio(String txtCodigoMedio) {
        this.txtCodigoMedio = txtCodigoMedio;
    }

    @XmlTransient
    public List<ActividadProgramada> getActividadProgramadaList() {
        return actividadProgramadaList;
    }

    public void setActividadProgramadaList(List<ActividadProgramada> actividadProgramadaList) {
        this.actividadProgramadaList = actividadProgramadaList;
    }

    @XmlTransient
    public List<Verificacion> getVerificacionList() {
        return verificacionList;
    }

    public void setVerificacionList(List<Verificacion> verificacionList) {
        this.verificacionList = verificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidMedio != null ? nidMedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medio)) {
            return false;
        }
        Medio other = (Medio) object;
        if ((this.nidMedio == null && other.nidMedio != null) || (this.nidMedio != null && !this.nidMedio.equals(other.nidMedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Medio[ nidMedio=" + nidMedio + " ]";
    }
    
}
