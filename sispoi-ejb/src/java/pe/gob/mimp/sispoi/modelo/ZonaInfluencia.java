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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "ZONA_INFLUENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaInfluencia.findAll", query = "SELECT z FROM ZonaInfluencia z"),
    @NamedQuery(name = "ZonaInfluencia.findByNidZonaInfluencia", query = "SELECT z FROM ZonaInfluencia z WHERE z.nidZonaInfluencia = :nidZonaInfluencia"),
    @NamedQuery(name = "ZonaInfluencia.findByFlgActivo", query = "SELECT z FROM ZonaInfluencia z WHERE z.flgActivo = :flgActivo"),
    @NamedQuery(name = "ZonaInfluencia.findByNidUsuario", query = "SELECT z FROM ZonaInfluencia z WHERE z.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "ZonaInfluencia.findByTxtPc", query = "SELECT z FROM ZonaInfluencia z WHERE z.txtPc = :txtPc"),
    @NamedQuery(name = "ZonaInfluencia.findByTxtIp", query = "SELECT z FROM ZonaInfluencia z WHERE z.txtIp = :txtIp"),
    @NamedQuery(name = "ZonaInfluencia.findByFecEdicion", query = "SELECT z FROM ZonaInfluencia z WHERE z.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "ZonaInfluencia.findByTxtCodigoZonaInfluencia", query = "SELECT z FROM ZonaInfluencia z WHERE z.txtCodigoZonaInfluencia = :txtCodigoZonaInfluencia"),
    @NamedQuery(name = "ZonaInfluencia.findByTxtZonaInfluencia", query = "SELECT z FROM ZonaInfluencia z WHERE z.txtZonaInfluencia = :txtZonaInfluencia")})
public class ZonaInfluencia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ZONA_INFLUENCIA", sequenceName = "SQ_ZONA_INFLUENCIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ZONA_INFLUENCIA")
    @Column(name = "NID_ZONA_INFLUENCIA")
    private BigDecimal nidZonaInfluencia;
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
    @Column(name = "TXT_CODIGO_ZONA_INFLUENCIA")
    private String txtCodigoZonaInfluencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_ZONA_INFLUENCIA")
    private String txtZonaInfluencia;
    @ManyToMany(mappedBy = "zonaInfluenciaList", fetch = FetchType.LAZY)
    private List<ActividadProgramada> actividadProgramadaList;
    @JoinColumn(name = "NID_ACTIVIDAD_PROGRAMADA", referencedColumnName = "NID_ACTIVIDAD_PROGRAMADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ActividadProgramada actividadProgramada;
    @JoinColumn(name = "NID_DISTRITO", referencedColumnName = "NID_DISTRITO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Distrito distrito;

    public ZonaInfluencia() {
    }

    public ZonaInfluencia(BigDecimal nidZonaInfluencia) {
        this.nidZonaInfluencia = nidZonaInfluencia;
    }

    public ZonaInfluencia(BigDecimal nidZonaInfluencia, BigInteger nidUsuario, String txtZonaInfluencia) {
        this.nidZonaInfluencia = nidZonaInfluencia;
        this.nidUsuario = nidUsuario;
        this.txtZonaInfluencia = txtZonaInfluencia;
    }

    public BigDecimal getNidZonaInfluencia() {
        return nidZonaInfluencia;
    }

    public void setNidZonaInfluencia(BigDecimal nidZonaInfluencia) {
        this.nidZonaInfluencia = nidZonaInfluencia;
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

    public String getTxtCodigoZonaInfluencia() {
        return txtCodigoZonaInfluencia;
    }

    public void setTxtCodigoZonaInfluencia(String txtCodigoZonaInfluencia) {
        this.txtCodigoZonaInfluencia = txtCodigoZonaInfluencia;
    }

    public String getTxtZonaInfluencia() {
        return txtZonaInfluencia;
    }

    public void setTxtZonaInfluencia(String txtZonaInfluencia) {
        this.txtZonaInfluencia = txtZonaInfluencia;
    }

    @XmlTransient
    public List<ActividadProgramada> getActividadProgramadaList() {
        return actividadProgramadaList;
    }

    public void setActividadProgramadaList(List<ActividadProgramada> actividadProgramadaList) {
        this.actividadProgramadaList = actividadProgramadaList;
    }

    public ActividadProgramada getActividadProgramada() {
        return actividadProgramada;
    }

    public void setActividadProgramada(ActividadProgramada actividadProgramada) {
        this.actividadProgramada = actividadProgramada;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidZonaInfluencia != null ? nidZonaInfluencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaInfluencia)) {
            return false;
        }
        ZonaInfluencia other = (ZonaInfluencia) object;
        if ((this.nidZonaInfluencia == null && other.nidZonaInfluencia != null) || (this.nidZonaInfluencia != null && !this.nidZonaInfluencia.equals(other.nidZonaInfluencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.ZonaInfluencia[ nidZonaInfluencia=" + nidZonaInfluencia + " ]";
    }
    
}
