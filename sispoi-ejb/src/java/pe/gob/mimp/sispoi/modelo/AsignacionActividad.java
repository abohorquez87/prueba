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
@Table(name = "ASIGNACION_ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionActividad.findAll", query = "SELECT a FROM AsignacionActividad a"),
    @NamedQuery(name = "AsignacionActividad.findByNidAsignacionActividad", query = "SELECT a FROM AsignacionActividad a WHERE a.nidAsignacionActividad = :nidAsignacionActividad"),
    @NamedQuery(name = "AsignacionActividad.findByNumMontoTotal", query = "SELECT a FROM AsignacionActividad a WHERE a.numMontoTotal = :numMontoTotal"),
    @NamedQuery(name = "AsignacionActividad.findByFlgEstado", query = "SELECT a FROM AsignacionActividad a WHERE a.flgEstado = :flgEstado"),
    @NamedQuery(name = "AsignacionActividad.findByNumMontoAfectado", query = "SELECT a FROM AsignacionActividad a WHERE a.numMontoAfectado = :numMontoAfectado"),
    @NamedQuery(name = "AsignacionActividad.findByNidActividadBeneficiada", query = "SELECT a FROM AsignacionActividad a WHERE a.nidActividadBeneficiada = :nidActividadBeneficiada"),
    @NamedQuery(name = "AsignacionActividad.findByNidActividadBeneficiaria", query = "SELECT a FROM AsignacionActividad a WHERE a.nidActividadBeneficiaria = :nidActividadBeneficiaria"),
    @NamedQuery(name = "AsignacionActividad.findByTxtCodigoAsignacionAct", query = "SELECT a FROM AsignacionActividad a WHERE a.txtCodigoAsignacionAct = :txtCodigoAsignacionAct"),
    @NamedQuery(name = "AsignacionActividad.findByFlgActivo", query = "SELECT a FROM AsignacionActividad a WHERE a.flgActivo = :flgActivo"),
    @NamedQuery(name = "AsignacionActividad.findByNidUsuario", query = "SELECT a FROM AsignacionActividad a WHERE a.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "AsignacionActividad.findByTxtPc", query = "SELECT a FROM AsignacionActividad a WHERE a.txtPc = :txtPc"),
    @NamedQuery(name = "AsignacionActividad.findByTxtIp", query = "SELECT a FROM AsignacionActividad a WHERE a.txtIp = :txtIp"),
    @NamedQuery(name = "AsignacionActividad.findByFecEdicion", query = "SELECT a FROM AsignacionActividad a WHERE a.fecEdicion = :fecEdicion")})
public class AsignacionActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ASIGNACION_ACTIVIDAD", sequenceName = "SQ_ASIGNACION_ACTIVIDAD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ASIGNACION_ACTIVIDAD")
    @Column(name = "NID_ASIGNACION_ACTIVIDAD")
    private BigDecimal nidAsignacionActividad;
    @Column(name = "NUM_MONTO_TOTAL")
    private BigInteger numMontoTotal;
    @Column(name = "FLG_ESTADO")
    private BigInteger flgEstado;
    @Column(name = "NUM_MONTO_AFECTADO")
    private BigInteger numMontoAfectado;
    @Column(name = "NID_ACTIVIDAD_BENEFICIADA")
    private BigInteger nidActividadBeneficiada;
    @Column(name = "NID_ACTIVIDAD_BENEFICIARIA")
    private BigInteger nidActividadBeneficiaria;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_ASIGNACION_ACT")
    private String txtCodigoAsignacionAct;
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
    @JoinColumn(name = "NID_ACTIVIDAD_PROGRAMADA", referencedColumnName = "NID_ACTIVIDAD_PROGRAMADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ActividadProgramada actividadProgramada;
    @JoinColumn(name = "NID_TIPO_MODIFICADOR", referencedColumnName = "NID_TIPO_MODIFICADOR")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoModificador tipoModificador;

    public AsignacionActividad() {
    }

    public AsignacionActividad(BigDecimal nidAsignacionActividad) {
        this.nidAsignacionActividad = nidAsignacionActividad;
    }

    public AsignacionActividad(BigDecimal nidAsignacionActividad, BigInteger nidUsuario) {
        this.nidAsignacionActividad = nidAsignacionActividad;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidAsignacionActividad() {
        return nidAsignacionActividad;
    }

    public void setNidAsignacionActividad(BigDecimal nidAsignacionActividad) {
        this.nidAsignacionActividad = nidAsignacionActividad;
    }

    public BigInteger getNumMontoTotal() {
        return numMontoTotal;
    }

    public void setNumMontoTotal(BigInteger numMontoTotal) {
        this.numMontoTotal = numMontoTotal;
    }

    public BigInteger getFlgEstado() {
        return flgEstado;
    }

    public void setFlgEstado(BigInteger flgEstado) {
        this.flgEstado = flgEstado;
    }

    public BigInteger getNumMontoAfectado() {
        return numMontoAfectado;
    }

    public void setNumMontoAfectado(BigInteger numMontoAfectado) {
        this.numMontoAfectado = numMontoAfectado;
    }

    public BigInteger getNidActividadBeneficiada() {
        return nidActividadBeneficiada;
    }

    public void setNidActividadBeneficiada(BigInteger nidActividadBeneficiada) {
        this.nidActividadBeneficiada = nidActividadBeneficiada;
    }

    public BigInteger getNidActividadBeneficiaria() {
        return nidActividadBeneficiaria;
    }

    public void setNidActividadBeneficiaria(BigInteger nidActividadBeneficiaria) {
        this.nidActividadBeneficiaria = nidActividadBeneficiaria;
    }

    public String getTxtCodigoAsignacionAct() {
        return txtCodigoAsignacionAct;
    }

    public void setTxtCodigoAsignacionAct(String txtCodigoAsignacionAct) {
        this.txtCodigoAsignacionAct = txtCodigoAsignacionAct;
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

    public ActividadProgramada getActividadProgramada() {
        return actividadProgramada;
    }

    public void setActividadProgramada(ActividadProgramada actividadProgramada) {
        this.actividadProgramada = actividadProgramada;
    }

    public TipoModificador getTipoModificador() {
        return tipoModificador;
    }

    public void setTipoModificador(TipoModificador tipoModificador) {
        this.tipoModificador = tipoModificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidAsignacionActividad != null ? nidAsignacionActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionActividad)) {
            return false;
        }
        AsignacionActividad other = (AsignacionActividad) object;
        if ((this.nidAsignacionActividad == null && other.nidAsignacionActividad != null) || (this.nidAsignacionActividad != null && !this.nidAsignacionActividad.equals(other.nidAsignacionActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.AsignacionActividad[ nidAsignacionActividad=" + nidAsignacionActividad + " ]";
    }
    
}
