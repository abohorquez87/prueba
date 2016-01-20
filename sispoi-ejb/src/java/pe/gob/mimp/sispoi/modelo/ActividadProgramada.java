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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ACTIVIDAD_PROGRAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadProgramada.findAll", query = "SELECT a FROM ActividadProgramada a"),
    @NamedQuery(name = "ActividadProgramada.findByNidActividadProgramada", query = "SELECT a FROM ActividadProgramada a WHERE a.nidActividadProgramada = :nidActividadProgramada"),
    @NamedQuery(name = "ActividadProgramada.findByTxtActividadProgramada", query = "SELECT a FROM ActividadProgramada a WHERE a.txtActividadProgramada = :txtActividadProgramada"),
    @NamedQuery(name = "ActividadProgramada.findByFlgCambioAsignado", query = "SELECT a FROM ActividadProgramada a WHERE a.flgCambioAsignado = :flgCambioAsignado"),
    @NamedQuery(name = "ActividadProgramada.findByFlgActivo", query = "SELECT a FROM ActividadProgramada a WHERE a.flgActivo = :flgActivo"),
    @NamedQuery(name = "ActividadProgramada.findByNidUsuario", query = "SELECT a FROM ActividadProgramada a WHERE a.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "ActividadProgramada.findByTxtPc", query = "SELECT a FROM ActividadProgramada a WHERE a.txtPc = :txtPc"),
    @NamedQuery(name = "ActividadProgramada.findByTxtIp", query = "SELECT a FROM ActividadProgramada a WHERE a.txtIp = :txtIp"),
    @NamedQuery(name = "ActividadProgramada.findByFecEdicion", query = "SELECT a FROM ActividadProgramada a WHERE a.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "ActividadProgramada.findByTxtCodigoActProgramada", query = "SELECT a FROM ActividadProgramada a WHERE a.txtCodigoActProgramada = :txtCodigoActProgramada")})
public class ActividadProgramada implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ACTIVIDAD_PROGRAMADA", sequenceName = "SQ_ACTIVIDAD_PROGRAMADA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACTIVIDAD_PROGRAMADA")
    @Column(name = "NID_ACTIVIDAD_PROGRAMADA")
    private BigDecimal nidActividadProgramada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "TXT_ACTIVIDAD_PROGRAMADA")
    private String txtActividadProgramada;
    @Column(name = "FLG_CAMBIO_ASIGNADO")
    private BigInteger flgCambioAsignado;
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
    @Column(name = "TXT_CODIGO_ACT_PROGRAMADA")
    private String txtCodigoActProgramada;
    @JoinTable(name = "ACT_PROGRAMADA_UNIDAD_MEDIDA", joinColumns = {
        @JoinColumn(name = "NID_ACTIVIDAD_PROGRAMADA", referencedColumnName = "NID_ACTIVIDAD_PROGRAMADA")}, inverseJoinColumns = {
        @JoinColumn(name = "NID_UNIDAD_MEDIDA", referencedColumnName = "NID_UNIDAD_MEDIDA")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<UnidadMedida> unidadMedidaList;
    @JoinTable(name = "ACT_PROGRAMADA_ZONA_INFLUENCIA", joinColumns = {
        @JoinColumn(name = "NID_ACTIVIDAD_PROGRAMADA", referencedColumnName = "NID_ACTIVIDAD_PROGRAMADA")}, inverseJoinColumns = {
        @JoinColumn(name = "NID_ZONA_INFLUENCIA", referencedColumnName = "NID_ZONA_INFLUENCIA")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ZonaInfluencia> zonaInfluenciaList;
    @JoinTable(name = "ACT_PROGRAMADA_MEDIO", joinColumns = {
        @JoinColumn(name = "NID_ACTIVIDAD_PROGRAMADA", referencedColumnName = "NID_ACTIVIDAD_PROGRAMADA")}, inverseJoinColumns = {
        @JoinColumn(name = "NID_MEDIO", referencedColumnName = "NID_MEDIO")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Medio> medioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadProgramada", fetch = FetchType.LAZY)
    private List<AsignacionActividad> asignacionActividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadProgramada", fetch = FetchType.LAZY)
    private List<Verificacion> verificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadProgramada", fetch = FetchType.LAZY)
    private List<ZonaInfluencia> zonaInfluenciaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadProgramada", fetch = FetchType.LAZY)
    private List<DetalleActProgramada> detalleActProgramadaList;
    @JoinColumn(name = "NID_ACCION_ESTRATEGICA", referencedColumnName = "NID_ACCION_ESTRATEGICA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AccionEstrategica accionEstrategica;
    @JoinColumn(name = "NID_UNIDAD_RESPONSABLE", referencedColumnName = "NID_UNIDAD_RESPONSABLE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadResponsable unidadResponsable;

    public ActividadProgramada() {
    }

    public ActividadProgramada(BigDecimal nidActividadProgramada) {
        this.nidActividadProgramada = nidActividadProgramada;
    }

    public ActividadProgramada(BigDecimal nidActividadProgramada, String txtActividadProgramada, BigInteger nidUsuario) {
        this.nidActividadProgramada = nidActividadProgramada;
        this.txtActividadProgramada = txtActividadProgramada;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidActividadProgramada() {
        return nidActividadProgramada;
    }

    public void setNidActividadProgramada(BigDecimal nidActividadProgramada) {
        this.nidActividadProgramada = nidActividadProgramada;
    }

    public String getTxtActividadProgramada() {
        return txtActividadProgramada;
    }

    public void setTxtActividadProgramada(String txtActividadProgramada) {
        this.txtActividadProgramada = txtActividadProgramada;
    }

    public BigInteger getFlgCambioAsignado() {
        return flgCambioAsignado;
    }

    public void setFlgCambioAsignado(BigInteger flgCambioAsignado) {
        this.flgCambioAsignado = flgCambioAsignado;
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

    public String getTxtCodigoActProgramada() {
        return txtCodigoActProgramada;
    }

    public void setTxtCodigoActProgramada(String txtCodigoActProgramada) {
        this.txtCodigoActProgramada = txtCodigoActProgramada;
    }

    @XmlTransient
    public List<UnidadMedida> getUnidadMedidaList() {
        return unidadMedidaList;
    }

    public void setUnidadMedidaList(List<UnidadMedida> unidadMedidaList) {
        this.unidadMedidaList = unidadMedidaList;
    }

    @XmlTransient
    public List<ZonaInfluencia> getZonaInfluenciaList() {
        return zonaInfluenciaList;
    }

    public void setZonaInfluenciaList(List<ZonaInfluencia> zonaInfluenciaList) {
        this.zonaInfluenciaList = zonaInfluenciaList;
    }

    @XmlTransient
    public List<Medio> getMedioList() {
        return medioList;
    }

    public void setMedioList(List<Medio> medioList) {
        this.medioList = medioList;
    }

    @XmlTransient
    public List<AsignacionActividad> getAsignacionActividadList() {
        return asignacionActividadList;
    }

    public void setAsignacionActividadList(List<AsignacionActividad> asignacionActividadList) {
        this.asignacionActividadList = asignacionActividadList;
    }

    @XmlTransient
    public List<Verificacion> getVerificacionList() {
        return verificacionList;
    }

    public void setVerificacionList(List<Verificacion> verificacionList) {
        this.verificacionList = verificacionList;
    }

    @XmlTransient
    public List<ZonaInfluencia> getZonaInfluenciaList1() {
        return zonaInfluenciaList1;
    }

    public void setZonaInfluenciaList1(List<ZonaInfluencia> zonaInfluenciaList1) {
        this.zonaInfluenciaList1 = zonaInfluenciaList1;
    }

    @XmlTransient
    public List<DetalleActProgramada> getDetalleActProgramadaList() {
        return detalleActProgramadaList;
    }

    public void setDetalleActProgramadaList(List<DetalleActProgramada> detalleActProgramadaList) {
        this.detalleActProgramadaList = detalleActProgramadaList;
    }

    public AccionEstrategica getAccionEstrategica() {
        return accionEstrategica;
    }

    public void setAccionEstrategica(AccionEstrategica accionEstrategica) {
        this.accionEstrategica = accionEstrategica;
    }

    public UnidadResponsable getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(UnidadResponsable unidadResponsable) {
        this.unidadResponsable = unidadResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidActividadProgramada != null ? nidActividadProgramada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadProgramada)) {
            return false;
        }
        ActividadProgramada other = (ActividadProgramada) object;
        if ((this.nidActividadProgramada == null && other.nidActividadProgramada != null) || (this.nidActividadProgramada != null && !this.nidActividadProgramada.equals(other.nidActividadProgramada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.ActividadProgramada[ nidActividadProgramada=" + nidActividadProgramada + " ]";
    }
    
}
