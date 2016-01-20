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
@Table(name = "ATENCION_PROGRAMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtencionProgramacion.findAll", query = "SELECT a FROM AtencionProgramacion a"),
    @NamedQuery(name = "AtencionProgramacion.findByNidAtencionProgramacion", query = "SELECT a FROM AtencionProgramacion a WHERE a.nidAtencionProgramacion = :nidAtencionProgramacion"),
    @NamedQuery(name = "AtencionProgramacion.findByNidUsuarioAtendio", query = "SELECT a FROM AtencionProgramacion a WHERE a.nidUsuarioAtendio = :nidUsuarioAtendio"),
    @NamedQuery(name = "AtencionProgramacion.findByTxtObservacion", query = "SELECT a FROM AtencionProgramacion a WHERE a.txtObservacion = :txtObservacion"),
    @NamedQuery(name = "AtencionProgramacion.findByFlgActivo", query = "SELECT a FROM AtencionProgramacion a WHERE a.flgActivo = :flgActivo"),
    @NamedQuery(name = "AtencionProgramacion.findByNidUsuario", query = "SELECT a FROM AtencionProgramacion a WHERE a.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "AtencionProgramacion.findByTxtPc", query = "SELECT a FROM AtencionProgramacion a WHERE a.txtPc = :txtPc"),
    @NamedQuery(name = "AtencionProgramacion.findByTxtIp", query = "SELECT a FROM AtencionProgramacion a WHERE a.txtIp = :txtIp"),
    @NamedQuery(name = "AtencionProgramacion.findByFecEdicion", query = "SELECT a FROM AtencionProgramacion a WHERE a.fecEdicion = :fecEdicion")})
public class AtencionProgramacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ATENCION_PROGRAMACION", sequenceName = "SQ_ATENCION_PROGRAMACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ATENCION_PROGRAMACION")
    @Column(name = "NID_ATENCION_PROGRAMACION")
    private BigDecimal nidAtencionProgramacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_USUARIO_ATENDIO")
    private BigInteger nidUsuarioAtendio;
    @Size(max = 1024)
    @Column(name = "TXT_OBSERVACION")
    private String txtObservacion;
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
    @JoinColumn(name = "NID_ESTADO_PROGRAMACION", referencedColumnName = "NID_ETDO_PROGRAMACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoProgramacion estadoProgramacion;
    @JoinColumn(name = "NID_PROGRAMACION", referencedColumnName = "NID_PROGRAMACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programacion programacion;

    public AtencionProgramacion() {
    }

    public AtencionProgramacion(BigDecimal nidAtencionProgramacion) {
        this.nidAtencionProgramacion = nidAtencionProgramacion;
    }

    public AtencionProgramacion(BigDecimal nidAtencionProgramacion, BigInteger nidUsuarioAtendio, BigInteger nidUsuario) {
        this.nidAtencionProgramacion = nidAtencionProgramacion;
        this.nidUsuarioAtendio = nidUsuarioAtendio;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidAtencionProgramacion() {
        return nidAtencionProgramacion;
    }

    public void setNidAtencionProgramacion(BigDecimal nidAtencionProgramacion) {
        this.nidAtencionProgramacion = nidAtencionProgramacion;
    }

    public BigInteger getNidUsuarioAtendio() {
        return nidUsuarioAtendio;
    }

    public void setNidUsuarioAtendio(BigInteger nidUsuarioAtendio) {
        this.nidUsuarioAtendio = nidUsuarioAtendio;
    }

    public String getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(String txtObservacion) {
        this.txtObservacion = txtObservacion;
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

    public EstadoProgramacion getEstadoProgramacion() {
        return estadoProgramacion;
    }

    public void setEstadoProgramacion(EstadoProgramacion estadoProgramacion) {
        this.estadoProgramacion = estadoProgramacion;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidAtencionProgramacion != null ? nidAtencionProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtencionProgramacion)) {
            return false;
        }
        AtencionProgramacion other = (AtencionProgramacion) object;
        if ((this.nidAtencionProgramacion == null && other.nidAtencionProgramacion != null) || (this.nidAtencionProgramacion != null && !this.nidAtencionProgramacion.equals(other.nidAtencionProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.AtencionProgramacion[ nidAtencionProgramacion=" + nidAtencionProgramacion + " ]";
    }
    
}
